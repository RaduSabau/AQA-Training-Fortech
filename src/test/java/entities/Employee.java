package entities;

import lombok.Builder;
import lombok.Data;

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
