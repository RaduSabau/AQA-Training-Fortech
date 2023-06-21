package fortest;

import fortest.databaseusers.DBUser;
import fortest.databaseusers.DatabaseMethods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TestTest {
    @Test
    public void testDB() throws SQLException {

        String dbURL = "jdbc:sqlite:C:/Users/radu.sabau/Downloads/Ex_Files_SQL_EssT/Ex_Files_SQL_EssT/Exercise Files/WSDA_Music.db";
        String selectUsers = """
                SELECT
                	FirstName,
                	LastName,
                	PostalCode
                FROM
                	Customer
                LIMIT 3""";
        DriverManager.registerDriver(new org.sqlite.JDBC());
        Connection con = DriverManager.getConnection(dbURL);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(selectUsers);
        List<DBUser> users = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            while (rs.next()) {
                users.add(DBUser.builder()
                        .withFirstName(rs.getString("FirstName"))
                        .withLastName(rs.getString("LastName"))
                        .withPostalCode(rs.getString("PostalCode"))
                        .build());
            }
        }
        con.close();
        System.out.println(users);
    }

    @Test
    public void testDBRowMapper() throws SQLException {
        System.out.println(new DatabaseMethods().getUserName());

    }
}