package com.flipkart.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Professor;
import com.flipkart.dao.ProfessorDaoInterface;
import com.flipkart.dao.ProfessorDaoOperation;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorDoesNotExistsException;
import com.flipkart.exception.UserNotFoundException;

public class ProfessorImpl implements ProfessorInterface {

    public static HashMap<Integer, Professor> profList;

    ProfessorDaoOperation professorDaoOperation = new ProfessorDaoOperation();



    public boolean addGrade(String studentId, String courseId, String grade) throws UserNotFoundException, SQLException, CourseNotFoundException, GradeNotAddedException {
        try
        {
            professorDaoOperation.addGrade(studentId, courseId, grade);
        }
        catch(Exception ex)
        {
            throw ex;
        }
        return true;
    }

    public List<EnrolledStudent> viewEnrolledStudents(String profId) throws SQLException {

        List<EnrolledStudent> enrolledStudents = new ArrayList<EnrolledStudent>();
        try
        {
            enrolledStudents = professorDaoOperation.viewEnrolledStudents(profId);
        }
        catch(Exception ex)
        {
            throw ex;
        }
        return enrolledStudents;
    }


    public List<Course> getCourses(String profId) throws SQLException, ProfessorDoesNotExistsException {
        List<Course> coursesOffered = new ArrayList<Course>();

        coursesOffered = professorDaoOperation.getCoursesByProf(profId);


        return coursesOffered;
    }

    public String getProfessorById(String profId)
    {

        return profId;
    }
}