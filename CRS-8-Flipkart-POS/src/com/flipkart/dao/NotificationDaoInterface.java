package com.flipkart.dao;

import java.sql.SQLException;

public interface NotificationDaoInterface {
    public int sendNotification(String studentId, String message) throws SQLException;
}
