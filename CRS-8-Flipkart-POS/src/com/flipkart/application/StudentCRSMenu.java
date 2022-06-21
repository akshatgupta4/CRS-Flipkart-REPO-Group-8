/**
 *
 */
package com.crs.flipkart.application;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.AdminServiceInterface;
import com.crs.flipkart.business.NotificationService;
import com.crs.flipkart.business.NotificationServiceInterface;
import com.crs.flipkart.business.PaymentService;
import com.crs.flipkart.business.PaymentServiceInterface;
import com.crs.flipkart.business.StudentService;
import com.crs.flipkart.business.StudentServiceInterface;
import com.crs.flipkart.dao.PaymentDaoInterface;
import com.crs.flipkart.dao.PaymentDaoOperations;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constant.ModeOfPayment;
import com.flipkart.constant.NotificationType;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.NotificationInterface;
import com.flipkart.service.StudentImpl;
import com.flipkart.service.StudentInterface;

/**
 * @author harsh
 *
 */

public class StudentCRSMenu {

	
	public void studentLoggedin(String id) {
		
		CreateMenu();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your option");
		int option = sc.nextInt();
		while(option != 11) {
			switch (option) {
				case 1:
					StudentImpl.viewReportCard(id);
					break;
				case 2:
					StudentImpl.viewRegisteredCourses(id);
					break;
				 case 3:
					 notificationService.showNotifications(id);
					 break;
				case 4:
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
