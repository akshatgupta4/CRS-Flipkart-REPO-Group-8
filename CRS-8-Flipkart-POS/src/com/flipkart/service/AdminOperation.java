package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;


public class AdminOperation implements AdminInterface{

    private AdminOperation()
    {

    }

    public static AdminOperation getInstance()
    {
    }



    public void addCourse(Course newCourse, List<Course> courseList) {

    }


    public void approveStudent(int studentId, List<Student> studentList) {

    }

    public void addProfessor(Professor professor)  {


    }

    public void assignCourse(String courseCode, String professorId) {

    }

    public List<Course> viewCourses(int catalogId) {


    }
}