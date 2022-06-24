package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorDoesNotExistsException;
import com.flipkart.exception.UserNotFoundException;

import java.util.List;
import com.flipkart.exception.GradeNotAddedException;

public interface ProfessorInterface {

//<<<<<<< HEAD
//    public boolean addGrade(String studentId, String courseId, String grade) throws GradeNotAddedException;
//
//    public List<EnrolledStudent> viewEnrolledStudents(String profId) throws SQLException;
//
//    public List<Course> getCourses(String profId) throws SQLException, GradeNotAddedException;
//
//=======
    /*
     * Method to add Grade of student
     * @param studentId
     * @param courseId
     * @return boolean indicating if grade is added or not
     * @throws GradeNotAddedException
     */
    public boolean addGrade(String studentId, String courseId, String grade) throws UserNotFoundException, SQLException, CourseNotFoundException, GradeNotAddedException;

    /*
     * Method to view all the enrolled students
     * @param profId: professor id
     * @return List of enrolled students
     */
    public List<EnrolledStudent> viewEnrolledStudents(String profId) throws SQLException;

    /*
     * Method to get list of all course a professor is teaching
     * @param profId: professor id
     * @return List of courses the professor is teaching
     */
    public List<Course> getCourses(String profId) throws SQLException, ProfessorDoesNotExistsException;

    /*
     * Method to get the professor name with ID
     * @param profId
     * @return Professor name
     */
    public String getProfessorById(String profId);
}