package com.flipkart.application;

import java.util.Scanner;


public class ProfessorCRSMenu {
    public void createMenu(String profId){
        Scanner sc=new Scanner(System.in);
        int input;
        while(CRSApplication.loggedIn){
            System.out.print("*****************************");
            System.out.print("**********Professor Menu*********");
            System.out.print("*****************************");
            System.out.print("1. View Courses");
            System.out.print("2. View Enrolled Students");
            System.out.print("3. Add grade");
            System.out.print("4. Logout");
            System.out.print("*****************************");
        }

        input=sc.nextInt();
        switch(input)
        {
            case 1:
                getCourses(profId);
                break;
            case 2:
                viewEnrolledStudents(profId);
                break;

            case 3:
                addGrade(profId);
                break;
            case 4:
                CRSApplication.loggedIn=false;
                return;
            default:
                System.out.print("***** Wrong Choice *****");
        }

    }

    public void viewEnrolledStudents(String profId)
    {

    }

    public void getCourses(String profId)
    {
    }

    public void addGrade(String profId)
    {

    }



}
