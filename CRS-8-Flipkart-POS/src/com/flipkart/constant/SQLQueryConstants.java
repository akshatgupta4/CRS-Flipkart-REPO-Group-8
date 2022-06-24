package com.flipkart.constant;

public class SQLQueryConstants {

    //admin dao
    public static final String ADD_COURSE_QUERY = "insert into coursecatalog values (?, ?, ?, ?, ?);";
    public static final String VIEW_COURSES_IN_CATALOG_QUERY = "select * from coursecatalog";

    public static final String PROF_GET_COURSES = "Select cc.courseId as cid, cc.courseName as cname,  count(*) as ns from coursecatalog as cc innerjoin studentcoursegrade as sag on cc.courseId = sag.courseId where cc.profId = ? group by courseId";
    public static final String PROF_GET_COURSE = "select * from coursecatalog where professorId=?";
    public static final String GET_ENROLLED_STUDENTS="select course.courseId,course.name ,studentcoursegrade.studentId  from coursecatalog as course inner join studentcoursegrade on course.courseId = studentcoursegrade.courseId where course.professorId = ? order by course.courseId";
    public static final String ADD_GRADE="update studentcoursegrade set grade=? where courseId=? and studentId=?";

    public static final String GET_VACANT_SEATS_QUERY = "select vacantSeat from coursecatalog where courseId = ?;";
    public static final String GET_COURSE_QUERY = "select * from coursecatalog where courseId = ?;";
    public static final String GET_PROFESSOR_QUERY = "select * from professor where professorId = ?;";
    public static final String GET_STUDENT_QUERY = "select * from student where studentId = ?;";


    //student operations
    public static final String VIEW_GRADE_QUERY= "select courseId, grade from studentcoursegrade where studentId = ? ;";
    public static final String VIEW_REGISTERED_COURSE_QUERY="select courseId from studentcoursegrade where studentId = ?;";
    public static final String IS_STUDENT_APPROVED="select isApproved from student where studentId = ?;";
    public static final String ADD_STUDENT_PAYMENT_QUERY="insert into payment values(?, ?, ?, ?, ?);";
    public static final String ADD_STUDENT_NOTIFICATION_QUERY="insert into notification values(?, ?, ?);";
    public static final String DROP_COURSE_BY_STUDENT_QUERY="delete from studentcoursegrade where studentId=? and courseId=?;";

    public static final String ADD_COURSE_BY_STUDENT_QUERY="insert into studentcoursegrade values(?, ?, null);";
    public static final String DECREMENT_VACANT_SEATS_QUERY="update coursecatalog set vacantSeat=vacantSeat-1 where courseId = ?;";
    public static final String INCREMENT_VACANT_SEARS_QUERY="update coursecatalog set vacantSeat=vacantSeat+1 where courseId = ?;" ;


    public static final String ADD_PROFESSOR_QUERY = "insert into professor values (?, ?, ?);";
    public static final String ADD_USER_QUERY = "insert into user values (?, ?, ?, ?, ?, ?, ?);";
    public static final String ADD_STUDENT_QUERY = "insert into student values(?, ?, 0);";
    public static final String VIEW_PROFESSORS_QUERY = "select professorId, name, designation from professor inner join user where professor.professorId = user.userId;";
    public static final String ASSIGN_COURSE_TO_PROF_QUERY = "update coursecatalog set professorId = ? where courseId = ?;";

    public static final String DELETE_COURSE_FROM_CATALOG_QUERY = "delete from coursecatalog where courseId = ?;";
    public static final String GET_PROF_NAME = "select name from user where userId = ?";
    public static final String VIEW_PENDING_ADMISSIONS_QUERY = "select studentId, name from student inner join user where student.studentId = user.userId and student.isApproved = 0;";
    public static final String APPROVE_STUDENT_QUERY = "update student set isApproved = 1 where studentId = ?;";

    //user
    public static  final String VERIFY_CREDENTIALS_QUERY="select password from user where userId = ?;";
    public static  final String GET_ROLE_ID_QUERY="select roleId from user where userId = ?;";
    public static  final String GET_ROLE_NAME_QUERY="select name from role where roleid = ?;";

    public static final String SEND_NOTIFICATION_QUERY="insert into notification values (?, ?, ?);";
}
