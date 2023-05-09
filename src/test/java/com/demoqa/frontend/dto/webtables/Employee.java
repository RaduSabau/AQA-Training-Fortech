package com.demoqa.frontend.dto.webtables;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder(setterPrefix = "with")
public class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private Integer salary;
    private String department;

}
