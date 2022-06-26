package com.flipkart.restController;


import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.constant.Role;
import com.flipkart.exception.CourseFoundException;
import com.flipkart.exception.CourseNotAssignedToProfessorException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorAlreadyExistsException;
import com.flipkart.service.AdminImpl;
import com.flipkart.service.AdminInterface;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

/**
 * Admin rest controller class
 */
@Path("/admin")
public class AdminRestAPI {
    AdminInterface adminOpObj = AdminImpl.getInstance();

    /**
     * Method to delete course from the catalog
     * @param courseCode
     * @return
     */
    @PUT
    @Path("/deleteCourse")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCourse(
            @QueryParam("courseCode") String courseCode) {
        try {
            adminOpObj.deleteCourse(courseCode);
            return Response.status(201).entity("Course with courseCode: " + courseCode + " deleted from catalog").build();
        }
        catch (CourseNotFoundException | SQLException e) {
            return Response.status(409).entity(e.getMessage()).build();
        }
    }

    /**
     * Method to add course to the catalog
     * @param course
     * @return
     */
    @POST
    @Path("/addCourse")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCourse(
            @Valid Course course) {
        try {
            adminOpObj.addCourse(course);
            return Response.status(201).entity("Course with courseCode: " + course.getCourseCode() + " added to catalog").build();
        } catch (CourseFoundException | SQLException e) {
            return Response.status(409).entity(e.getMessage()).build();
        }

    }

    /**
     * Method to view pending admissions
     * @return
     */
    @GET
    @Path("/viewPendingAdmissions")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewPendingAdmissions( ){
        try {
            return Response.status(200).entity(adminOpObj.viewPendingAdmissions()).build();
        } catch (Exception e) {
            return Response.status(409).entity(e.getMessage()).build();
        }

    }

    /**
     * Method to approve student
     * @param studentId
     * @return
     */
    @PUT
    @Path("/approveStudent")
    @Produces(MediaType.APPLICATION_JSON)
    public Response approveStudent(
            @NotNull
            @QueryParam("studentId") String studentId
    ) {
        try {
            adminOpObj.approveStudent(studentId);
            return Response.status(201).entity("Student with studentId: " + studentId + " approved").build();
        } catch (SQLException e) {
            return Response.status(409).entity(e.getMessage()).build();
        }
    }

    /**
     * Method to add professor to the platform
     * @param professor
     * @return
     */
    @POST
    @Path("/addProfessor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProfessor(
            @Valid Professor professor)  {
//        ProfessorImpl.profList.put(Integer.parseInt(professor.getUserId()), professor);
        try {
            professor.setRole(Role.getRole("Professor"));
            adminOpObj.addProfessor(professor);
            return Response.status(201).entity("Professor with professorId: " + professor.getUserId() + " added").build();
        } catch (ProfessorAlreadyExistsException | SQLException e) {
            return Response.status(409).entity(e.getMessage()).build();
        }
    }
//

    /**
     * Method to assign course to the professor
     * @param courseCode
     * @param professorId
     * @return
     */
    @POST
    @Path("/assignCourseToProfessor")
    @Produces(MediaType.APPLICATION_JSON)
    public Response assignCourse(
            @NotNull
            @QueryParam("courseCode") String courseCode,
            @NotNull
            @QueryParam("professorId") String professorId
    )  {
        try {
            adminOpObj.assignCourse(courseCode, professorId);
            return Response.status(201).entity("courseCode: " + courseCode + " assigned to professor: " + professorId).build();
        } catch (CourseNotAssignedToProfessorException | SQLException e) {
            return Response.status(409).entity(e.getMessage()).build();
        }

    }
//

    /**
     * Method to view courses in the catalog
     * @return
     * @throws SQLException
     */
    @GET
    @Path("/viewCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewCoursesInCatalog(

    ) throws SQLException {
        return adminOpObj.viewCoursesInCatalog();
    }

    /**
     * Method to view professors on the platform
     * @return
     * @throws SQLException
     */
//
    @GET
    @Path("/viewProfessors")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Professor> viewProfessors() throws SQLException {
        return adminOpObj.viewProfessors();
    }
}
