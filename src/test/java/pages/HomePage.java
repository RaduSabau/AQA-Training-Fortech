package pages;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class HomePage {
    private final Utils utils;
    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
    }

    public void clickAlertFrameWindowsCategory() {
        utils.clickCategory(Constants.ALERTS_FRAME_WINDOWS_CATEGORY);
    }

    public void clickElementsCategory() {
        utils.clickCategory(Constants.ELEMENTS_CATEGORY);
    }

    public void clickFormsCategory() {
        utils.clickCategory(Constants.FORMS_CATEGORY);
    }
    public void clickWidgetsCategory() {
        utils.clickCategory(Constants.WIDGETS_CATEGORY);
    }
    public void clickInteractionsCategory() {
        utils.clickCategory(Constants.INTERACTIONS_CATEGORY);
    }

}
