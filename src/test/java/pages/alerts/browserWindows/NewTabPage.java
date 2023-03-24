package pages.alerts.browserWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class NewTabPage {
    private final WebDriver driver;
    private final Utils utils;

    private final String urlIdentifier = "/sample";

    public NewTabPage(WebDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
    }

    public void switchToNewTab() {
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
