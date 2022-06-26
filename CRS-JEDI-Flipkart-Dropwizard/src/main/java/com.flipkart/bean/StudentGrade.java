package com.flipkart.bean;

public class StudentGrade {

    private String courseCode;
    private String courseName;
    private String grade;

    /**
     * parameterised constructor for studentGrade
     *
     * @param courseCode
     * @param courseName
     * @param grade
     */
    public StudentGrade(String courseCode, String courseName, String grade) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.grade = grade;
    }

    /**
     * gives courseCode
     *
     * @return courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * sets courseCode
     *
     * @param courseCode
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * gives courseName
     *
     * @return courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * sets courseName
     *
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * gives grade
     *
     * @return grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * sets grade
     *
     * @param grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
