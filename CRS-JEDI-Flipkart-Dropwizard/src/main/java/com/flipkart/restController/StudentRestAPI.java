package main.java.com.flipkart.restController;
import com.flipkart.bean.Course;
import com.flipkart.dao.ProfessorDaoInterface;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseLimitExceedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.SeatNotAvailableException;
import com.sun.istack.internal.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.ValidationException;
import javax.xml.ws.Response;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("/student")
public class StudentRestAPI {
	StudentDaoInterface registrationInterface = StudentDaoInterface.getInstance();


	@POST
	@Path("/registerCourses")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerCourses(List<String> courseList,
	                                @NotNull
	                                @QueryParam("studentId") String studentId)	throws ValidationException{


		try
		{
			List<Course> availableCourseList = registrationInterface.viewRegisteredCourses(studentId);
			Set<String> hash_set = new HashSet<String>();

			for(String courseCode:courseList) {
				registrationInterface.addCourse(courseCode, studentId);
				if(!hash_set.add(courseCode))
					return Response.status(500).entity("Duplicate value  : "+courseCode).build();
			}

		}
		catch (CourseLimitExceedException | SeatNotAvailableException | CourseNotFoundException | CourseAlreadyRegisteredException e)
		{
			return Response.status(500).entity(e.getMessage()).build();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (SeatNotAvailableException e) {
			throw new RuntimeException(e);
		}


		return Response.status(201).entity( "Registration Successful").build();
	}


	@PUT
	@Path("/addCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCourse(
			@NotNull
			@Size(min = 4 , max = 10, message = "Course Code length should be between 4 and 10 character")
			@QueryParam("courseCode") String courseCode,
			@NotNull
			@QueryParam("studentId") String studentId) throws ValidationException{


		try{
			registrationInterface.addCourse(courseCode, studentId);

			return Response.status(201).entity( "You have successfully added Course : " + courseCode).build();

		}
		catch (CourseLimitExceedException | SeatNotAvailableException | CourseNotFoundException |
		       CourseAlreadyRegisteredException | SQLException e)
		{
			return Response.status(500).entity(e.getMessage()).build();
		}


	}


	@DELETE
	@Path("/dropCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response dropCourse(
			@NotNull
			@Size(min = 4 , max = 10 , message = "Course Code length should be between 4 and 10 character")
			@QueryParam("courseCode") String courseCode,
			@NotNull
			@QueryParam("studentId") String studentId) throws ValidationException {


		try{

			registrationInterface.dropCourse(courseCode, studentId);
			return Response.status(201).entity( "You have successfully dropped Course : " + courseCode).build();
		}
		catch(CourseNotFoundException | SQLException e)
		{
			return Response.status(501).entity("Please try again later").build();
		}

	}

	@GET
	@Path("/viewRegisteredCourses")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> viewRegisteredCourse(
			@NotNull
			@QueryParam("studentId") String studentId) throws ValidationException, SQLException {

		return registrationInterface.viewRegisteredCourses(studentId);
	}

	@GET
	@Path("/viewGradeCard")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> viewGradeCard(
			@NotNull
			@QueryParam("studentId") String studentId) throws ValidationException, SQLException {


		return registrationInterface.viewGrades(studentId);


	}

	@POST
	@Path("/make_payment")
	@Produces(MediaType.APPLICATION_JSON)
	public Response make_payment(
			@NotNull
			@QueryParam("studentId") String studentId ,
			@NotNull
			@Min( value = 1)
			@Max( value = 3)
			@QueryParam("paymentMode") int paymentMode) throws ValidationException{

		if(registrationInterface.getRegistrationStatus(studentId) == false)
			return Response.status(200).entity("Student course registration is pending").build();

		double fee=registrationInterface.calculateFee(studentId);

		fee = registrationInterface.calculateFee(studentId);
		logger.info("Your total fee  = " + fee);
		ModeOfPayment mode = ModeOfPayment.getModeofPayment(paymentMode);


		Notification notify = registrationInterface.payFee(studentId, mode,fee);


		logger.info("Your Payment is successful");
		logger.info("Your transaction id : " + notify.getReferenceId());

		return Response.status(201).entity("Your total fee  = " + fee+"\n"+"Your Payment is successful\n"+"Your transaction id : " + notify.getReferenceId()).build();

	}



}
