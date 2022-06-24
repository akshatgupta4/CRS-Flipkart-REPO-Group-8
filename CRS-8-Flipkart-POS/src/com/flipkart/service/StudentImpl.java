package com.flipkart.service;

import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

import java.util.HashMap;
import java.util.Scanner;

public class StudentImpl implements StudentInterface  {
    public static HashMap<String, Student> StudentList = new HashMap<String, Student>();

    public void viewGrades(String studentID){};
    public String register(String name, String studentID, String password, Role role, Gender gender, String branch, int batch, String address, String country){
        Student student = new Student(studentID, name, role, password, gender, address,
                country, branch);
//        System.out.println("in register..");
        User user = new User(studentID, name, role, password, gender, address, country);

//        int id_ = Integer.parseInt(studentID);
//        System.out.println("User cerated..");
        System.out.println(studentID);
        System.out.println(student.getRole());

        StudentList.put(studentID, student);
//        System.out.println("User cerated next..");
        UserImpl.userList.put(studentID, user);
//        System.out.println(("next step.."));
        return studentID;

    };
    public void addCourse(String studentID){};
    public void dropCourse(String studentID){};

    public void viewRegisteredCourses(String studentID){};

    public void showNotifications(String studentID){};

    public void payFees(String studentID){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Credit Card Number:");
        String cardNumber = sc.next();
        System.out.println("Enter Expiry in the format(MM/YY):");
        String expiry = sc.next();
        System.out.println("Enter CVV:");
        String cvv = sc.next();
        System.out.println("Connecting to Payment Server");
        System.out.println("Redirecting");
        for(int i=0;i<1e7;i++);
        System.out.println("Enter OTP sent to mobile Number:");
        String otp = sc.next();
        System.out.println("Processing Payment");
        for(int i=0;i<1e7;i++);
        System.out.println("Payment Completed Successfully");
    };

    public HashMap<String, Student> getStudentList(){
        return StudentList;
    }

    public boolean isApproved(String studentId){
        Student student  = StudentList.get(studentId);
        return student.isApproved();
    }


}
