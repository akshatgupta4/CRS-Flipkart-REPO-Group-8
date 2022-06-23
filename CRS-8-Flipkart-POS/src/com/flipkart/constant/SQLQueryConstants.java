package com.flipkart.constant;

public class SQLQueryConstants {

    //admin dao
    public static final String ADD_COURSE_QUERY = "insert into coursecatalog values (?, ?, ?, ?, ?);";
    public static final String VIEW_COURSES_IN_CATALOG_QUERY = "select * from coursecatalog";
    public static final String ADD_PROFESSOR_QUERY = "insert into professor values (?, ?, ?);";
    public static final String ADD_USER_QUERY = "insert into user values (?, ?, ?, ?, ?, ?, ?);";
    public static final String VIEW_PROFESSORS_QUERY = "select professorId, name, designation from professor inner join user where professor.professorId = user.userId;";
    public static final String ASSIGN_COURSE_TO_PROF_QUERY = "update coursecatalog set professorId = ? where courseId = ?;";

    public static final String DELETE_COURSE_FROM_CATALOG_QUERY = "delete from coursecatalog where courseId = ?;";
}
