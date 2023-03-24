package testBrowserWindows;

import constants.BrowserWindowsConstants;
import constants.CategoryConstants;
import constants.ItemConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.alerts.AlertFrameWindowsPage;
import pages.alerts.browserWindows.BrowserWindowsPage;
import pages.alerts.browserWindows.NewTabPage;
import pages.alerts.browserWindows.NewWindowMessagePage;
import utils.Utils;

public class TestBrowserWindows {

    private static final String MAIN_URL = "https://demoqa.com/";

    private WebDriver driver;

    @BeforeClass
    public void setup() {
//        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*").addArguments("--start-maximized=*"));

        driver = new FirefoxDriver(getFirefoxOptions());
        driver.manage().window().maximize();
        driver.get(MAIN_URL);

        System.out.println(driver);
    }
    @Test
    public void testMe() {
        System.out.println(driver);
    }
    public static FirefoxOptions getFirefoxOptions() {
        final FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--disable-web-security");
        firefoxOptions.addArguments("--allow-running-insecure-content");

        final FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("pageLoadStrategy", "normal");
        profile.setPreference("intl.accept_languages", "en-GB");

        firefoxOptions.setCapability(FirefoxDriver.Capability.PROFILE, profile);

        return firefoxOptions;
    }
    @Test
    public void testBrowserWindows() {
        HomePage homePage = new HomePage(driver);
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);
        AlertFrameWindowsPage alertFrameWindowsPage = new AlertFrameWindowsPage(driver);
        NewTabPage newTabPage = new NewTabPage(driver);
        NewWindowMessagePage newWindowMessagePage = new NewWindowMessagePage(driver);

        //Main Page - Click Alert, Frame & Windows button
        homePage.clickAlertFrameWindowsCategory();
        Assert.assertTrue(alertFrameWindowsPage.getPageTitle().contains(CategoryConstants.ALERTS_FRAME_WINDOWS_CATEGORY));

        //Click Alert, Frame & Windows Page - Click Browser Windows button
        alertFrameWindowsPage.clickOnBrowserWindows();
        Assert.assertTrue(alertFrameWindowsPage.getPageTitle().contains(ItemConstants.BROWSER_ITEM));

        //Browser Windows Page - Get current window
        String currentWindow = newTabPage.getCurrentWindow();

        //Browser Windows Page - Click New Tab Button
        browserWindowsPage.clickNewTab();

        //Browser Windows Page - Switch on New Tab Page
        newTabPage.switchToNewTab();

        //New Tab Page - Get Text
        String newTabText = newTabPage.getNewTabText();
        Assert.assertEquals(newTabText, BrowserWindowsConstants.TEXT_SAMPLE);

        //New Tab Page - Switch to parent window
        newTabPage.switchToParentWindow(currentWindow);

        //Browser Windows Page - Click New Window Button
        browserWindowsPage.clickNewWindow();

        //Browser Windows Page - Switch on New Window Page
        newTabPage.switchToNewTab();

        //New Window Page - Get Text
        String newWindowText = newTabPage.getNewTabText();
        Assert.assertEquals(newWindowText, BrowserWindowsConstants.TEXT_SAMPLE);

        //New Window Page - Switch to parent window
        newTabPage.switchToParentWindow(currentWindow);

        //Browser Windows Page - Click New Tab Button
        browserWindowsPage.clickNewWindowMessage();

        //Browser Windows Page - Switch on New Blank Page
        newWindowMessagePage.switchToNewWindowMessage();

        //New Blank Page - Get URL
        Assert.assertTrue(newWindowMessagePage.getNewWindowText().contains(BrowserWindowsConstants.LONG_TEXT_SAMPLE));

        //New Blank Page - Switch to parent window
        newTabPage.switchToParentWindow(currentWindow);
    }

    @AfterClass
    public void close() {
        if (driver != null) {
            System.out.println(driver);
            driver.quit();
        }
        System.out.println(driver);
    }
}
//taskKill /t /f /im chromedriver.exe /im chrome.exe /im geckodriver.exe