package oldPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContactPage extends LoadableComponent<ContactPage> {
    private final String URL = "https://www.fortech.ro/contact/";
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(name = "your-name")
    private WebElement myName;
    @FindBy(name = "organization")
    private WebElement myOrganization;
    @FindBy(name = "your-email")
    private WebElement myEmail;
    @FindBy(name = "your-phone")
    private WebElement myPhone;
    @FindBy(name = "your-message")
    private WebElement myMessage;
    @FindBy(name = "your-reason")
    private WebElement reason;
    @FindBy(name = "your-hear-about-us")
    private WebElement hearAboutUs;
    @FindBy(name = "collect-my-details[]")
    private WebElement collectMyDetails;
    @FindBy(name = "agree-be-contacted[]")
    private WebElement agreeToBeContacted;
    @FindBy(xpath = "//input[@value='Submit']")
    private WebElement submitContact;
    @FindBy(className = "wpcf7-response-output")
    private WebElement validationErrorMessage;

    public ContactPage(WebDriverWait wait) {
        this.wait = wait;
    }

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get(URL);
    }

    @Override
    protected void isLoaded() throws Error {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, URL);
    }

    private void enterName(String name) {
        myName.sendKeys(name);
    }

    private void enterOrganization(String organization) {
        myOrganization.sendKeys(organization);
    }

    private void enterMyEmail(String email) {
        myEmail.sendKeys(email);
    }

    private void enterTelephoneNumber(String telephone) {
        myPhone.sendKeys(telephone);
    }

    private void enterMessage(String message) {
        myMessage.sendKeys(message);
    }

    private void enterReasonToContact(String myReason) {
        Select selectReason = new Select(reason);
        selectReason.getOptions().stream().filter(e -> e.getText().contains(myReason)).findFirst().get().click();
    }

    private void enterWhereHearAboutUs(String aboutUs) {
        Select selectAboutUs = new Select(hearAboutUs);
        selectAboutUs.getOptions().stream().filter(e -> e.getText().contains(aboutUs)).findFirst().get().click();
    }

    private void clickCollectMyDetails() {
        collectMyDetails.click();
    }

    private void clickAgreeToBeContacted() {
        agreeToBeContacted.click();
    }

    private void clickSubmitContact() {
        submitContact.submit();
    }

    private WebElement elementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void testFillingContactForm(String name, String organization, String email, String telephone,
                                       String message, String myReason, String aboutUs) {
        enterName(name);
        enterOrganization(organization);
        enterMyEmail(email);
        enterTelephoneNumber(telephone);
        enterMessage(message);
        enterReasonToContact(myReason);
        enterWhereHearAboutUs(aboutUs);

    }

    public WebElement clickAgreeButtons() {
        elementToBeClickable(collectMyDetails);
        clickCollectMyDetails();
        elementToBeClickable(agreeToBeContacted);
        clickAgreeToBeContacted();
        clickSubmitContact();
        return validationErrorMessage;
    }


    public WebElement clickJustConsentCollectDetailsButton() {
        elementToBeClickable(collectMyDetails);
        clickCollectMyDetails();
        clickSubmitContact();
        return validationErrorMessage;
    }

    public WebElement clickJustAgreeToBeContactedButton() {
        elementToBeClickable(agreeToBeContacted);
        clickAgreeToBeContacted();
        clickSubmitContact();
        return validationErrorMessage;
    }
}
