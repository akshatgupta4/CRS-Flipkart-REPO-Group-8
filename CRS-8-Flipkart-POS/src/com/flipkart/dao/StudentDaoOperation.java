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
        Connection connection = CRSDbConnection.getConnection();
        try{
            stmt=connection.prepareStatement(SQLQueryConstants.ADD_USER_QUERY);
            stmt.setString(1, studentID);
            stmt.setInt(2, role.getValue());
            stmt.setString(3, name);
            stmt.setString(4, password);
            stmt.setString(5, gender.toString());
            stmt.setString(6, address);
            stmt.setString(7, country);
            stmt.executeUpdate();
            stmt=connection.prepareStatement(SQLQueryConstants.ADD_STUDENT_QUERY);
            stmt.setString(1, studentID);
            stmt.setString(2, branch);
            stmt.executeUpdate();
            return "Done\n";
        }catch (SQLException se){
            System.out.println(se.getMessage());
        }
        return "Error";
    } ;


    public void addCourse(String studentID, String cid) throws SQLException {
        Connection connection = CRSDbConnection.getConnection();
        PreparedStatement checkStmt=connection.prepareStatement(SQLQueryConstants.GET_VACANT_SEATS_QUERY);
        checkStmt.setString(1, cid);
        try{
            ResultSet R= checkStmt.executeQuery();
            R.next();
            if(R.getInt("vacantSeat")>0){
                    stmt = connection.prepareStatement(SQLQueryConstants.ADD_COURSE_BY_STUDENT_QUERY);
                    stmt.setString(1,studentID);
                    stmt.setString(2,cid);
                    stmt.executeUpdate();
                    stmt = connection.prepareStatement(SQLQueryConstants.DECREMENT_VACANT_SEATS_QUERY);
                    stmt.setString(1, cid);
                    stmt.executeUpdate();
            }
            else{
                throw new SQLException();
            }
        }catch(SQLException se){
            System.out.println(se.getMessage());
        }finally {
            connection.close();
        }
    };
    public void dropCourse(String studentID, String courseCode) throws SQLException{
        Connection connection = CRSDbConnection.getConnection();
        try {
            stmt = connection.prepareStatement(SQLQueryConstants.DROP_COURSE_BY_STUDENT_QUERY);
            stmt.setString(1, studentID);
            stmt.setString(2, courseCode);
            stmt.executeUpdate();
            stmt = connection.prepareStatement(SQLQueryConstants.INCREMENT_VACANT_SEARS_QUERY);
            stmt.setString(1, courseCode);
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
        stmt = connection.prepareStatement(SQLQueryConstants.ADD_STUDENT_NOTIFICATION_QUERY);
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
            R.next();
            isApproved=R.getBoolean(1);

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
