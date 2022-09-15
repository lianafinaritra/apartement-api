package com.example.apartementapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CreateHouse {

    private String categoryName;

    private String type;

    private String cityName;

    @Column(nullable = false)
    private String territory;

    @Min(0)
    private int rooms;

    private String description;

    @Column(nullable = false)
    private int price;

    @Pattern(regexp = "^[0-9]", message = "length must be 10")
    private String phone;

}
