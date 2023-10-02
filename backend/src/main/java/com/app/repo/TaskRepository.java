package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entity.Task;

//JpaRepository Class is Extended which contains method such as (save(), findAll(), findbyID().
public interface TaskRepository extends JpaRepository<Task, Long>{

}
