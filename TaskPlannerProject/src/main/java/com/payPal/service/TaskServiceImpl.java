package com.payPal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payPal.model.Task;
import com.payPal.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	/**
	 * @Autowired : adding dependency of Repository layer inside the service layer 
	 */
	
	@Autowired
	private TaskRepository taskRepo;

	@Override
	public Task addTask(Task task) {
		return taskRepo.save(task);
	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task getTasksById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task updateTask(Integer id, Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTask(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
