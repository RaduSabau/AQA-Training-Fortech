package pages.elements;

import org.openqa.selenium.WebDriver;
import utils.WebpageHandler;

public class MenuElements {
    private final WebpageHandler webpageHandler;
    public static final String WEB_TABLES_ITEM = "Web Tables";
    public static final String CHECK_BOX_ITEM = "Check Box";

    public MenuElements(WebDriver driver) {
        this.webpageHandler = new WebpageHandler(driver);
    }

    public void clickOnWebTables() {
        webpageHandler.clickItemMenu(WEB_TABLES_ITEM);
    }

    public void clickOnCheckBox() {
        webpageHandler.clickItemMenu(CHECK_BOX_ITEM);
    }

}
