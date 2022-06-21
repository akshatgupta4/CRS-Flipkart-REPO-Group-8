package com.flipkart.service;
import java.util.UUID;

import com.flipkart.constant.ModeOfPayment;
import com.flipkart.constant.NotificationType;

public class NotificationInterface {

    public int sendNotification(NotificationType type,int studentId,ModeOfPayment modeOfPayment,double amount);

    public UUID getReferenceId(int notificationId);



}
