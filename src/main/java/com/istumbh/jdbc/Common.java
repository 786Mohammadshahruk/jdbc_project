package com.istumbh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Common {
    static String URL = "jdbc:mysql://localhost:3306/employee";
    static String USER_NAME = "root";
    static String PASSWORD = "root12345";

    static Connection loadAndCreateConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Problem While Loading the JDBC Driver");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Getting Error While Establishing the Connection !!!");
        }
        return connection;
    }
}
