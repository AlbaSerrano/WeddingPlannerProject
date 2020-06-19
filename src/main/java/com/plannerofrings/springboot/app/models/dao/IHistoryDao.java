package com.plannerofrings.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.plannerofrings.springboot.app.models.entity.History;

public interface IHistoryDao extends CrudRepository<History, Long>{

}
