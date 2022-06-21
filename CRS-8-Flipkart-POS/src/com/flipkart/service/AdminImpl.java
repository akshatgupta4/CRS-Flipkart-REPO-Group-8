package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;


public class AdminImpl implements AdminInterface{

    private static AdminImpl instance = null;
    private static CourseCatalogImpl catalogInstance = null;

    private AdminImpl() {
        catalogInstance = new CourseCatalogImpl();
    }
    public static AdminImpl getInstance()
    {
        if(instance==null)
        {
            // This is a synchronized block, when multiple threads will access this instance
            instance = new AdminImpl();
        }
        return instance;
    }
    @Override
    public void deleteCourse(String courseCode, List<Course> courseList) {

    }

    public void addCourse(Course newCourse) {
        catalogInstance.addCourse(newCourse);
    }

    @Override
    public List<Student> viewPendingAdmissions() {
        return null;
    }


    @Override
    public void approveStudent(int studentId) {
        StudentImpl.studentList.get(studentId).setApproved(true);
        return;
    }

    public void addProfessor(Professor professor)  {
        ProfessorImpl.profList.put(Integer.parseInt(professor.getUserId()), professor);
        return;
    }

    public void assignCourse(String courseCode, String professorId) {

    }

    public List<Course> viewCoursesInCatalog() {

//        CourseCatalogInterface catalog = new CourseCatalogImpl();
        return catalogInstance.viewAllCourses();
    }

    @Override
    public List<Professor> viewProfessors() {
        return null;
    }
}