package com.company.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    final String url = "jdbc:postgresql://localhost:5432/issa_postgres_stu_database";
    final String user = "postgres";
    final String password = "admin";
    Connection connection;
    Statement statement;


    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
//            System.out.println("Successfully connected");

        } catch (Exception e) {
            System.out.println("Exception" + " " + e);
        }
        return connection;
    }
}
