package pages.elements.webTables;
import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class WebTablesPage {
   private final WebDriver driver;
   public Utils utils;
    @FindBy(id = "addNewRecordButton")
    private WebElement addNewLineButton;
    @FindBy(id = "firstName")
    private WebElement firstNameInputField;
    @FindBy(id = "lastName")
    private WebElement lastNameInputField;
    @FindBy(id = "userEmail")
    private WebElement userEmailInputField;
    @FindBy(id = "age")
    private WebElement ageInputField;
    @FindBy(id = "salary")
    private WebElement salaryInputField;
    @FindBy(id = "department")
    private WebElement departmentInputField;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy(className = "rt-table")
    public WebElement webTable;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
        PageFactory.initElements(driver, this);
    }
    public void clickAddNewLineButton(){
        utils.elementClickable(addNewLineButton).click();
    }
    public void addFirstName(String firstName){
        utils.findElement(firstNameInputField);
        firstNameInputField.sendKeys(firstName);
    }
    public void addLastName(String lastName){
        utils.findElement(lastNameInputField);
        lastNameInputField.sendKeys(lastName);
    }
    public void addEmail(String email){
        utils.findElement(userEmailInputField);
        userEmailInputField.sendKeys(email);
    }
    public void addAge(String age){
        utils.findElement(ageInputField);
        ageInputField.sendKeys(age);
    }
    public void addSalary(String salary){
        utils.findElement(salaryInputField);
        salaryInputField.sendKeys(salary);
    }
    public void addDepartment(String department){
        utils.findElement(departmentInputField);
        departmentInputField.sendKeys(department);
    }
    public void clickSubmitButton(){
        utils.elementClickable(submitButton).click();
    }
}
