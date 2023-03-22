import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageDemoqa.*;

public class TestBrowserWindows {
    private static final String BROWSER_VALUE = "Browser Windows";
    private static final String ELEMENT_ITEM = "Alerts, Frame & Windows";
    private static final String TEXT_SAMPLE = "This is a sample page";
    private static final String LONG_TEXT_SAMPLE = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
    private static String currentWindow;
    WebDriver driver;

    @BeforeClass
    public void setup() {
        String URL = "https://demoqa.com/";
//        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*").addArguments("--start-maximized=*"));
        driver = new FirefoxDriver(new FirefoxOptions().addArguments("--start-maximized=*"));
        driver.get(URL);

    }

    @Test
    public void testBrowserWindows() {
        MainPage mainPage = new MainPage(driver);
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);
        AlertFrameWindowsPage alertFrameWindowsPage = new AlertFrameWindowsPage(driver);
        NewTabPage newTabPage = new NewTabPage(driver);
        NewWindowMessagePage newWindowMessagePage = new NewWindowMessagePage(driver);

        mainPage.clickAlertFrameWindowsMenuButton(ELEMENT_ITEM);
        Assert.assertTrue(alertFrameWindowsPage.getPageTitle().contains(ELEMENT_ITEM));
        alertFrameWindowsPage.chooseItemMenu(BROWSER_VALUE);
        Assert.assertTrue(alertFrameWindowsPage.getPageTitle().contains(BROWSER_VALUE));
        String currentWindow = newTabPage.getCurrentWindow();
        browserWindowsPage.clickNewTab();
        newTabPage.switchToNewTab();
        String newTabText = newTabPage.getNewTabText();
        Assert.assertEquals(newTabText, TEXT_SAMPLE);
        newTabPage.switchToParentWindow(currentWindow);
        browserWindowsPage.clickNewWindow();
        newTabPage.switchToNewTab();
        Assert.assertEquals(newTabText, TEXT_SAMPLE);
        newTabPage.switchToParentWindow(currentWindow);
        browserWindowsPage.clickNewWindowMessage();
        newWindowMessagePage.switchToNewWindowMessage();
        Assert.assertTrue(newWindowMessagePage.getNewWindowText().contains(LONG_TEXT_SAMPLE));
        newTabPage.switchToParentWindow(currentWindow);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}
