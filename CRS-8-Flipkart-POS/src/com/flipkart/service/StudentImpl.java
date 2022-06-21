package com.flipkart.service;

import com.flipkart.bean.Student;

import java.util.HashMap;

public class StudentImpl implements StudentInterface  {
    public static HashMap<Integer, Student> studentList;
    public void viewGrades(String studentID, String password){};
    public int register(String name, String studentID, String password, String branch, int batch, String address, String country){
        return 1;
    };
    public void addCourse(String studentID, String CourseCode){};
    public void dropCourse(String studentID, String CourseCode){};

    public HashMap<Integer, Student> getStudentList(){
        return studentList;
    }

}
