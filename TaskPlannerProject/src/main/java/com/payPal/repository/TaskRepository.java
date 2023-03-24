package com.payPal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.payPal.dto.CountType;
import com.payPal.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
	
	@Query(value = "Select new com.payPal.dto.CountType (COUNT(*)/(Select COUNT(*) from Task)*100 ,type) from Task GROUP BY type")
	public List<CountType> getTasksByType();
}
