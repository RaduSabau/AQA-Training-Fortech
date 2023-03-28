package testDemoqa;

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
import utils.Utils;


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

//    @AfterMethod
//    public void close() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
//taskKill /t /f /im chromedriver.exe /im chrome.exe /im geckodriver.exe