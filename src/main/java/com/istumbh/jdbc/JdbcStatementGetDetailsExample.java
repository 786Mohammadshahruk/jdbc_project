package com.istumbh.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcStatementGetDetailsExample {


    public static void main(String[] args) {
        try {
            Connection connection = Common.loadAndCreateConnection();

            if (connection != null) {
                //Initializing Statement Object
                Statement statement = connection.createStatement();
                // Creating String Query
                String query = "SELECT PersonID, LastName, FirstName, Address, City FROM Persons";
                //Executing SQL Query
                ResultSet value = statement.executeQuery(query);


                while (value.next()){
                    System.out.println("PersonID : " + value.getInt("PersonID") );
                    System.out.println("LastName : " + value.getString("LastName") );
                    System.out.println("FirstName : " + value.getString("FirstName") );
                    System.out.println("Address : " + value.getString("Address") );
                    System.out.println("City : " + value.getString("City") );

                    System.out.println("=====================================");
                    System.out.println("PersonID : " + value.getInt(1) );
                    System.out.println("LastName : " + value.getString(2) );
                    System.out.println("FirstName : " + value.getString(3) );
                    System.out.println("Address : " + value.getString(4) );
                    System.out.println("City : " + value.getString(5) );
                }
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Getting Error While Establishing the Connection !!!");
        }
    }
}
