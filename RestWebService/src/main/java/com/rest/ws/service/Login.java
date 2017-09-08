package com.rest.ws.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.ws.dto.User;

@Path("/Login")
public class Login {

	@POST
	@Path("/userControl")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public User checkUser(User u){
		u.setCheck(false);
		if(u.getName().equals("ilgin") && u.getPassword().equals("password")){
			u.setCheck(true);
		}
		return u;
	}
	
}
