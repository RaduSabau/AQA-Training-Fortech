package pages;

import org.openqa.selenium.WebDriver;
import utils.WebpageHandler;

public class HomePage {
    private final WebpageHandler webpageHandler;
    protected WebDriver driver;
    public static final String ALERTS_FRAME_WINDOWS_CATEGORY = "Alerts, Frame & Windows";
    public static final String ELEMENTS_CATEGORY = "Elements";
    public static final String WIDGETS_CATEGORY = "Widgets";
    public static final String INTERACTIONS_CATEGORY = "Interactions";

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

    public void clickWidgetsCategory() {
        webpageHandler.clickCategory(WIDGETS_CATEGORY);
    }
    public void clickInteractionsCategory() {
        webpageHandler.clickCategory(INTERACTIONS_CATEGORY);
    }

}
