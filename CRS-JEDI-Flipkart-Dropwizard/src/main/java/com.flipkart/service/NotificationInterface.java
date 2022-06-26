package com.flipkart.service;
import java.util.UUID;

public interface NotificationInterface {

    public int sendNotification(String studentId, String message);

    public UUID getReferenceId(int notificationId);



}
