package pages.forms;

import org.openqa.selenium.WebDriver;
import utils.WebpageHandler;

public class MenuForms {
    private final WebpageHandler webpageHandler;
    public static final String PRACTICE_FORM_ITEM = "Practice Form";
    public MenuForms(WebDriver driver) {
        this.webpageHandler = new WebpageHandler(driver);
    }
    public void clickOnPracticeForm() {
        webpageHandler.clickItemMenu(PRACTICE_FORM_ITEM);
    }


}
