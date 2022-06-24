package com.flipkart.dao;


import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.exception.GradeNotAddedException;


import java.sql.SQLException;
import java.util.List;

/**
 *Interface for Professor Dao Operations
 */
public interface ProfessorDaoInterface {
<<<<<<< HEAD
public boolean addGrade(String studentId, String courseId, String grade) throws GradeNotAddedException,SQLException;

=======
    /**
     * Method to Grade a student using SQL Commands
     * @param studentId
     * @param courseId
     * @param grade
     * @return
     * @throws SQLException
     */
    public boolean addGrade(String studentId, String courseId, String grade) throws SQLException;

    /**
     * Method to view list of enrolled Students using SQL Commands
     * @param profId
     * @return
     */
>>>>>>> 947280ef724bddead115bb8e991f82d3f7ab640e
    public List<EnrolledStudent> viewEnrolledStudents(String profId);

    /**
     * Method to get Courses by Professor Id using SQL Commands
     * @param profId
     * @return
     */
    public List<Course> getCourses(String profId);

<<<<<<< HEAD

=======
    /**
     * Method to Get professor name by id
     * @param profId
     * @return
     */
    public String getProfessorById(String profId);
>>>>>>> 947280ef724bddead115bb8e991f82d3f7ab640e

    /**
     * Method to list all courses taught by the professor with id
     * @param profId
     * @return
     */
    List<Course> getCoursesByProf(String profId);
}
