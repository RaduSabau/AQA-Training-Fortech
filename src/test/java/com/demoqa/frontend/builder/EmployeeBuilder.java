package com.demoqa.frontend.builder;

import com.demoqa.frontend.dto.webtables.Employee;
import com.demoqa.frontend.utils.Utils;

public class EmployeeBuilder {
    public Employee getEmployee(String value) {
        Utils utils = new Utils();
        return Employee.builder().withFirstName(utils.getListFromRow(value).get(0))
                .withLastName(utils.getListFromRow(value).get(1))
                .withEmail(utils.getListFromRow(value).get(2))
                .withAge(Integer.valueOf(utils.getListFromRow(value).get(3)))
                .withSalary(Integer.valueOf(utils.getListFromRow(value).get(4)))
                .withDepartment(utils.getListFromRow(value).get(5))
                .build();
    }
}
