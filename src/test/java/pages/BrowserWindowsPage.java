package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class BrowserWindowsPage {
    private final Utils utils;

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
        this.utils = new Utils(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickNewTab() {
        utils.elementClickable(newTabButton).click();
    }

    public void clickNewWindow() {
        utils.elementClickable(newWindowButton).click();
    }

    public void clickNewWindowMessage() {
        utils.elementClickable(newWindowMessageButton).click();
    }

}
