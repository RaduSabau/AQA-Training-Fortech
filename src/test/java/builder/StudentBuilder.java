package builder;

import entities.practiceform.Student;
import utils.Utils;

import java.sql.Date;

public class StudentBuilder {

    public Student getStudent(String value) {
        Utils utils = new Utils();
        return Student.builder().withFirstName(utils.getListFromRow(value).get(0))
                .withLastName(utils.getListFromRow(value).get(1))
                .withEmail(utils.getListFromRow(value).get(2))
                .withMobileNumber(utils.getListFromRow(value).get(3))
                .withDateOfBirth(Date.valueOf(utils.getListFromRow(value).get(4)))
                .withAddress(utils.getListFromRow(value).get(5))
                .build();
    }
}
