package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class TrainingPage extends LoadableComponent<TrainingPage> {
    private final String URL = "https://www.fortech.ro/careers/training-internship-programs/";
    WebDriver driver;
    @FindBy(className = "contact")
    private WebElement contact;

    public TrainingPage(WebDriver driver) {
        this.driver = driver;
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
    public ContactPage clickContactButton(){
        contact.click();
        return new ContactPage(driver);
    }
}

