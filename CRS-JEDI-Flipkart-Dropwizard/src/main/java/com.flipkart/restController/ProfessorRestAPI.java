package com.flipkart.restController;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.service.ProfessorImpl;
import com.flipkart.service.ProfessorInterface;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Path("/professor")
public class ProfessorRestAPI {
    ProfessorInterface professorInterface=  new ProfessorImpl();

    @GET
    @Path("/getEnrolledStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EnrolledStudent> viewEnrolledStudents(
            @NotNull
            
            @QueryParam("profId") String profId) throws SQLException {

        List<EnrolledStudent> students=new ArrayList<EnrolledStudent>();
        try
        {
            students=professorInterface.viewEnrolledStudents(profId);
        }
        catch(Exception ex)
        {
            return null;
        }
        return students;
    }

    @GET
    @Path("/getCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCourses(

            @NotNull
            @QueryParam("profId") String profId) throws SQLException	{

        List<Course> courses=new ArrayList<Course>();
        try
        {
            courses=professorInterface.getCourses(profId);
        }
        catch(Exception ex)
        {
            return null;
        }
        return courses;

    }

    @POST
    @Path("/addGrade")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGrade(
            @NotNull
            @QueryParam("studentId") String studentId,

            @NotNull
            @QueryParam("courseCode") String courseId,

            @NotNull
            @QueryParam("profId") String profId,

            @QueryParam("grade") String grade) throws ValidationException  	{

        try
        {
            List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
            enrolledStudents=professorInterface.viewEnrolledStudents(profId);
            List<Course> coursesEnrolled=new ArrayList<Course>();
            coursesEnrolled	=professorInterface.getCourses(profId);

            professorInterface.addGrade(studentId, courseId, grade);


        }
        catch(Exception ex)
        {
            return Response.status(500).entity( "Something went wrong, Please Try Again ! ").build();
        }
        return Response.status(200).entity( "Grade updated for student: "+studentId).build();

    }


}

