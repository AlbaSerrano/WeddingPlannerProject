package com.plannerofrings.springboot.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plannerofrings.springboot.app.models.dao.IWeddingDao;
import com.plannerofrings.springboot.app.models.entity.Wedding;

@Service
public class WeddingServiceImpl implements IWeddingService {

	@Autowired
	private IWeddingDao weddingDao;

	@Override
	@Transactional(readOnly = true)
	public Wedding findOne(Long id) {
		return weddingDao.findById(id).orElse(null);
	}
}
