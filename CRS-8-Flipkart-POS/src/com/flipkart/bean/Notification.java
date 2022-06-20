package com.flipkart.bean;

public class Notification {
    private int studendId;
    private int paymentId;

    public int getStudendId() {
        return studendId;
    }

    public void setStudendId(int studendId) {
        this.studendId = studendId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotificationMessage() {
        return notificationMessage;
    }

    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }

    private int notificationId;
    private String notificationMessage;
}
