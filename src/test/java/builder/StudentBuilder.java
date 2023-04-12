package builder;

import bean.practiceform.Student;
import utils.Utils;

public class StudentBuilder {
    public Student getStudent(String value) {
        Utils utils = new Utils();
        return Student.builder()
                .withFirstName(utils.getListFromRow(value).get(0))
                .withLastName(utils.getListFromRow(value).get(1))
                .withEmail(utils.getListFromRow(value).get(2))
                .withGender(utils.getListFromRow(value).get(3))
                .withMobileNumber(utils.getListFromRow(value).get(4))
                .withDateOfBirth(java.sql.Date.valueOf(utils.getListFromRow(value).get(5)))
                .withAddress(utils.getListFromRow(value).get(6))
                .build();
    }
}
