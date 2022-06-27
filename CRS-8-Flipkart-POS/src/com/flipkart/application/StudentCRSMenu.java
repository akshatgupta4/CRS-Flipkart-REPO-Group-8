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
import com.flipkart.exception.SeatNotAvailableException;
import com.flipkart.service.StudentImpl;
import com.flipkart.service.StudentInterface;


/**
 * @author harsh
 *
 */

public class StudentCRSMenu {

	
	public void studentLoggedin(String id) throws SQLException, SeatNotAvailableException {
		
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
					System.out.println("Enter CourseId");
					courseId= sc.next();
					studentImpl.addCourse(id, courseId);
					System.out.println("\n");
					break;
				case 4:
					System.out.println("Enter CourseId");
					courseId= sc.next();
					studentImpl.dropCourse(id, courseId);
					System.out.println("\n");
					break;
				case 5:
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
		System.out.println("3. Add Course");
		System.out.println("4. Drop Course");
		System.out.println("5. Pay Fees");

	}


	
	
}
