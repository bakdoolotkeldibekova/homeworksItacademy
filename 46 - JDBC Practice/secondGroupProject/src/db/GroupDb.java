package db;

import java.sql.*;

public class GroupDb {
    private DbWorker dbWorker = new DbWorker();


    public void insertGroup(String name, int id_course, int id_trainer, int duration, int price) {
        String SQL = "insert into groupp(name, course_id, trainer_id, duration, price) values(?, ?, ?, ?, ?)";
        try (Connection connection = dbWorker.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id_course);
            preparedStatement.setInt(3, id_trainer);
            preparedStatement.setInt(4, duration);
            preparedStatement.setInt(5, price);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        String SQL2 = "update course set numberOfGroups =? where id = ?";
        try (Connection connection = dbWorker.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL2)){
            preparedStatement.setInt(1, dbWorker.getNumberOfStudentInCourse(id_course)+1);
            preparedStatement.setInt(2, id_course);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "нет такой группы с таким id!!");
        }
    }

    public void showGroups(int id_course) {
        String SQL = "select * from groupp where course_id=?";
        try (Connection connection = dbWorker.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setInt(1, id_course);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println("id, course_id, name, id_trainer, duration, price, numberOfStudents");
                System.out.println(rs.getInt("id") + " : "
                        + rs.getInt("course_id") + " : "
                        + rs.getString("name") + " : "
                        + rs.getInt("trainer_id") +" : "
                        + rs.getInt("duration") +" : "
                        + rs.getInt("price") +" : "
                        + rs.getInt("numberOfStudents") + "\n");
            }
        } catch (SQLException e) {
            System.out.println("нет группы с таким id_course");
        }
    }

    public void showTop3Groups(int id_course) {
        String SQL = "select * from groupp g where g.course_id = ? order by g.numberofstudents asc limit 3;";
        try (Connection connection = dbWorker.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setInt(1, id_course);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println("id, course_id, name, id_trainer, duration, price, numberOfStudents");
                System.out.println(rs.getInt("id") + " : "
                        + rs.getInt("course_id") + " : "
                        + rs.getString("name") + " : "
                        + rs.getInt("trainer_id") +" : "
                        + rs.getInt("duration") +" : "
                        + rs.getInt("price") +" : "
                        + rs.getInt("numberOfStudents") + "\n");
            }
        } catch (SQLException e) {
            System.out.println("нет группы с таким id_course");
        }
    }





}
