package com.flipkart.constant;

public class SQLQueryConstants {

    //admin dao
    public static final String ADD_COURSE_QUERY = "insert into coursecatalog values (?, ?, ?, ?, ?);";
    public static final String VIEW_COURSES_IN_CATALOG_QUERY = "select * from coursecatalog";

    public static final String PROF_GET_COURSES = "Select cc.courseId as cid, cc.courseName as cname,  count(*) as ns from coursecatalog as cc innerjoin studentcoursegrade as sag on cc.courseId = sag.courseId where cc.profId = ? group by courseId";
    public static final String PROF_GET_COURSE = "select * from course where professorId=?";
    public static final String GET_ENROLLED_STUDENTS="select course.courseId,course.name , sudentcoursegrade.studentId from coursecatalog as course inner join studentcoursegrade on course.courseId = studentcoursegrade.courseId where course.professorId = ? order by course.courseId";
    public static final String ADD_GRADE="update studentcoursegrade set grade=? where courseId=? and studentId=?";

}
