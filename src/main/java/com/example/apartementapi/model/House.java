package com.example.apartementapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class House implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_house;

    @ManyToOne
    private Category category;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    private City city;

    @Column(nullable = false)
    private String territory;

    @Min(1)
    private int rooms;

    private String description;

    @Column(nullable = false)
    private int price;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        vendu,
        libre
    }

    public enum Type {
        vente,
        location
    }
}
