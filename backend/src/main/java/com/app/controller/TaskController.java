package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entity.Task;
import com.app.exception.TaskNotFoundException;
import com.app.repo.*;



@RestController
@CrossOrigin("http://localhost:3000")
public class TaskController {

	@Autowired
	private TaskRepository TaskRepo; 
	
	@PostMapping("/task")
	Task newUser(@RequestBody Task newTask) {
		System.out.println(newTask.toString());
		return TaskRepo.save(newTask);
	}
	
	@GetMapping("/taskdetails")
	List<Task> getalluser(){
		return TaskRepo.findAll();
	}
	@GetMapping("/task/{id}") 
	Task getUserbyId(@PathVariable Long id) {
		return TaskRepo.findById(id)
				.orElseThrow(()-> new TaskNotFoundException(id)); 
	}
	@PutMapping("/task/{id}")
	Task updateUser(@RequestBody Task newTask,@PathVariable Long id) {
		return TaskRepo.findById(id)
			    .map(task -> {
			    	task.setTitle(newTask.getTitle());
			    	task.setEndDate(newTask.getEndDate());
			    	task.setStatus(newTask.getStatus());
			    	 return TaskRepo.save(task);
			    }).orElseThrow(() -> new TaskNotFoundException(id));
	}
	@DeleteMapping("/task/{id}")
		String deleteUser(@PathVariable Long id) {
			if(!TaskRepo.existsById(id)) {
				throw new TaskNotFoundException(id);
			}
			TaskRepo.deleteById(id);
			return "Task with id "+id+" has been Deleted.";
		}
	}

