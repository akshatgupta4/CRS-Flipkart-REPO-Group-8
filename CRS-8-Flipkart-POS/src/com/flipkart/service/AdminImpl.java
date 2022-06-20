package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;


public class AdminImpl implements AdminInterface{


    @Override
    public void deleteCourse(String courseCode, List<Course> courseList) {

    }

    public void addCourse(Course newCourse, List<Course> courseList) {

    }

    @Override
    public List<Student> viewPendingAdmissions() {
        return null;
    }


    public void approveStudent(int studentId, List<Student> studentList) {

    }

    public void addProfessor(Professor professor)  {


    }

    public void assignCourse(String courseCode, String professorId) {

    }

    public List<Course> viewCourses(int catalogId) {


    }

    @Override
    public List<Professor> viewProfessors() {
        return null;
    }
}