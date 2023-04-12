package utils;

import bean.jsonstructureobjbuilder.Employees;
import com.google.gson.Gson;
import org.testng.annotations.Test;


public class TestTest {
    JsonStructureClass jsonStructureClass = new JsonStructureClass();
    Utils utils = new Utils();


    @Test
    public void testJson() {
//        Gson gson = new Gson();
//        Employees ids = jsonStructureClass.idsGenerator(1);
//        String jsonString = gson.toJson(ids);
//        System.out.println(jsonString);

    }

//        Utils utils = new Utils();
//        WebTablesPage webTablesPage = new WebTablesPage(driver);
//        WebpageHandler webpageHandler = new WebpageHandler(driver);
//
//        new HomePage(driver).clickElementsCategory();
//        Assert.assertTrue(webpageHandler.getPageTitle().contains(HomePage.ELEMENTS_CATEGORY));
//
//        new MenuElements(driver).clickOnWebTables();
//        Assert.assertTrue(webpageHandler.getPageTitle().contains(MenuElements.WEB_TABLES_ITEM));
//
//        List<String> testEmployee = new Utils().readFileToList(employeesfile);
//        List<Employee> employeesList = new ArrayList<>();
//
//        for (String data : testEmployee) {
//            employeesList.add(new EmployeeBuilder().getEmployee(data));
//        }
//        Employees employees = Employees.builder().withEmployees(employeesList).build();
//        JSONObject jsonObject = new JSONObject();
//        for (Employee employee : employees.getEmployees()) {
//            jsonObject.put("firstName", employee.getFirstName());
//            jsonObject.put("lastName", employee.getLastName());
//            jsonObject.put("email", employee.getEmail());
//            jsonObject.put("age", employee.getAge());
//            jsonObject.put("salary", employee.getSalary());
//            jsonObject.put("department", employee.getDepartment());
//        }
//        System.out.println(jsonObject.get("firstName").toString());
//    }
}