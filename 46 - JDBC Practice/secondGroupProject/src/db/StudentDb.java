package db;

import java.sql.*;

public class StudentDb {
    private DbWorker dbWorker = new DbWorker();
    private int count = 0;

    public void insertStudent(String name, int group_id) {
        String SQL = "insert into student(name, group_id) values(?, ?)";
        try (Connection connection = dbWorker.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, group_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "нет такой группы с таким id!");
        }
        String SQL1 = "update groupp set numberOfStudents =? where id = ?";
        try (Connection connection = dbWorker.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL1)){
            count++;
            preparedStatement.setInt(1, count);
            preparedStatement.setInt(2, group_id);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "нет такой группы с таким id!!");
        }
        String SQL2 = "update course \n" +
                "set numberOfStudents = ?\n" +
                "from groupp\n" +
                "where groupp.course_id = course.id and groupp.id= ?;";
        try (Connection connection = dbWorker.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL2)){
            preparedStatement.setInt(1, dbWorker.getNumberOfStudentInCourse(dbWorker.getCourseId(group_id))+1);
            preparedStatement.setInt(2, group_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "нет такой группы с таким id!!");
        }
    }


}
