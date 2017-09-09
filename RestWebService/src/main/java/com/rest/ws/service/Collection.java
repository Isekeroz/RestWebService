package com.rest.ws.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.rest.ws.common.CsvParser;
import com.rest.ws.dto.User;
import com.rest.ws.service.DBManager;

public class Collection {
	static DBManager dbManager;
	public void createCollection(){
		String name;
		List<User> people = new ArrayList<User>();

		CsvParser csvParser = new CsvParser();

		System.out.println("Reading from CSV file using BufferedReader and String Split");
		try {
			people = csvParser.readCSV();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Parsing CSV file using CSVParser of Apache commons CSV");
		try {
			csvParser.parseCSV();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dbManager = new DBManager();
		dbManager.connectDB();

		dbManager.createCollection();
		dbManager.importCollection(people);

	}
}
