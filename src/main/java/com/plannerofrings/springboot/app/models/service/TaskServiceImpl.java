package com.plannerofrings.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plannerofrings.springboot.app.models.dao.ITasksDao;
import com.plannerofrings.springboot.app.models.entity.Task;

/*@Service indicates that the class is a business layer bean that
acts as an intermediate between the repository and the controller */
@Service
public class TaskServiceImpl implements ITasksService {

	/*
	 * Inject the ITasksDao repository that implements the Crud respository
	 * interface
	 */
	@Autowired
	private ITasksDao taskDao;

	// Method to select all tasks and return a list with this tasks
	@Override
	public List<Task> findAllTasks() {

		return (List<Task>) taskDao.findAll();
	}

	// Method to create a new task and return the created task
	@Override
	public Task createTask(Task task) {
		// TODO Auto-generated method stub
		return taskDao.save(task);
	}

	// Method to delete a task with the id
	@Override
	public void deleteTasksById(Long id) {
		taskDao.deleteById(id);
	}

}
