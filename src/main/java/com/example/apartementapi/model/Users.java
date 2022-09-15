package com.example.apartementapi.model;

import com.example.apartementapi.security.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;

    private String username;

    private String password;

    @Column(columnDefinition = "boolean default true")
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Role role;
}
