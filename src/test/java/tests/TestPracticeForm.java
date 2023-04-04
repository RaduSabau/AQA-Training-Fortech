package tests;

import entities.practiceform.Student;
import entities.practiceform.Students;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.forms.MenuForms;
import pages.forms.PracticeForm;
import utils.Utils;
import utils.WebpageHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static constants.Constants.*;


public class TestPracticeForm {
    protected WebDriver driver;
    private WebpageHandler webpageHandler;
    private PracticeForm practiceForm;

    private static ChromeOptions getChromeOptions() {
        return new ChromeOptions()
//                .addArguments("--window-size=1920, 1080")
//                .addArguments("--disable-gpu")
//                .addArguments("--headless")
                .addArguments("disable-infobars")
                .addArguments("--start-maximized")
                .addArguments("--remote-allow-origins=*")
                .addArguments("--disable-extensions")
                .addArguments("--no-sandbox");
    }

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver(getChromeOptions());
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
        driver.get(MAIN_URL);
        webpageHandler = new WebpageHandler(driver);
        Utils utils = new Utils();
        practiceForm = new PracticeForm(driver);
    }

    @Test
    public void testPracticeForm() throws AWTException, InterruptedException {
        new HomePage(driver).clickFormsCategory();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(HomePage.FORMS_CATEGORY));

        new MenuForms(driver).clickOnPracticeForm();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(MenuForms.PRACTICE_FORM_ITEM));

        List<String> testData = new Utils().readFileToList(studentsfile);
        List<Student> studentsList = new ArrayList<>();

        for (String data : testData) {
            studentsList.add(new PracticeForm(driver).getStudent(data));
        }

        Students students = Students.builder().withStudents(studentsList).build();

        for (Student student : students.getStudents()) {
            practiceForm.addFirstName(student.getFirstName());
            practiceForm.addLastName(student.getLastName());
            practiceForm.clickMaleButton();
            practiceForm.addUserDateOfBirth(student.getDateOfBirth());
            practiceForm.addUserNumber(student.getMobileNumber());
            practiceForm.addUserEmail(student.getEmail());
            practiceForm.pressEnterInUserEmailField();
            practiceForm.clickCloseLargeModal();
        }
    }

    @AfterClass
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }


}
