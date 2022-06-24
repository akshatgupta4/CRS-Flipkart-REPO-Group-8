package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.constant.SQLQueryConstants;
import com.flipkart.exception.GradeNotAddedException;
//import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorDoesNotExistsException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.util.CRSDbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDaoOperation {



    public List<EnrolledStudent> viewEnrolledStudents(String profId) throws SQLException {
        Connection connection = CRSDbConnection.getConnection();
        List<EnrolledStudent> enrolledStudents = new ArrayList<EnrolledStudent>();

        try
        {
            PreparedStatement stmt = connection.prepareStatement(SQLQueryConstants.GET_ENROLLED_STUDENTS);
            stmt.setString(1, profId);
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                enrolledStudents.add(new EnrolledStudent(res.getString(1), res.getString(2), res.getString(3)));
            }

        }
        catch(Exception ex)
        {
            throw ex;
        }
        finally {
            connection.close();
        }
        return enrolledStudents;

    }

    public List<Course> getCoursesByProf(String profId) throws SQLException, ProfessorDoesNotExistsException {
        Connection connection = CRSDbConnection.getConnection();
        List<Course> coursesOffered= new ArrayList<Course>();

        PreparedStatement stmt = connection.prepareStatement(SQLQueryConstants.GET_PROFESSOR_QUERY);
        stmt.setString(1, profId);
        ResultSet rs = stmt.executeQuery();
        if(!rs.next()) throw new ProfessorDoesNotExistsException(profId);
        try
        {
        stmt = connection.prepareStatement(SQLQueryConstants.PROF_GET_COURSE);
        stmt.setString(1, profId);
        ResultSet res = stmt.executeQuery();
        while(res.next()){
            coursesOffered.add(new Course(res.getString(1), res.getString(2), res.getInt(3), res.getString(4), res.getInt(5)));
        }

        }
        catch(Exception ex)
        {
            throw ex;
        }
        finally {
            connection.close();
        }
        return coursesOffered;
    }

//<<<<<<< HEAD
//    public boolean addGrade(String studentId, String courseId, String grade) throws GradeNotAddedException {
//        Connection connection =CRSDbConnection.getConnection();
//=======
    public boolean addGrade(String studentId, String courseId, String grade) throws SQLException, CourseNotFoundException, UserNotFoundException, GradeNotAddedException {
        Connection connection = CRSDbConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement(SQLQueryConstants.GET_COURSE_QUERY);
        stmt.setString(1, courseId);
        ResultSet rs = stmt.executeQuery();
        if(!rs.next()) throw new CourseNotFoundException(courseId);

        stmt = connection.prepareStatement(SQLQueryConstants.GET_STUDENT_QUERY);
        stmt.setString(1, studentId);
        rs = stmt.executeQuery();
        if(!rs.next()) throw new UserNotFoundException(studentId);
        try {
            stmt = connection.prepareStatement(SQLQueryConstants.ADD_GRADE);


            stmt.setString(1, grade);
            stmt.setString(2, courseId);
            stmt.setString(3, studentId);

            int row = stmt.executeUpdate();

            if(row==1)
                return true;
            else
                throw new GradeNotAddedException(studentId);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }


}
