package com.flipkart.application;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.Gender;
import com.flipkart.constant.NotificationType;
import com.flipkart.constant.Role;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.dao.UserDaoInterface;
import com.flipkart.dao.UserDaoOperation;
import com.flipkart.exception.CourseFoundException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.SeatNotAvailableException;
import com.flipkart.exception.StudentNotFoundForApprovalException;
import com.flipkart.service.*;
import java.util.Date;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

/**
 * Class containing methods for main menu
 */
public class CRSApplication {
    public static boolean loggedIn = false;
    public static UserDaoInterface userInterface = new UserDaoOperation();

    /*
    Main Menu Displays Here.
     */
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
//        System.out.println("hello hello...");
        menu();

        int userInput = sc.nextInt();

        try {
            while (userInput != 4) {
                switch (userInput) {
                    case 1:
                        // login
                        //Date currentDate = new Date();
                        //System.out.println("Current Date and Time: " + currentDate);
                        loginUser();
                        break;
                    case 2:
                        // student registration
                        registerStudent();
                        break;
                    case 3:
                        // update Password
                        updatePassword();
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
                menu();
                userInput = sc.nextInt();
            }
        }catch(Exception e) {
            System.out.println("ERROR OCCURED" + e.getMessage());
        }

    }


    /**
     * Method to display main menu
     */
    public static void menu() {
        System.out.println("----------Welcome to Course Management System---------");
        System.out.println("1. Login");
        System.out.println("2. Student Registration");
        System.out.println("3. UpdatePassword");
        System.out.println("4. Exit");
        System.out.println("Enter user input");
    }
    /*
    Method to login the user.
    -> Admin
    -> Student
    -> Professor
     */

    /**
     * Method to login the user.
     *     -> Admin
     *     -> Student
     *     -> Professor
     * @throws SQLException
     * @throws CourseFoundException
     */
    public static void loginUser() throws SQLException, CourseFoundException, GradeNotAddedException, SeatNotAvailableException, StudentNotFoundForApprovalException {
        Scanner sc=new Scanner(System.in);

        String userId,password;

            System.out.println("-----------------Login------------------");
            //Date currentDate = new Date();
            //System.out.println("Current Date and Time - Before Java 8 : " + currentDate);
            System.out.println("Email:");
            userId=sc.next();
            System.out.println("Password:");
            password=sc.next();
            loggedIn = userInterface.verifyCredentials(userId, password);


            if(loggedIn)
            {
                Date currentDate = new Date();
                System.out.println("Logged in at : " + currentDate);
                Role userRole=userInterface.getRole(userId);

//                Role userRole=Role.stringToName(role);
                switch(userRole)
                {
                    case ADMIN:
                        System.out.println(" Login Successful");
                        AdminCRSMenu adminMenu=new AdminCRSMenu();
                        adminMenu.displayMenu();
                        break;
                    case PROFESSOR:
                        System.out.println(" Login Successful");
                        ProfessorCRSMenu professorMenu=new ProfessorCRSMenu();
                        professorMenu.professorLoggedin(userId);

                        break;
                    case STUDENT:
                        StudentDaoInterface studentInterface = new StudentDaoOperation();
                        boolean isApproved=studentInterface.isApproved(userId);
                        if(isApproved)
                        {
                            System.out.println(" Login Successful");
                            StudentCRSMenu studentMenu=new StudentCRSMenu();
                            studentMenu.studentLoggedin(userId);
                        }
                        else
                        {
                            System.out.println("Failed to login, you have not been approved by the administration!");
                            loggedIn=false;
                        }
                        break;
                }


            }
            else
            {
                System.out.println("Invalid Credentials!");
            }

        }


    /**
     * Method to register the student on
     *     the portal.
     */
    public static void registerStudent() {

        Scanner sc = new Scanner(System.in);
        StudentDaoInterface studentImpl = new StudentDaoOperation();
        NotificationImpl notificationImpl = new NotificationImpl();
        String userId, name, password, address, country, branchName, gender;
        int genderV, batch;
        try {
            //input all the student details
            System.out.println("---------------Student Registration-------------");
            System.out.println("Name:");
            name = sc.next();
            System.out.println("Email:");
            userId = sc.next();
            System.out.println("Password:");
            password = sc.next();
            System.out.println("Gender: 1. Male | 2. Female | 3. Other");
            gender = sc.next();
            System.out.println("Branch:");
            branchName = sc.next();
            System.out.println("Batch(in numbers):");
            batch = sc.nextInt();
            sc.nextLine();
            System.out.println("Address:");
            address = sc.next();
            System.out.println("Country");
            country = sc.next();
            String newStudentId = studentImpl.register(name, userId, password, Role.STUDENT, Gender.getName(Integer.parseInt(gender)), branchName, batch, address, country);
            System.out.println(newStudentId);
//            notificationImpl.sendNotification(NotificationType.REGISTRATION, newStudentId, null, 0);


        } catch (Exception e) {
            System.out.println(e+"Something went wrong!  not registered. Please try again");
        }

    }

        public static void updatePassword() {
//            TODO

        }




}
