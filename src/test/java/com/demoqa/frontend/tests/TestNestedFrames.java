package com.demoqa.frontend.tests;

import com.demoqa.frontend.constants.Constants;
import com.demoqa.frontend.pages.HomePage;
import com.demoqa.frontend.utils.WebpageHandler;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.frontend.pages.alerts.MenuAlertFrameWindowsPage;
import com.demoqa.frontend.pages.alerts.NestedFrames.NestedFramesPage;

public class TestNestedFrames extends MainPage {

    @Test
    public void testNestedFrames() {
        NestedFramesPage nestedFramesPage = new NestedFramesPage(driver);
        WebpageHandler webpageHandler = new WebpageHandler(driver);

        new HomePage(driver).clickAlertFrameWindowsCategory();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(HomePage.ALERTS_FRAME_WINDOWS_CATEGORY));

        new MenuAlertFrameWindowsPage(driver).clickOnNestedFrames();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(MenuAlertFrameWindowsPage.NESTED_FRAMES_ITEM));

        nestedFramesPage.switchToParentFrame();
        Assert.assertEquals(nestedFramesPage.frameText(), Constants.PARENT_FRAME_TEXT);

        nestedFramesPage.switchToInnerFrame();
        Assert.assertEquals(nestedFramesPage.frameText(), Constants.INNER_FRAME_TEXT);
    }

}