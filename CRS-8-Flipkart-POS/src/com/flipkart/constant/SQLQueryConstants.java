package com.flipkart.constant;

public class SQLQueryConstants {

    //admin dao
    public static final String ADD_COURSE_QUERY = "insert into coursecatalog values (?, ?, ?, ?, ?);";
    public static final String VIEW_COURSES_IN_CATALOG_QUERY = "select * from coursecatalog";
}
