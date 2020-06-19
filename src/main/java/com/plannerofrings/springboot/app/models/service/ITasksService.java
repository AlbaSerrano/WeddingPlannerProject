package com.plannerofrings.springboot.app.models.service;

import java.util.List;

import com.plannerofrings.springboot.app.models.entity.Task;

/*interface that containing the header of the methods implemented by the service TaskServiceImpl*/
public interface ITasksService {
	// Method to select all tasks and return a list with this tasks
	public List<Task> findAllTasks();

	// Method to create a new task and return the created task
	public Task createTask(Task task);

	// Method to delete a task with the id
	public void deleteTasksById(Long id);
}
