import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.ResultSet.CONCUR_UPDATABLE;
import static java.sql.ResultSet.TYPE_SCROLL_SENSITIVE;

public class SelectOrderByTest {

    private static final String SQL_QUERY = "SELECT * FROM product";


    public void test(Connection connection) throws SQLException {


        connection.setAutoCommit(false);
        try (final PreparedStatement statement = connection.prepareStatement(SQL_QUERY,
                TYPE_SCROLL_SENSITIVE,
                CONCUR_UPDATABLE)) {
            try (final ResultSet resultSet = statement.executeQuery()) {
                System.out.println(String.format("Result ok"));

            }
        } finally {
            connection.commit();
        }

    }
}
