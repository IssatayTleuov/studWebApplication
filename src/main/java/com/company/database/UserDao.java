package com.company.database;

import com.company.util.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class UserDao extends Database{

    Connection connection;

    public User createAccount (String login, String password) throws SQLException {
        connection = getConnection();
        UUID uuid = UUID.randomUUID();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (login, password,session_id) VALUES (?, ?, ?)");
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, uuid.toString());
        int rows = preparedStatement.executeUpdate();

        if (rows == 1) {
            return new User(login, password, uuid.toString());
        }
        return null;
    }

    public User logIn(String login, String password) throws SQLException {
//        student01@email.com
//        Aa123456
        connection = getConnection();
        User user = new User();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE login = ? and password = ?");
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet resultSet =  preparedStatement.executeQuery();

        while (resultSet.next()) {
            user.setId(resultSet.getInt(1));
            user.setLogin(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
        }
        return user;
    }
    public ArrayList<User> getUsers() {
        connection = getConnection();
        ArrayList<User> userArrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setSessionId(resultSet.getString(4));

                userArrayList.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userArrayList;
    }

    public void updateSessionId(String sessionId, int userId) {
        connection = getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET session_id = ? WHERE id = ?");
            preparedStatement.setString(1, sessionId);
            preparedStatement.setInt(2, userId);
            int rows = preparedStatement.executeUpdate();

            if (rows == 1) {
                System.out.println("session_id successfully updated!");
            } else {
                System.out.println("Something want wrong!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId(String sessionId) {
        int id = 0;
        ArrayList<User> userArrayList;
        userArrayList = getUsers();

        for (User u : userArrayList) {
            if (u.getSessionId().equals(sessionId)) {
                id = u.getId();
            }
        }
        return id;
    }
}
