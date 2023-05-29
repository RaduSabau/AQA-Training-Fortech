package com.saucedemo.test;

import com.saucedemo.dto.User;
import com.saucedemo.pages.*;
import com.saucedemo.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.saucedemo.constants.Constants.*;

@Slf4j
public class SauceDemoTest extends MainPage {
    private final static String fileName = "jsonData/usersJsonGeneratedFile.json";

    private static List<User> getUsersFromFile() {
        return new FileUtils().getFromJson(fileName).getUsers().stream().toList();
    }

    @Test
    public void sauceDemoLoginAndLogoutTest() {
        System.out.println(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        Collection<User> users = getUsersFromFile();
        for (User user : users) {
            try {
                loginPage.loginWith(user.getUsername(), user.getPassword());
                productsPage.logout();
            } catch (Exception ignored) {
//                log.info("User is locked");
            }
        }
    }

    @Test
    public void addProductToShoppingCartAndCheckout() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        YourCartPage yourCartPage = new YourCartPage(driver);
        CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);


        User user = getUsersFromFile().stream().toList().get(0);
        loginPage.loginWith(user.getUsername(), user.getPassword());

        productsPage.clickAddAllToCartButton();
        List<String> productsListAdded = productsPage.getProductsTitleList();
        productsPage.clickShoppingCartLink();

        Assert.assertEquals(productsPage.getShoppingCartBadgeNumber(), productsListAdded.size());
        Assert.assertEquals(productsPage.getProductsTitleList(), productsListAdded);

        yourCartPage.clickCheckoutButton();
        checkoutYourInformationPage.fillCheckoutUserInfo(user.getFirstName(), user.getLastName(), user.getPostalCode());

        Assert.assertEquals(checkoutOverviewPage.getSubTotalSummary(), checkoutOverviewPage.productPricesSum());
        Assert.assertEquals(checkoutOverviewPage.getTax(), checkoutOverviewPage.calculateTax());
        Assert.assertEquals(checkoutOverviewPage.getTotalSummary(), checkoutOverviewPage.productPricesSum() + checkoutOverviewPage.calculateTax());
        checkoutOverviewPage.clickFinishTransaction();

        Assert.assertTrue(checkoutCompletePage.thankYouMessageIsDisplayed());
        checkoutCompletePage.clickBackHomeButton();

        productsPage.logout();

    }

    @Test
    public void testLoginWithInvalidUserAndValidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        User user = getUsersFromFile().stream().toList().get(0);
        loginPage.loginWith("username", user.getPassword());
        Assert.assertEquals(loginPage.getErrorMessage(), USERNAME_PASSWORD_DO_NOT_MATCH_MESSAGE);
    }

    @Test
    public void testLoginWithValidUsernameAndInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        User user = getUsersFromFile().stream().toList().get(0);
        loginPage.loginWith(user.getUsername(), "password");
        Assert.assertEquals(loginPage.getErrorMessage(), USERNAME_PASSWORD_DO_NOT_MATCH_MESSAGE);
    }

    @Test
    public void testLoginWithInvalidUsernameAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWith("username", "password");
        Assert.assertEquals(loginPage.getErrorMessage(), USERNAME_PASSWORD_DO_NOT_MATCH_MESSAGE);
    }

    @Test
    public void testLoginWithNoUsernameAndValidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        User user = getUsersFromFile().stream().toList().get(0);
        loginPage.loginWith("", user.getPassword());
        Assert.assertEquals(loginPage.getErrorMessage(), USERNAME_IS_REQUIRED);
    }

    @Test
    public void testLoginWithValidUsernameAndNoPassword() {
        LoginPage loginPage = new LoginPage(driver);
        User user = getUsersFromFile().stream().toList().get(0);
        loginPage.loginWith(user.getUsername(), "");
        Assert.assertEquals(loginPage.getErrorMessage(), PASSWORD_IS_REQUIRED);
    }

    @Test
    public void testLoginWithNoUsernameAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWith("", "");
        Assert.assertEquals(loginPage.getErrorMessage(), USERNAME_IS_REQUIRED);
    }

    @Test
    public void testSortProducts() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        User user = getUsersFromFile().stream().toList().get(0);
        loginPage.loginWith(user.getUsername(), user.getPassword());
        List<String> displayedProducts = productsPage.getProductsTitleList();
        List<Double> displayedPrices = productsPage.getPricesToList();

        productsPage.sortBy("nameZToA");
        Assert.assertEquals(productsPage.getProductsTitleList(), displayedProducts.stream().sorted(Comparator.reverseOrder()).toList());

        productsPage.sortBy("nameAToZ");
        Assert.assertEquals(productsPage.getProductsTitleList(), displayedProducts.stream().sorted().toList());

        productsPage.sortBy("highToLow");
        Assert.assertEquals(productsPage.getPricesToList(), displayedPrices.stream().sorted(Comparator.reverseOrder()).toList());

        productsPage.sortBy("lowToHigh");
        Assert.assertEquals(productsPage.getPricesToList(), displayedPrices.stream().sorted().toList());
    }
    @Test
    public void testBlankCheckoutInformationFields() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        YourCartPage yourCartPage = new YourCartPage(driver);
        CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        User user = getUsersFromFile().stream().toList().get(0);
        loginPage.loginWith(user.getUsername(), user.getPassword());

        productsPage.clickAddAllToCartButton();
        productsPage.clickShoppingCartLink();
        yourCartPage.clickCheckoutButton();
        checkoutYourInformationPage.fillCheckoutUserInfo("","","");
        Assert.assertEquals(checkoutYourInformationPage.setErrorMessage(),ERROR_FIRST_NAME_IS_REQUIRED);
        checkoutYourInformationPage.fillCheckoutUserInfo(user.getFirstName(), "","");
        Assert.assertEquals(checkoutYourInformationPage.setErrorMessage(),ERROR_LAST_NAME_IS_REQUIRED);
        checkoutYourInformationPage.fillCheckoutUserInfo(user.getFirstName(), user.getLastName(), "");
        Assert.assertEquals(checkoutYourInformationPage.setErrorMessage(),ERROR_POSTAL_CODE_IS_REQUIRED);
        TimeUnit.SECONDS.sleep(2);
    }
    //    @Test
//    public void testTest() {
//
//
//    }
}

