package com.company.database;

import com.company.util.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        int rows = preparedStatement.executeUpdate();

        if (rows > 0) {
            Student student = new Student(name, surname, phoneNumber, course, facultyId, userId);
        }
    }

    public ArrayList<Student> getStudUserId() {
        connection = getConnection();
        ArrayList<Student> arrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setSurname(resultSet.getString(3));
                student.setPhoneNumber(resultSet.getString(4));
                student.setCourse(resultSet.getInt(5));
                student.setFacultyId(resultSet.getInt(6));
                student.setUserId(resultSet.getInt(7));

                arrayList.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
