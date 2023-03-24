package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    public void chooseItemMenu(String itemMenu) {
        String itemMenuXpath = "//span[contains(text(),'" + itemMenu + "')]";
        WebElement menuItem = driver.findElement(By.xpath(itemMenuXpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menuItem);
        utils.elementClickable(menuItem).click();
    }

    public String getPageTitle() {
        WebElement pageTitle = driver.findElement(By.className("main-header"));
        utils.findElement(pageTitle);
        return pageTitle.getText();
    }

}
