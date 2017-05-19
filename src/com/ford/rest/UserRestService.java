package com.ford.rest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ford.domain.User;
import com.ford.service.UserService;

@Path("/users")
public class UserRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getDefaultUserInJSON() {
        UserService userService = new UserService();
        return userService.getDefaultUser();
    }
    
    @POST
	@Path("/userService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
		System.out.println("CDSID-->"+user.getCdsid());
		System.out.println("Mobile Number-->"+user.getMobileNumber());
		System.out.println("Gender-->"+user.getGender());
		UserService userService = new UserService();
		userService.addUser(user);
    	return Response.status(200).entity(user).build();
	}
}