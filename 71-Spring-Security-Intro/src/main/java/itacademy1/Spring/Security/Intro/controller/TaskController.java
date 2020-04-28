package itacademy1.Spring.Security.Intro.controller;

import itacademy1.Spring.Security.Intro.entity.Task;
import itacademy1.Spring.Security.Intro.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/api/check-user")
    public String helloUser(){
        return "Hello User";
    }

    @GetMapping("/api/check-admin")
    public String helloAdmin(){
        return "Hello Admin";
    }

    @GetMapping("/api/check-moder")
    public String helloModerator(){
        return "Hello Moderator";
    }

    @GetMapping
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable Long id) {
        Task task = taskService.getById(id);
        HttpHeaders headers = new HttpHeaders();

        if (task == null) {
            headers.add("Message", "Couldn't find task with id " + id);
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }
        headers.add("Message", "OK");
        return new ResponseEntity<>(task, headers, HttpStatus.OK);
    }

    @GetMapping("/title")
    public List<Task> searchByTitle(@RequestHeader String title) {
        return taskService.searchByTitle(title);
    }

    @GetMapping("/text")
    public List<Task> searchByText(@RequestHeader String text) {
        return taskService.searchByText(text);
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return taskService.create(task);
    }

    @PutMapping
    public Task update(@RequestBody Task task) {
        return taskService.update(task);
    }

    @DeleteMapping
    public Task deleteById(@RequestParam(name = "id") Long id) {
        return taskService.deleteById(id);
    }
}
