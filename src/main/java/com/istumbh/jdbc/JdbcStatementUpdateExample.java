package com.istumbh.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcStatementUpdateExample {


    public static void main(String[] args) {
        try {
            Connection connection = Common.loadAndCreateConnection();

            if (connection != null) {
                //Initializing Statement Object
                Statement statement = connection.createStatement();
                // Creating String Query
                String query = "UPDATE Persons SET PersonID = 3 WHERE PersonID = '2'";
                //Executing SQL Query
                int value = statement.executeUpdate(query);
                System.out.println("Value : " + value);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Getting Error While Establishing the Connection !!!");
        }
    }
}
