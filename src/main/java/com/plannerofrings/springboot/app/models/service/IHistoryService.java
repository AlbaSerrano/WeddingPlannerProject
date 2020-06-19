package com.plannerofrings.springboot.app.models.service;

import com.plannerofrings.springboot.app.models.entity.History;

public interface IHistoryService {

	public History findOne(Long id);
	
}
