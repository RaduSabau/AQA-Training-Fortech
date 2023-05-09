package com.demoqa.frontend.tests;

import com.demoqa.frontend.constants.Constants;
import com.demoqa.frontend.pages.HomePage;
import com.demoqa.frontend.pages.elements.MenuElements;
import com.demoqa.frontend.utils.WebpageHandler;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.frontend.pages.elements.checkBox.CheckBoxPage;


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

        checkBoxPage.click(expand, Constants.HOME_NODE);
        checkBoxPage.click(expand, Constants.DOCUMENTS_NODE);
        checkBoxPage.click(expand, Constants.WORK_SPACE_NODE);
        checkBoxPage.click(checkbox, Constants.REACT_NODE);
        checkBoxPage.click(checkbox, Constants.ANGULAR_NODE);
        checkBoxPage.click(checkbox, Constants.VEU_NODE);
        Assert.assertTrue(checkBoxPage.youHaveSelectedMessageDisplayedText().contains(Constants.REACT_NODE));
        Assert.assertTrue(checkBoxPage.youHaveSelectedMessageDisplayedText().contains(Constants.ANGULAR_NODE));
        Assert.assertTrue(checkBoxPage.youHaveSelectedMessageDisplayedText().contains(Constants.VEU_NODE));
        Assert.assertTrue(checkBoxPage.youHaveSelectedMessageDisplayedText().contains(Constants.WORK_SPACE_NODE));
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
