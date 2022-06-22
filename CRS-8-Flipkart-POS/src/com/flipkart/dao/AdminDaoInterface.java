package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.List;

public interface AdminDaoInterface {
    public void deleteCourse(String courseCode, List<Course> courseList) ;


    public void addCourse(Course course);


    public List<Student> viewPendingAdmissions();

    public void approveStudent(String studentId) ;

    public void addProfessor(Professor professor);

    public void assignCourse(String courseCode, String professorId) ;

    public List<Course> viewCoursesInCatalog();

    public List<Professor> viewProfessors();
}
