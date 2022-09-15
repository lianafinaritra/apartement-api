package com.example.apartementapi.controller;

import com.example.apartementapi.model.Category;
import com.example.apartementapi.model.City;
import com.example.apartementapi.model.House;
import com.example.apartementapi.repository.CityRepository;
import com.example.apartementapi.repository.HouseRepository;
import com.example.apartementapi.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class CityController {

    private CityService cityService;

    @GetMapping("/city")
    public List<City> getAllCity() {
        return cityService.getAllCity();
    }

    @PostMapping("/city")
    public City postCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @DeleteMapping("/city")
    public String deleteCity(@RequestParam int id_city, @RequestParam String name){
        return  cityService.deleteCity(id_city, name);
    }
}
