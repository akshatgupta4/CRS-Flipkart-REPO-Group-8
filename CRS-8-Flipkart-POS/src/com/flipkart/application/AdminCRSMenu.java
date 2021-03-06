package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.AdminDaoOperation;
import com.flipkart.exception.CourseFoundException;
import com.flipkart.service.AdminImpl;
import com.flipkart.service.AdminInterface;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Class containing methods for Admin menu
 */
public class AdminCRSMenu {
    AdminInterface adminObj = AdminImpl.getInstance();
//    AdminDaoInterface adminDaoObj = AdminDaoOperation.getInstance();
    Scanner scanner = new Scanner(System.in);

    /* Admin Menu*/


    /**
     * Method to display admin menu
     * @throws SQLException
     * @throws CourseFoundException
     */
    public void displayMenu() throws SQLException, CourseFoundException {
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
                try {
                    List<Course> courseList = adminObj.viewCoursesInCatalog();
                    for (Course course : courseList) {
                        System.out.print(course.getCourseCode() + " |   " + course.getName() + "\n");

                    }
                    break;
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                    break;
                }


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
//                CRSApplication.loggedin = false;
                return;

            default:
                System.out.println("***** Wrong Choice *****");
        }
    }
    }
    /* Method to add the courses
       in the database.
     */


    /**
     * Method to add course to catalog
     * @throws SQLException
     * @throws CourseFoundException
     */
    public void addCourseToCatalog() throws SQLException, CourseFoundException {

        scanner.nextLine();
        System.out.println("Enter Course Code:");
        String courseCode = scanner.nextLine();

        System.out.println("Enter Course Name:");
        String courseName = scanner.nextLine();

        Course course = new Course(courseCode, courseName);
        System.out.println(course.getName() + " " + course.getCourseCode());
//        adminObj.addCourse(course);
        try {
            adminObj.addCourse(course);
        }
        catch (CourseFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Method to approve the student by the admin.
     * @throws SQLException
     */
    public void approveStudent() throws SQLException {
        System.out.println("Enter Student's ID:");
        String studentUserId= scanner.next();
        adminObj.approveStudent(studentUserId);
    }


    /**
     * Method to add the Professor.
     * @throws SQLException
     */
    public void addProfessor() throws SQLException {
        Professor professor = new Professor();

//        System.out.println("Enter Professor Name:");
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

        System.out.println("Enter Gender:");
        String gender = scanner.next();
        professor.setGender(Gender.stringToGender(gender));

        System.out.println("Enter Address:");
        String address = scanner.next();
        professor.setAddress(address);

        System.out.println("Enter Country:");
        String country = scanner.next();
        professor.setCountry(country);

        professor.setRole(Role.getRole("Professor"));
//        System.out.println(professor.getUserId()) + " "  + " " + professor.getName() + " " + professor.getPassword() + " " + professor.getGender().toString());
        try {
            adminObj.addProfessor(professor);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * Method to assign the Course to Professor.
     * @throws SQLException
     */
    public void assignCourseToProfessor() throws SQLException {
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
            System.out.println(String.format("%20s | %20s | %20s", course.getCourseCode(), course.getName(), course.getInstructorId()));
        }

        System.out.println("Enter Course Code:");
        String courseCode = scanner.next();

        try {
            adminObj.assignCourse(courseCode, profId);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Method to view the Pending Admission of students to get them approved/rejected.
     * @throws SQLException
     */
    public void viewPendingAdmissions() throws SQLException {
        List<Student> pendingAdmissionsList = adminObj.viewPendingAdmissions();
        for(Student student: pendingAdmissionsList) {
            System.out.println(String.format("%20s | %20s ", student.getUserId(), student.getName()));
        }
    }


    /**
     * Method to delete the Course.
     * @throws SQLException
     */
    public void deleteCourse() throws SQLException {
        List<Course> courseList = adminObj.viewCoursesInCatalog();
        for(Course course: courseList) {
            System.out.println(String.format("%20s | %20s | %20s", course.getCourseCode(), course.getName(), course.getInstructorId()));
        }

        System.out.println("Enter Course Code for the course to be deleted:");
        String courseCode = scanner.next();
        try {
            adminObj.deleteCourse(courseCode);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
