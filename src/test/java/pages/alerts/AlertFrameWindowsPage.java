package pages.alerts;

import org.openqa.selenium.WebDriver;
import utils.WebpageHandler;


public class AlertFrameWindowsPage {
    private final WebpageHandler webpageHandler;
    public static final String BROWSER_ITEM = "Browser Windows";
    public static final String NESTED_FRAMES_ITEM = "Nested Frames";

    public AlertFrameWindowsPage(WebDriver driver) {
        this.webpageHandler = new WebpageHandler(driver);
    }

    public void clickOnBrowserWindows() {
        webpageHandler.clickItemMenu(BROWSER_ITEM);
    }

    public void clickOnNestedFrames() {
        webpageHandler.clickItemMenu(NESTED_FRAMES_ITEM);
    }


}
