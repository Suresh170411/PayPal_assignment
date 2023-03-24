package com.payPal.service;

import java.util.List;

import com.payPal.model.Task;

public interface TaskService {

	public Task addTask(Task task);
	public List<Task> getAllTasks();
	public Task getTasksById(Integer id);
	public Task updateTask(Integer id, Task task);
	public String deleteTask(Integer id);
}
