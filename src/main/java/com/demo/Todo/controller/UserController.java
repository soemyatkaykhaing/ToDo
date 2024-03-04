package com.demo.Todo.controller;

import com.demo.Todo.entity.User;
import com.demo.Todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    private User getCurrentUser(@RequestBody User user){
        System.out.println("GET user by username and password *****");
        return userService.getUser(user);
    }
    @GetMapping("/login/{username}/{password}")
    private boolean findUserByUsername(@PathVariable String username,@PathVariable String password){
        return userService.getUserByUsername(username,password);
    }
    @PostMapping("/createUser")
    private boolean addUser(@RequestBody User user){
        boolean user_exist = userService.findUserByUsername(user.getUsername());
        if(user_exist){
            System.out.println("CANT Create user");
            return false;
        }
        userService.saveUser(user);
        return true;
    }
}
