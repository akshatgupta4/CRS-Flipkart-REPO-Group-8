package com.flipkart.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CRSDbConnection {
    private static Connection connection = null;
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/CRSDatabase";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "hellojoshi123";


    public static Connection getConnection() {

        try {
                if (connection != null && !connection.isClosed()) {
                    return connection;
                }
                else {
                    Class.forName(JDBC_DRIVER);
                    connection = DriverManager.getConnection(DB_URL,USER,PASS);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return connection;
    }
}
