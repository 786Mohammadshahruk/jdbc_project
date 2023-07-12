package com.istumbh.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcStatementInsertExample {


    public static void main(String[] args) {
        try {
            Connection connection = Common.loadAndCreateConnection();

            if (connection != null) {
                //Initializing Statement Object
                Statement statement = connection.createStatement();
                // Creating String Query
                String query = "INSERT INTO Persons (PersonID, LastName, FirstName, Address, City) VALUES ('1', 'Kumar', 'Ajay', 'Mumbai', 'Bandra')";
                //Executing SQL Query
                int value = statement.executeUpdate(query);
                System.out.println("Insert Data !!!, Value : " + value);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Getting Error While Establishing the Connection !!!");
        }
    }
}
