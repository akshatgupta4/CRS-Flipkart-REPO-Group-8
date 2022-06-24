

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



    public void deleteCourse(String courseCode) throws SQLException, CourseNotFoundException;


    public void addCourse(Course course) throws SQLException, CourseFoundException;


    public List<Student> viewPendingAdmissions() throws SQLException;

    public void approveStudent(String studentId) throws SQLException;

    public void addProfessor(Professor professor) throws SQLException, ProfessorAlreadyExistsException;

    public void assignCourse(String courseCode, String professorId) throws SQLException, CourseNotAssignedToProfessorException;

    public List<Course> viewCoursesInCatalog() throws SQLException;

    public List<Professor> viewProfessors() throws SQLException;
}