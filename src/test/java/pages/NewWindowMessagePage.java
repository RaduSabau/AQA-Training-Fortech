package pages;

import org.openqa.selenium.WebDriver;
import utils.Utils;

public class NewWindowMessagePage {
    private final WebDriver driver;
    private final Utils utils;
    private final String urlIdentifier = "about:blank";

    public NewWindowMessagePage(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
    }

    public void switchToNewWindowMessage() {
        utils.switchWindow(urlIdentifier);
    }

    public String getNewWindowText() {
        return driver.getPageSource();
    }
}