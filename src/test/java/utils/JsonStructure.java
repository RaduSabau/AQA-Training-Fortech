package utils;

import bean.jsonstructureobjbuilder.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class JsonStructure {

    Utils utils = new Utils();
    Random random = new Random();

    public Department employeeGenerator(int noOfIds) {

        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < noOfIds; i++) {
            String firstName = utils.getName().firstName();
            String lastName = utils.getName().lastName();
            employeeList.add(Employee.builder()
                    .withId(i)
                    .withFirstName(firstName)
                    .withLastName(lastName)
                    .withEmail(firstName + lastName + "@mail.com")
                    .withRole(utils.getRoleAndSeniority("role")
                            .get(random.nextInt(utils.getRoleAndSeniority("role").size())))
                    .withSeniority(utils.getRoleAndSeniority("seniority")
                            .get(random.nextInt(utils.getRoleAndSeniority("seniority").size())))
                    .withPersonalInformation(personalInformationGenerator())
                    .withFinancialInformation(financialInformationGenerator())
                    .build());
        }
        return Department.builder().withEmployees(employeeList).build();
    }

    public PersonalInformation personalInformationGenerator() {
        LocalDate dateOfBirth = utils.getDateOfBirth();
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return (PersonalInformation.builder()
                .withAge(age)
                .withDateOfBirth(String.valueOf(dateOfBirth))
                .withGender(utils.getRoleAndSeniority("gender")
                        .get(random.nextInt(utils.getRoleAndSeniority("gender").size())))
                .build());
    }

    public FinancialInformation financialInformationGenerator() {
        int salary = utils.getSalary();
        return (FinancialInformation.builder()
                .withSalary(salary)
                .withBonus(salary * utils.getBonusPercent() / 100)
                .withLastUpdated(String.valueOf(utils.getLastUpdatedDate()))
                .build());
    }

    public Departments departmentsGenerator(int noOfIds) {
        return Departments.builder().withDepartment(employeeGenerator(noOfIds)).build();
    }
}