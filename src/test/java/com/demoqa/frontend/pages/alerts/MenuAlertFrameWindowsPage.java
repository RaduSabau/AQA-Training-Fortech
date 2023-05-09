package com.demoqa.frontend.pages.alerts;

import com.demoqa.frontend.utils.WebpageHandler;
import org.openqa.selenium.WebDriver;


public class MenuAlertFrameWindowsPage {
    private final WebpageHandler webpageHandler;
    public static final String BROWSER_ITEM = "Browser Windows";
    public static final String NESTED_FRAMES_ITEM = "Nested Frames";

    public MenuAlertFrameWindowsPage(WebDriver driver) {
        this.webpageHandler = new WebpageHandler(driver);
    }

    public void clickOnBrowserWindows() {
        webpageHandler.clickItemMenu(BROWSER_ITEM);
    }

    public void clickOnNestedFrames() {
        webpageHandler.clickItemMenu(NESTED_FRAMES_ITEM);
    }


}
