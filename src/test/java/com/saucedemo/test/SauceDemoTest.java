package com.saucedemo.test;

import com.saucedemo.dto.User;
import com.saucedemo.pages.*;
import com.saucedemo.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.List;

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
        System.out.println(driver);
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

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testLoginWithInvalidUserAndValidPassword() {
        System.out.println(driver);
        LoginPage loginPage = new LoginPage(driver);
        User user = getUsersFromFile().stream().toList().get(0);
        loginPage.loginWith("username", user.getPassword());
        Assert.assertEquals(loginPage.getErrorMessage(), USERNAME_PASSWORD_DO_NOT_MATCH_MESSAGE);
    }

    @Test
    public void testLoginWithValidUsernameAndInvalidPassword() {
        System.out.println(driver);
        LoginPage loginPage = new LoginPage(driver);
        User user = getUsersFromFile().stream().toList().get(0);
        loginPage.loginWith(user.getUsername(), "password");
        Assert.assertEquals(loginPage.getErrorMessage(), USERNAME_PASSWORD_DO_NOT_MATCH_MESSAGE);
    }

    @Test
    public void testLoginWithInvalidUsernameAndPassword() {
        System.out.println(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWith("username", "password");
        Assert.assertEquals(loginPage.getErrorMessage(), USERNAME_PASSWORD_DO_NOT_MATCH_MESSAGE);
    }

    @Test
    public void testLoginWithNoUsernameAndValidPassword() {
        System.out.println(driver);
        LoginPage loginPage = new LoginPage(driver);
        User user = getUsersFromFile().stream().toList().get(0);
        loginPage.loginWith("", user.getPassword());
        Assert.assertEquals(loginPage.getErrorMessage(), USERNAME_IS_REQUIRED);
    }

    @Test
    public void testLoginWithValidUsernameAndNoPassword() {
        System.out.println(driver);
        LoginPage loginPage = new LoginPage(driver);
        User user = getUsersFromFile().stream().toList().get(0);
        loginPage.loginWith(user.getUsername(), "");
        Assert.assertEquals(loginPage.getErrorMessage(), PASSWORD_IS_REQUIRED);
    }

    @Test
    public void testLoginWithNoUsernameAndPassword() {
        System.out.println(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWith("", "");
        Assert.assertEquals(loginPage.getErrorMessage(), USERNAME_IS_REQUIRED);
    }

//    @Test
//    public void testSortAToZ(){
//        LoginPage loginPage = new LoginPage(driver);
//        ProductsPage productsPage = new ProductsPage(driver);
//        User user = getUsersFromFile().stream().toList().get(0);
//        loginPage.loginWith(user.getUsername(), user.getPassword());
//        productsPage.sortProductZToA();
//        Collection<String> productsTitleList = productsPage.getProductsTitleList();
//        System.out.println(productsTitleList);
//    }

    //    @Test
//    public void testTest() {
//
//
//    }
}
