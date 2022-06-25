package com.flipkart.exception;

public class StudentNotFoundForApprovalException extends Exception{
    private String studentId;

    public StudentNotFoundForApprovalException(String studentId) {
        this.studentId = studentId;
    }


    public String getStudentId() {
        return this.studentId;
    }

    @Override
    public String getMessage() {
        return "studentId: " + studentId + " not found for approval!" ;
    }
}
