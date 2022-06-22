package com.flipkart.dao;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constant.SQLQueryConstants;
import com.flipkart.service.AdminImpl;
import com.flipkart.util.CRSDbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AdminDaoOperation implements AdminDaoInterface {
    public static PreparedStatement stmt = null;
    private static AdminDaoOperation instance = null;
    public void deleteCourse(String courseCode, List<Course> courseList){

    } ;

    public static AdminDaoOperation getInstance()
    {
        if(instance==null)
        {
            // This is a synchronized block, when multiple threads will access this instance
            instance = new AdminDaoOperation();
        }
        return instance;
    }

    public void addCourse(Course course) throws SQLException {
        Connection connection = CRSDbConnection.getConnection();
        stmt = connection.prepareStatement(SQLQueryConstants.ADD_COURSE_QUERY);

//        String name="Anand ";
//        String address="Bengaluru";
//        String location="india";
        //Bind values into the parameters.
//        stmt.setInt(1, id);  // This would set age
        int fee = 5000;
        stmt.setString(1,course.getCourseCode());
        stmt.setString(2,"Null");
        stmt.setInt(3,fee);
        stmt.setString(4,course.getName());
        stmt.setInt(5, 10);
        try {
            stmt.executeUpdate();
        }
        catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        finally {
            connection.close();
        }


    }


//    public List<Student> viewPendingAdmissions(){}
//
//    public void approveStudent(String studentId){}
//
//    public void addProfessor(Professor professor){};
//
//    public void assignCourse(String courseCode, String professorId){}
//
//    public List<Course> viewCoursesInCatalog(){}
//
//    public List<Professor> viewProfessors(){}
}
