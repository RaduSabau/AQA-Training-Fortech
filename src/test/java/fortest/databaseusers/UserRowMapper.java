package fortest.databaseusers;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<DBUser> {

    @Override
    public DBUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        return DBUser.builder().withFirstName(rs.getString("FirstName"))
                .withLastName(rs.getString("LastName"))
                .withPostalCode(rs.getString("PostalCode")).build();
    }

}
