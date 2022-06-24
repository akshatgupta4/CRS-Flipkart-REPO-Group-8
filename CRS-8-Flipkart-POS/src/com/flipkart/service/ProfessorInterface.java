package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;

import java.util.List;
import com.flipkart.exception.GradeNotAddedException;

public interface ProfessorInterface {

    public boolean addGrade(String studentId, String courseId, String grade) throws GradeNotAddedException;

    public List<EnrolledStudent> viewEnrolledStudents(String profId) throws SQLException;

    public List<Course> getCourses(String profId) throws SQLException, GradeNotAddedException;

    public String getProfessorById(String profId);
}