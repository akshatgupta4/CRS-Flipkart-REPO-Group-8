package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;

public class ProfessorImpl implements ProfessorInterface {





    public boolean addGrade(int studentId,String courseCode,String grade) {
        return false;
    }


    public List<EnrolledStudent> viewEnrolledStudents(String profId){

        return null;
    }

    public List<Course> getCourses(String profId) {

        return null;
    }

    public String getProfessorById(String profId)
    {

        return profId;
    }
}