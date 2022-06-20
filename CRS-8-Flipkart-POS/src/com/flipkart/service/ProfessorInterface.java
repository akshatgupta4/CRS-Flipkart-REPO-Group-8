package com.flipkart.service;



public interface ProfessorInterface {

    public boolean addGrade(int studentId,String courseCode,String grade);

    public List<EnrolledStudent> viewEnrolledStudents(String profId) ;

    public List<Course> getCourses(String profId);

    public String getProfessorById(String profId);
}