package com.plannerofrings.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.plannerofrings.springboot.app.models.entity.Task;


public interface ITasksDao extends CrudRepository<Task, Long> {

}
