package com.app.exception;

public class TaskNotFoundException extends RuntimeException{

	//Here one Constructor is made which show the Exception "TaskNotFound".
	public TaskNotFoundException(Long id) {
		super("Task Not Found with id "+ id);
	}
}
