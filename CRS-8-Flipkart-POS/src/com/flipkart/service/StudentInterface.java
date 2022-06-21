package com.flipkart.service;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public interface StudentInterface {

    public void viewGrades(String studentID);

    public String register(String name, String studentID, String password, Role role, Gender gender, String branch, int batch, String address, String country) ;

    public void addCourse(String studentID);
    public void dropCourse(String studentID);

    public void viewRegisteredCourses(String studentID);
    public void payFees(String studentID);
    public void showNotifications(String studentID);

    public boolean isApproved(String studentId);

}
