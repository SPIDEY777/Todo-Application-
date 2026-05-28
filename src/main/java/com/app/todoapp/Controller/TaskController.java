package com.app.todoapp.Controller;

import com.app.todoapp.Services.TaskService;
import com.app.todoapp.models.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
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

    @PostMapping
    public String createTasks(@RequestParam String title){
         taskService.createTask(title);
         return "redirect:/";


    }

    @GetMapping("/{id}/delete")
    public String  deleteTask(Path path, @PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String  toggleTask(Path path, @PathVariable Long id){
        taskService.toggletask(id);
        return "redirect:/";
    }

}
