package com.flipkart.service;

import java.util.HashMap;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Professor;

public class ProfessorImpl implements ProfessorInterface {

    public static HashMap<Integer, Professor> profList;



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