package com.company.database;

import com.company.util.Rating;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RatingDao  extends Database{

    Connection connection;

    public ArrayList<Rating> getAllRating() {
        connection = getConnection();
        ArrayList<Rating> ratingArrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM rating");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Rating rating = new Rating();
                rating.setId(resultSet.getInt(1));
                rating.setMark(resultSet.getInt(2));
                rating.setStudentId(resultSet.getInt(3));
                rating.setTeacherId(resultSet.getInt(4));
                rating.setObjectId(resultSet.getInt(5));
                rating.setMarkTypeId(resultSet.getInt(6));
                rating.setDate(resultSet.getDate(7));

                ratingArrayList.add(rating);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ratingArrayList;
    }

    public void updateMark(int ratingId, int mark) {
        connection = getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE rating SET mark = ? WHERE id = ?");
            preparedStatement.setInt(1, mark);
            preparedStatement.setInt(2, ratingId);
            int rows = preparedStatement.executeUpdate();
            if (rows == 1) {
                System.out.println("Mark was successfully updated!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
