package com.demoqa.frontend.tests;

import com.demoqa.frontend.builder.EmployeeBuilder;
import com.demoqa.frontend.constants.Constants;
import com.demoqa.frontend.dto.webtables.Employee;
import com.demoqa.frontend.dto.webtables.Employees;
import com.demoqa.frontend.pages.HomePage;
import com.demoqa.frontend.pages.elements.MenuElements;
import com.demoqa.frontend.pages.elements.webTables.WebTablesPage;
import com.demoqa.frontend.utils.Utils;
import com.demoqa.frontend.utils.WebpageHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestWebTables extends MainPage {
    private static List<String> getStrings() {
        return new ArrayList<>() {{
            add(Constants.FIRST_NAME);
            add(Constants.LAST_NAME);
            add(Constants.USER_EMAIL);
            add(String.valueOf(Constants.USER_AGE));
            add(String.valueOf(Constants.USER_SALARY));
            add(Constants.DEPARTMENT);
        }};
    }

    @Test
    public void testWebTable() {

        WebTablesPage webTablesPage = new WebTablesPage(driver);
        WebpageHandler webpageHandler = new WebpageHandler(driver);

        new HomePage(driver).clickElementsCategory();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(HomePage.ELEMENTS_CATEGORY));

        new MenuElements(driver).clickOnWebTables();
        Assert.assertTrue(webpageHandler.getPageTitle().contains(MenuElements.WEB_TABLES_ITEM));

        List<String> testEmployeeData = new Utils().readFileToList(Constants.employeesfile);
        List<Employee> employeesList = new ArrayList<>();

        for (String data : testEmployeeData) {
            employeesList.add(new EmployeeBuilder().getEmployee(data));
        }
        Employees employees = Employees.builder().withEmployees(employeesList).build();

        for (Employee employee : employees.getEmployees()) {
            webTablesPage.clickAddNewLineButton();

            webTablesPage.addFirstName(employee.getFirstName());
            webTablesPage.addLastName(employee.getLastName());
            webTablesPage.addEmail(employee.getEmail());
            webTablesPage.addAge(employee.getAge());
            webTablesPage.addSalary(employee.getSalary());
            webTablesPage.addDepartment(employee.getDepartment());

            webTablesPage.clickSubmitButton();
        }

        getStrings().forEach(v -> Assert.assertTrue(webTablesPage.webTable.getText().contains(v)));

        webTablesPage.clickEditLineButton(Constants.FIRST_NAME_TO_EDIT);
        webTablesPage.addSalary(Constants.USER_NEW_SALARY);
        webTablesPage.clickSubmitButton();
        Assert.assertTrue(webTablesPage.getAgeWebTableLine(Constants.FIRST_NAME_TO_EDIT).contains(String.valueOf(Constants.USER_NEW_SALARY)));

        webTablesPage.clickDeleteLineButton(Constants.FIRST_NAME_TO_DELETE);
        Assert.assertFalse(webTablesPage.webTable.getText().contains(Constants.FIRST_NAME_TO_DELETE));
    }


}
