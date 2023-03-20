import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(className = "contact")
    private WebElement contact;
    @FindBy(name = "your-name")
    private WebElement yourName;
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

    public TestSelenium() {
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*").addArguments("--start-maximized=*"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, TestSelenium.this);
    }

    @Test
    public void testMe() {
        final String url = "https://www.fortech.ro/careers/training-internship-programs/";
        final String name = "My name";
        final String organization = "Fortech";
        final String email = "myname@fortech.ro";
        final String telephone = "0747761303";
        final String message = "This is the message";
        final String myReason = "Sponsorship";
        final String aboutUs = "Social Media";

        driver.get(url);
        Actions actions = new Actions(driver);
        findElement(contact);
        actions.moveToElement(contact).click().build().perform();
        Assert.assertTrue(driver.getCurrentUrl().contains("/contact/"), "Not on contact page");
        findElement(yourName);
//        actions.moveToElement(yourName).sendKeys(name).build().perform();
//        actions.moveToElement(myOrganization).sendKeys(organization);
//        wait.until(ExpectedConditions.visibilityOf(contact));
//        contact.click();
        yourName.sendKeys(name);
        myOrganization.sendKeys(organization);
        myEmail.sendKeys(email);
        myPhone.sendKeys(telephone);
        myMessage.sendKeys(message);
        Select selectReason = new Select(reason);
//        selectReason.selectByValue(myReason);
//        for (WebElement option : selectReason.getOptions()) {
//            option.click();
//            System.out.println("Select option: " + selectReason.getFirstSelectedOption().getText());
//        }
//        selectReason.getOptions().stream().filter(element -> element.getText().contains("Inquiry"))
//                .peek(e -> System.out.println(e.getText())).forEach(WebElement::click);
        selectReason.getOptions().stream().filter(e -> e.getText().contains(myReason)).findFirst().get().click();
        System.out.println(selectReason.getOptions().stream().anyMatch(element -> element.getText().contains(myReason)));
        Select selectAboutUs = new Select(hearAboutUs);
        selectAboutUs.getOptions().stream().filter(e -> e.getText().contains(aboutUs)).findFirst().get().click();
        System.out.println(selectAboutUs.getOptions().stream().anyMatch(element -> element.getText().contains(aboutUs)));
//        selectAboutUs.selectByValue(aboutUs);
        collectMyDetails.click();
        agreeToBeContacted.click();
        driver.quit();
    }

    private WebElement findElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
