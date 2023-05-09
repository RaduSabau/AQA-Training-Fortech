package com.demoqa.frontend.pages.alerts.browserwindows;

import com.demoqa.frontend.utils.WebpageHandler;
import org.openqa.selenium.WebDriver;

public class NewWindowMessagePage {
    private static final String urlIdentifier = "about:blank";
    private final WebDriver driver;
    private final WebpageHandler webpageHandler;

    public NewWindowMessagePage(WebDriver driver) {
        this.driver = driver;
        this.webpageHandler = new WebpageHandler(driver);
    }

    public void switchToNewWindowMessage() {
        webpageHandler.switchWindow(urlIdentifier);
    }

    public String getNewWindowText() {
        return driver.getPageSource();
    }
}