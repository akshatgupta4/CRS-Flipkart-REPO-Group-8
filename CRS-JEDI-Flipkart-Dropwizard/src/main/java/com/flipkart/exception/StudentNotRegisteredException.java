package com.flipkart.exception;

public class StudentNotRegisteredException extends Exception{
    private String studentName;

    public StudentNotRegisteredException(String studentName)
    {
        this.studentName=studentName;
    }


    public String getStudentName()
    {
        return studentName;
    }

    @Override
    public String getMessage() {
        return  "Student with name:" + studentName+" is not registered";
    }
}
