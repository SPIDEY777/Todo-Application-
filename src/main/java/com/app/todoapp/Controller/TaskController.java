package com.app.todoapp.Controller;

import com.app.todoapp.Services.TaskService;
import com.app.todoapp.models.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class TaskController {

    final private TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;

    }
    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks  = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

}
