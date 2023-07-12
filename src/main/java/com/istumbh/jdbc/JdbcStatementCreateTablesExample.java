package com.istumbh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcStatementCreateTablesExample {


    public static void main(String[] args) {
        try {
            Connection connection = Common.loadAndCreateConnection();

            if (connection != null) {
                //Initializing Statement Object
                Statement statement = connection.createStatement();
                // Creating String Query
                String query = "CREATE TABLE Persons (PersonID int,LastName varchar(255),FirstName varchar(255),Address varchar(255),City varchar(255))";
                //Executing SQL Query
                int value = statement.executeUpdate(query);
                System.out.println("Create Tables !!!, Value : " + value);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Getting Error While Establishing the Connection !!!");
        }
    }
}
