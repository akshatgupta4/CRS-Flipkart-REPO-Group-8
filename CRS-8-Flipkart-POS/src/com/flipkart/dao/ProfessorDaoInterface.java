package com.flipkart.dao;


import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;


import java.sql.SQLException;
import java.util.List;

public interface ProfessorDaoInterface {
public boolean addGrade(String studentId, String courseId, String grade) throws SQLException;

    public List<EnrolledStudent> viewEnrolledStudents(String profId);

    public List<Course> getCourses(String profId);

    public String getProfessorById(String profId);
}
