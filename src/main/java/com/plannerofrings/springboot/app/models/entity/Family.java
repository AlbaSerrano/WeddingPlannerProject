package com.plannerofrings.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*Entity to save the image and data of the family to show in the index page*/
@Entity
//Name of the table in the database
@Table(name = "family")
public class Family implements Serializable {

	//Primary key
	@Id
	// Auto-increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "profile_photo")
	private String profilePhoto;

	private String name;

	private String relationship;

	// Empty constructor
	public Family() {
	}

	// Constructor using fields
	public Family(String profilePhoto, String name, String relationship) {
		this.profilePhoto = profilePhoto;
		this.name = name;
		this.relationship = relationship;
	}

	/**** GETTERS AND SETTERS ****/
	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	// To String
	@Override
	public String toString() {
		return "Family [id=" + id + ", profilePhoto=" + profilePhoto + ", name=" + name + ", relationship="
				+ relationship + "]";
	}

	// Default serial version UID
	private static final long serialVersionUID = 1L;

}
