package bean.jsonstructureobjbuilder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String seniority;
    private PersonalInformation personalInformation;
    private FinancialInformation financialInformation;
}

