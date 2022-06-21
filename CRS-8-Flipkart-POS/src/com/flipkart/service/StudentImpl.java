package com.flipkart.service;

import com.flipkart.bean.Student;

import java.util.HashMap;

public class StudentImpl implements StudentInterface  {
    public static HashMap<Integer, Student> studentList;
    public void viewGrades(String studentID, String password){};
    public void register(String name, String studentID, String branch, String address, String password){};
    public void addCourse(String studentID, String CourseCode){};
    public void dropCourse(String studentID, String CourseCode){};

    public HashMap<Integer, Student> getStudentList(){
        return studentList;
    }

}
