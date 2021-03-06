package com.flipkart.dao;

import com.flipkart.constant.SQLQueryConstants;
import com.flipkart.util.CRSDbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Implementation of notification dao interface
 */
public class NotificationDaoOperation implements NotificationDaoInterface{
    public static PreparedStatement stmt = null;
    private static NotificationDaoOperation instance = null;
    private static int notification_id = 1;

    /**
     * Method to get Notification dao instance, and preserve single instance
     * @return
     */
    public static NotificationDaoOperation getInstance() {
        if (instance == null) {
            // This is a synchronized block, when multiple threads will access this instance
            instance = new NotificationDaoOperation();
        }
        return instance;
    }

    /**
     * Dao method to add notification to system storage
     * @param studentId
     * @param message
     * @return
     * @throws SQLException
     */
    @Override
    public int sendNotification(String studentId, String message) throws SQLException {
        Connection connection = CRSDbConnection.getConnection();

        stmt = connection.prepareStatement(SQLQueryConstants.SEND_NOTIFICATION_QUERY);
        stmt.setString(1, Integer.toString(++notification_id));
        stmt.setString(2, message);
        stmt.setString(3, studentId);

        try {
            stmt.executeQuery();
            return notification_id;
        }
        catch(Exception ex) {
            throw ex;
        }
        finally {
            connection.close();
        }
    }
}
