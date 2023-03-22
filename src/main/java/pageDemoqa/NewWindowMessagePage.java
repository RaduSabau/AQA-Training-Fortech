package pageDemoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class NewWindowMessagePage {
    private final WebDriver driver;
    private Utils utils;
    private String urlIdentifier = "about:blank";
    private String currentWindow;

    public NewWindowMessagePage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToNewWindowMessage() {
        Utils utils = new Utils(driver);
        utils.switchWindow(urlIdentifier);
    }

    public String getNewWindowText() {
        return driver.getPageSource();
    }
}