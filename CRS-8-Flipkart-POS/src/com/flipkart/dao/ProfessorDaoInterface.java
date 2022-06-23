package com.flipkart.dao;


import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;


import java.util.List;

public interface ProfessorDaoInterface {
    public boolean addGrade(String studentId);

    public List<EnrolledStudent> viewEnrolledStudents(String profId);

    public List<Course> getCourses(String profId);

    public String getProfessorById(String profId);

    List<Course> getCoursesByProf(String profId);
}
