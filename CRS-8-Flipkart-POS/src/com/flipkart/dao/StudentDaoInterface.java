package com.flipkart.dao;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

import java.sql.SQLException;

/**
 * Interface for Student Dao Operations
 */
public interface StudentDaoInterface {
    /**
     * Method to view grades by id
     * @param studentID
     * @throws SQLException
     */
    public void viewGrades(String studentID) throws SQLException;

    /**
     * method to register a student
     * @param name
     * @param studentID
     * @param password
     * @param role
     * @param gender
     * @param branch
     * @param batch
     * @param address
     * @param country
     * @return
     */
    public String register(String name, String studentID, String password, Role role, Gender gender, String branch, int batch, String address, String country) ;

    /**
     * method to add course by Id
     * @param studentID
     * @throws SQLException
     */
    public void addCourse(String studentID, String courseId) throws SQLException;

    /**
     * method to drop course by Id
     * @param studentID
     * @throws SQLException
     */
    public void dropCourse(String studentID, String courseId) throws SQLException;

    /**
     * Method to view the registered courses for student by Id
     * @param studentID
     * @throws SQLException
     */
    public void viewRegisteredCourses(String studentID) throws SQLException;

    /**
     * Method to pay fees for registered courses by the student by Id
     * @param studentID
     * @throws SQLException
     */
    public void payFees(String studentID) throws SQLException;

    /**
     * Method to show notification to student with Id
     * @param studentID
     * @throws SQLException
     */
    public void showNotifications(String studentID) throws SQLException;

    /**
     * Method to check if the sudent with Id is approved
     * @param studentId
     * @return
     * @throws SQLException
     */
    public boolean isApproved(String studentId) throws SQLException;
}
