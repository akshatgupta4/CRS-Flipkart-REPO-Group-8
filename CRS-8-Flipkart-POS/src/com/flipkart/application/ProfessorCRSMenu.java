package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.dao.ProfessorDaoInterface;
import com.flipkart.service.ProfessorImpl;
import com.flipkart.service.StudentImpl;
import com.flipkart.service.StudentImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ProfessorCRSMenu {

    ProfessorImpl professorImpl = new ProfessorImpl();

    public void professorLoggedin(String profId) {
        CreateMenu();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your option");
        int option = sc.nextInt();
        while (option != 4) {
            switch(option)
            {
                case 1:
                    //view all the courses taught by the professor
                    getCourses(profId);
                    break;
                case 2:
                    //view all the enrolled students for the course
                    viewEnrolledStudents(profId);
                    break;

                case 3:
                    //add grade for a student
                    addGrade(profId);
                    break;
                case 4:
                    //logout from the system
                    CRSApplication.loggedIn=false;
                    return;
                default:
                    System.out.println("***** Wrong Choice *****");
            }
            CreateMenu();
            System.out.println("\nEnter Your Choice");
            option = sc.nextInt();
        }
    }
    /*
    Manin menu of the professor.
     */
        private void CreateMenu() {
            // TODO Auto-generated method stub
            System.out.println("1. View Courses");
            System.out.println("2. View Enrolled Students");
            System.out.println("3. Add Grade");
            System.out.println("4. Logout");

        }
    /*
    Method to get the desired course of the
    professor based on its UserId.
    @Params -> profId
     */
        public void getCourses(String profId){

            try
            {
                List<Course> enrolledCourses = professorImpl.getCourses(profId);
                System.out.println(String.format("%20s %20s %20s","COURSE CODE","COURSE NAME","No. of Students  enrolled" ));
                for(Course object : enrolledCourses){
                    System.out.println(String.format("%20s %20s %20s",object.getCourseCode(), object.getName(), 10- object.getVacantSeats()));
                }
            }
            catch (Exception e)
            {
                System.out.println("Something went wrong!"+e.getMessage());

            }

        }
        /*
        Method to view the enrolled students
        in all the courses of specific professor.
         */

    public void viewEnrolledStudents(String profId){try{
        List<EnrolledStudent> enrolledStudents = professorImpl.viewEnrolledStudents(profId);
        System.out.println(String.format("%20s %20s %20s","COURSE CODE","COURSE NAME","STUDENT ID" ));
        for(EnrolledStudent object : enrolledStudents){
            System.out.println(String.format("%20s %20s %20s",object.getCourseCode(), object.getName(),object.getStudentId()));
        }
    }
    catch (Exception e){
        System.out.println("Something went wrong!"+e.getMessage());
    }
    }

    /*
    Method to add the grade to the student
    by the professor.
     */

    public void  addGrade(String profId){
        Scanner sc=new Scanner(System.in);

        String studentId, courseId,grade;
        try
        {
            List<EnrolledStudent> enrolledStudents=  new ArrayList<EnrolledStudent>();
            enrolledStudents = professorImpl.viewEnrolledStudents(profId);
            System.out.println(String.format("%20s %20s %20s","COURSE CODE","COURSE NAME","Student ID" ));
            for(EnrolledStudent obj: enrolledStudents)
            {
                System.out.println(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getName(),obj.getStudentId()));
            }
            List<Course> coursesEnrolled=new ArrayList<Course>();
            coursesEnrolled	=professorImpl.getCourses(profId);
            System.out.println("----------------Add Grade--------------");
            System.out.println("Enter student id");
            studentId=sc.next();
            System.out.println("Enter course code");
            courseId=sc.next();
            System.out.println("Enter grade");
            grade=sc.next();
//            if(ProfessorValidator.isValidStudent(enrolledStudents, studentId) && ProfessorValidator.isValidCourse(coursesEnrolled, courseCode))
//            {
                professorImpl.addGrade(studentId, courseId, grade);
                System.out.println("Grade added successfully for "+studentId);
//            }
//            else
//            {
//                System.out.println("Invalid data entered, try again!");
//            }
        }
        catch(SQLException ex)
        {
            System.out.println("Grade not added, SQL exception occured "+ex);
        }
        catch(Exception ex)
        {
            System.out.println("Grade cannot be added for"+ex);

        }

    }


}




