package com.company.database;

import com.company.util.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao extends Database{

    Connection connection;

    public User createAccount (String login, String password) throws SQLException {
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (login, password) VALUES (?, ?)");
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        int rows = preparedStatement.executeUpdate();

        if (rows == 1) {
            return new User(login, password);
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

                userArrayList.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userArrayList;
    }
}
