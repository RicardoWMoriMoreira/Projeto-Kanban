package com.kanban.demo.service;

import com.kanban.demo.model.Task;
import com.kanban.demo.model.TaskCategory;
import com.kanban.demo.model.TaskStatus;
import com.kanban.demo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(Long id, Task task) {
        task.setId(id);
        return taskRepository.findById(id)
                .map(existingTask -> taskRepository.save(task))
                .orElseThrow(() -> new RuntimeException("Task não encontrada: " + id));
    }

    public void deleteTask(Long id) {
        taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada: " + id));
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksByCategory(String category) {
        return taskRepository.findByCategory(TaskCategory.valueOf(category));
    }


    public List<Task> getTasksByStatus(String status) {
        try {
            TaskStatus taskStatus = TaskStatus.valueOf(status.toUpperCase());
            return taskRepository.findByStatus(taskStatus);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Status inválido: " + status);
        }
    }

}