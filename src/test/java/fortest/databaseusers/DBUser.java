package fortest.databaseusers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class DBUser {
    private String firstName;
    private String lastName;
    private String postalCode;

}
