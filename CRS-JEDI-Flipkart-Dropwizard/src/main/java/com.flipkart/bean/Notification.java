package com.flipkart.bean;

public class Notification {
    private int studentId;
    private int paymentId;

    private int notificationId;
    private String notificationMessage;

    public Notification(int studentId, int paymentId, int notificationId, String notificationMessage) {
        this.studentId = studentId;
        this.paymentId = paymentId;
        this.notificationId = notificationId;
        this.notificationMessage = notificationMessage;
    }

    /**
     * gives studentId for a notification
     * @return studentId
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * sets studentId for a notification
     * @param studentId
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * gives paymentId for payment notification
     * @return paymentId
     */
    public int getPaymentId() {
        return paymentId;
    }

    /**
     * sets paymentId for payment notification
     * @param paymentId
     */
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * gives notificationId for a notification
     * @return notificationId
     */
    public int getNotificationId() {
        return notificationId;
    }

    /**
     * sets notificationId for a notification
     * @param notificationId
     */
    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    /**
     * gives notificationMessage for a notification
     * @return notificationMessage
     */
    public String getNotificationMessage() {
        return notificationMessage;
    }

    /**
     * sets notificationMessage for a notification
     * @param notificationMessage
     */
    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }


}
