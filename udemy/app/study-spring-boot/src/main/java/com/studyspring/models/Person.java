package com.studyspring.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long	id;

	@Column(name = "first_name", nullable = false, length = 80)
	private String	firstName;
	@Column(name = "last_name", nullable = false, length = 80)
	private String	lastName;
	@Column(nullable = false, length = 80)
	private String	address;
	@Column(nullable = false, length = 6)
	private String	gender;

	public Person() {}
	
	public Long	getId() { return id; }
    public void	setId(Long id) { this.id = id; }

    public String	getFirstName() { return firstName; }
    public void 	setFirstName(String firstName) { this.firstName = firstName; }

    public String	getLastName() { return lastName; }
    public void		setLastName(String lastName) { this.lastName = lastName; }

    public String	getAddress() { return address; }
    public void		setAddress(String address) { this.address = address; }

    public String	getGender() { return gender; }
    public void		setGender(String gender) { this.gender = gender; }

	public void printAttributes() {
		System.out.println("Print Person");
		System.out.println("ID: " + id);
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Address: " + address);
		System.out.println("Gender: " + gender);
	}
}
