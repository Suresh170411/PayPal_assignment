package com.payPal.service;

import java.util.List;

import com.payPal.dto.CountType;
import com.payPal.exception.TaskException;
import com.payPal.model.Task;

public interface TaskService {

	public Task addTask(Task task);

	public List<Task> getAllTasks() throws TaskException;

	public Task getTasksById(Integer id) throws TaskException;

	public Task updateTask(Integer id, Task task) throws TaskException;

	public String deleteTask(Integer id) throws TaskException;

	public List<CountType> getPercentageByType();
}
