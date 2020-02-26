package db;

import java.sql.*;

public class DbWorker {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "BAGDASH...";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public int getNumberOfStudent(int group_id){
        String SQL = "SELECT count(*) FROM student where group_id = ?";
        try (Connection connection =connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setInt(1, group_id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                return rs.getInt(1);
            }
            return -1;
        } catch (SQLException e) {
            return -1;
        }
    }
    public int getNumberOfStudentInCourse(int course_id){
        String SQL3 = "select count(*) from student\n" +
                "inner join groupp on groupp.id = student.group_id \n" +
                "where groupp.course_id = ?";
        try (Connection connection =connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL3)){
            preparedStatement.setInt(1, course_id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                return rs.getInt(1);
            }
            return -1;
        } catch (SQLException e) {
            return -1;
        }
    }

    public int getCourseId(int group_id) {
        String SQL = "select course_id from groupp where groupp.id = ?";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setInt(1, group_id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                return rs.getInt(1);
            }
            return -1;
        } catch (SQLException e) {
            return -1;
        }
    }
}
