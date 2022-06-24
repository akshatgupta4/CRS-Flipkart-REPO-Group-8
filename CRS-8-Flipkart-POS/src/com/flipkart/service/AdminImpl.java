package com.flipkart.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.AdminDaoOperation;
import com.flipkart.exception.CourseFoundException;
import com.flipkart.exception.CourseNotAssignedToProfessorException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorAlreadyExistsException;


public class AdminImpl implements AdminInterface{

    private static AdminImpl instance = null;
    private static AdminDaoInterface adminDaoObj = null;
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
            adminDaoObj = AdminDaoOperation.getInstance();
        }
        return instance;
    }
    @Override
    public void deleteCourse(String courseCode) throws SQLException, CourseNotFoundException {
        adminDaoObj.deleteCourse(courseCode);
    }

    public void addCourse(Course newCourse) throws SQLException, CourseFoundException {
        adminDaoObj.addCourse(newCourse);
    }

    @Override
    public List<Student> viewPendingAdmissions() throws SQLException {
        return adminDaoObj.viewPendingAdmissions();
    }


    @Override
    public void approveStudent(String studentId) throws SQLException {
        adminDaoObj.approveStudent(studentId);
        return;
    }

    public void addProfessor(Professor professor) throws SQLException, ProfessorAlreadyExistsException {
//        ProfessorImpl.profList.put(Integer.parseInt(professor.getUserId()), professor);
        adminDaoObj.addProfessor(professor);
        return;
    }

    public void assignCourse(String courseCode, String professorId) throws SQLException, CourseNotAssignedToProfessorException {
        adminDaoObj.assignCourse(courseCode, professorId);
    }

    public List<Course> viewCoursesInCatalog() throws SQLException {

//        CourseCatalogInterface catalog = new CourseCatalogImpl();
        return adminDaoObj.viewCoursesInCatalog();
    }

    @Override
    public List<Professor> viewProfessors() throws SQLException {
//        HashMap<Integer, Professor> profListMap= ProfessorImpl.profList;
//        List<Professor> profList = new ArrayList<Professor>();
//        profListMap.forEach((k, v) -> profList.add(v));
//        return profList;
        return adminDaoObj.viewProfessors();
    }
}