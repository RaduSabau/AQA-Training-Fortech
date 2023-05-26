package com.saucedemo.pages;

import com.saucedemo.test.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {
    private final static String thankYouMessage = "Thank you for your order!";
    @FindBy(id="back-to-products")
    private WebElement backHomeButton;
    @FindBy(className="complete-header")
    private WebElement thankYouHeader;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public Boolean thankYouMessageIsDisplayed() {
        return thankYouHeader.getText().contains(thankYouMessage);
    }
    public void clickBackHomeButton(){
        click(backHomeButton);
    }
}
