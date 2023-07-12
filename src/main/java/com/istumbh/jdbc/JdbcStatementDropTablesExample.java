package com.istumbh.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcStatementDropTablesExample {


    public static void main(String[] args) {
        try {
            Connection connection = Common.loadAndCreateConnection();

            if (connection != null) {
                //Initializing Statement Object
                Statement statement = connection.createStatement();
                // Creating String Query
                String query = "Drop TABLE persons";
                //Executing SQL Query
                int value = statement.executeUpdate(query);
                System.out.println("Dropped Tables !!!, Value : " + value);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Getting Error While Establishing the Connection !!!");
        }
    }
}
