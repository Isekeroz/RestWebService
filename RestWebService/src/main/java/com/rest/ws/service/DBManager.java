package com.rest.ws.service;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import com.rest.ws.dto.User;

/**
 * 
 * @author ilgin.sekeroz
 *
 */
public class DBManager {

	private static MongoClient mongoClient;

	// Connected to the database
	public void connectDB() {
		try {
			mongoClient = new MongoClient("localhost", 27017);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Connected to database");
	}

	public DB getDatabase() {
		DB db = mongoClient.getDB("userDB");
		return db;
	}
	
	public void createCollection() {
		try {
			DB db = mongoClient.getDB("userDB");
			DBCollection contacts = db.createCollection("users", null);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Connect to database successfully");
		System.out.println("Collection created successfully");
	}

	// Search by name
	public void findByName(String name) {
		DB db = mongoClient.getDB("userDB");
		DBCollection coll = db.getCollection("users");

		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("name", name);
		DBCursor cursor = coll.find(whereQuery);
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}

	// It returns all collection
	public JSONArray getAllInformation() throws JSONException {
		DB db = mongoClient.getDB("userDB");
		DBCollection coll = db.getCollection("users");

		DBCursor cursor = coll.find();

		while (cursor.hasNext()) {
			int i = 1;
			System.out.println(cursor.next());
			i++;
		}
	    JSON json = new JSON();
	    String serialize = json.serialize(cursor);
	    JSONArray AllJson = new JSONArray(serialize);
	    return AllJson;
	}

	public void importCollection(List<User> list) {
		DB db = mongoClient.getDB("userDB");
		DBCollection coll = db.getCollection("users");

		for (User c : list) {
			BasicDBObject document = new BasicDBObject();
			document.put("name", c.getName());
			document.put("lastName", c.getLastName());
			List<String> phoneList = new ArrayList<String>();
			String tempPhone = "[";
			phoneList = c.getPhones();

			for (String p : phoneList) {
				if (tempPhone.equals("[")) {
					tempPhone = tempPhone + p;
				} else {
					tempPhone = tempPhone + "," + p;
				}
			}
			tempPhone = tempPhone + "]";
			document.put("phones", tempPhone);
			coll.insert(document);
		}
	}
}
