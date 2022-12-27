package com.example.eShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static final String url = "jdbc:postgresql://localhost/eShop";
    private static final String user = "postgres";
    private static final String password = "123";

    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }
}