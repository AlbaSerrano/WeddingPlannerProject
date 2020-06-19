package com.plannerofrings.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plannerofrings.springboot.app.models.dao.IFamilyDao;
import com.plannerofrings.springboot.app.models.entity.Family;

@Service
public class FamilyService {

	//Inyect the interface IMemoriesDao to access to the CRUD operations
		@Autowired
		private IFamilyDao familyDao;
		
		//Method to get all Memories that exist on the table memories of the database that are mapped by the Entity Family
		public List<Family> findAll(){
			return (List<Family>) familyDao.findAll();
		}
}
