package com.company.database;

import com.company.util.Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ObjectDao extends Database {
    Connection connection;

    public ArrayList<Object> getObjects() {
        connection = getConnection();
        ArrayList<Object> objectArrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM objects");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Object object = new Object();
                object.setId(resultSet.getInt(1));
                object.setName(resultSet.getString(2));

                objectArrayList.add(object);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return objectArrayList;
    }

}
