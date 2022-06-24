//package com.flipkart.dao;
//
//import com.flipkart.bean.Course;
//import com.flipkart.bean.EnrolledStudent;
//import com.flipkart.constant.SQLQueryConstants;
//import com.flipkart.service.ProfessorInterface;
//import com.flipkart.util.CRSDbConnection;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProfessorDaoOperation implements ProfessorInterface {
//
//    public static PreparedStatement  stmt = null;
//    private static ProfessorDaoOperation instance = null;
//
//    public static ProfessorDaoOperation getInstance(){
//        if(instance == null){
//            instance = new ProfessorDaoOperation();
//        }
//        return instance;
//    }
//    public boolean addGrade(String studentId) {
//        return false;
//    }
//
//    public List<EnrolledStudent> viewEnrolledStudents(String profId){
//
//        Connection connection=CRSDbConnection.getConnection();
//        List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
//        try {
//            PreparedStatement stmt = connection.prepareStatement(SQLQueryConstants.GET_ENROLLED_STUDENTS);
//            stmt.setString(1, profId);
//
//            ResultSet results = stmt.executeQuery();
//            while(results.next())
//            {
//                enrolledStudents.add(new EnrolledStudent(results.getString("courseId"),results.getString("Name"),results.getString("studentId")));
//            }
//        }
//        catch(SQLException se)
//        {
//            System.out.println(se.getMessage());
//        }
//        finally
//        {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        return enrolledStudents;
//    }
//
//    public List<Course> getCourses(String profId) {
//
//        return null;
//    }
//
//    public String getProfessorById(String profId)
//    {
//
//        return profId;
//    }
//}
