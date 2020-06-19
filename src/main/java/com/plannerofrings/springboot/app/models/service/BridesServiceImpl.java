package com.plannerofrings.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plannerofrings.springboot.app.models.dao.IBridesDao;
import com.plannerofrings.springboot.app.models.entity.Brides;

@Service
public class BridesServiceImpl implements IBridesService {

	@Autowired
	private IBridesDao bridesDao;

	@Override
	@Transactional(readOnly = true)
	public Brides findOne(Long id) {
		return bridesDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Brides brides) {
		bridesDao.save(brides);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Brides> findAll() {
		return (List<Brides>) bridesDao.findAll();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		bridesDao.deleteById(id);
	}

}
