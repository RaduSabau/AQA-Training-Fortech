package pages;

import org.openqa.selenium.WebDriver;
import utils.WebpageHandler;

public class HomePage {
    public static final String ALERTS_FRAME_WINDOWS_CATEGORY = "Alerts, Frame & Windows";
    public static final String ELEMENTS_CATEGORY = "Elements";
    public static final String FORMS_CATEGORY = "Forms";

    private final WebpageHandler webpageHandler;
    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.webpageHandler = new WebpageHandler(driver);
    }

    public void clickAlertFrameWindowsCategory() {
        webpageHandler.clickCategory(ALERTS_FRAME_WINDOWS_CATEGORY);
    }

    public void clickElementsCategory() {
        webpageHandler.clickCategory(ELEMENTS_CATEGORY);
    }

    public void clickFormsCategory() {
        webpageHandler.clickCategory(FORMS_CATEGORY);
    }

}
