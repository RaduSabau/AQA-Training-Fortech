package com.demoqa.frontend.tests;

import com.demoqa.frontend.builder.StudentBuilder;
import com.demoqa.frontend.constants.Constants;
import com.demoqa.frontend.dto.practiceform.Student;
import com.demoqa.frontend.dto.practiceform.Students;
import com.demoqa.frontend.pages.HomePage;
import com.demoqa.frontend.pages.forms.MenuForms;
import com.demoqa.frontend.pages.forms.PracticeFormPage;
import com.demoqa.frontend.utils.Utils;
import com.demoqa.frontend.utils.WebpageHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestPracticeForm extends MainPage {

    @Test
    public void testPracticeForm() throws InterruptedException {
        WebpageHandler webpageHandler = new WebpageHandler(driver);
        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);

        new HomePage(driver).clickFormsCategory();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(HomePage.FORMS_CATEGORY));

        new MenuForms(driver).clickOnPracticeForm();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(MenuForms.PRACTICE_FORM_ITEM));

        List<String> testStudentData = new Utils().readFileToList(Constants.studentsfile);
        List<Student> studentsList = new ArrayList<>();

        for (String data : testStudentData) {
            studentsList.add(new StudentBuilder().getStudent(data));
        }

        Students students = Students.builder().withStudents(studentsList).build();

        for (Student student : students.getStudents()) {
            practiceFormPage.addFirstName(student.getFirstName());
            practiceFormPage.addLastName(student.getLastName());
            practiceFormPage.clickGenderButton(student.getGender());
            practiceFormPage.addUserDateOfBirth(student.getDateOfBirth());
            practiceFormPage.addUserNumber(student.getMobileNumber());
            practiceFormPage.addUserEmail(student.getEmail());
            practiceFormPage.clickSubmitButton();
            practiceFormPage.getLabelStrings().forEach(v -> System.out.println(practiceFormPage.getWebElementText(v)));
            practiceFormPage.clickCloseLargeModal();
        }
    }
}
