package com.flipkart.service;

public interface StudentInterface {

    public void viewGrades(String studentID, String password);
    public void register(String name, String studentID, String branch, String address, String password);
    public void addCourse(String studentID, String CourseCode);
    public void dropCourse(String studentID, String CourseCode);
}
