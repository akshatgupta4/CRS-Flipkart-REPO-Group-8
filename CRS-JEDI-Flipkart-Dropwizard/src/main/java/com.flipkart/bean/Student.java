package com.flipkart.bean;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public class Student extends User {

    private String studentId;
    private String branch;
    boolean isApproved = false;

    /**
     * returns true if Student is approved by admin else returns false
     *
     * @param studentId
     * @return true or false
     */
    public boolean isApproved(String studentId) {
        return isApproved;
    }

    /**
     * sets approved status of student
     *
     * @param approved
     */
    public void setApproved(boolean approved) {
        isApproved = approved;
    }


    /**
     * parameterised constructor for student
     *
     * @param userId
     * @param name
     * @param role
     * @param password
     * @param gender
     * @param address
     * @param country
     * @param branch
     */
    public Student(String userId, String name, Role role, String password, Gender gender, String address,
                   String country, String branch) {
        super(userId, name, role, password, gender, address, country);
        this.branch = branch;
    }

    /**
     * default constructor for student
     */
    public Student() {
    }

    /**
     * gives branch for a student
     * @return branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * sets branch for a student
     * @param branch
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }
}
