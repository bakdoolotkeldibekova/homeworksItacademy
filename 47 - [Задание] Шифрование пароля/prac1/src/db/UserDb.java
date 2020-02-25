package db;

import db.DbWorker;

import java.sql.*;
import java.time.LocalDate;

public class UserDb {
    private final DbWorker dbWorker = new DbWorker();

    public void registerUser(String login, String password, String email) {
        String SQL = "insert into userss(login, passwordd, email, date_of_registration) values(?, ?, ?, ?)";
        try (Connection connection = dbWorker.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setString(1, login);
            String passwordEncryption = "";
            for(int i=password.length()-1; i>=0; i--){
                passwordEncryption += password.charAt(i);
            }
            passwordEncryption += password.charAt(0);
            preparedStatement.setString(2, passwordEncryption);
            preparedStatement.setString(3, email);
            Date SQLDate = Date.valueOf(LocalDate.now());
            preparedStatement.setDate(4, SQLDate);
            preparedStatement.execute();
        }
        catch (SQLException e) {
            System.out.println("Логин занят");
        }
    }

    public int indexOfUser(String login) {
        String SQL = "select * from userss where login=?";
        try (Connection connection = dbWorker.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setString(1, login);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                return rs.getInt("id");
            }
            return -1;

        } catch (SQLException e) {
            return -1;
        }
    }

    public boolean authorize(String login, String password) {
        String SQL = "select * from userss where login = ? and passwordd = ?";

        try(Connection connection = dbWorker.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            String passwordEncryption = "";
            for(int i=password.length()-1; i>=0; i--){
                passwordEncryption += password.charAt(i);
            }
            passwordEncryption += password.charAt(0);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, passwordEncryption);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) return true;
            return false;
        } catch (SQLException e) {
            return false;
        }
    }
}
