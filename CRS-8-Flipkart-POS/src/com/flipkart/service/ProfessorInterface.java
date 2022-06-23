package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;

import java.util.List;

public interface ProfessorInterface {

    public boolean addGrade(String studentId) throws SQLException;

    public List<EnrolledStudent> viewEnrolledStudents(String profId) ;

    public List<Course> getCourses(String profId);

    public String getProfessorById(String profId);
}