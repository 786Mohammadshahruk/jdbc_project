package com.istumbh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcStatementCreateDataBaseExample {


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver IS Loaded");

            //Creating the Connection
            Connection connection = null;
            String URL = "jdbc:mysql://localhost:3306/crunchify";
            String USER_NAME = "root";
            String PASSWORD = "root12345";

            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            if (connection != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Not Established !!!");
                return;
            }

            //Initializing Statement Object
            Statement statement = connection.createStatement();
            String query = "CREATE DATABASE Employee";

            //Executing SQL Query
            int value = statement.executeUpdate(query);

            System.out.println("Database Created !!!, Value : " + value);

        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Problem While Loading the JDBC Driver");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Getting Error While Establishing the Connection !!!");
        }
    }
}
