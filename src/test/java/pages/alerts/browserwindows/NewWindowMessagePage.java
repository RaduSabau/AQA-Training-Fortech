package pages.alerts.browserwindows;

import org.openqa.selenium.WebDriver;
import utils.WebpageHandler;

public class NewWindowMessagePage {
    private final WebDriver driver;
    private final WebpageHandler webpageHandler;
    private final String urlIdentifier = "about:blank";

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