package testBrowserWindows;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.alerts.AlertFrameWindowsPage;
import pages.alerts.browserWindows.BrowserWindowsPage;
import pages.alerts.browserWindows.NewTabPage;
import pages.alerts.browserWindows.NewWindowMessagePage;
import pages.elements.ElementsPage;
import pages.elements.webTables.WebTablesPage;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;


public class TestBrowserWindows {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*").addArguments("--start-maximized=*"));
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
        driver.get(Constants.MAIN_URL);
    }

    @Test
    public void testBrowserWindows() {
        HomePage homePage = new HomePage(driver);
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);
        AlertFrameWindowsPage alertFrameWindowsPage = new AlertFrameWindowsPage(driver);
        NewTabPage newTabPage = new NewTabPage(driver);
        NewWindowMessagePage newWindowMessagePage = new NewWindowMessagePage(driver);
        Utils utils = new Utils(driver);


        homePage.clickAlertFrameWindowsCategory();
        Assert.assertTrue(utils.getPageTitle().contains(Constants.ALERTS_FRAME_WINDOWS_CATEGORY));

        alertFrameWindowsPage.clickOnBrowserWindows();
        Assert.assertTrue(utils.getPageTitle().contains(Constants.BROWSER_ITEM));

        String currentWindow = newTabPage.getCurrentWindow();
        browserWindowsPage.clickNewTab();

        newTabPage.switchToNewTab();

        String newTabText = newTabPage.getNewTabText();
        Assert.assertEquals(newTabText, Constants.TEXT_SAMPLE);

        newTabPage.switchToParentWindow(currentWindow);

        browserWindowsPage.clickNewWindow();

        newTabPage.switchToNewTab();

        String newWindowText = newTabPage.getNewTabText();
        Assert.assertEquals(newWindowText, Constants.TEXT_SAMPLE);

        newTabPage.switchToParentWindow(currentWindow);

        browserWindowsPage.clickNewWindowMessage();

        newWindowMessagePage.switchToNewWindowMessage();

        Assert.assertTrue(newWindowMessagePage.getNewWindowText().contains(Constants.LONG_TEXT_SAMPLE));

        newTabPage.switchToParentWindow(currentWindow);
    }

    @Test
    public void testWebTables() {
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
        for (String value : regData){
            Assert.assertTrue(webTablesPage.webTable.getText().contains(value));
        }

    }
//    @AfterMethod
//    public void close() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
//taskKill /t /f /im chromedriver.exe /im chrome.exe /im geckodriver.exe