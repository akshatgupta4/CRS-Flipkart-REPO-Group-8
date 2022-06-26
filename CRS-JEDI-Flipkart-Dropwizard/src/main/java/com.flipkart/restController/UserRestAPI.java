package com.flipkart.restController;

import com.flipkart.bean.Student;
import com.flipkart.constant.Role;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.dao.UserDaoInterface;
import com.flipkart.dao.UserDaoOperation;
import com.flipkart.exception.UserNotFoundException;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;


@Path("/user")
public class UserRestAPI {
    StudentDaoInterface studentInterface = new StudentDaoOperation();
    UserDaoInterface userInterface = new UserDaoOperation();

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployees() {
        System.out.println("In get Employees");
        return Response.ok().entity("testing successful").build();
    }

    /**
     * @param userId:      userId of the user
     * @param newPassword: new password to be stored in db.
     * @return @return 201, if password is updated, else 500 in case of error
     */
    @GET
    @Path("/updatePassword")
    public Response updatePassword(
            @NotNull
            @QueryParam("userId") String userId,
            @NotNull
            @Size(min = 4, max = 20, message = "Password length should be between 4 and 20 characters")
            @QueryParam("newPassword") String newPassword) throws ValidationException {

        if (userInterface.updatePassword(userId, newPassword)) {
            return Response.status(201).entity("Password updated successfully! ").build();
        } else {
            return Response.status(500).entity("Something went wrong, please try again!").build();
        }

    }

    /**
     * @param userId
     * @param password
     * @return
     */

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verifyCredentials(
            @NotNull
            @QueryParam("userId") String userId,
            @NotNull
            @Size(min = 4, max = 20, message = "Password length should be between 4 and 20 characters")
            @QueryParam("password") String password) throws ValidationException {

        try {
            boolean loggedin = userInterface.verifyCredentials(userId, password);
            if (loggedin) {
                Role role = userInterface.getRole(userId);
//                String userRole = Role.getRole(role);
                Role userRole = role;

                switch (userRole) {

                    case STUDENT:
                        String studentId = userId;
                        boolean isApproved = studentInterface.isApproved(studentId);
                        if (!isApproved) {
                            return Response.status(200).entity("Login unsuccessful! Student " + userId + " has not been approved by the administration!").build();
                        }
                        break;

                }
                return Response.status(200).entity("Login successful").build();
            } else {
                return Response.status(500).entity("Invalid credentials!").build();
            }
        } catch (SQLException e) {
            return Response.status(500).entity(e.getMessage()).build();
        }

    }

    /**
     * @param userId
     * @return
     * @throws ValidationException
     */
    @GET
    @Path("/getRole")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRole(
            @NotNull
            @QueryParam("userId") String userId) throws ValidationException {

            Role role = userInterface.getRole(userId);
            System.out.println(role);
        if(true ){
            return Response.status(201).entity("Role is " + role ).build();
        }else{
            return Response.status(201).entity("Role fetching failed" ).build();
        }
    }

    /**
     * @param student
     * @return 201, if user is created, else 500 in case of error
     */
    @POST
    @Path("/studentRegistration")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(@Valid Student student) {

        try {
            studentInterface.register(student.getName(), student.getUserId(), student.getPassword(),student.getRole() ,student.getGender(), student.getBranch(), 1,student.getAddress(), student.getCountry());
        } catch (Exception ex) {
            return Response.status(500).entity("Something went wrong! Please try again.").build();
        }


        return Response.status(201).entity("Registration Successful for " + student.getUserId()).build();
    }


}