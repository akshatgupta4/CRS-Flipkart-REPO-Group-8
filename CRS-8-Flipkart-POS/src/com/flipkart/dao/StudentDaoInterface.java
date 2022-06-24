package com.flipkart.dao;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.exception.CourseFoundException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.SeatNotAvailableException;
import com.flipkart.exception.StudentNotFoundForApprovalException;

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
    public void viewGrades(String studentID) throws SQLException, StudentNotFoundForApprovalException, GradeNotAddedException;

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
     * Method to add course to student's registered courses
     * @param studentID
     * @throws SQLException
     * @throws SeatNotAvailableException
     */
    public void addCourse(String studentID) throws SQLException, SeatNotAvailableException;

    /**
     * method to drop course by Id
     * @param studentID
     * @throws SQLException
     */
    public void dropCourse(String studentID) throws SQLException, CourseFoundException;

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
