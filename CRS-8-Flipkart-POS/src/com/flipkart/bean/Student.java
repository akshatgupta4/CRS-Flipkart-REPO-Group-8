package com.flipkart.bean;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

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





    public Student(String userId, String name, Role role, String password, Gender gender, String address,
                   String country, String branch) {
        super(userId, name, role, password, gender, address, country);
        this.branch = branch;
    }

    public Student(){}


    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
