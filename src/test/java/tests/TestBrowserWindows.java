package tests;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.alerts.MenuAlertFrameWindowsPage;
import pages.alerts.browserwindows.BrowserWindowsPage;
import pages.alerts.browserwindows.NewTabPage;
import pages.alerts.browserwindows.NewWindowMessagePage;
import utils.WebpageHandler;


public class TestBrowserWindows {

    private WebDriver driver;
    private BrowserWindowsPage browserWindowsPage;
    private NewTabPage newTabPage;
    private NewWindowMessagePage newWindowMessagePage;
    private WebpageHandler webpageHandler;


    @BeforeClass
    public void setup() {
//        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*").addArguments("--start-maximized=*"));
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(Constants.MAIN_URL);
        browserWindowsPage = new BrowserWindowsPage(driver);
        newTabPage = new NewTabPage(driver);
        newWindowMessagePage = new NewWindowMessagePage(driver);
        webpageHandler = new WebpageHandler(driver);
    }

    @Test
    public void testBrowserWindows() {

        new HomePage(driver).clickAlertFrameWindowsCategory();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(HomePage.ALERTS_FRAME_WINDOWS_CATEGORY));

        new MenuAlertFrameWindowsPage(driver).clickOnBrowserWindows();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(MenuAlertFrameWindowsPage.BROWSER_ITEM));

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

    @AfterClass
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
//taskKill /t /f /im chromedriver.exe /im chrome.exe /im geckodriver.exe