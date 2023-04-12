package utils;

import bean.jsonstructureobjbuilder.Employees;
import bean.jsonstructureobjbuilder.FinancialInformation;
import bean.jsonstructureobjbuilder.ID;
import bean.jsonstructureobjbuilder.PersonalInformation;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class JsonStructureClass {

    Utils utils = new Utils();
    Random random = new Random();

    public Employees idsGenerator(int noOfIds) {
        List<ID> idList = new ArrayList<>();
        for (int i = 0; i < noOfIds; i++) {
            String firstName = utils.getName().firstName();
            String lastName = utils.getName().lastName();
            idList.add(ID.builder()
                    .withFirstName(firstName)
                    .withLastName(lastName)
                    .withEmail(firstName + lastName + "@mail.com")
                    .withRole(utils.getRoleAndSeniority("role").get(random.nextInt(utils.getRoleAndSeniority("role").size())))
                    .withSeniority(utils.getRoleAndSeniority("seniority").get(random.nextInt(utils.getRoleAndSeniority("seniority").size())))
                    .withPersonalInformation(personalInformationGenerator())
//                    .withFinancialInformation()
                    .build());
        }
        return Employees.builder().withIds(idList).build();
    }

    public PersonalInformation personalInformationGenerator() {
        LocalDate dateOfBirth = utils.getDateOfBirth();
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return (PersonalInformation.builder()
                .withAge(age)
                .withDateOfBirth(String.valueOf(dateOfBirth))
                .withGender(utils.getRoleAndSeniority("gender").get(random.nextInt(utils.getRoleAndSeniority("gender").size())))
                .build());
    }

    public FinancialInformation financialInformationGenerator() {
        int salary = utils.getSalary();
        return (FinancialInformation.builder()
                .withSalary(salary)
                .withBonus(salary * utils.getBonusPercent() / 100)
                .withLastUpdated()
                .build());
    }

}