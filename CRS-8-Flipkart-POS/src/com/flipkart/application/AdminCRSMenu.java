package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constant.Role;
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


        int choice = scanner.nextInt();

        switch(choice) {
            case 1:
//                viewCoursesInCatalogue();
                List<Course> courseList = adminObj.viewCoursesInCatalog();
                for (Course course : courseList) {
                    System.out.println(course.getName());
                }
                break;

            case 2:
                addCourseToCatalog();
                break;

            case 3:
//                deleteCourse();
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
//                CRSApplication.loggedin = false;
                return;

            default:
                System.out.println("***** Wrong Choice *****");
        }
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

    public void deleteCourseFromCatalog(){}

    public void approveStudent() {
        System.out.println("Enter Student's ID:");
        int studentUserId= scanner.nextInt();
        adminObj.approveStudent(studentUserId);
    }

    public void addProfessor() {
        Professor professor = new Professor();

        System.out.println("Enter Professor Name:");
        System.out.println("Enter Professor Name:");
        String professorName = scanner.next();
        professor.setName(professorName);

        System.out.println("Enter Department:");
        String department = scanner.next();
        professor.setDepartment(department);

        System.out.println("Enter Designation:");
        String designation = scanner.next();
        professor.setDesignation(designation);

        System.out.println("Enter User Id:");
        String userId = scanner.next();
        professor.setUserId(userId);

        System.out.println("Enter Password:");
        String password = scanner.next();
        professor.setPassword(password);

        System.out.println("Enter Address:");
        String address = scanner.next();
        professor.setAddress(address);

        System.out.println("Enter Country:");
        String country = scanner.next();
        professor.setCountry(country);

        professor.setRole(Role.getRole("Professor"));
        adminObj.addProfessor(professor);
    }

    public void assignCourseToProfessor() {
        List<Professor> professorList = adminObj.viewProfessors();

        System.out.println(String.format("%20s | %20s | %20s ", "ProfessorId", "Name", "Designation"));
        for(Professor professor : professorList) {
            System.out.println(String.format("%20s | %20s | %20s ", professor.getUserId(), professor.getName(), professor.getDesignation()));
        }

        System.out.println("Enter Professor's User Id:");
        String profId = scanner.next();

        System.out.println("\n\n");

        List<Course> courseList = adminObj.viewCoursesInCatalog();
        for(Course course: courseList) {
            System.out.println(String.format("%20s | %20s | %20s ", course.getCourseCode(), course.getName()));
        }

        System.out.println("Enter Course Code:");
        String courseCode = scanner.next();

        adminObj.assignCourse(courseCode, profId);
    }

    public void viewPendingAdmissions() {
        List<Student> pendingAdmissionsList = adminObj.viewPendingAdmissions();
        for(Student student: pendingAdmissionsList) {
            System.out.println(String.format("%20s | %20s ", student.getUserId(), student.getName()));
        }
    }

}
