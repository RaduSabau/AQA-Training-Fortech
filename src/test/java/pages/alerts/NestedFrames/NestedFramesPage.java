package pages.alerts.NestedFrames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebpageHandler;

public class NestedFramesPage {
    private final WebDriver driver;
    private final WebpageHandler webpageHandler;

    @FindBy(id = "frame1")
    private WebElement parentFrame;
    @FindBy(xpath = "//html/body")
    private WebElement frameTextElement;
    @FindBy(xpath = "//iframe[@srcdoc]")
    private WebElement innerFrame;

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
        this.webpageHandler = new WebpageHandler(driver);
        PageFactory.initElements(driver, this);
    }

    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchToParentFrame() {
        switchToFrame(parentFrame);
    }

    public String frameText() {
        return webpageHandler.findElement(frameTextElement).getText();
    }

    public void switchToInnerFrame() {
        switchToFrame(innerFrame);
    }
}
