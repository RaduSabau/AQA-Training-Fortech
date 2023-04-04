package pages.elements.webTables;

import entities.webtables.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;
import utils.WebpageHandler;

public class WebTablesPage {
    private final WebDriver driver;
    private final WebpageHandler webpageHandler;
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
        this.webpageHandler = new WebpageHandler(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickAddNewLineButton() {
        webpageHandler.elementClickable(addNewLineButton).click();
    }

    public void addFirstName(String firstName) {
        webpageHandler.findElement(firstNameInputField);
        firstNameInputField.clear();
        firstNameInputField.sendKeys(firstName);
    }


    public void addLastName(String lastName) {
        webpageHandler.findElement(lastNameInputField);
        lastNameInputField.clear();
        lastNameInputField.sendKeys(lastName);
    }

    public void addEmail(String email) {
        webpageHandler.findElement(userEmailInputField);
        userEmailInputField.clear();
        userEmailInputField.sendKeys(email);
    }

    public void addAge(int age) {
        webpageHandler.findElement(ageInputField);
        ageInputField.clear();
        ageInputField.sendKeys(String.valueOf(age));
    }

    public void addSalary(int salary) {
        webpageHandler.findElement(salaryInputField);
        salaryInputField.clear();
        salaryInputField.sendKeys(String.valueOf(salary));
    }

    public void addDepartment(String department) {
        webpageHandler.findElement(departmentInputField);
        departmentInputField.clear();
        departmentInputField.sendKeys(department);
    }

    public void clickSubmitButton() {
        webpageHandler.elementClickable(submitButton).click();
    }

    public void clickDeleteLineButton(String firstName) {
        String deleteButtonXpath = "//div[contains(text(),'" + firstName + "')]//following-sibling::div/div/span[@title='Delete']";
        clickWebElement(deleteButtonXpath);
    }

    public void clickEditLineButton(String firstName) {
        String editButtonXpath = "//div[contains(text(),'" + firstName + "')]//following-sibling::div/div/span[@title='Edit']";
        clickWebElement(editButtonXpath);
    }

    private void clickWebElement(String categoryCardXpath) {
        WebElement webElement = driver.findElement(By.xpath(categoryCardXpath));
        webpageHandler.elementClickable(webElement).click();
    }

    public String getAgeWebTableLine(String firstName) {
        String webTableLineXpath = "//div[contains(text(),'" + firstName + "')]//ancestor::div[@class='rt-tr-group']";
        WebElement webTableLine = driver.findElement(By.xpath(webTableLineXpath));
        webpageHandler.findElement(webTableLine);
        return webTableLine.getText();
    }

    public Employee getEmployee(String value) {
        Utils utils = new Utils();
        return Employee.builder().withFirstName(utils.getListFromRow(value).get(0))
                .withLastName(utils.getListFromRow(value).get(1))
                .withEmail(utils.getListFromRow(value).get(2))
                .withAge(Integer.valueOf(utils.getListFromRow(value).get(3)))
                .withSalary(Integer.valueOf(utils.getListFromRow(value).get(4)))
                .withDepartment(utils.getListFromRow(value).get(5))
                .build();
    }
}
