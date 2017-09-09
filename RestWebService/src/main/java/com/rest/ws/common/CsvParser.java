package com.rest.ws.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import com.rest.ws.dto.User;

/**
 * 
 * @author ilgin.sekeroz
 *
 */
public class CsvParser {

	static List<User> users;
	private static Boolean control = true;

	public List<User> readCSV() throws FileNotFoundException, IOException {
		users = new ArrayList<User>();
		control = true;
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/Asus/workspace/RestWebService/src/main/resources/users.csv"));
		String line = br.readLine();
		while ((line = br.readLine()) != null && !line.isEmpty()) {
			String[] fields = line.split(",");
			String name = fields[0];
			String lastName = fields[1];
			List<String> phones = new ArrayList<String>();
			String phone = fields[2];
			phones.add(phone);

			for (User con : users) {
				if (con.getName().equals(name)) {
					con.getPhones().add(phone);
					control = false;
				}
			}
			if (control) {
				User person = new User(name, lastName, phones);
				users.add(person);
			}
		}
		br.close();
		return users;
	}

	public void parseCSV() throws FileNotFoundException, IOException {
		CSVParser parser = new CSVParser(new FileReader("C:/Users/Asus/workspace/RestWebService/src/main/resources/users.csv"),
				CSVFormat.DEFAULT.withHeader());
		parser.close();
	}

}
