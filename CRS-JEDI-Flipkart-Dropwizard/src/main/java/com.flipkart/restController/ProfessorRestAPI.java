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
    /**
     * Method to view enrolled studet a professor is teaching
     * @param profId
     * @return
     */
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
    
    /**
     * Method to view list of courses a professor is teaching
     * @param profId
     * @throws SQLException
     * @return
     */

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
    
    /**
     * Method to add grade of course of student
     * @param profId
     * @param studentId
     * @param courseId
     * @throws SQLException
     */

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
            return Response.status(500).entity( ex.getMessage()).build();
        }
        return Response.status(200).entity( "Grade updated for student: "+studentId).build();

    }


}

