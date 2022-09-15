package com.example.apartementapi.service;

import com.example.apartementapi.model.CreateUser;
import com.example.apartementapi.model.House;
import com.example.apartementapi.model.Users;
import com.example.apartementapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users findUserByName(String userName) {
        return userRepository.findByUsername(userName);
    }

    public Users createUser(Users newUser) {
        return userRepository.save(newUser);
    }
}
