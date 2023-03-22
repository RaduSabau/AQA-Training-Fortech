package pageDemoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class NewTabPage {
    WebDriver driver;
    String currentWindow;
    private Utils utils;

    private String urlIdentifier = "/sample";

    public NewTabPage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToNewTab() {
        Utils utils = new Utils(driver);
        utils.switchWindow(urlIdentifier);
    }

    public String getNewTabText() {
        return driver.findElement(By.id("sampleHeading")).getText();
    }

    public String getCurrentWindow() {
        return driver.getWindowHandle();
    }

    public void switchToParentWindow(String parentWindow) {
        driver.switchTo().window(parentWindow);
    }

}
