import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        main.start();

    }

    public void start() {

        try {
            DataSource dataSource = getDataSource();
            SequencesService sequencesService = new SequencesService(dataSource);
            int seq1 = sequencesService.nextValue("SEQ1");


        } catch (SQLException exception) {

            exception.printStackTrace();
        }


    }

    DataSource getDataSource() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("unsharded");
        dataSource.setServerName("localhost");
        dataSource.setPort(33577);
        dataSource.setUser("root");

        return dataSource;
    }

    Connection connect() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:33577/");
        return connection;
    }
}
