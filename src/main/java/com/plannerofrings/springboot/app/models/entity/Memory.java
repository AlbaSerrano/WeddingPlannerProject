package com.plannerofrings.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*Entity to save the images and the content of text-card of the mansory gallery*/
@Entity
/* Name of the table on the database */
@Table(name = "memories")
public class Memory implements Serializable {

	// Primary key
	@Id
	// Auto-increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Image
	private String memory;

	private String title;

	private String description;

	// Empty constructor
	public Memory() {
	}

	// Constructor using fields
	public Memory(String memory, String title, String description) {
		this.memory = memory;
		this.title = title;
		this.description = description;
	}

	/*** GETTERS AND SETTERS ***/
	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// To String
	@Override
	public String toString() {
		return "Memories [id=" + id + ", memory=" + memory + ", title=" + title + ", description=" + description + "]";
	}

	// Default serial version UID
	private static final long serialVersionUID = 1L;

}
