package pages.elements.checkBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebpageHandler;

public class CheckBoxPage {
    private final WebpageHandler webpageHandler;
    private final WebDriver driver;
    @FindBy(id="result")
    private WebElement youHaveSelectedMessage;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        this.webpageHandler = new WebpageHandler(driver);
        PageFactory.initElements(driver, this);
    }
    public void clickExpandNode(String expandNode){
        String expandNodeButtonXpath = "//label[@for='tree-node-"+expandNode+"']//preceding-sibling::button[@type='button']";
        WebElement expandNodeMenuButton = driver.findElement(By.xpath(expandNodeButtonXpath));
        webpageHandler.elementClickable(expandNodeMenuButton).click();
    }
    public void clickSelectNode(String selectNode){
        String selectNodeXpath = "//label[@for='tree-node-"+selectNode+"']";
        WebElement selectNodeButton = driver.findElement(By.xpath(selectNodeXpath));
        webpageHandler.elementClickable(selectNodeButton).click();
    }
    public String youHaveSelectedMessageDisplayedText(){
        webpageHandler.findElement(youHaveSelectedMessage);
        return youHaveSelectedMessage.getText();
    }
}
