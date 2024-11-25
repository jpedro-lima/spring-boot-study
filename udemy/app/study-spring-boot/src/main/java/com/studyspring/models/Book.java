
package com.studyspring.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "author", length = 180)
	private String author;

	@Column(name = "launch_date", nullable = false)
	private Date launchDate;

	@Column(name = "price")
	private Double price;

	@Column(name = "title", length = 180)
	private String title;

	public Book() {}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }

	public Date getLaunchDate() { return launchDate; }
	public void setLaunchDate(Date launchDate) { this.launchDate = launchDate; }

	public Double getPrice() { return price; }
	public void setPrice(Double price) { this.price = price; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public void printAttributes() {
		System.out.println("Print Book");
		System.out.println("ID: " + id);
		System.out.println("Author: " + author);
		System.out.println("Launch Date: " + launchDate);
		System.out.println("Price: " + price);
		System.out.println("Title: " + title);
	}
}