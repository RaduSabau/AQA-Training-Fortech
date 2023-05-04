package archive;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class UnusedMethods {

    WebDriver driver;
    WebDriverWait wait;

    public UnusedMethods(WebDriver driver) {
        this.driver = driver;
    }
    public List<String> selects = Arrays.asList("Commands", "Public", "React", "Word File.doc");
    List<WebElement> names;
    private void selectMethod(){
            for (String a : selects) {
            for (WebElement e : names) {
                if (e.getText().contains(a)) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
                    e.click();
                }
            }
        }
    }
    public <T> void waitElement(T elementAttr) {
        if (elementAttr.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementAttr));
        } else {
            wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr));
        }
    }

    public <T> String readText(T elementAttr) {
        waitElement(elementAttr);
        if (elementAttr.getClass().getName().contains("By")) {
            return driver.findElement((By) elementAttr).getText();
        } else {
            return ((WebElement) elementAttr).getText();
        }
    }
}
