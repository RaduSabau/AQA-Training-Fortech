package tests.demoqatests;

import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.alerts.MenuAlertFrameWindowsPage;
import pages.alerts.browserwindows.BrowserWindowsPage;
import pages.alerts.browserwindows.NewTabPage;
import pages.alerts.browserwindows.NewWindowMessagePage;
import utils.WebpageHandler;


public class TestBrowserWindows extends MainPage {

    @Test
    public void testBrowserWindows() {
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);
        NewTabPage newTabPage = new NewTabPage(driver);
        NewWindowMessagePage newWindowMessagePage = new NewWindowMessagePage(driver);
        WebpageHandler webpageHandler = new WebpageHandler(driver);

        new HomePage(driver).clickAlertFrameWindowsCategory();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(HomePage.ALERTS_FRAME_WINDOWS_CATEGORY));

        new MenuAlertFrameWindowsPage(driver).clickOnBrowserWindows();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(MenuAlertFrameWindowsPage.BROWSER_ITEM));

        String currentWindow = newTabPage.getCurrentWindow();
        browserWindowsPage.clickNewTab();

        newTabPage.switchToNewTab();

        String newTabText = newTabPage.getNewTabText();
        Assert.assertEquals(newTabText, Constants.TEXT_SAMPLE);

        newTabPage.switchToParentWindow(currentWindow);

        browserWindowsPage.clickNewWindow();

        newTabPage.switchToNewTab();

        String newWindowText = newTabPage.getNewTabText();
        Assert.assertEquals(newWindowText, Constants.TEXT_SAMPLE);

        newTabPage.switchToParentWindow(currentWindow);

        browserWindowsPage.clickNewWindowMessage();

        newWindowMessagePage.switchToNewWindowMessage();

        Assert.assertTrue(newWindowMessagePage.getNewWindowText().contains(Constants.LONG_TEXT_SAMPLE));

        newTabPage.switchToParentWindow(currentWindow);
    }
}
//taskKill /t /f /im chromedriver.exe /im chrome.exe /im geckodriver.exe