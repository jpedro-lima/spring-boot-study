package com.studyspring.study_spring_boot.unittests;

public class MockPerson {
	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String gender;

	public MockPerson() {}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }

	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }

	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }

	public String getGender() { return gender; }
	public void setGender(String gender) { this.gender = gender; }

	public void printAttributes() {
		System.out.println("Print MockPerson");
		System.out.println("ID: " + id);
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Address: " + address);
		System.out.println("Gender: " + gender);
	}
}
