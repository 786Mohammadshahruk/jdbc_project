package com.istumbh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionExample {

    public static void main(String[] args) {

        // Loading the Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver IS Loaded");
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Problem While Loading the JDBC Driver");
        }


        //Creating the Connection
        Connection connection = null;
        String URL = "jdbc:mysql://localhost:3306/crunchify";
        String USER_NAME = "root";
        String PASSWORD = "root12345";
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Getting Error While Establishing the Connection !!!");
        }
        if (connection != null) {
            System.out.println("Connection Established");
        } else {
            System.out.println("Connection Not Established !!!");
        }


    }
}
