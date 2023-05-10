package com.saucedemo.pages;

import com.saucedemo.test.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BasePage {
    private static final String addCartButtonIdXpath = "add-to-cart$replaceMe$";
    public final String SAUCE_LABS_BACKPACK_PRODUCT = "Sauce Labs Backpack";
    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerButton;
    @FindBy(className = "shopping_cart_badge")
    public WebElement shoppingCartBadge;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String productButtonName(String productName) {
        String[] splitString = productName.split(" ");
        StringBuilder productNameC = new StringBuilder();
        for (String s : splitString) {
            productNameC.append("-").append(s.toLowerCase());
        }
        return productNameC.toString();
    }

    public void clickAddToCartButton(String name) {
        By element = By.id(addCartButtonIdXpath.replace("$replaceMe$", name));
        click(element);
    }

    public void shoppingCartBadgeIsVisible() {
        shoppingCartBadge.getText();
    }

    public void logout() {
        jsClick(burgerButton);
        jsClick(logoutButton);
    }
}
