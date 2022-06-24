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

public interface ProfessorInterface {

    public boolean addGrade(String studentId, String courseId, String grade) throws UserNotFoundException, SQLException, CourseNotFoundException;

    public List<EnrolledStudent> viewEnrolledStudents(String profId) throws SQLException;

    public List<Course> getCourses(String profId) throws SQLException, ProfessorDoesNotExistsException;

    public String getProfessorById(String profId);
}