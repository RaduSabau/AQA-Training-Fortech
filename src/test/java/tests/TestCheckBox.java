package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.elements.MenuElements;
import pages.elements.checkBox.CheckBoxPage;
import utils.WebpageHandler;

import static constants.Constants.*;


public class TestCheckBox extends MainPage {

    @Test
    public void testCheckBox() {
        WebpageHandler webpageHandler = new WebpageHandler(driver);
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        new HomePage(driver).clickElementsCategory();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(HomePage.ELEMENTS_CATEGORY));
        new MenuElements(driver).clickOnCheckBox();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(MenuElements.CHECK_BOX_ITEM));
        String expand = "expandNode";
        String checkbox = "checkbox";

        checkBoxPage.click(expand, HOME_NODE);
        checkBoxPage.click(expand, DOCUMENTS_NODE);
        checkBoxPage.click(expand, WORK_SPACE_NODE);
        checkBoxPage.click(checkbox, REACT_NODE);
        checkBoxPage.click(checkbox, ANGULAR_NODE);
        checkBoxPage.click(checkbox, VEU_NODE);
        Assert.assertTrue(checkBoxPage.youHaveSelectedMessageDisplayedText().contains(REACT_NODE));
        Assert.assertTrue(checkBoxPage.youHaveSelectedMessageDisplayedText().contains(ANGULAR_NODE));
        Assert.assertTrue(checkBoxPage.youHaveSelectedMessageDisplayedText().contains(VEU_NODE));
        Assert.assertTrue(checkBoxPage.youHaveSelectedMessageDisplayedText().contains(WORK_SPACE_NODE));
    }

    @Test
    public void test() {
        WebpageHandler webpageHandler = new WebpageHandler(driver);
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        new HomePage(driver).clickElementsCategory();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(HomePage.ELEMENTS_CATEGORY));
        new MenuElements(driver).clickOnCheckBox();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(MenuElements.CHECK_BOX_ITEM));

        checkBoxPage.getNodes();
        checkBoxPage.selects.forEach(s -> Assert.assertTrue(checkBoxPage.youHaveSelectedMessageDisplayedText()
                .contains(s.toLowerCase().replaceAll("\\s","").replace(".doc",""))));
    }

}
