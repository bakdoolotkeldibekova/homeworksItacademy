package db;

import model.User;

import java.sql.*;

public class UserDb extends DbWorker {

    public boolean createUser(User user){
        String SQL = "insert into users(login, password, email, is_woman) values(?, ?, ?, ?)";

        try(Connection connection = connect();
            PreparedStatement preparedStatement =connection.prepareStatement(SQL)){

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setBoolean(4, user.isWoman());

            return preparedStatement.execute();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public User getUser(){
        String SQL = "select * from users order by id desc limit 1";

        User user = new User();
        try(Connection connection = connect()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            while(resultSet.next()){
                user.setId(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setWoman(resultSet.getBoolean(5));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return user;
    }
}
