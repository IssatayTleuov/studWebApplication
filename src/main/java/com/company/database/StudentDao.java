package com.company.database;

import com.company.util.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao extends Database {

    Connection connection;

    public void createAccount(String fullName, String phoneNumber, int course, int facultyId, int userId) throws SQLException {
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students (fullname, phone_number, course, faculty_id, user_id) VALUES (?, ?, ?, ?, ?)");
        preparedStatement.setString(1, fullName);
        preparedStatement.setString(2, phoneNumber);
        preparedStatement.setInt(3, course);
        preparedStatement.setInt(4, facultyId);
        preparedStatement.setInt(5, userId);
        int rows = preparedStatement.executeUpdate();

        if (rows > 0) {
            Student student = new Student(fullName, phoneNumber, course, facultyId, userId);
        }
    }

    public ArrayList<Student> getAllStudents() {
        connection = getConnection();
        ArrayList<Student> arrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setPhoneNumber(resultSet.getString(2));
                student.setCourse(resultSet.getInt(3));
                student.setFacultyId(resultSet.getInt(4));
                student.setUserId(resultSet.getInt(5));
                student.setFullName(resultSet.getString(6));
                student.setObjectsId(resultSet.getString(7));

                arrayList.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
