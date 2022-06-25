package com.flipkart.bean;

public class EnrolledStudent {
    public EnrolledStudent(String courseCode, String name, String studentId) {
        super();
        this.courseCode = courseCode;
        this.name = name;
        this.studentId = studentId;
    }

    /**
     * gives course code enrolled student
     *
     * @return courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * sets course code for enrolled student
     *
     * @param courseCode
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * gives name for enrolled student
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * sets name for enrolled student
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gives studentId for enrolled student
     *
     * @return
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * sets studentId for enrolled student
     *
     * @param studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    private String courseCode;
    private String name;
    private String studentId;

}
