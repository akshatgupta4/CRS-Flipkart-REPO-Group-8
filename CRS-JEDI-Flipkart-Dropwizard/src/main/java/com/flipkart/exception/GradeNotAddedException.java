package com.flipkart.exception;

public class GradeNotAddedException extends Exception{
    private String studentId;


    public GradeNotAddedException(String studentId)
    {
        this.studentId=studentId;
    }


    public String getStudentId()
    {
        return studentId;
    }

    @Override
    public String getMessage()
    {
        return "Grade not Added for student with studentID:" + studentId ;
    }
}
