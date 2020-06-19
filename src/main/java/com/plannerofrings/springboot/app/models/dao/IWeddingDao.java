package com.plannerofrings.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.plannerofrings.springboot.app.models.entity.Wedding;

public interface IWeddingDao extends CrudRepository<Wedding, Long> {

}
