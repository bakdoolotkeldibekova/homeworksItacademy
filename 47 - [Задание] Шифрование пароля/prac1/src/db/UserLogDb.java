package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UserLogDb {
    private DbWorker dbWorker = new DbWorker();

    public void insertUserLog(int userId, boolean result) {
        String SQL = "insert into userlogs(user_id, entry_time, success) values(?, ?, ?)";
        try (Connection connection = dbWorker.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setInt(1, userId);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            preparedStatement.setTimestamp(2, timestamp);
            preparedStatement.setBoolean(3, result);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
