package com.demoqa.frontend.tests;

import com.demoqa.frontend.constants.Constants;
import com.demoqa.frontend.utils.BrowserReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class MainPage {
    protected WebDriver driver;
    private BrowserReader browserReader;

    @BeforeClass
    public void setup() {
        browserReader = new BrowserReader("chrome");
        driver = browserReader.getDriver();
        driver.get(Constants.MAIN_URL);
    }

    @AfterClass
    public void close() {
        if (browserReader != null) {
            browserReader.quit();
        }
    }
}
