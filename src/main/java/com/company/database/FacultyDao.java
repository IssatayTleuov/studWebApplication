package com.company.database;

import com.company.util.Faculty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FacultyDao extends Database{

    Connection connection;

    public ArrayList<Faculty> getFaculties() {
        connection = getConnection();
        ArrayList<Faculty> faculties = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM faculty");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Faculty faculty = new Faculty();
                faculty.setId(resultSet.getInt(1));
                faculty.setName(resultSet.getString(2));

                faculties.add(faculty);
            }

        } catch (SQLException e) {
            System.out.println("Exception" + " " + e);
        }
        return faculties;
    }

}
