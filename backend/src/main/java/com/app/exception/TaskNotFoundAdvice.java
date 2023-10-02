package com.app.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
	//@ControllerAdvice : It's used in Spring to define a class that handles exceptions globally across all controllers
public class TaskNotFoundAdvice {
	
	@ResponseBody
	//@Response : Tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object
	@ExceptionHandler(TaskNotFoundException.class)
	//@ExceptionHandler : It's used in Spring Boot to handle specific exceptions and send custom responses to the client.
	@ResponseStatus(HttpStatus.NOT_FOUND)
	//@ResponseStatus : It's used to mark a method or exception class with a status code and reason that should be returned.
	public Map<String,String> exceptionHandler(TaskNotFoundException exception){
		
		Map<String,String> errorMap=new HashMap<>(); 
		errorMap.put("Error",exception.getMessage());
		
		return errorMap;
	}
}
