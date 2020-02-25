package db;

import java.sql.*;
import java.time.LocalDateTime;

public class NewsDb {
    DbWorker dbWorker = new DbWorker();

    public void createNews(String newsHeadline, String newsText) {
        String SQL = "insert into news(newsHeadline, newsText, publicationTime) values(?, ?, ?)";
        try (Connection connection = dbWorker.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setString(1, newsHeadline);
            preparedStatement.setString(2, newsText);
            preparedStatement.setTimestamp(3,  Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.execute();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showNews(int id) {
        String SQL = "select * from news where id=?";
        try (Connection connection = dbWorker.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("newsHeadline, newsText");
                System.out.println(resultSet.getString("newsHeadline") + " : "
                        + resultSet.getString("newsText") + "\n");
            }
        } catch (SQLException e) {
            System.out.println("no news with this id.");
        }
    }

    public void deleteNews(int id) {
        String SQL = "delete from journal where id = ?";
        try (Connection connection = dbWorker.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeText(int id, String text) {
        String SQL = "update news set newsText = ? where id = ?";
        try (Connection connection = dbWorker.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setString(1, text);
            preparedStatement.setInt(2, id);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeHeadline(int id, String headline) {
        String SQL = "update news set newsHeadline = ? where id = ?";
        try (Connection connection = dbWorker.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setString(1, headline);
            preparedStatement.setInt(2, id);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
