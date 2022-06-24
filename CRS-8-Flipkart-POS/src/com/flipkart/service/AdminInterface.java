

package com.flipkart.service;


import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.Course;
import com.flipkart.exception.CourseFoundException;
import com.flipkart.exception.CourseNotAssignedToProfessorException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorAlreadyExistsException;

public interface AdminInterface {


    /*
     * Method to Delete Course from Course Catalog
     * @param courseCode
     * @throws CourseNotFoundException
     * @throws CourseNotDeletedException
     */
    public void deleteCourse(String courseCode) throws SQLException, CourseNotFoundException;

    /*
     * Method to add Course to Course Catalog
     * @param course : Course object storing details of a course
     */


    public void addCourse(Course course) throws SQLException, CourseFoundException;

    /*
     * Method to view Students yet to be approved by Admin
     * @return List of Students with pending admissions
     */
    public List<Student> viewPendingAdmissions() throws SQLException;

    /*
     * Method to approve a Student
     * @param studentId
     * @throws StudentNotFoundException
     * @throws StudentNotFoundForApprovalException
     */
    public void approveStudent(String studentId) throws SQLException;

    /*
     * Method to add Professor to DB
     * @param professor : Professor Object storing details of a professor
     * @throws ProfessorNotAddedException
     * @throws UserIdAlreadyInUseException
     */
    public void addProfessor(Professor professor) throws SQLException, ProfessorAlreadyExistsException;

    /*
     * Method to assign Course to a Professor
     * @param courseCode
     * @param professorId
     * @throws CourseNotFoundException
     * @throws UserNotFoundException
     */
    public void assignCourse(String courseCode, String professorId) throws SQLException, CourseNotAssignedToProfessorException;

    /*
     * Method to get list of courses in catalog
     * @return List of courses in catalog
     */
    public List<Course> viewCoursesInCatalog() throws SQLException;

    /*
     * View professor in the institute
     * @return List of the professors in the institute
     */
    public List<Professor> viewProfessors() throws SQLException;
}