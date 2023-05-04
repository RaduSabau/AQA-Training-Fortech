package dto.jsonstructurebuilder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class PersonalInformation {
    private String dateOfBirth;
    private Integer age;
    private String gender;
}
