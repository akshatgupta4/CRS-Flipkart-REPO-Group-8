package com.flipkart.service;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public interface StudentInterface {

    /**
     * Method to view grades of a student
     * @param studentID
     */
    public void viewGrades(String studentID);

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
    public String register(String name, String studentID, String password, Role role, Gender gender, String branch, int batch, String address, String country) ;

    /**
     * Method to add course to student's registered courses
     * @param studentID
     */
    public void addCourse(String studentID);

    /**
     * Method to remove course from student's registered courses
     * @param studentID
     */
    public void dropCourse(String studentID);

    /**
     * Method to view registered courses of a student
     * @param studentID
     */

    public void viewRegisteredCourses(String studentID);

    /**
     * Method to implement fee payment for a student
     * @param studentID
     */
    public void payFees(String studentID);

    /**
     * Method to display notifications
     * @param studentID
     */
    public void showNotifications(String studentID);

    /**
     * Method to check if a student is approved
     * @param studentId
     * @return
     */

    public boolean isApproved(String studentId);

}
