package com.company.database;

import com.company.util.MarkType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MarkTypeDao extends Database {

    Connection connection;

    public ArrayList<MarkType> getMarkTypes() {
        connection = getConnection();
        ArrayList<MarkType> markTypeArrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mark_type");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                MarkType markType = new MarkType();
                markType.setId(resultSet.getInt(1));
                markType.setName(resultSet.getString(2));

                markTypeArrayList.add(markType);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return markTypeArrayList;
    }

}
