package com.payPal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payPal.exception.TaskException;
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
		List<Task> list = taskRepo.findAll();
		
		if (list.size() == 0) {
			throw new TaskException("No tasks added yet!");
		}else {
			return list;
		}
	}

	@Override
	public Task getTasksById(Integer id) {
		Optional<Task> opt = taskRepo.findById(id);
		if (opt.isEmpty()) {
			throw new TaskException("No task found with this id");
		}else {
			return opt.get();
		}
	}

	@Override
	public Task updateTask(Integer id, Task task) {
		Optional<Task> opt = taskRepo.findById(id);
		if (opt.isEmpty()) {
			throw new TaskException("No task found with this id");
		}else {
			opt.get().setTitle(task.getTitle());
			opt.get().setType(task.getType());
			opt.get().setDueDate(task.getDueDate());
			opt.get().setDescription(task.getDescription());
			
			return opt.get();
		}
	}

	@Override
	public String deleteTask(Integer id) {
		Optional<Task> opt = taskRepo.findById(id);
		if (opt.isEmpty()) {
			throw new TaskException("No task found with this id");
		}else {
			taskRepo.deleteById(id);
			return "Task deleted successfully !";
		}
	}
	
	
}
