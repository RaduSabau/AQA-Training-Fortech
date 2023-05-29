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
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {
    private static final String addCartButtonId = "add-to-cart$replaceMe$";
    private static final String removeCartButtonId = "remove$replaceMe$";
    Utils utils = new Utils();
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

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCartButton(String name) {
        By element = By.id(addCartButtonId.replace("$replaceMe$", utils.concatStringWithLine(name)));
        click(element);
        By removeElement = By.id(removeCartButtonId.replace("$replaceMe$", utils.concatStringWithLine(name)));
        highlight(driver, driver.findElement(removeElement));
        highlight(driver, shoppingCartLink);
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
        return getTextsFromPageToList(item);
    }

    public List<Double> getPricesToList() {
        String price = "inventory_item_price";
        return getTextsFromPageToList(price).stream().map(p -> p.substring(1)).map(Double::parseDouble).collect(Collectors.toList());
    }

    public void clickShoppingCartLink() {
        click(shoppingCartLink);
    }

    public void logout() {
        jsClick(burgerButton);
        jsClick(logoutButton);
    }

    public void sortBy(String sortBy) {
        switch (sortBy) {
            case "nameAToZ" -> new Select(selectSortProduct).selectByVisibleText("Name (A to Z)");
            case "nameZToA" -> new Select(selectSortProduct).selectByVisibleText("Name (Z to A)");
            case "lowToHigh" -> new Select(selectSortProduct).selectByVisibleText("Price (low to high)");
            case "highToLow" -> new Select(selectSortProduct).selectByVisibleText("Price (high to low)");
        }
    }
}
