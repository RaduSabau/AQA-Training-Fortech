package com.saucedemo.test;

import com.demoqa.frontend.utils.BrowserReader;
import com.saucedemo.constants.Constants;
import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceDemoLoginTest{
    protected WebDriver driver;

    @DataProvider(name="data-provider", parallel=true)
    public Object[][]dpMethod(){
        return new Object[][]{{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"}};
    }
    @Test(dataProvider = "data-provider")
    public void loginTest(String username, String password){
        BrowserReader browserReader = new BrowserReader("chrome");
        driver = browserReader.getDriver();
        driver.get(Constants.MAIN_SAUCEDEMO_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWith(username,password);
        driver.quit();
    }
}
