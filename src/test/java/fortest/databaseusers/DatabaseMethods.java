package fortest.databaseusers;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DatabaseMethods extends JdbcTemplate {
    private final String url = "jdbc:sqlite:C:/Users/radu.sabau/Downloads/Ex_Files_SQL_EssT/Ex_Files_SQL_EssT/Exercise Files/WSDA_Music.db";
    private final String selectUsers = """
            SELECT
            	FirstName,
            	LastName,
            	PostalCode
            FROM
            	Customer
            LIMIT 3""";
    private final BasicDataSource basicDataSource = new BasicDataSource();
    public DatabaseMethods() {
        setDataSource(getDataSource());
    }

    public BasicDataSource getDataSource() {
        basicDataSource.setUrl(url);
        basicDataSource.setDriverClassName("org.sqlite.JDBC");

        return basicDataSource;
    }

    public List<DBUser> getUserName() {
        return query(selectUsers, new UserRowMapper());
    }
}
