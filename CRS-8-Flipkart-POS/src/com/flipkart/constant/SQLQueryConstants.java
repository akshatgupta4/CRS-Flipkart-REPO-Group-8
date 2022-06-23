package com.flipkart.constant;

public class SQLQueryConstants {

    //admin dao
    public static final String ADD_COURSE_QUERY = "insert into coursecatalog values (?, ?, ?, ?, ?);";

    //professor dao
    public static final String GET_ENROLLED_STUDENTS="select studentId from studentcoursegrade inner join course on studentcoursegrade.courseId = course.courseID and profId=?";


}
