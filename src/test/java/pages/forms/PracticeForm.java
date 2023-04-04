package pages.forms;

import entities.practiceform.Student;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.elements.webTables.WebTablesPage;
import utils.Utils;
import utils.WebpageHandler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.Date;

public class PracticeForm {
    WebDriver driver;
    WebpageHandler webpageHandler;
    @FindBy(id ="firstName")
    private WebElement firstNameInputField;
    @FindBy(id ="lastName")
    private WebElement lastNameInputField;
    @FindBy(id ="userEmail")
    private WebElement userEmailInputField;
    @FindBy(id ="userNumber")
    private WebElement userNumberInputField;
    @FindBy(id="dateOfBirthInput")
    private WebElement userDateOfBirthInputField;
    @FindBy(id="currentAddress")
    private WebElement userAddressInputField;
    @FindBy(xpath="//input[@value='Male']")
    private WebElement maleRadioButton;
    @FindBy(id="closeLargeModal")
    private WebElement closeLargeModalButton;

    public PracticeForm(WebDriver driver) {
        this.driver = driver;
        this.webpageHandler = new WebpageHandler(driver);
        PageFactory.initElements(driver, this);
    }
    public void clearInputField(WebElement element) {
        webpageHandler.findElement(element);
        element.clear();
    }
    public void addFirstName(String firstName){
        clearInputField(firstNameInputField);
        firstNameInputField.sendKeys(firstName);
    }
    public void addLastName(String lastName){
        clearInputField(lastNameInputField);
        lastNameInputField.sendKeys(lastName);
    }
    public void addUserEmail(String userEmail){
        clearInputField(userEmailInputField);
        userEmailInputField.sendKeys(userEmail);
    }
    public void addUserNumber(String userNumber){
        clearInputField(userNumberInputField);
        userNumberInputField.sendKeys(userNumber);
    }
    public void addUserDateOfBirth(Date userBirthDate){
        clearInputField(userDateOfBirthInputField);
        userDateOfBirthInputField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        userDateOfBirthInputField.sendKeys(String.valueOf(userBirthDate));
    }
    public void addUserAddress(String userAddress){
        clearInputField(userAddressInputField);
        userDateOfBirthInputField.sendKeys(userAddress);
    }
    public void clickMaleButton(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", maleRadioButton);
    }

    public void clickCloseLargeModal(){
        webpageHandler.elementClickable(closeLargeModalButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", closeLargeModalButton);
    }
    public Student getStudent(String value) {
        Utils utils = new Utils();
        return Student.builder().withFirstName(utils.getListFromRow(value).get(0))
                .withLastName(utils.getListFromRow(value).get(1))
                .withEmail(utils.getListFromRow(value).get(2))
                .withMobileNumber(utils.getListFromRow(value).get(3))
                .withDateOfBirth(java.sql.Date.valueOf(utils.getListFromRow(value).get(4)))
                .withAddress(utils.getListFromRow(value).get(5))
                .build();
    }
    public void pressEnterKey() throws AWTException, InterruptedException {
        Thread.sleep(1000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
    }
    public void pressEnterInUserEmailField(){
        userEmailInputField.sendKeys(Keys.ENTER);
    }
}
