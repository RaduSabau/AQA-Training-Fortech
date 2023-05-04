package tests.demoqatests;

import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.alerts.MenuAlertFrameWindowsPage;
import pages.alerts.NestedFrames.NestedFramesPage;
import utils.WebpageHandler;

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