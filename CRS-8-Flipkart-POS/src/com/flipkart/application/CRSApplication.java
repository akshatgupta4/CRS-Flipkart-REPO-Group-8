package com.flipkart.application;

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
                        CRSApplication.loginUser();
                        break;
                    case 2:
                        // student registration
                        CRSApplication.registerStudent();
                        break;
                    case 3:
                        // update Password
                        CRSApplication.updatePassword();
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

    public static void registerStudent(){

    }
    public static void updatePassword(){

    }



}
