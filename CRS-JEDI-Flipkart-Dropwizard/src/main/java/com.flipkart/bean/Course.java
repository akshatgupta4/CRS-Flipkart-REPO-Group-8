package com.flipkart.bean;

public class Course {

    private String courseCode;
    private String name;

    private String instructorId;
    private int vacantSeats = 10;

    private int courseFee = 5000;

    /**
     * returns courseFee
     *
     * @return courseFee
     */
    public int getCourseFee() {
        return courseFee;
    }

    /**
     * sets courseFee
     *
     * @param courseFee
     */
    public void setCourseFee(int courseFee) {
        this.courseFee = courseFee;
    }

    /**
     * constructor for Course
     *
     * @param courseCode
     * @param name
     */
    public Course(String courseCode, String name) {
        this.courseCode = courseCode;
        this.name = name;
    }

    /**
     * parameterised constructor for Course
     *
     * @param courseCode
     * @param professorId
     * @param courseFee
     * @param name
     * @param vacantSeat
     */
    public Course(String courseCode, String professorId, int courseFee, String name, int vacantSeat) {
        this.courseCode = courseCode;
        this.name = name;
        this.instructorId = professorId;
        this.courseFee = courseFee;
        this.vacantSeats = vacantSeat;


    }

    /**
     * default constructor for Course with no params
     */
    public Course() {
    }

    /**
     * returns courseCode for a course
     *
     * @return courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * sets courseCode for a course
     *
     * @param courseCode
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * returns name of Course
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets name of course
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns instructorId for a course
     *
     * @return instructorId
     */
    public String getInstructorId() {
        return instructorId;
    }

    /**
     * sets instructorId for a course
     *
     * @param instructorId
     */
    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    /**
     * returns number of vacantSeats for a course(initially 10)
     *
     * @return vacantSeats
     */
    public int getVacantSeats() {
        return vacantSeats;
    }

    /**
     * sets number of vacantSeats for a course
     *
     * @param seats
     */
    public void setVacantSeats(int seats) {
        this.vacantSeats = seats;
    }


}
