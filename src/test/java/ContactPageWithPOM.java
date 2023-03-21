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

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*").addArguments("--start-maximized=*"));
    }

    //Test Contact Form with blank username field and all others valid
    @Test
    public void testContactFormWithBlankUsernameField() {
        String emptyName = " ";
        String organization = "Fortech";
        String email = "myname@fortech.ro";
        String telephone = "0345678910";
        String message = "This is the message";
        String myReason = "Sponsorship";
        String aboutUs = "Social Media";
        TrainingPage trainingPage = new TrainingPage(driver);
        trainingPage.get();
        ContactPage contactPage = trainingPage.clickContactButton();
        contactPage.testFillingContactForm(emptyName, organization, email, telephone, message, myReason, aboutUs);
        WebElement submitErrorMessageDisplayed = contactPage.clickAgreeButtons();
        Assert.assertTrue(submitErrorMessageDisplayed.isDisplayed());
    }

    //Test Contact Form with blank password field and all others valid
    @Test
    public void testContactFormWithBlankPasswordField() {
        String name = "My Name";
        String emptyOrganization = " ";
        String email = "myname@fortech.ro";
        String telephone = "0345678910";
        String message = "This is the message";
        String myReason = "Sponsorship";
        String aboutUs = "Social Media";
        TrainingPage trainingPage = new TrainingPage(driver);
        trainingPage.get();
        ContactPage contactPage = trainingPage.clickContactButton();
        contactPage.testFillingContactForm(name, emptyOrganization, email, telephone, message, myReason, aboutUs);
        WebElement submitErrorMessageDisplayed = contactPage.clickAgreeButtons();
        Assert.assertTrue(submitErrorMessageDisplayed.isDisplayed());
    }
    //Test Contact Form with blank password field and all others valid
    @Test
    public void testContactFormWithBlankEmailField() {
        String name = "My Name";
        String organization = "Fortech";
        String emptyEmail = " ";
        String telephone = "0345678910";
        String message = "This is the message";
        String myReason = "Sponsorship";
        String aboutUs = "Social Media";
        TrainingPage trainingPage = new TrainingPage(driver);
        trainingPage.get();
        ContactPage contactPage = trainingPage.clickContactButton();
        contactPage.testFillingContactForm(name, organization, emptyEmail, telephone, message, myReason, aboutUs);
        WebElement submitErrorMessageDisplayed = contactPage.clickAgreeButtons();
        Assert.assertTrue(submitErrorMessageDisplayed.isDisplayed());
    }
    @Test
    public void testContactFormWithoutAgreeToBeContactedClicked(){
        String name = "My Name";
        String organization = "Fortech";
        String email = "myname@fortech.ro";
        String telephone = "0345678910";
        String message = "This is the message";
        String myReason = "Sponsorship";
        String aboutUs = "Social Media";
        TrainingPage trainingPage = new TrainingPage(driver);
        trainingPage.get();
        ContactPage contactPage = trainingPage.clickContactButton();
        contactPage.testFillingContactForm(name, organization, email, telephone, message, myReason, aboutUs);
        WebElement submitErrorMessageDisplayed = contactPage.clickJustConsentCollectDetailsButton();
        Assert.assertTrue(submitErrorMessageDisplayed.isDisplayed());
    }
    @Test
    public void testContactFormWithoutDataConsentClicked(){
        String name = "My Name";
        String organization = "Fortech";
        String email = "myname@fortech.ro";
        String telephone = "0345678910";
        String message = "This is the message";
        String myReason = "Sponsorship";
        String aboutUs = "Social Media";
        TrainingPage trainingPage = new TrainingPage(driver);
        trainingPage.get();
        ContactPage contactPage = trainingPage.clickContactButton();
        contactPage.testFillingContactForm(name, organization, email, telephone, message, myReason, aboutUs);
        WebElement submitErrorMessageDisplayed = contactPage.clickJustAgreeToBeContactedButton();
        Assert.assertTrue(submitErrorMessageDisplayed.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
//        driver.quit();
    }
}
