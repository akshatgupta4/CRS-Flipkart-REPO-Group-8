/**
 *
 */
package com.flipkart.application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.service.StudentImpl;


/**
 * @author harsh
 *
 */

public class StudentCRSMenu {

	
	public void studentLoggedin(String id) throws SQLException {
		
		CreateMenu();
		Scanner sc = new Scanner(System.in);
		StudentDaoInterface studentImpl = new StudentDaoOperation();
		System.out.println("Enter your option");
		int option = sc.nextInt();
		String courseId;
		while(option != 11) {
			switch (option) {
				case 1:
					studentImpl.viewGrades(id);
					break;
				case 2:
					studentImpl.viewRegisteredCourses(id);
					break;
				 case 3:
					 studentImpl.showNotifications(id);
					 break;
				case 4:
					courseId= sc.next();
					studentImpl.addCourse(id, courseId);
					break;
				case 5:
					courseId= sc.next();
					studentImpl.dropCourse(id, courseId);
					break;
				case 6:
					studentImpl.payFees(id);
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
		System.out.println("1. View Report Card");
		System.out.println("2. View Registered Courses");
		System.out.println("3. Show Notifications");
		System.out.println("4. Add Course");
		System.out.println("5. Drop Course");
		System.out.println("6. Pay Fees");

	}


	
	
}
