package com.flipkart.service;
import java.util.UUID;

import com.flipkart.constant.ModeOfPayment;

public interface NotificationInterface {

    public int sendNotification(String studentId,  String message);

    public UUID getReferenceId(int notificationId);



}
