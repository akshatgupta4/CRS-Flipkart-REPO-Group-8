package com.flipkart.service;

public interface StudentInterface {

    public void viewGrades(String studentID);

    public int register(String name, String studentID, String password, String branch, int batch, String address, String country) ;

    public void addCourse(String studentID);
    public void dropCourse(String studentID);

    public void viewRegisteredCourses(String studentID);
    public void payFees(String studentID);
    public void showNotifications(String studentID);
}
