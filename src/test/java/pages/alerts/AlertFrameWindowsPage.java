package pages.alerts;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;


public class AlertFrameWindowsPage {
    private final WebDriver driver;
    private final Utils utils;


    public AlertFrameWindowsPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
    }

    public void clickOnBrowserWindows() {
        utils.clickItemMenu(Constants.BROWSER_ITEM);
    }

    public String getPageTitle() {
        WebElement pageTitle = driver.findElement(By.className("main-header"));
        utils.findElement(pageTitle);
        return pageTitle.getText();
    }

}
