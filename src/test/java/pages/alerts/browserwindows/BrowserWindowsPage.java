package pages.alerts.browserwindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebpageHandler;

public class BrowserWindowsPage {
    private final WebpageHandler webpageHandler;

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
        this.webpageHandler = new WebpageHandler(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickNewTab() {
        webpageHandler.elementClickable(newTabButton).click();
    }

    public void clickNewWindow() {
        webpageHandler.elementClickable(newWindowButton).click();
    }

    public void clickNewWindowMessage() {
        webpageHandler.elementClickable(newWindowMessageButton).click();
    }

}
