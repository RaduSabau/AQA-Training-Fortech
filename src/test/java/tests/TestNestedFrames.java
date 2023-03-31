package tests;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.alerts.AlertFrameWindowsPage;
import pages.alerts.NestedFrames.NestedFramesPage;
import utils.WebpageHandler;

public class TestNestedFrames {
    private WebDriver driver;
    private NestedFramesPage nestedFramesPage;
    private WebpageHandler webpageHandler;
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*").addArguments("--start-maximized=*"));
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
        driver.get(Constants.MAIN_URL);
        nestedFramesPage = new NestedFramesPage(driver);
        webpageHandler = new WebpageHandler(driver);
    }

    @Test
    public void testNestedFrames() {

        new HomePage(driver).clickAlertFrameWindowsCategory();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(HomePage.ALERTS_FRAME_WINDOWS_CATEGORY));

        new AlertFrameWindowsPage(driver).clickOnNestedFrames();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(AlertFrameWindowsPage.NESTED_FRAMES_ITEM));

        nestedFramesPage.switchToParentFrame();
        Assert.assertEquals(nestedFramesPage.frameText(),Constants.PARENT_FRAME_TEXT);

        nestedFramesPage.switchToInnerFrame();
        Assert.assertEquals(nestedFramesPage.frameText(),Constants.INNER_FRAME_TEXT);
    }

    @AfterClass
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}