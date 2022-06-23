package com.flipkart.bean;

public class Course {
    private String courseCode;
    private String name;
    private boolean isOffered;
    private String instructorId;
    private int vacantSeats = 10;

    private int courseFee = 5000;
    public int getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(int courseFee) {
        this.courseFee = courseFee;
    }


    public Course(String courseCode, String name) {
        this.courseCode = courseCode;
        this.name = name;
    }

    public Course(){}
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOffered() {
        return isOffered;
    }

    public void setOffered(boolean offered) {
        isOffered = offered;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public int getVacantSeats() {
        return vacantSeats;
    }

    public void setVacantSeats(int seats) {
        this.vacantSeats = seats;
    }





}
