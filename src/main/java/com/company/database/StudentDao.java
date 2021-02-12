package com.company.database;

import com.company.util.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDao extends Database {

    Connection connection;

    public void createAccount(String name, String surname, String phoneNumber, int course, int facultyId, int userId) throws SQLException {
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students (name, surname, phone_number, course, faculty_id, user_id) VALUES (?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, surname);
        preparedStatement.setString(3, phoneNumber);
        preparedStatement.setInt(4, course);
        preparedStatement.setInt(5, facultyId);
        preparedStatement.setInt(6, userId);
        int row = preparedStatement.executeUpdate();

        if (row == 6) {
            Student student = new Student(name, surname, phoneNumber, course, facultyId, userId);
        }
    }
}
