package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseFoundException;
import com.flipkart.exception.CourseNotAssignedToProfessorException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorAlreadyExistsException;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface for Admin Dao Operations
 */
public interface AdminDaoInterface {

    /**
     * Delete Course using SQL commands
     * @param courseCode
     * @throws SQLException
     */
    public void deleteCourse(String courseCode) throws SQLException, CourseNotFoundException;

    /**
     * Add Course using SQL commands
     * @param course
     * @throws CourseFoundException
     * @throws SQLException
     */
    public void addCourse(Course course) throws SQLException, CourseFoundException;

    /**
     *Fetch Students yet to approved using SQL commands
     * @return
     * @throws SQLException
     */
    public List<Student> viewPendingAdmissions() throws SQLException;
//

    /**
     *Approve Student using SQL commands
     * @param studentId
     * @throws SQLException
     */
    public void approveStudent(String studentId) throws SQLException;
//

    /**
     * Add professor using SQL Commands
     * @param professor
     * @throws SQLException
     */
    public void addProfessor(Professor professor) throws SQLException, ProfessorAlreadyExistsException;
//

    /**
     * Assign courses to Professor using SQL commands
     * @param courseCode
     * @param professorId
     * @throws SQLException
     */
    public void assignCourse(String courseCode, String professorId) throws SQLException, CourseNotAssignedToProfessorException;
//

    /**
     * View courses in the catalog
     * @return
     * @throws SQLException
     */
    public List<Course> viewCoursesInCatalog() throws SQLException;
//

    /**
     * View professor in the institute
     * @return
     * @throws SQLException
     */
    public List<Professor> viewProfessors() throws SQLException;
}
