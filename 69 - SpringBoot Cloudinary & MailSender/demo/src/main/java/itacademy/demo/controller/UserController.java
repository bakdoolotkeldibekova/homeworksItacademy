package itacademy.demo.controller;

import itacademy.demo.entity.User;
import itacademy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping("/{login}/{password}")
    public Boolean logIn(@PathVariable String login, @PathVariable String password){
        return userService.logIn(login, password);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @PutMapping
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @PatchMapping("/{id}")
    public Boolean dropPassword(@PathVariable Long id){
        return userService.dropPassword(id);
    }

}
