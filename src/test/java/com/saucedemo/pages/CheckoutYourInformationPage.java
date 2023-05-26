package com.saucedemo.pages;

import com.saucedemo.test.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutYourInformationPage extends BasePage {
    @FindBy(id = "first-name")
    private WebElement firstNameField;
    @FindBy(id = "last-name")
    private WebElement lastNameField;
    @FindBy(id = "postal-code")
    private WebElement postalCodeField;
    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
    }

    public void fillCheckoutUserInfo(String firstName, String lastName, String zipOrPostCode) {
        sendText(firstNameField, firstName);
        sendText(lastNameField, lastName);
        sendText(postalCodeField, zipOrPostCode);
        click(continueButton);
    }
}
