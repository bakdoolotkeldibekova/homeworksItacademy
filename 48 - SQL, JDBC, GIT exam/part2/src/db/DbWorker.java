package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbWorker {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "BAGDASH...";

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
