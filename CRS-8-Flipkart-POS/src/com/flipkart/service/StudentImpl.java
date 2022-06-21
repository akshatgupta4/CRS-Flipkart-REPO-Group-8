package com.flipkart.service;

import com.flipkart.bean.Student;

import java.util.HashMap;

public class StudentImpl implements StudentInterface  {
    public static HashMap<Integer, Student> studentList;
    public void viewGrades(String studentID){};
    public int register(String name, String studentID, String password, String branch, int batch, String address, String country){
        return 1;
    };
    public void addCourse(String studentID){};
    public void dropCourse(String studentID){};

    public void viewRegisteredCourses(String studentID){};

    public void showNotifications(String studentID){};

    public void payFees(String studentID){};

    public HashMap<Integer, Student> getStudentList(){
        return studentList;
    }

}
