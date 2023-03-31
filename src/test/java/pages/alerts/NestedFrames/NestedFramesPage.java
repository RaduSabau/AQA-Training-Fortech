package pages.alerts.NestedFrames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebpageHandler;

public class NestedFramesPage {
    private final WebDriver driver;
    private final WebpageHandler webpageHandler;

    @FindBy(id="frame1")
    private WebElement parentFrame;
    @FindBy(xpath="//html/body")
    private WebElement frameTextElement;
    @FindBy(xpath="//iframe[@srcdoc]")
    private WebElement innerFrame;

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
        this.webpageHandler = new WebpageHandler(driver);
        PageFactory.initElements(driver, this);
    }
    public void switchToParentFrame(){
        driver.switchTo().frame(parentFrame);
    }
    public String frameText(){
        webpageHandler.findElement(frameTextElement);
        return frameTextElement.getText();
    }
    public void switchToInnerFrame(){
        driver.switchTo().frame(innerFrame);
    }
}
