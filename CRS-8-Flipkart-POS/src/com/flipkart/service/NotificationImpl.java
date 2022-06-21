package com.flipkart.service;

import com.flipkart.constant.ModeOfPayment;

import java.util.UUID;

public class NotificationImpl {

    public UUID getReferenceId(int notificationId){
        return UUID.randomUUID();
    }
    public int sendNotification(int type, String studentId, ModeOfPayment modeOfPayment, double amount){
        return  0;
    }

}
