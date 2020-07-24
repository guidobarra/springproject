package com.guba.springdemo.mvc;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class Customer {

	private String firstName;
	
	// the message will be show when an error occurs 
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
