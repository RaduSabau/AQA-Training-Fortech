package testDemoqa;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.elements.ElementsPage;
import pages.elements.checkBox.CheckBoxPage;
import utils.Utils;

public class TestCheckBox {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*").addArguments("--start-maximized=*"));
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
        driver.get(Constants.MAIN_URL);

    }
    @Test
    public void testCheckBox() {
        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        Utils utils = new Utils(driver);
        homePage.clickElementsCategory();
        Assert.assertTrue(utils.getPageTitle().contains(Constants.ELEMENTS_CATEGORY));
        elementsPage.clickOnCheckBox();
        Assert.assertTrue(utils.getPageTitle().contains(Constants.CHECK_BOX_ITEM));
        checkBoxPage.clickExpandNode(Constants.HOME_NODE);
        checkBoxPage.clickExpandNode(Constants.DOCUMENTS_NODE);
        checkBoxPage.clickExpandNode(Constants.WORK_SPACE_NODE);
        checkBoxPage.clickSelectNode(Constants.REACT_NODE);
        checkBoxPage.clickSelectNode(Constants.ANGULAR_NODE);
        Assert.assertTrue(checkBoxPage.youHaveSelectedMessageDisplayedText().contains(Constants.REACT_NODE));
        Assert.assertTrue(checkBoxPage.youHaveSelectedMessageDisplayedText().contains(Constants.ANGULAR_NODE));
    }
    //    @AfterMethod
//    public void close() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
