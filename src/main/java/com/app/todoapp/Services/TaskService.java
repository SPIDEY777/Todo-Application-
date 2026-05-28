package com.app.todoapp.Services;

import com.app.todoapp.models.Task;
import com.app.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public  void deleteTask(Long id) {
         taskRepository.deleteById(id);

    }

    public  void toggletask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Task  Id"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();

    }

    public void createTask(String title) {

        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }
}
