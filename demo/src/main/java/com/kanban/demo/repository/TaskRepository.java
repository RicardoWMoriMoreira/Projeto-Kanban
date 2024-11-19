package com.kanban.demo.repository;

import com.kanban.demo.model.Task;
import com.kanban.demo.model.TaskCategory;
import com.kanban.demo.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus status);
    List<Task> findByCategory(TaskCategory category)    ;

}



