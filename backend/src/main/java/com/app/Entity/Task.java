package com.app.Entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

//Here a POJO class is created of the variable and @Entity Annotation is used to Create the table.
//It provide getters and setters of the variable and also extends the BaseEntity Class.
@Entity
@Table(name = "TaskManager")
public class Task extends BaseEntity{

	 @Column(name = "Title",length = 30)
	 private String Title;
	 @Column(name = "EndDate")
	 private LocalDate EndDate;
	 @Column(name = "Status",length = 30)
	 private String Status;
	
	 
	 public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public LocalDate getEndDate() {
		return EndDate;
	}
	public void setEndDate(LocalDate endDate) {
		EndDate = endDate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "Task [Title=" + Title + ", EndDate=" + EndDate + ", Status=" + Status + "]";
	}
	
	 	 
}
