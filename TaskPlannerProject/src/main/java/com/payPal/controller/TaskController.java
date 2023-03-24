package com.payPal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payPal.dto.CountType;
import com.payPal.model.Task;
import com.payPal.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@PostMapping("/task")
	public ResponseEntity<Task> addTaskHandler(@RequestBody Task task){
		return new ResponseEntity<Task>(taskService.addTask(task),HttpStatus.CREATED);
	}
	
	@GetMapping("/tasks")
	public ResponseEntity<List<Task>> getAllTasksHandler(){
		return new ResponseEntity<List<Task>>(taskService.getAllTasks(),HttpStatus.OK);
	}
	
	@GetMapping("/task/{id}")
	public ResponseEntity<Task> getTaskByIdHandler(@PathVariable ("id") Integer id){
		return new ResponseEntity<Task>(taskService.getTasksById(id),HttpStatus.OK);
	}
	
	@PutMapping("/task/{id}")
	public ResponseEntity<Task> updateTaskHandler(@RequestBody Task task, @PathVariable ("id") Integer id){
		return new ResponseEntity<Task>(taskService.updateTask(id, task),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/task/{id}")
	public ResponseEntity<String> deleteTaskHandler(@PathVariable ("id") Integer id){
		return new ResponseEntity<String>(taskService.deleteTask(id),HttpStatus.OK);
	}
	
	@GetMapping("/task/data/percent")
	public ResponseEntity<List<CountType>> getTaskByTypePercentageHandler(){
		return new ResponseEntity<List<CountType>>(taskService.getPercentageByType(),HttpStatus.OK);
	}
}
