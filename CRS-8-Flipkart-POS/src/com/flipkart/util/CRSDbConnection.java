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
    static final String PASS = "password";


    public static Connection getConnection() {

        try {
                if (connection != null && !connection.isClosed()) {
                    return connection;
                }
                else {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection(DB_URL,USER,PASS);
    //                Properties prop = new Properties();
    //                InputStream inputStream = CRSDb.class.getClassLoader().getResourceAsStream("./config.properties");
    //                prop.load(inputStream);
    //                String driver = prop.getProperty("driver");
    //                String url = prop.getProperty("url");
    //                String user = prop.getProperty("user");
    //                String password = prop.getProperty("password");
    //                Class.forName(driver);
    //                connection = DriverManager.getConnection(url, user, password);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return connection;
    }
}
