package com.flipkart.exception;

public class GradeNotAddedException extends Exception{
    private int studentId;


    public GradeNotAddedException(int studentId)
    {
        this.studentId=studentId;
    }


    public int getStudentId()
    {
        return studentId;
    }

    @Override
    public String getMessage()
    {
        return "Grade not Added for student with studentID:" + studentId ;
    }
}
