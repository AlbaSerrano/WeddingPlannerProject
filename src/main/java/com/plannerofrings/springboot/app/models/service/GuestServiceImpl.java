package com.plannerofrings.springboot.app.models.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plannerofrings.springboot.app.models.dao.IGuestDao;
import com.plannerofrings.springboot.app.models.entity.Guest;

@Service
public class GuestServiceImpl implements IGuestService {

	// Inyect the Interface IGuestDao to acces to crud operations
	@Autowired
	private IGuestDao guestDao;

	// Method to list all guests
	@Override
	public List<Guest> findallGuests() {
		// Have to cast to (List<Guest>) because the mehod findAll return an iterable
		return (List<Guest>) guestDao.findAll();
	}

	// Method to save a new guest
	@Override
	public void saveGuest(Guest guest) {
		guestDao.save(guest);
	}

	// Method to find a guest by the id
	@Override
	public Guest findGuest(Long id) {
		/*
		 * The method findById return an optional and allow return other object if the
		 * id doesn't exist
		 */
		return guestDao.findById(id).orElse(null);
	}

	// Method to delete a guest by the id
	@Override
	public void deleteGuest(Long id) {
		guestDao.deleteById(id);
	}


	// Method to select the guests with birth date between the paremeter 1 and 2
	@Override
	public List<Guest> findByBirthDateBetween(Date birthDate1, Date birthDate2) {

		return guestDao.findByBirthDateBetween(birthDate1, birthDate2);
	}


}
