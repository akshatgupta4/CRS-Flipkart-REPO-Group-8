package com.flipkart.service;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Student;
import com.flipkart.bean.Course;

public class ProfessorImpl implements ProfessorInterface {
    private static volatile ProfessorImpl instance=null;
    public static ProfessorImpl getInstance()
    {
        if(instance==null)
        {
            // This is a synchronized block, when multiple threads will access this instance
            synchronized(ProfessorImpl.class){
                instance=new ProfessorImpl();
            }
        }
        return instance;
    }



    public boolean addGrade(int studentId,String courseCode,String grade) {
    }


    public List<Student> viewEnrolledStudents(String profId){
    }

    public List<Course> getCourses(String profId) {

    }

    @Override
    public String getProfessorById(String profId) {
        return null;
    }

}