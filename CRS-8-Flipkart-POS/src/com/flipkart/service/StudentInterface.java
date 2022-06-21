package com.flipkart.service;

public interface StudentInterface {

    public void viewGrades(String studentID, String password);

    public int register(String name, String studentID, String password, String branch, int batch, String address, String country) ;

    public void addCourse(String studentID, String CourseCode);
    public void dropCourse(String studentID, String CourseCode);
}
