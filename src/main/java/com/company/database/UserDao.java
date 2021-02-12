package com.company.database;

import com.company.util.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends Database{

    Connection connection;

    public int createAccount (String login, String password) throws SQLException {
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (login, password) VALUES (?, ?)");
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        int row = preparedStatement.executeUpdate();

        if (row == 2) {
            User user =  new User(login, password);
            return user.getId();
        }
        return 0;
    }

    public boolean logIn(String login, String password) throws SQLException {
//        student01@email.com
//        Aa123456
        connection = getConnection();
        PreparedStatement preparedStatement = super.connection.prepareStatement("SELECT * FROM users WHERE login = ? and password = ?");
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet resultSet =  preparedStatement.executeQuery();
        if (!resultSet.next()) {
            return false;
        } else {
            return true;
        }
    }
}
