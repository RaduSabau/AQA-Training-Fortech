package tests;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.elements.MenuElements;
import pages.elements.checkBox.CheckBoxPage;
import utils.WebpageHandler;

public class TestCheckBox {
    private WebDriver driver;
    private WebpageHandler webpageHandler;
    private CheckBoxPage checkBoxPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*").addArguments("--start-maximized=*"));
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
        driver.get(Constants.MAIN_URL);
        webpageHandler = new WebpageHandler(driver);
        checkBoxPage = new CheckBoxPage(driver);
    }

    @Test
    public void testCheckBox() {
        new HomePage(driver).clickElementsCategory();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(HomePage.ELEMENTS_CATEGORY));
        new MenuElements(driver).clickOnCheckBox();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(MenuElements.CHECK_BOX_ITEM));
        checkBoxPage.clickExpandNode(Constants.HOME_NODE);
        checkBoxPage.clickExpandNode(Constants.DOCUMENTS_NODE);
        checkBoxPage.clickExpandNode(Constants.WORK_SPACE_NODE);
        checkBoxPage.clickSelectNode(Constants.REACT_NODE);
        checkBoxPage.clickSelectNode(Constants.ANGULAR_NODE);
        checkBoxPage.clickSelectNode(Constants.VEU_NODE);
        Assert.assertTrue(checkBoxPage.youHaveSelectedMessageDisplayedText().contains(Constants.REACT_NODE));
        Assert.assertTrue(checkBoxPage.youHaveSelectedMessageDisplayedText().contains(Constants.ANGULAR_NODE));
        Assert.assertTrue(checkBoxPage.youHaveSelectedMessageDisplayedText().contains(Constants.VEU_NODE));
        Assert.assertTrue(checkBoxPage.youHaveSelectedMessageDisplayedText().contains(Constants.WORK_SPACE_NODE));
    }

    @AfterClass
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
