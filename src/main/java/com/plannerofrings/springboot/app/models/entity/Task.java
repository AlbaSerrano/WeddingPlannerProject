package com.plannerofrings.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*Task is an Entity what is mapped with the tasks table of the database*/
@Entity
@Table(name = "tasks")
public class Task implements Serializable {

	// Primary key
	@Id
	// Auto-increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// The task to do
	private String description;

	// The budget for each task
	private Double budget;

	// Empty constructor
	public Task() {

	}

	// Constructor using fields
	public Task(String description, Double budget) {
		this.description = description;
		this.budget = budget;
	}

	/*** GETTERS AND SETTERS METHODS ***/
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public Long getId() {
		return id;
	}

	// To String Method
	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", budget=" + budget + "]";
	}

	// Default Serial Version UID
	private static final long serialVersionUID = 1L;

}
