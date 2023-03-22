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

    WebDriver driver;

    @BeforeClass
    public void setup() {
        String URL = "https://demoqa.com/";
//        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*").addArguments("--start-maximized=*"));
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(URL);

    }

    @Test
    public void testBrowserWindows() {
        MainPage mainPage = new MainPage(driver);
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);
        AlertFrameWindowsPage alertFrameWindowsPage = new AlertFrameWindowsPage(driver);
        NewTabPage newTabPage = new NewTabPage(driver);
        NewWindowMessagePage newWindowMessagePage = new NewWindowMessagePage(driver);
        //Main Page - Click Alert, Frame & Windows button
        mainPage.clickAlertFrameWindowsMenuButton(ELEMENT_ITEM);
        Assert.assertTrue(alertFrameWindowsPage.getPageTitle().contains(ELEMENT_ITEM));
        //Click Alert, Frame & Windows Page - Click Browser Windows button
        alertFrameWindowsPage.chooseItemMenu(BROWSER_VALUE);
        Assert.assertTrue(alertFrameWindowsPage.getPageTitle().contains(BROWSER_VALUE));
        //Browser Windows Page - Get current window
        String currentWindow = newTabPage.getCurrentWindow();
        //Browser Windows Page - Click New Tab Button
        browserWindowsPage.clickNewTab();
        //Browser Windows Page - Switch on New Tab Page
        newTabPage.switchToNewTab();
        //New Tab Page - Get Text
        String newTabText = newTabPage.getNewTabText();
        Assert.assertEquals(newTabText, TEXT_SAMPLE);
        //New Tab Page - Switch to parent window
        newTabPage.switchToParentWindow(currentWindow);
        //Browser Windows Page - Click New Window Button
        browserWindowsPage.clickNewWindow();
        //Browser Windows Page - Switch on New Window Page
        newTabPage.switchToNewTab();
        //New Window Page - Get Text
        String newWindowText = newTabPage.getNewTabText();
        Assert.assertEquals(newWindowText, TEXT_SAMPLE);
        //New Window Page - Switch to parent window
        newTabPage.switchToParentWindow(currentWindow);
        //Browser Windows Page - Click New Tab Button
        browserWindowsPage.clickNewWindowMessage();
        //Browser Windows Page - Switch on New Blank Page
        newWindowMessagePage.switchToNewWindowMessage();
        //New Blank Page - Get URL
        Assert.assertTrue(newWindowMessagePage.getNewWindowText().contains(LONG_TEXT_SAMPLE));
        //New Blank Page - Switch to parent window
        newTabPage.switchToParentWindow(currentWindow);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}
