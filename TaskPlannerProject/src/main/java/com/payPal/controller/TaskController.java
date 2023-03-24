package com.payPal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
