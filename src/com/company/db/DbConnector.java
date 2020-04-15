package com.company.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private static Connection connection;
    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/factory_db";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";

    static {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        return connection;
    }
}
