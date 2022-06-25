package com.flipkart.dao;


import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.ProfessorDoesNotExistsException;
import com.flipkart.exception.UserNotFoundException;

import java.sql.SQLException;
import java.util.List;

/**
 *Interface for Professor Dao Operations
 */
public interface ProfessorDaoInterface {

    /**
     * Method to Grade a student using SQL Commands
     * @param studentId
     * @param courseId
     * @param grade
     * @return
     * @throws SQLException
     */
    public boolean addGrade(String studentId, String courseId, String grade) throws SQLException, CourseNotFoundException, UserNotFoundException, GradeNotAddedException;

    /**
     * Method to view list of enrolled Students using SQL Commands
     * @param profId
     * @return
     */
    public List<EnrolledStudent> viewEnrolledStudents(String profId) throws SQLException;

    /**
     * Method to get Courses by Professor Id using SQL Commands
     * @param profId
     * @return
     */
//    public List<Course> getCoursesByProf(String profId);


//    /**
//     * Method to Get professor name by id
//     * @param profId
//     * @return
//     */
//    public String getProfessorById(String profId);

    /**
     * Method to list all courses taught by the professor with id
     * @param profId
     * @return
     */
    List<Course> getCoursesByProf(String profId) throws SQLException, ProfessorDoesNotExistsException;
}
