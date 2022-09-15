package com.example.apartementapi.mapper;

import com.example.apartementapi.model.CreateUser;
import com.example.apartementapi.model.House;
import com.example.apartementapi.model.Users;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserMapper {
    public Users toDomain(CreateUser createUser){
        Users newUser = new Users();
        List<House> list = new ArrayList<>();
        newUser.setUsername(createUser.getUsername());
        newUser.setPassword(createUser.getPassword());
        return newUser;
    }

}
