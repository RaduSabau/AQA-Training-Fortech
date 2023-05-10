package com.saucedemo.test;

import com.google.gson.Gson;
import com.saucedemo.dto.userbuilderjson.User;
import com.saucedemo.dto.userbuilderjson.Users;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.SauceHomePage;
import com.saucedemo.utils.PageHandler;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class SauceDemoTest extends MainPage {
    private final static String fileName = "jsonData/usersJsonGeneratedFile.json";

    @Test
    public void sauceDemoLoginAndLogoutTest() {
        SauceHomePage sauceHomePage = new SauceHomePage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        Users users = getFromJson();
        for (User user : users.getUsers()) {
            try {
                sauceHomePage.loginWith(user.getUsername(), user.getPassword());
                inventoryPage.logout();
            } catch (Exception ignored) {
//                log.info("User is locked");
            }
        }
    }

    private Users getFromJson() {
        return new Gson().fromJson(new PageHandler().getReader(fileName), Users.class);
    }

    @Test
    public void addProductToShoppingCart() {
        SauceHomePage sauceHomePage = new SauceHomePage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        User user = getFromJson().getUsers().stream().toList().get(0);
        sauceHomePage.loginWith(user.getUsername(), user.getPassword());
        inventoryPage.clickAddToCartButton(inventoryPage.productButtonName(inventoryPage.SAUCE_LABS_BACKPACK_PRODUCT));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(inventoryPage.shoppingCartBadge.isDisplayed());
        log.info(inventoryPage.shoppingCartBadge.getText());
    }
    @Test
    public void testTest(){
        InventoryPage inventoryPage = new InventoryPage(driver);

    }
}
