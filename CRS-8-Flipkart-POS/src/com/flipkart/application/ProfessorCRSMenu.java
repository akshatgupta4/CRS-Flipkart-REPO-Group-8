package com.flipkart.application;

import com.flipkart.service.ProfessorImpl;
import com.flipkart.service.StudentImpl;
import com.flipkart.service.StudentImpl;

import java.util.Scanner;


public class ProfessorCRSMenu {

    public void professorLoggedin(String id) {
        CreateMenu();
        Scanner sc = new Scanner(System.in);
        ProfessorImpl professorImpl = new ProfessorImpl();
        System.out.println("Enter your option");
        int option = sc.nextInt();
        while (option != 11) {
            switch (option) {
                case 1:
                    professorImpl.getCourses(id);
                    break;
                case 2:
                    professorImpl.viewEnrolledStudents(id);
                    break;

                case 3:
                    professorImpl.addGrade(id);
                    break;
                case 4:
                    CRSApplication.loggedIn = false;
                    return;
                default:
                    System.out.print("***** Wrong Choice *****");
            }
            CreateMenu();
            System.out.println("\nEnter Your Choice");
            option = sc.nextInt();
        }
    }

        private void CreateMenu() {
            // TODO Auto-generated method stub
            System.out.println("1. View Courses");
            System.out.println("2. View Enrolled Students");
            System.out.println("3. Add Grade");
            System.out.println("4. Logout");

        }

}




