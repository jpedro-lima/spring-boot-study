package com.studyspring.vo;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "firstName", "lastName", "address", "gender"})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long	key;

	private String	firstName;
	private String	lastName;
	private String	address;
	private String	gender;

	public PersonVO() {}
	
	public Long	getKey() { return key; }
    public void	setKey(Long key) { this.key = key; }

    public String	getFirstName() { return firstName; }
    public void 	setFirstName(String firstName) { this.firstName = firstName; }

    public String	getLastName() { return lastName; }
    public void		setLastName(String lastName) { this.lastName = lastName; }

    public String	getAddress() { return address; }
    public void		setAddress(String address) { this.address = address; }

    public String	getGender() { return gender; }
    public void		setGender(String gender) { this.gender = gender; }

    public void printAttributes() {
        System.out.println("Print PersonVO");
		System.out.println("ID: " + key);
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Address: " + address);
		System.out.println("Gender: " + gender);
	}
}
