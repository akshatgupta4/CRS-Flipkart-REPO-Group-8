package com.flipkart.application;

import com.flipkart.constant.NotificationType;
import com.flipkart.service.NotificationImpl;
import com.flipkart.service.StudentImpl;

import java.util.Scanner;
public class CRSApplication {
    static boolean loggedIn = false;


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


    public static void menu() {
        System.out.println("----------Welcome to Course Management System---------");
        System.out.println("1. Login");
        System.out.println("2. Student Registration");
        System.out.println("3. UpdatePassword");
        System.out.println("4. Exit");
        System.out.println("Enter user input");
    }

    public static void loginUser(){




    }

    public static void registerStudent() {

        Scanner sc = new Scanner(System.in);
        StudentImpl studentImpl = new StudentImpl();
        NotificationImpl notificationImpl = new NotificationImpl();
        String userId, name, password, address, country, branchName;
        int genderV, batch;
        try {
            //input all the student details
            System.out.println("---------------Student Registration-------------");
            System.out.println("Name:");
            name = sc.nextLine();
            System.out.println("Email:");
            userId = sc.next();
            System.out.println("Password:");
            password = sc.next();
            System.out.println("Branch:");
            branchName = sc.nextLine();
            System.out.println("Batch:");
            batch = sc.nextInt();
            sc.nextLine();
            System.out.println("Address:");
            address = sc.nextLine();
            System.out.println("Country");
            country = sc.next();

            int newStudentId = studentImpl.register(name, userId, password, branchName, batch, address, country);
            notificationImpl.sendNotification(NotificationType.REGISTRATION, newStudentId, null, 0);


        } catch (Exception e) {
            System.out.println("Something went wrong!  not registered. Please try again");
        }

    }
        public static void updatePassword() {


        }




}
