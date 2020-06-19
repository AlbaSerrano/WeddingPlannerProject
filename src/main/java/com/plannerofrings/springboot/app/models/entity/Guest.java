package com.plannerofrings.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

//Guest is an Entity what is mapped with the guests table of the database
@Entity
@Table(name = "guests")
public class Guest implements Serializable {

	// Primary key
	@Id
	// Autoincrement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	// Indicate to Spring that is a date
	@Temporal(TemporalType.DATE)
	// The name of the field on the table
	@Column(name = "birth_date")
	// Format date
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;

	private String email;

	private String attend;

	private String suggestion;

	// Empty constructor
	public Guest() {
	}

	// Constructor using fields
	public Guest(String name, Date birthDate, String email, String attend, String suggestion) {
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
		this.attend = attend;
		this.suggestion = suggestion;
	}

	/**** GETTERS AND SETTERS ****/

	public Long getId() {
		return id;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAttend() {
		return attend;
	}

	public void setAttend(String attend) {
		this.attend = attend;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	// Serial version UID
	private static final long serialVersionUID = 1L;

	// To String method
	@Override
	public String toString() {
		return "Guest [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", email=" + email + ", attend="
				+ attend + ", suggestion=" + suggestion + "]";
	}

}