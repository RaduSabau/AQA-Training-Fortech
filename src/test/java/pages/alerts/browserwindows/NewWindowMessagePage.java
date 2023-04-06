package pages.alerts.browserwindows;

import org.openqa.selenium.WebDriver;
import utils.WebpageHandler;

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