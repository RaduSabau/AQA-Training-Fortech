package tests.demoqatests;

import builder.EmployeeBuilder;
import dto.webtables.Employee;
import dto.webtables.Employees;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.elements.MenuElements;
import pages.elements.webTables.WebTablesPage;
import utils.Utils;
import utils.WebpageHandler;
import java.util.ArrayList;
import java.util.List;

import static constants.Constants.*;

public class TestWebTables extends MainPage {
    private static List<String> getStrings() {
        return new ArrayList<>() {{
            add(FIRST_NAME);
            add(LAST_NAME);
            add(USER_EMAIL);
            add(String.valueOf(USER_AGE));
            add(String.valueOf(USER_SALARY));
            add(DEPARTMENT);
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

        List<String> testEmployeeData = new Utils().readFileToList(employeesfile);
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

        webTablesPage.clickEditLineButton(FIRST_NAME_TO_EDIT);
        webTablesPage.addSalary(USER_NEW_SALARY);
        webTablesPage.clickSubmitButton();
        Assert.assertTrue(webTablesPage.getAgeWebTableLine(FIRST_NAME_TO_EDIT).contains(String.valueOf(USER_NEW_SALARY)));

        webTablesPage.clickDeleteLineButton(FIRST_NAME_TO_DELETE);
        Assert.assertFalse(webTablesPage.webTable.getText().contains(FIRST_NAME_TO_DELETE));
    }


}
