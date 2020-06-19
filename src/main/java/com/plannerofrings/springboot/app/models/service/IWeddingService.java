package com.plannerofrings.springboot.app.models.service;

import com.plannerofrings.springboot.app.models.entity.Wedding;

public interface IWeddingService {

	public Wedding findOne(Long id);

}
