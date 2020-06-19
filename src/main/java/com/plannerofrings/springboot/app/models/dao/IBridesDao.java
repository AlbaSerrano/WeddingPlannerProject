package com.plannerofrings.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.plannerofrings.springboot.app.models.entity.Brides;

public interface IBridesDao extends CrudRepository<Brides, Long> {
	
}
