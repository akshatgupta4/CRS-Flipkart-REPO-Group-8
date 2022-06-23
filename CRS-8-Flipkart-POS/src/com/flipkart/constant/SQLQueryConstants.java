package com.flipkart.constant;

public class SQLQueryConstants {

    //admin dao
    public static final String ADD_COURSE_QUERY = "insert into coursecatalog values (?, ?, ?, ?, ?);";
    public static final String VIEW_COURSES_IN_CATALOG_QUERY = "select * from coursecatalog";


    //student operations
    public static final String VIEW_GRADE_QUERY= "select courseId, grade from studentcoursegrade where studentId = ? ;";
    public static final String VIEW_REGISTERED_COURSE_QUERY="select courseId from studentcoursegrade where studentId = ?;";
    public static final String IS_STUDENT_APPROVED="select isApproved from student where studentId = ?;";
    public static final String ADD_STUDENT_PAYMENT_QUERY="insert into payment values(?, ?, ?, ?, ?);";

}
