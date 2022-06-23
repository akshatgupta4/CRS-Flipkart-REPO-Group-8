package com.flipkart.constant;

public class SQLQueryConstants {

    //admin dao
    public static final String ADD_COURSE_QUERY = "insert into coursecatalog values (?, ?, ?, ?, ?);";

    //professor dao
    public static final String GET_ENROLLED_STUDENTS="select studentId from studentcoursegrade inner join course on studentcoursegrade.courseId = course.courseID and profId=?";

    public static final String VIEW_COURSES_IN_CATALOG_QUERY = "select * from coursecatalog";
    //student operations
    public static final String VIEW_GRADE_QUERY= "select courseId, grade from studentcoursegrade where studentId = ? ;";
    public static final String VIEW_REGISTERED_COURSE_QUERY="select courseId from studentcoursegrade where studentId = ?;";
    public static final String IS_STUDENT_APPROVED="select isApproved from student where studentId = ?;";
    public static final String ADD_STUDENT_PAYMENT_QUERY="insert into payment values(?, ?, ?, ?, ?);";
    public static final String ADD_STUDENT_NOTIFCATION_QUERY="insert into notification values(?, ?, ?);";

    public static final String ADD_PROFESSOR_QUERY = "insert into professor values (?, ?, ?);";
    public static final String ADD_USER_QUERY = "insert into user values (?, ?, ?, ?, ?, ?, ?);";
    public static final String VIEW_PROFESSORS_QUERY = "select professorId, name, designation from professor inner join user where professor.professorId = user.userId;";
    public static final String ASSIGN_COURSE_TO_PROF_QUERY = "update coursecatalog set professorId = ? where courseId = ?;";

    public static final String DELETE_COURSE_FROM_CATALOG_QUERY = "delete from coursecatalog where courseId = ?;";
}
