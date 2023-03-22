package pageDemoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class BrowserWindowsPage {
    private WebDriver driver;
    private Utils utils;

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
        this.utils = new Utils(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickNewTab() {
        utils.findElement(newTabButton).click();
    }

    public void clickNewWindow() {
        utils.findElement(newWindowButton).click();
    }

    public void clickNewWindowMessage() {
        utils.findElement(newWindowMessageButton).click();
    }

}
