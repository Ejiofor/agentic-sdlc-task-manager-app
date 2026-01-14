package com.joachimnwofor.agenticsdlcfundamental.task_manager_web_app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joachimnwofor.agenticsdlcfundamental.task_manager_web_app.models.Task;

/**
 * JPA repository for Task entities.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Example convenience finder
    List<Task> findByTitleContainingIgnoreCase(String title);
}
