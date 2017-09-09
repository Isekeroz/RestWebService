package com.rest.ws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import com.rest.ws.dto.User;

/**
 * 
 * @author ilgin.sekeroz
 *
 */
@Path("/UserService")
public class UserService {
	static DBManager dbManager;

	@GET
	@Path("/users")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List listUsers() throws JSONException {
		List userList = new ArrayList();

		dbManager = new DBManager();
		dbManager.connectDB();

//		Set<String> collectionNames = dbManager.getDatabase().getCollectionNames();
//		
//		for (final String collectionName : collectionNames) {
//			if ("users".equalsIgnoreCase(collectionName)) {
//				break;
//			} else {
//				Collection collection = new Collection();
//				collection.createCollection();
//			}
//		}

		Collection collection = new Collection();
		collection.createCollection();
		
		JSONArray jsonArray = (JSONArray) dbManager.getAllInformation();
		if (jsonArray != null) {
			int len = jsonArray.length();
			for (int i = 0; i < len; i++) {
				userList.add(jsonArray.get(i).toString());
			}
		}

		return userList;
	}
}
