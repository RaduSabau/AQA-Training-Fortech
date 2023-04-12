package bean.webtables;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "with")
public class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private Integer salary;
    private String department;

}
