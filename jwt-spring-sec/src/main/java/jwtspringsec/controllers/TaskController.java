package jwtspringsec.controllers;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jwtspringsec.dao.TaskRepository;
import jwtspringsec.entities.Task;

@RestController
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping("/tasks")
	public List<Task> getTasks() {
		return taskRepository.findAll();
	}
	@PostMapping("/task")
	public Task saveTask(@RequestBody Task task) {
		return taskRepository.save(task);
	}
}
