package com.istumbh.jdbc;

public class JdbcClassLoadExample {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver IS Loaded");
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Problem While Loading the JDBC Driver");
        }

    }
}
