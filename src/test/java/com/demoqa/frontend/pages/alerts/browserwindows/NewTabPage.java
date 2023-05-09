package com.demoqa.frontend.pages.alerts.browserwindows;

import com.demoqa.frontend.utils.WebpageHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTabPage {
    private final WebDriver driver;
    private final WebpageHandler webpageHandler;
    @FindBy(id="sampleHeading")
    private WebElement sampleHeadingElement;

    public NewTabPage(WebDriver driver) {
        this.driver = driver;
        webpageHandler = new WebpageHandler(driver);
        PageFactory.initElements(driver, this);
    }

    public void switchToNewTab() {
        String urlIdentifier = "/sample";
        webpageHandler.switchWindow(urlIdentifier);

    }

    public String getNewTabText() {
        return sampleHeadingElement.getText();
    }

    public String getCurrentWindow() {
        return driver.getWindowHandle();
    }

    public void switchToParentWindow(String parentWindow) {
        driver.switchTo().window(parentWindow);
    }

}
