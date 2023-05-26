package com.saucedemo.test;

import com.saucedemo.dto.User;
import com.saucedemo.pages.*;
import com.saucedemo.utils.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SauceDemoSecondTest extends MainPage {
    private final static String fileName = "jsonData/usersJsonGeneratedFile.json";

    private static List<User> getUsersFromFile() {
        return new FileUtils().getFromJson(fileName).getUsers().stream().toList();
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

}
