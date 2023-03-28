package testDemoqa;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.elements.ElementsPage;
import pages.elements.webTables.WebTablesPage;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class TestWebTables {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*").addArguments("--start-maximized=*"));
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
        driver.get(Constants.MAIN_URL);
    }

    @Test
    public void testWebTable() {
        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        WebTablesPage webTablesPage = new WebTablesPage(driver);
        Utils utils = new Utils(driver);

        homePage.clickElementsCategory();
        Assert.assertTrue(utils.getPageTitle().contains(Constants.ELEMENTS_CATEGORY));

        elementsPage.clickOnWebTables();
        Assert.assertTrue(utils.getPageTitle().contains(Constants.WEB_TABLES_ITEM));

        webTablesPage.clickAddNewLineButton();

        webTablesPage.addFirstName(Constants.FIRST_NAME);
        webTablesPage.addLastName(Constants.LAST_NAME);
        webTablesPage.addEmail(Constants.USER_EMAIL);
        webTablesPage.addAge(Constants.USER_AGE);
        webTablesPage.addSalary(Constants.USER_SALARY);
        webTablesPage.addDepartment(Constants.DEPARTMENT);

        webTablesPage.clickSubmitButton();

        List<String> regData = new ArrayList<String>();
        regData.add(Constants.FIRST_NAME);
        regData.add(Constants.LAST_NAME);
        regData.add(Constants.USER_EMAIL);
        regData.add(Constants.USER_AGE);
        regData.add(Constants.USER_SALARY);
        regData.add(Constants.DEPARTMENT);
        for (String value : regData) {
            Assert.assertTrue(webTablesPage.webTable.getText().contains(value));
        }

        webTablesPage.clickDeleteLineButton(Constants.FIRST_NAME_TO_DELETE);
        Assert.assertFalse(webTablesPage.webTable.getText().contains(Constants.FIRST_NAME_TO_DELETE));

        webTablesPage.clickEditLineButton(Constants.FIRST_NAME_TO_EDIT);
        webTablesPage.editSalary(Constants.USER_NEW_SALARY);
        webTablesPage.clickSubmitButton();
        Assert.assertTrue(webTablesPage.checkAgeWebTableLine(Constants.FIRST_NAME_TO_EDIT).contains(Constants.USER_NEW_SALARY));
    }

    //    @AfterMethod
//    public void close() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
