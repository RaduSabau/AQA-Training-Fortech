package com.demoqa.frontend.pages.forms;

import com.demoqa.frontend.utils.WebpageHandler;
import org.openqa.selenium.WebDriver;

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
