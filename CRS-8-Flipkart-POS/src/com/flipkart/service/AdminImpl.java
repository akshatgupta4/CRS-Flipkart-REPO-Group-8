package com.flipkart.service;

import java.util.ArrayList;
import java.util.HashMap;
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
    public void deleteCourse(String courseCode) {
        catalogInstance.deleteCourse(courseCode);
    }

    public void addCourse(Course newCourse) {
        catalogInstance.addCourse(newCourse);
    }

    @Override
    public List<Student> viewPendingAdmissions() {
        List<Student> pendingAdmissionsList = new ArrayList<Student>();
        StudentImpl.StudentList.forEach((k, v) -> {
            if(!v.isApproved()) pendingAdmissionsList.add(v);
        });

        return pendingAdmissionsList;
    }


    @Override
    public void approveStudent(String studentId) {
        System.out.println(StudentImpl.StudentList.size());
        StudentImpl.StudentList.get(studentId).setApproved(true);
        return;
    }

    public void addProfessor(Professor professor)  {
        ProfessorImpl.profList.put(Integer.parseInt(professor.getUserId()), professor);
        return;
    }

    public void assignCourse(String courseCode, String professorId) {
        Course course = CourseCatalogImpl.courseCatalog.get(courseCode);
        course.setInstructorId(professorId);
        CourseCatalogImpl.courseCatalog.put(courseCode, course);
    }

    public List<Course> viewCoursesInCatalog() {

//        CourseCatalogInterface catalog = new CourseCatalogImpl();
        return catalogInstance.viewAllCourses();
    }

    @Override
    public List<Professor> viewProfessors() {
        HashMap<Integer, Professor> profListMap= ProfessorImpl.profList;
        List<Professor> profList = new ArrayList<Professor>();
        profListMap.forEach((k, v) -> profList.add(v));
        return profList;
    }
}