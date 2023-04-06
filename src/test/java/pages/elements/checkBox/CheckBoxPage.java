package pages.elements.checkBox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebpageHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckBoxPage {
    private static final String expandNode = "//label[@for='tree-node-$replaceMe$']//preceding-sibling::button[@type='button']";
    private static final String checkbox = "//label[@for='tree-node-$replaceMe$']";
    private final WebpageHandler webpageHandler;
    private final WebDriver driver;
    private final Map<String, String> options = new HashMap<>() {{
        put("expandNode", expandNode);
        put("checkbox", checkbox);
    }};
    public List<String> selects = Arrays.asList("Commands", "Public", "React", "Word File.doc");
    @FindBy(id = "result")
    private WebElement youHaveSelectedMessage;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        this.webpageHandler = new WebpageHandler(driver);
        PageFactory.initElements(driver, this);
    }

    public void click(String selection, String name) {
        By element = By.xpath(options.get(selection).replace("$replaceMe$", name));
        webpageHandler.findElement(driver.findElement(element)).click();
    }

    public String youHaveSelectedMessageDisplayedText() {
        return webpageHandler.findElement(youHaveSelectedMessage).getText().toLowerCase();
    }

    public void getNodes() {

        while (isaBoolean()) {
            WebElement element = driver.findElement(By.xpath("//*[contains(@class, 'rct-node-collapsed')]//button"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }

        List<WebElement> names = driver.findElements(By.xpath("//*[@class='rct-title']"));

        selects.forEach(s -> names.stream()
                .filter(e -> e.getText().contains(s))
                .peek(element -> ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element))
                .findFirst().get().click());

//        for (String a : selects) {
//            for (WebElement e : names) {
//                if (e.getText().contains(a)) {
//                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
//                    e.click();
//                }
//            }
//        }
    }

    private boolean isaBoolean() {
        return driver.findElements(By.xpath("//*[contains(@class, 'rct-node-collapsed')]//button")).size() > 0;
    }
}
