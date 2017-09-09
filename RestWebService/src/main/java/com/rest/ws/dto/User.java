package com.rest.ws.dto;

import java.util.List;

/**
 * 
 * @author ilgin.sekeroz
 *
 */
public class User {

	private String name;
	private String lastName;
	private List<String> phones;

	public User(String name, String lastName, List<String> phones) {
		this.name = name;
		this.lastName = lastName;
		this.phones = phones;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

}
