package com.example.apartementapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CreateUser {
    private String username;

    private String password;
}
