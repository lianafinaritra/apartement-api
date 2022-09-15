package com.example.apartementapi.controller;


import com.example.apartementapi.mapper.UserMapper;
import com.example.apartementapi.model.Category;
import com.example.apartementapi.model.CreateUser;
import com.example.apartementapi.model.House;
import com.example.apartementapi.model.Users;
import com.example.apartementapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;


    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/username")
    public Users getUserByName(@RequestParam String userName) {
        return userService.findUserByName(userName);
    }

    @PostMapping("/users")
    public Users postUser(@RequestBody CreateUser newUser) {
        return userService.createUser(userMapper.toDomain(newUser));
    }
}
