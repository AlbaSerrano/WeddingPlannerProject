package com.plannerofrings.springboot.app.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.plannerofrings.springboot.app.models.entity.Task;
import com.plannerofrings.springboot.app.models.service.ITasksService;

/*The TasksController responds to user-launched events from
 *  the web that are mapped to the route "/presupuesto_boda" and and its descendant routes*/
@Controller
//The main route
@RequestMapping(value = "/presupuesto_boda")
public class TasksController {

	// Inject the service of the entity Task 
	@Autowired
	private ITasksService taskService;

	/*
	 * Method mapped by the route "/presupuesto_boda" to show the page and through
	 * the model we pass to the view the list of task and new Task to create
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String listTasks(ModelMap mp) throws ParseException {

		// Obtain all the tasks
		List<Task> tasks = taskService.findAllTasks();
		// Var double to store the total of the budge
		Double totalBudget = 0.0;
		// go through the list
		for (Task task : tasks) {
			// add each budget to the total of budget
			totalBudget += task.getBudget();
		}
		// pass to the view through model map a new task
		mp.addAttribute("task", new Task());
		// pass to the view through model map the list of tasks
		mp.addAttribute("tasks", tasks);
		// pass to the view through model map the total
		mp.addAttribute("total", totalBudget);
		// Return the view
		return "budget/tasks_list";
	}

	/*
	 * Method mapped by the route "/presupuesto_boda" to create a new task through
	 * the form of the view mapped to this route with the post type method
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String createTask(Task task, ModelMap mp) {
		/*
		 * If the user not assigned a budget because it's not necessary, set the budget
		 * with the value '0'
		 */
		if (task.getBudget() == null) {
			task.setBudget(0.0);
		}
		// Create the new task with the values ​​that the user has modified in the form
		taskService.createTask(task);
		// Pass the task to the view
		mp.put("task", task);
		// Redirect to the view again
		return "redirect:/presupuesto_boda";
	}

	/*
	 * Method mapped by the route "/presupuesto_boda/eliminar-tarea/{id}" to delete
	 * the task with the id that is passed in the route the form of the view mapped
	 * to this route with the post type method
	 * 
	 * @PathVariable indicates that the method parameter (id) should be bound to a
	 * URI template variable.
	 */
	@RequestMapping(value = "/eliminar-tarea/{id}")
	public String deleteTask(@PathVariable(value = "id") Long id) {
		// If the id exist
		if (id > 0) {
			// Delete the task with this id
			taskService.deleteTasksById(id);
		}
		// Redirect to the view again
		return "redirect:/presupuesto_boda";
	}
}
