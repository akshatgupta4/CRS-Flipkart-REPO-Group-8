package com.flipkart.dao;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

import java.sql.SQLException;

public interface StudentDaoInterface {
    public void viewGrades(String studentID) throws SQLException;

    public String register(String name, String studentID, String password, Role role, Gender gender, String branch, int batch, String address, String country) ;

    public void addCourse(String studentID) throws SQLException;
    public void dropCourse(String studentID) throws SQLException;

    public void viewRegisteredCourses(String studentID) throws SQLException;
    public void payFees(String studentID) throws SQLException;
    public void showNotifications(String studentID) throws SQLException;

    public boolean isApproved(String studentId) throws SQLException;
}
