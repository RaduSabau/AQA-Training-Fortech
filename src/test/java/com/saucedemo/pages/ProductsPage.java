package com.saucedemo.pages;

import com.saucedemo.test.BasePage;
import com.saucedemo.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends BasePage {
    private static final String addCartButtonId = "add-to-cart$replaceMe$";
    private static final String removeCartButtonId = "remove$replaceMe$";

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerButton;
    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;
    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;
    @FindBy(className = "product_sort_container")
    private WebElement selectSortProduct;

    Utils utils = new Utils();

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCartButton(String name) {
        By element = By.id(addCartButtonId.replace("$replaceMe$", utils.concatStringWithLine(name)));
        click(element);
        By removeElement = By.id(removeCartButtonId.replace("$replaceMe$",utils.concatStringWithLine(name)));
        highlight(driver, driver.findElement(removeElement));
        highlight(driver,shoppingCartLink);
        takeScreenShot();
    }

    public void clickAddAllToCartButton() {
        getProductsTitleList().forEach(this::clickAddToCartButton);
    }

    public Integer getShoppingCartBadgeNumber() {
        shoppingCartBadge.isDisplayed();
        return Integer.valueOf(shoppingCartBadge.getText());
    }

    public List<String> getProductsTitleList() {
        String item = "inventory_item_name";
        return getTitlesFromPageToList(item);
    }

    public void clickShoppingCartLink() {
        click(shoppingCartLink);
    }

    public void logout() {
        jsClick(burgerButton);
        jsClick(logoutButton);
    }



}
