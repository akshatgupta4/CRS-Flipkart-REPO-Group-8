package com.flipkart.service;

import com.flipkart.constant.ModeOfPayment;
import com.flipkart.constant.NotificationType;

import java.util.UUID;

public class NotificationImpl {

    public UUID getReferenceId(int notificationId){
        return UUID.randomUUID();
    }
    public int sendNotification(NotificationType type, int studentId, ModeOfPayment modeOfPayment, double amount){
        return  0;
    }

}
