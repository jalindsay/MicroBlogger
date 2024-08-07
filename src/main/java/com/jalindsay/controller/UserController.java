package com.jalindsay.controller;

import com.jalindsay.entity.User;
import com.jalindsay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> listAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("user/{id}")
    public User getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @PostMapping("user")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("user/{id}")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    // TODO: Implement return type for deleteUser (and also everything)
    @DeleteMapping("user/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }

}
