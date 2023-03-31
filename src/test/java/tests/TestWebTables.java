package tests;

import entities.Employee;
import entities.Employees;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.elements.MenuElements;
import pages.elements.webTables.WebTablesPage;
import utils.Utils;
import utils.WebpageHandler;

import java.util.ArrayList;
import java.util.List;

import static constants.Constants.*;
import static utils.Utils.employeeList;
import static utils.Utils.userList;


public class TestWebTables {

    protected WebDriver driver;
    private WebTablesPage webTablesPage;
    private WebpageHandler webpageHandler;
    private Utils utils;

    private static ChromeOptions getChromeOptions() {
        return new ChromeOptions()
//                .addArguments("--window-size=1920, 1080")
//                .addArguments("--disable-gpu")
//                .addArguments("--headless")
                .addArguments("disable-infobars")
                .addArguments("--start-maximized")
                .addArguments("--remote-allow-origins=*")
                .addArguments("--disable-extensions")
                .addArguments("--no-sandbox");
    }

    private static List<String> getStrings() {
        return new ArrayList<>() {{
            add(FIRST_NAME);
            add(LAST_NAME);
            add(USER_EMAIL);
            add(String.valueOf(USER_AGE));
            add(USER_SALARY);
            add(DEPARTMENT);
        }};
    }

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver(getChromeOptions());
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
        driver.get(MAIN_URL);
        webTablesPage = new WebTablesPage(driver);
        webpageHandler = new WebpageHandler(driver);
        utils = new Utils();
    }

    @Test
    public void testWebTable() throws Exception {

        new HomePage(driver).clickElementsCategory();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(HomePage.ELEMENTS_CATEGORY));

        new MenuElements(driver).clickOnWebTables();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(MenuElements.WEB_TABLES_ITEM));

        utils.readFile();
        employeeList = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            employeeList.add(utils.getEmployee(i));
        }
        Employees employees = Employees.builder().withEmployees(employeeList).build();

        for (Employee user : employees.getEmployees()) {
            webTablesPage.clickAddNewLineButton();

            webTablesPage.addFirstName(user.getFirstName());
            webTablesPage.addLastName(user.getLastName());
            webTablesPage.addEmail(user.getEmail());
            webTablesPage.addAge(user.getAge());
            webTablesPage.addSalary(user.getSalary());
            webTablesPage.addDepartment(user.getDepartment());

            webTablesPage.clickSubmitButton();
        }

        getStrings().forEach(v -> Assert.assertTrue(webTablesPage.webTable.getText().contains(v)));

        webTablesPage.clickDeleteLineButton(FIRST_NAME_TO_DELETE);
        Assert.assertFalse(webTablesPage.webTable.getText().contains(FIRST_NAME_TO_DELETE));

        webTablesPage.clickEditLineButton(FIRST_NAME_TO_EDIT);
        webTablesPage.addSalary(USER_NEW_SALARY);
        webTablesPage.clickSubmitButton();
        Assert.assertTrue(webTablesPage.getAgeWebTableLine(FIRST_NAME_TO_EDIT).contains(String.valueOf(USER_NEW_SALARY)));

    }

    @AfterClass
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

}
