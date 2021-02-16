package com.company.database;

import com.company.util.Student;
import com.company.util.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TeacherDao extends Database {

    Connection connection;

    public void createAccount(String name, String surname, String phoneNumber, int objectId, int facultyId, int userId) {
        connection = getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO teachers (name, surname, phone_number, object_id, faculty_id, user_id) values (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setInt(4, objectId);
            preparedStatement.setInt(5, facultyId);
            preparedStatement.setInt(6, userId);
            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                Teacher teacher = new Teacher(name, surname, phoneNumber, objectId, facultyId, userId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Teacher> getTeachUserId() {
        connection = getConnection();
        ArrayList<Teacher> arrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM teachers");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt(1));
                teacher.setName(resultSet.getString(2));
                teacher.setSurname(resultSet.getString(3));
                teacher.setPhoneNumber(resultSet.getString(4));
                teacher.setObjectId(resultSet.getInt(5));
                teacher.setFacultyId(resultSet.getInt(6));
                teacher.setUserId(resultSet.getInt(7));

                arrayList.add(teacher);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

}
