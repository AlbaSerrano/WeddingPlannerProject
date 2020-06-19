package com.plannerofrings.springboot.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plannerofrings.springboot.app.models.dao.IHistoryDao;
import com.plannerofrings.springboot.app.models.entity.History;

@Service
public class HistoryServiceImpl implements IHistoryService {

	@Autowired
	private IHistoryDao historyDao;

	@Override
	public History findOne(Long id) {

		return historyDao.findById(id).orElse(null);
	}

}
