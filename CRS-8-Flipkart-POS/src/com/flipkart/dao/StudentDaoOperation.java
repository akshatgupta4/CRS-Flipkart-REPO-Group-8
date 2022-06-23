package com.flipkart.dao;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.constant.SQLQueryConstants;
import com.flipkart.util.CRSDbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoOperation implements StudentDaoInterface{
    public static PreparedStatement stmt = null;
    private static StudentDaoOperation instance = null;
    public static StudentDaoOperation getInstance()
    {
        if(instance==null)
        {
            // This is a synchronized block, when multiple threads will access this instance
            instance = new StudentDaoOperation();
        }
        return instance;
    }
    public void viewGrades(String studentID) throws SQLException{
        Connection connection = CRSDbConnection.getConnection();
        stmt = connection.prepareStatement(SQLQueryConstants.VIEW_GRADE_QUERY);
        stmt.setString(1, studentID);
        try {
            ResultSet R = stmt.executeQuery();
            while(R.next())
            {
                String cid=R.getString("courseId");
                String grade=R.getString("grade");
                System.out.println("course id is "+cid+"grade is "+grade);
            }
        }
        catch (SQLException se)
        {
            System.out.println(se.getMessage());
        }
        finally {
            connection.close();
        }




    } ;

    public String register(String name, String studentID, String password, Role role, Gender gender, String branch, int batch, String address, String country){
        return "NULL";
    } ;


    public void addCourse(String studentID) throws SQLException {
        Connection connection = CRSDbConnection.getConnection();
         stmt = connection.prepareStatement(SQLQueryConstants.ADD_COURSE_QUERY);
        String cid="cs002";
        stmt.setString(1,studentID);
        stmt.setString(2,cid);
        stmt.setString(3,"NULL");
        try {
            stmt.executeUpdate();
        }
        catch (SQLException se)
        {
            System.out.println(se.getMessage());
        }
        finally {
            connection.close();
        }
    };
    public void dropCourse(String studentID) throws SQLException{
        Connection connection = CRSDbConnection.getConnection();
        stmt = connection.prepareStatement(SQLQueryConstants.VIEW_GRADE_QUERY);
        try {
            stmt.executeUpdate();
        }
        catch (SQLException se)
        {
            System.out.println(se.getMessage());
        }
        finally {
            connection.close();
        }
    };

    public void viewRegisteredCourses(String studentID) throws SQLException{
        Connection connection = CRSDbConnection.getConnection();
        stmt = connection.prepareStatement(SQLQueryConstants.VIEW_REGISTERED_COURSE_QUERY);
        stmt.setString(1, studentID);
        try {
            ResultSet R = stmt.executeQuery();
            while(R.next())
            {
                String cid=R.getString("courseId");

                System.out.println("course id is "+cid);
            }
        }
        catch (SQLException se)
        {
            System.out.println(se.getMessage());
        }
        finally {
            connection.close();
        }

    };
    public void payFees(String studentID) throws SQLException{
        Connection connection = CRSDbConnection.getConnection();
        stmt = connection.prepareStatement(SQLQueryConstants.ADD_STUDENT_PAYMENT_QUERY);
        String paymentId="p0101";
        int amount=5000;
        String mode="online";
        Boolean status=true;
        stmt.setString(1,paymentId);
        stmt.setString(2,studentID);
        stmt.setInt(3,amount);
        stmt.setString(4,mode);
        stmt.setBoolean(5,status);

        try {
            stmt.executeUpdate();
        }
        catch (SQLException se)
        {
            System.out.println(se.getMessage());
        }
        finally {
            connection.close();
        }
    };
    public void showNotifications(String studentID) throws SQLException{
        Connection connection = CRSDbConnection.getConnection();
        stmt = connection.prepareStatement(SQLQueryConstants.ADD_NOTIFICATION);
        String notificationId="n0101";

        String notificationMessage="done";

        stmt.setString(1,notificationId);
        stmt.setString(2,notificationMessage);
        stmt.setString(3,studentID);


        try {
            stmt.executeUpdate();
        }
        catch (SQLException se)
        {
            System.out.println(se.getMessage());
        }
        finally {
            connection.close();
        }
    };

    public boolean isApproved(String studentId) throws SQLException{

        Connection connection = CRSDbConnection.getConnection();
        stmt = connection.prepareStatement(SQLQueryConstants.IS_STUDENT_APPROVED);
        stmt.setString(1, studentId);
        boolean isApproved=false;
        try {

            ResultSet R = stmt.executeQuery();
            isApproved=R.getBoolean("isApproved");

        }
        catch (SQLException se)
        {
            System.out.println(se.getMessage());
        }
        finally {
            connection.close();
        }
        return  isApproved;
    }
}
