package db;

import java.sql.*;

public class CourseDb {
    private DbWorker dbWorker = new DbWorker();

    public void insertCourse(String name, int numberOfGroups, int numberOfStudents) {
        String SQL = "insert into course(name, numberOfGroups, numberOfStudents) values(?, ?, ?)";
        try (Connection connection = dbWorker.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, numberOfGroups);
            preparedStatement.setInt(3, numberOfStudents);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showCourses() {
        String SQL = "select * from course";
        try (Connection conn = dbWorker.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " : "
                        + rs.getString("name") + " : "
                        + rs.getInt("numberOfGroups") +" : "
                        + rs.getInt("numberOfStudents") + "\n");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
