package com.flipkart.bean;

public class Student {

    private int StudentId;

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentAddress() {
        return StudentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        StudentAddress = studentAddress;
    }

    public String getStudentBranch() {
        return StudentBranch;
    }

    public void setStudentBranch(String studentBranch) {
        StudentBranch = studentBranch;
    }

    private String StudentName;

    private String StudentAddress;

    private String StudentBranch;


}
