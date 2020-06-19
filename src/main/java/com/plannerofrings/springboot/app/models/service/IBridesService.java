package com.plannerofrings.springboot.app.models.service;

import java.util.List;

import com.plannerofrings.springboot.app.models.entity.Brides;

public interface IBridesService {

	public List<Brides> findAll();

	public Brides findOne(Long id);

	public void save(Brides brides);

	public void delete(Long id);

}
