package com.demoqa.frontend.dto.jsonstructurebuilder;

import com.demoqa.frontend.jsonstructure.JsonStructureHandler;
import com.demoqa.frontend.utils.Utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class JsonStructureBuilder {

    Utils utils = new Utils();
    Random random = new Random();
    JsonStructureHandler jsonStructureHandler = new JsonStructureHandler();

    public Department employeeGenerator(int noOfIds) {

        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < noOfIds; i++) {
            String firstName = utils.getRandomName().firstName();
            String lastName = utils.getRandomName().lastName();
            employeeList.add(Employee.builder()
                    .withId(jsonStructureHandler.getIdNumber())
                    .withFirstName(firstName)
                    .withLastName(lastName)
                    .withEmail(firstName + lastName + "@mail.com")
                    .withRole(jsonStructureHandler.getRoleAndSeniority("role")
                            .get(random.nextInt(jsonStructureHandler.getRoleAndSeniority("role").size())))
                    .withSeniority(jsonStructureHandler.getRoleAndSeniority("seniority")
                            .get(random.nextInt(jsonStructureHandler.getRoleAndSeniority("seniority").size())))
                    .withPersonalInformation(personalInformationGenerator())
                    .withFinancialInformation(financialInformationGenerator())
                    .build());
        }
        return Department.builder().withEmployees(employeeList).build();
    }

    public PersonalInformation personalInformationGenerator() {
        LocalDate dateOfBirth = jsonStructureHandler.getDateOfBirth();
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return (PersonalInformation.builder()
                .withAge(age)
                .withDateOfBirth(String.valueOf(dateOfBirth))
                .withGender(jsonStructureHandler.getRoleAndSeniority("gender")
                        .get(random.nextInt(jsonStructureHandler.getRoleAndSeniority("gender").size())))
                .build());
    }

    public FinancialInformation financialInformationGenerator() {
        int salary = jsonStructureHandler.getSalary();
        return (FinancialInformation.builder()
                .withSalary(salary)
                .withBonus(salary * jsonStructureHandler.getBonusPercent() / 100)
                .withLastUpdated(String.valueOf(jsonStructureHandler.getLastUpdatedDate()))
                .build());
    }

    public Departments departmentsGenerator(int noOfIds) {
        return Departments.builder().withDepartment(employeeGenerator(noOfIds)).build();
    }
}