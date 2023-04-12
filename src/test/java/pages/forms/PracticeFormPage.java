package pages.forms;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebpageHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PracticeFormPage {
    WebDriver driver;
    WebpageHandler webpageHandler;
    @FindBy(id = "firstName")
    private WebElement firstNameInputField;
    @FindBy(id = "lastName")
    private WebElement lastNameInputField;
    @FindBy(id = "userEmail")
    private WebElement userEmailInputField;
    @FindBy(id = "userNumber")
    private WebElement userNumberInputField;
    @FindBy(id = "dateOfBirthInput")
    private WebElement userDateOfBirthInputField;
    @FindBy(id = "closeLargeModal")
    private WebElement closeLargeModalButton;
    @FindBy(id = "submit")
    private WebElement submitButton;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.webpageHandler = new WebpageHandler(driver);
        PageFactory.initElements(driver, this);
    }

    public List<String> getLabelStrings() {
        return new ArrayList<>() {{
            add("Student Name");
            add("Student Email");
            add("Gender");
            add("Mobile");
            add("Date of Birth");
        }};

    }

    public void clearInputField(WebElement element) {
        webpageHandler.findElement(element).clear();
    }

    public void addFirstName(String firstName) {
        clearInputField(firstNameInputField);
        firstNameInputField.sendKeys(firstName);
    }

    public void addLastName(String lastName) {
        clearInputField(lastNameInputField);
        lastNameInputField.sendKeys(lastName);
    }

    public void addUserEmail(String userEmail) {
        clearInputField(userEmailInputField);
        userEmailInputField.sendKeys(userEmail);
    }

    public void addUserNumber(String userNumber) {
        clearInputField(userNumberInputField);
        userNumberInputField.sendKeys(userNumber);
    }

    public void addUserDateOfBirth(Date userBirthDate) {
        clearInputField(userDateOfBirthInputField);
        userDateOfBirthInputField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        userDateOfBirthInputField.sendKeys(String.valueOf(userBirthDate));
    }

    public void clickGenderButton(String gender) {
        WebElement genderElement = driver.findElement(By.xpath("//input[@value='" + gender + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", genderElement);
    }

    public String getWebElementText(String label) {
        return driver.findElement(By.xpath("//td[contains(text(),'" + label + "')]/following-sibling::td")).getText();
    }

    public void clickCloseLargeModal() {
        webpageHandler.clickOnElementExecutor(closeLargeModalButton);
    }

    public void clickSubmitButton() {
        webpageHandler.clickOnElementExecutor(submitButton);
    }
}