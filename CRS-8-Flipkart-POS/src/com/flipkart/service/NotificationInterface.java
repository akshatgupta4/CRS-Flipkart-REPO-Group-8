package com.flipkart.service;
import java.util.UUID;

import com.flipkart.constant.ModeOfPayment;

public interface NotificationInterface {

    public int sendNotification(int type, int studentId, ModeOfPayment modeOfPayment, double amount);

    public UUID getReferenceId(int notificationId);



}
