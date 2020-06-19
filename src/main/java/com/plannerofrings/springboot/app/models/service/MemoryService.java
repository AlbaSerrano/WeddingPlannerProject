package com.plannerofrings.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plannerofrings.springboot.app.models.dao.IMemoryDao;
import com.plannerofrings.springboot.app.models.entity.Memory;

@Service
public class MemoryService {

	// Inyect the interface IMemoriesDao to access to the CRUD operations
	@Autowired
	private IMemoryDao memoryDao;

	/*
	 * Method to get all Memories that exist on the table memories of the database
	 * that are mapped by the Entity Memories
	 */
	public List<Memory> findAll() {
		return (List<Memory>) memoryDao.findAll();
	}

}
