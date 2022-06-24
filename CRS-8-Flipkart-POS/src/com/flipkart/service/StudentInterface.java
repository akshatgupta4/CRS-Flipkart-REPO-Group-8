package com.flipkart.service;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.exception.CourseFoundException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.SeatNotAvailableException;
import com.flipkart.exception.StudentNotFoundForApprovalException;
import java.sql.SQLException;


public interface StudentInterface {


    /**
     * Method to view grades of a student
     * @param studentID
     */
    public void viewGrades(String studentID) throws SQLException, StudentNotFoundForApprovalException, GradeNotAddedException;

    /**
     * Method to register student into the system
     * @param name
     * @param studentID
     * @param password
     * @param role
     * @param gender
     * @param branch
     * @param batch
     * @param address
     * @param country
     * @return student id
     */
    public String register(String name, String studentID, String password, Role role, Gender gender, String branch, int batch, String address, String country) throws SQLException;

    /**
     * Method to add course to student's registered courses
     * @param studentID
     */
    public void addCourse(String studentID) throws SQLException, SeatNotAvailableException;

    /**
     * Method to remove course from student's registered courses
     * @param studentID
     */
    public void dropCourse(String studentID) throws SQLException, CourseFoundException;

    /**
     * Method to view registered courses of a student
     * @param studentID
     */

    public void viewRegisteredCourses(String studentID) throws SQLException;

    /**
     * Method to implement fee payment for a student
     * @param studentID
     */
    public void payFees(String studentID);

    /**
     * Method to display notifications
     * @param studentID
     */
    public void showNotifications(String studentID) throws SQLException;

    /**
     * Method to check if a student is approved
     * @param studentId
     * @return
     */

    public boolean isApproved(String studentId) throws SQLException;

}
