package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;

public class HomePage {
    private final Utils utils;
    protected WebDriver driver;
    private static final String ALERTS_CATEGORY = "Alerts, Frame & Windows";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
    }

    public void clickAlertFrameWindowsCategory() {
        utils.clickCategory(ALERTS_CATEGORY);
    }

}
