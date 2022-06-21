package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.service.AdminImpl;
import com.flipkart.service.AdminInterface;

import java.util.List;
import java.util.Scanner;

public class AdminCRSMenu {
    AdminInterface adminObj = AdminImpl.getInstance();
    Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        while(true) {
            System.out.println("**********Admin Menu*********");
            System.out.println("*****************************");
            System.out.println("*****************************");
            System.out.println("1. View course in catalog");
            System.out.println("2. Add Course to catalog");
            System.out.println("3. Delete Course from catalog");
            System.out.println("4. Approve Students");
            System.out.println("5. View Pending Admission");
            System.out.println("6. Add Professor");
            System.out.println("7. Assign Courses To Professor");
            System.out.println("8. Logout");
            System.out.println("*****************************");
        }

        int choice = scanner.nextInt();

        switch(choice) {
            case 1:
//                viewCoursesInCatalogue();
                List<Course> courseList = adminObj.viewCoursesInCatalog();
                for(Course course: courseList) {
                    System.out.println(course.getName());
                }
                break;

            case 2:
                addCourseToCatalog();
                break;

            case 3:
                deleteCourse();
                break;

            case 4:
                approveStudent();
                break;

            case 5:
                viewPendingAdmissions();
                break;

            case 6:
                addProfessor();
                break;

            case 7:
                assignCourseToProfessor();
                break;

            case 8:
                CRSApplication.loggedin = false;
                return;

            default:
                System.out.println("***** Wrong Choice *****");
        }
    }

    public void addCourseToCatalog() {

        scanner.nextLine();
        System.out.println("Enter Course Code:");
        String courseCode = scanner.nextLine();

        System.out.println("Enter Course Name:");
        String courseName = scanner.nextLine();

        Course course = new Course(courseCode, courseName);

        adminObj.addCourse(course);
    }

}