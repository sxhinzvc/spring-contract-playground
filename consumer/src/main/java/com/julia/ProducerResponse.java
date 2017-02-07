package com.julia;

public class ProducerResponse {

	private String firstName;
	private String lastName;

	public ProducerResponse(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public ProducerResponse() {
	}

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
