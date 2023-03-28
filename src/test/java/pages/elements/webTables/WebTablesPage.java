package pages.elements.webTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class WebTablesPage {
    private final WebDriver driver;
    private final Utils utils;
    @FindBy(id = "firstName")
    public WebElement firstNameInputField;
    @FindBy(className = "rt-table")
    public WebElement webTable;
    @FindBy(id = "addNewRecordButton")
    private WebElement addNewLineButton;
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

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickAddNewLineButton() {
        utils.elementClickable(addNewLineButton).click();
    }

    public void addFirstName(String firstName) {
        utils.findElement(firstNameInputField);
        firstNameInputField.sendKeys(firstName);
    }

    public void addLastName(String lastName) {
        utils.findElement(lastNameInputField);
        lastNameInputField.sendKeys(lastName);
    }

    public void addEmail(String email) {
        utils.findElement(userEmailInputField);
        userEmailInputField.sendKeys(email);
    }

    public void addAge(String age) {
        utils.findElement(ageInputField);
        ageInputField.sendKeys(age);
    }

    public void addSalary(String salary) {
        utils.findElement(salaryInputField);
        salaryInputField.sendKeys(salary);
    }

    public void addDepartment(String department) {
        utils.findElement(departmentInputField);
        departmentInputField.sendKeys(department);
    }

    public void clickSubmitButton() {
        utils.elementClickable(submitButton).click();
    }

    public void clickDeleteLineButton(String firstName) {
        String deleteButtonXpath = "//div[contains(text(),'" + firstName + "')]//following-sibling::div/div/span[@title='Delete']";
        WebElement deleteWebTableLineButton = driver.findElement(By.xpath(deleteButtonXpath));
        utils.elementClickable(deleteWebTableLineButton).click();
    }

    public void clickEditLineButton(String firstName) {
        String editButtonXpath = "//div[contains(text(),'" + firstName + "')]//following-sibling::div/div/span[@title='Edit']";
        WebElement editWebTableLineButton = driver.findElement(By.xpath(editButtonXpath));
        utils.elementClickable(editWebTableLineButton).click();
    }

    public void editSalary(String newSalary) {
        utils.findElement(salaryInputField);
        salaryInputField.clear();
        salaryInputField.sendKeys(newSalary);
    }

    public String checkAgeWebTableLine(String firstName) {
        String webTableLineXpath = "//div[contains(text(),'" + firstName + "')]//ancestor::div[@class='rt-tr-group']";
        WebElement webTableLine = driver.findElement(By.xpath(webTableLineXpath));
        utils.findElement(webTableLine);
        return webTableLine.getText();
    }
}
