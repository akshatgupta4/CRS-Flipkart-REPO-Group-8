package com.flipkart.dao;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constant.SQLQueryConstants;
import com.flipkart.service.AdminImpl;
import com.flipkart.util.CRSDbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoOperation implements AdminDaoInterface {
    public static PreparedStatement stmt = null;
    private static AdminDaoOperation instance = null;

    public void deleteCourse(String courseCode, List<Course> courseList) {

    }

    ;

    public static AdminDaoOperation getInstance() {
        if (instance == null) {
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
        stmt.setString(1, course.getCourseCode());
        stmt.setNull(2, Types.NULL);
        stmt.setInt(3, fee);
        stmt.setString(4, course.getName());
        stmt.setInt(5, 10);
        try {
            stmt.executeUpdate();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } finally {
            connection.close();
        }


    }


    //    public List<Student> viewPendingAdmissions(){}
//
//    public void approveStudent(String studentId){}
//
    public void addProfessor(Professor professor) throws SQLException {
        Connection connection = CRSDbConnection.getConnection();
        stmt = connection.prepareStatement(SQLQueryConstants.ADD_USER_QUERY);

        stmt.setString(1, professor.getUserId());
        stmt.setInt(2, professor.getRole().getValue());
        stmt.setString(3, professor.getName());
        stmt.setString(4, professor.getPassword());
        stmt.setString(5, professor.getGender().toString());
        stmt.setString(6, professor.getAddress());
        stmt.setString(7, professor.getCountry());
        try {
            stmt.executeUpdate();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            return;
        }

        stmt = connection.prepareStatement(SQLQueryConstants.ADD_PROFESSOR_QUERY);
        stmt.setString(1, professor.getUserId());
        stmt.setString(2, professor.getDepartment());
        stmt.setString(3, professor.getDesignation());

        try {
            stmt.executeUpdate();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            return;
        }

        connection.close();


    };
//
    public void assignCourse(String courseCode, String professorId) throws SQLException {
        Connection connection = CRSDbConnection.getConnection();
        stmt = connection.prepareStatement(SQLQueryConstants.ASSIGN_COURSE_TO_PROF_QUERY);

        stmt.setString(1, professorId);
        stmt.setString(2, courseCode);
        try {
            stmt.executeUpdate();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            connection.close();
            return;
        }
    }
//
    public List<Course> viewCoursesInCatalog() throws SQLException {
//        sql = "SELECT id, name ,address, location FROM employee";
//        ResultSet rs = stmt.executeQuery(sql);

        Connection connection = CRSDbConnection.getConnection();
        stmt = connection.prepareStatement(SQLQueryConstants.VIEW_COURSES_IN_CATALOG_QUERY);
        ResultSet rs = stmt.executeQuery();

        //STEP 5: Extract data from result set
        List<Course> courseList = new ArrayList<Course>();
        while (rs.next()) {
            Course course = new Course();
            course.setCourseCode(rs.getString(1));
            course.setInstructorId(rs.getString(2));
            course.setCourseFee(rs.getInt(3));
            course.setName(rs.getString(4));
            course.setVacantSeats(rs.getInt(5));
            courseList.add(course);
        }

        connection.close();
        return courseList;

    }

    public List<Professor> viewProfessors() throws SQLException {
        Connection connection = CRSDbConnection.getConnection();
        stmt = connection.prepareStatement(SQLQueryConstants.VIEW_PROFESSORS_QUERY);
        ResultSet rs = stmt.executeQuery();

        //STEP 5: Extract data from result set
        List<Professor> profList = new ArrayList<Professor>();
        while (rs.next()) {
            Professor prof = new Professor();
            prof.setUserId(rs.getString(1));
            prof.setName(rs.getString(2));
            prof.setDesignation(rs.getString(3));

            profList.add(prof);
        }

        return profList;
    }
}
//
//