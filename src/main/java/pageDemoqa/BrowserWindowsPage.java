package pageDemoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;

public class BrowserWindowsPage{
    private WebDriver driver;
    private Utils utils ;
    WebDriverWait wait;
    @FindBy(id = "tabButton")
    private WebElement newTabButton;
    @FindBy(id = "windowButton")
    private WebElement newWindowButton;
    @FindBy(id = "messageWindowButton")
    private WebElement newWindowMessageButton;
    @FindBy(id = "sampleHeading")
    private WebElement newTabSampleText;
    @FindBy(tagName = "body")
    private WebElement newWindowMessageText;

    public BrowserWindowsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.utils = new Utils(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickNewTab() {
        utils.findElement(newTabButton).click();
        String currentHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
//        waitForElementToBeVisible(newTabSampleText);
        String newTabTextDisplayed = newTabSampleText.getText();
        driver.switchTo().window(currentHandle);
        System.out.println(newTabTextDisplayed);
    }

    public void clickNewWindow() {
        utils.findElement(newWindowButton).click();
        String currentHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
//        waitForElementToBeVisible(newTabSampleText);
        String newWindowTextDisplayed = newTabSampleText.getText();
        driver.switchTo().window(currentHandle);
        System.out.println(newWindowTextDisplayed);
    }

    public void clickNewWindowMessage() {
        utils.findElement(newWindowMessageButton).click();
        String currentHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
//        waitForElementToBeVisible(newWindowMessageText);
        String pageSource = driver.getPageSource();
        driver.switchTo().window(currentHandle);
        System.out.println(pageSource);
    }
    public void cclickNewTab() {
        utils.findElement(newTabButton).click();
    }
}
