/**
 *
 */
package com.crs.flipkart.application;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;


import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constant.ModeOfPayment;
import com.flipkart.constant.NotificationType;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.NotificationInterface;
import com.flipkart.service.StudentInterface;

/**
 * @author harsh
 *
 */

public class StudentCRSMenu {
	NotificationInterface notificationService = new NotificationInterface() {
		@Override
		public int sendNotification(NotificationType type, int studentId, ModeOfPayment modeOfPayment, double amount) {
			return 0;
		}

		@Override
		public UUID getReferenceId(int notificationId) {
			return null;
		}
	};
//	PaymentServiceInterface paymentInterface = new PaymentService();
	AdminInterface adminInterface = new AdminInterface() {
	@Override
	public void deleteCourse(String courseCode, List<Course> courseList) {

	}

	@Override
	public void addCourse(Course course, List<Course> courseList) {

	}

	@Override
	public List<Student> viewPendingAdmissions() {
		return null;
	}


	@Override
	public void addProfessor(Professor professor) {

	}

	@Override
	public void assignCourse(String courseCode, String professorId) {

	}

	@Override
	public List<Course> viewCourses(int catalogId) {
		return null;
	}

	@Override
	public List<Professor> viewProfessors() {
		return null;
	}
};
	
	public void studentLoggedin(String id) {
		StudentInterface studentService = new StudentInterface() {
			@Override
			public void viewGrades(String studentID, String password) {

			}

			@Override
			public void register(String name, String studentID, String branch, String address, String password) {

			}

			@Override
			public void addCourse(String studentID, String CourseCode) {

			}

			@Override
			public void dropCourse(String studentID, String CourseCode) {

			}
		};
		
		CreateMenu();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your option");
		int option = sc.nextInt();
		while(option != 11) {
			switch (option) {
				case 1:
					studentService.register(id);
					break;
				case 2:
					studentService.viewReportCard(id);
					break;
				case 3:
					studentService.viewRegisteredCourses(id);
					break;
				 case 4:
					 notificationService.showNotifications(id);
					 break;
				case 5:
					paymentInterface.showMenu(id);
					break;
				default:
					System.out.println("Enter valid option");
			}
			CreateMenu();
            System.out.println("\nEnter Your Choice");
            option = sc.nextInt();
		}
	}

	private void CreateMenu() {
		// TODO Auto-generated method stub
		System.out.println("1. Registration");
		System.out.println("2. View Report Card");
		System.out.println("3. View Registered Courses");
		System.out.println("4. Show Notifications");
		System.out.println("5. Pay Fees");
		
	}
	
	
	
}
