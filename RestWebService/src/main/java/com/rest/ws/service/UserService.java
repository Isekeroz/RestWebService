package com.rest.ws.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.ws.dto.User;

/**
 * 
 * @author ilgin.sekeroz
 *
 */
@Path("/UserService")
public class UserService {
	@GET
	@Path("/users")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List listUsers() {
		List userList = new ArrayList();

		User u1 = new User();
		u1.setId(1);
		u1.setName("Ilgin");
		u1.setPassword("xxx");
		u1.setCheck(true);

		User u2 = new User();
		u2.setId(2);
		u2.setName("Cameron");
		u2.setPassword("pass");
		u2.setCheck(true);

		User u3 = new User();
		u3.setId(3);
		u3.setName("Joe");
		u3.setPassword("password");
		u3.setCheck(true);

		userList.add(u1);
		userList.add(u2);
		userList.add(u3);

		return userList;
	}
}
