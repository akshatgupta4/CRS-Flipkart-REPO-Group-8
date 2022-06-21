package com.flipkart.service;

import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

import java.util.HashMap;

public class StudentImpl implements StudentInterface  {
    public static HashMap<Integer, Student> studentList;
    public void viewGrades(String studentID){};
    public int register(String name, String studentID, String password, Role role, Gender gender, String branch, int batch, String address, String country){
        Student student = new Student(studentID, name, role, password, gender, address,
                country, branch);
        User user = new User(studentID, name, role, password, gender, address, country);
        int id_ = Integer.parseInt(studentID);
        studentList.put(id_, student);
        UserImpl.userList.put(id_, user);
        return id_;

    };
    public void addCourse(String studentID){};
    public void dropCourse(String studentID){};

    public void viewRegisteredCourses(String studentID){};

    public void showNotifications(String studentID){};

    public void payFees(String studentID){};

    public HashMap<Integer, Student> getStudentList(){
        return studentList;
    }

    public boolean isApproved(String studentId){
        Student student  = studentList.get(Integer.parseInt(studentId));
        return student.isApproved();
    }


}
