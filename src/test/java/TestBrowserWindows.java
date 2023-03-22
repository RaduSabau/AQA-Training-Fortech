import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageDemoqa.AlertFrameWindowsPage;
import pageDemoqa.BrowserWindowsPage;
import pageDemoqa.MainPage;

public class TestBrowserWindows {
    WebDriver driver;

    private static final String BROWSER_VALUE = "Browser Windows";
    private static final String elementItem = "Alerts, Frame & Windows";

    @BeforeClass
    public void setup() {
        String URL = "https://demoqa.com/";
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*").addArguments("--start-maximized=*"));
        driver.get(URL);
    }

    @Test
    public void testBrowserWindows() {

        MainPage mainPage = new MainPage(driver);
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);
        AlertFrameWindowsPage alertFrameWindowsPage = new AlertFrameWindowsPage(driver);
        mainPage.clickAlertFrameWindowsMeniuButton(elementItem);
        alertFrameWindowsPage.chooseItemMenu(BROWSER_VALUE);
        browserWindowsPage.cclickNewTab();
        browserWindowsPage.clickNewTab();
        browserWindowsPage.clickNewWindow();
        browserWindowsPage.clickNewWindowMessage();
    }

    @AfterClass
    public void close() {
//        driver.quit();
    }
}
