package com.saucedemo.pages;

import com.saucedemo.test.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends BasePage {
    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckoutButton() {
        jsClick(checkoutButton);
    }
}
