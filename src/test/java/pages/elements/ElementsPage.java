package pages.elements;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class ElementsPage {
    private final Utils utils;
    WebDriver driver;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
    }

    public void clickOnWebTables() {
        utils.clickItemMenu(Constants.WEB_TABLES_ITEM);
    }

}
