package com.flipkart.dao;


import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.exception.GradeNotAddedException;


import java.sql.SQLException;
import java.util.List;

public interface ProfessorDaoInterface {
public boolean addGrade(String studentId, String courseId, String grade) throws GradeNotAddedException,SQLException;

    public List<EnrolledStudent> viewEnrolledStudents(String profId);

    public List<Course> getCourses(String profId);



    List<Course> getCoursesByProf(String profId);
}
