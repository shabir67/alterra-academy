package com.Altera.task.controller;

import com.Altera.task.entity.User;
import com.Altera.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(path="/v1/users")
    public List<User> getAllUser() {
        return (List<User>) userService.findAll();
    }

    @GetMapping(path="/v1/users/{id}")
    public User getOneUser(@PathVariable("id") Integer id) {
        return userService.findOne(id);
    }

    @PostMapping(path = "/v1/users")
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping(path = "/v1/users")
    public User updateUser(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping(path = "/v1/users/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteOne(id);
        return "Deleted Successfully";
    }
}
