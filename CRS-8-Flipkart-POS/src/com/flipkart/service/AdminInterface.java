

package com.flipkart.service;


import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.Course;

public interface AdminInterface {



    public void deleteCourse(String courseCode, List<Course> courseList) ;


    public void addCourse(Course course);


    public List<Student> viewPendingAdmissions();

    public void approveStudent(int studentId, List<Student> studentList) ;

    public void addProfessor(Professor professor);

    public void assignCourse(String courseCode, String professorId) ;

    public List<Course> viewCoursesInCatalog();

    public List<Professor> viewProfessors();
}