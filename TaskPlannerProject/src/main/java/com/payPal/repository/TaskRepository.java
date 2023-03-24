package com.payPal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payPal.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
