
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
//            DataSource dataSource = getDataSourceForVitessLocal();
//            testSequence(dataSource);

            testOrderByVitessLocalMySQL();


        } catch (SQLException exception) {

            exception.printStackTrace();
        }


    }

    private void testSequence(DataSource dataSource) throws SQLException {
        SequencesService sequencesService = new SequencesService(dataSource);
        int seq1 = sequencesService.nextValue("SEQ1");
    }

    private void testOrderByVitessLocalMySQL() throws SQLException {
        DataSource dataSourceForMySQLLocal = getDataSourceForVitessLocal();
        Connection connection = dataSourceForMySQLLocal.getConnection();
        SelectOrderByTest sequencesService = new SelectOrderByTest();
        sequencesService.test(connection);
    }

    private void testOrderByLocalMySQL() throws SQLException {
        DataSource dataSourceForMySQLLocal = getDataSourceForMySQLLocal();
        Connection connection = dataSourceForMySQLLocal.getConnection();
        SelectOrderByTest sequencesService = new SelectOrderByTest();
        sequencesService.test(connection);
    }





    //*******************Vitess Test Image*******************
    Connection connectVitessTest() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:33577/");
        return connection;
    }

    DataSource getDataSourceForVitessTest() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("unsharded");
        dataSource.setServerName("localhost");
        dataSource.setPort(33577);
        dataSource.setUser("root");

        return dataSource;
    }

    //*******************Vitess Local Image*******************
    Connection connectVitessLocal() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:15306/");
        return connection;
    }

    DataSource getDataSourceForVitessLocal() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("commerce");
        dataSource.setServerName("localhost");
        dataSource.setPort(15306);
        dataSource.setUser("root");


        return dataSource;
    }

    //*******************Local connection*******************
    Connection connectMySQLLocal() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://root:root@localhost:3307/commerce");
        return connection;
    }

    DataSource getDataSourceForMySQLLocal() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("commerce");
        dataSource.setServerName("localhost");
        dataSource.setPort(3307);
        dataSource.setUser("root");
        dataSource.setPassword("root");

        return dataSource;
    }
}
