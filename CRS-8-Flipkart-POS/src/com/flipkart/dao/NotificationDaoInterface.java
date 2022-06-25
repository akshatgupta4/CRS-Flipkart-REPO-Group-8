package com.flipkart.dao;

import java.sql.SQLException;

/**
 * Interface to implement notification related operations
 */
public interface NotificationDaoInterface {
    public int sendNotification(String studentId, String message) throws SQLException;
}
