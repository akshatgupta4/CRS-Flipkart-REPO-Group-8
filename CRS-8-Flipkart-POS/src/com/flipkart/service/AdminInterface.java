

package com.flipkart.service;


import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.Course;

public interface AdminInterface {



    public void deleteCourse(String courseCode) throws SQLException;


    public void addCourse(Course course) throws SQLException;


    public List<Student> viewPendingAdmissions() throws SQLException;

    public void approveStudent(String studentId) throws SQLException;

    public void addProfessor(Professor professor);

    public void assignCourse(String courseCode, String professorId) throws SQLException;

    public List<Course> viewCoursesInCatalog() throws SQLException;

    public List<Professor> viewProfessors() throws SQLException;
}