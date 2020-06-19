package com.plannerofrings.springboot.app.models.service;

import java.util.Date;
import java.util.List;

import com.plannerofrings.springboot.app.models.entity.Guest;

public interface IGuestService {

	// Method to list all guests
	public List<Guest> findallGuests();

	// Method to save a new guest
	public void saveGuest(Guest guest);

	// Method to find a guest by the id
	public Guest findGuest(Long id);

	// Method to delete a guest by the id
	public void deleteGuest(Long id);


	// Method to select the guests with birth date between the paremeter 1 and 2
	public List<Guest> findByBirthDateBetween(Date birthDate1, Date birthDate2);

}
