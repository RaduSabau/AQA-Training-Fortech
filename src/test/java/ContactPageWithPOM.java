import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.TrainingPage;

public class ContactPageWithPOM {
    WebDriver driver;
    final String name = " ";
    final String organization = "Fortech";
    final String email = "myname@fortech.ro";
    final String telephone = "0747761303";
    final String message = "This is the message";
    final String myReason = "Sponsorship";
    final String aboutUs = "Social Media";

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*").addArguments("--start-maximized=*"));
    }

    @Test
    public void testContactWithPOM() {
        TrainingPage trainingPage = new TrainingPage(driver);
        trainingPage.get();
        ContactPage contactPage = trainingPage.clickContactButton();
        WebElement submitErrorMessageDisplayed = contactPage.testFillingContactForm(name,organization,email,telephone,message,myReason,aboutUs);
        Assert.assertTrue(submitErrorMessageDisplayed.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
//        driver.quit();
    }
}
