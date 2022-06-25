package com.flipkart.exception;

public class ProfessorAlreadyExistsException extends Exception{
    private String professorId;

    public ProfessorAlreadyExistsException (String professorId) {
        this.professorId = professorId;
    }


    public String getUserId() {
        return this.professorId;
    }


    @Override
    public String getMessage() {
        return "professorId: " + professorId + " already exists!";
    }
}
