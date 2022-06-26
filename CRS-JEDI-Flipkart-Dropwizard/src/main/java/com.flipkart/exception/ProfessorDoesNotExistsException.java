package com.flipkart.exception;

public class ProfessorDoesNotExistsException extends Exception{
        private String professorId;

        public ProfessorDoesNotExistsException (String professorId) {
            this.professorId = professorId;
        }


        public String getUserId() {
            return this.professorId;
        }


        @Override
        public String getMessage() {
            return "professorId: " + professorId + " does not exists!";
        }
    }
