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


//This is the TaskController Class here various request method (such as post, get, put etc) get executed.
@RestController
//@RestController : It simply return the object of a class and the object data is directly written in HTTP response as JSON.
@CrossOrigin("http://localhost:3000")
//@CrossOrigin : It's used to establish a Connection between Frontend and Backend.	
	
public class TaskController {

	//@AutoWired : It's used to automatically wire dependencies into a spring bean.
	@Autowired
	private TaskRepository TaskRepo; 

	//@PostMapping : It's used to get the Post request Map to this method.
	@PostMapping("/task")
	Task newUser(@RequestBody Task newTask) {
		System.out.println(newTask.toString());
		return TaskRepo.save(newTask);
		//save() is JPA Repo Method which is used to save the details.
	}

	//@GetMapping : It's used to get the Get request Map to this method.
	@GetMapping("/taskdetails")
	List<Task> getalluser(){
		return TaskRepo.findAll();
		//findAll() is JPA Repo Method which is used to find the details.
	}
	@GetMapping("/task/{id}") 
	Task getUserbyId(@PathVariable Long id) {
		return TaskRepo.findById(id)
				.orElseThrow(()-> new TaskNotFoundException(id)); 
		//findById() is JPA Repo Method which is used to find the details by ID.
	}
	//@PutMapping : It's used to update the task.
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
	//@DeleteMapping : It's used to Delete the task.
	@DeleteMapping("/task/{id}")
		String deleteUser(@PathVariable Long id) {
			if(!TaskRepo.existsById(id)) {
				throw new TaskNotFoundException(id);
			}
			TaskRepo.deleteById(id);
			return "Task with id "+id+" has been Deleted.";
			//deleteById() is JPA Repo Method which is used to delete the details by ID.
		}
	}

