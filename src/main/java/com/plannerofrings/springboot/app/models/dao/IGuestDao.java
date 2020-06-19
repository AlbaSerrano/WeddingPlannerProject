package com.plannerofrings.springboot.app.models.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.plannerofrings.springboot.app.models.entity.Guest;

//Crud repository for the Entity 'Guest' with a primary key of long type
public interface IGuestDao extends CrudRepository<Guest, Long> {

	/*
	 * Query creation from method name to select the guests with birth date between
	 * the paremeter 1 and 2
	 */
	public List<Guest> findByBirthDateBetween(Date birthDate1, Date birthDate2);


}
