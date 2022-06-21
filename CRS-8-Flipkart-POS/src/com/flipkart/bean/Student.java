package com.flipkart.bean;

import javax.management.relation.Role;

public class Student extends User{

    private  String studentId;
    private  String branch;
    boolean isApproved = false;

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }





    public Student( String studentId, String branch) {
        super();
        this.studentId = studentId;
        this.branch = branch;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
