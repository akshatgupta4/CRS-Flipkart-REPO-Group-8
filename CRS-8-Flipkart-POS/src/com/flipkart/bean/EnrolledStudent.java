package com.flipkart.bean;

public class EnrolledStudent {
    public EnrolledStudent(String courseCode, String name, String studentId) {
        super();
        this.courseCode = courseCode;
        this.name = name;
        this.studentId = studentId;
    }

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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    private String courseCode;
    private String name;
    private String studentId;

}
