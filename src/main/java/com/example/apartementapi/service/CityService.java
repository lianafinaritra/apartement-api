package com.example.apartementapi.service;

import com.example.apartementapi.model.City;
import com.example.apartementapi.model.House;
import com.example.apartementapi.repository.CityRepository;
import com.example.apartementapi.repository.HouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CityService {
    private final HouseRepository houseRepository;

    private CityRepository cityRepository;

    public List<City> getAllCity() {
        return cityRepository.findAll();
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public String deleteCity(int id_city, String name) {
        City city = new City();
        city.setId_city(id_city);
        city.setName(name);
        List<House> list = houseRepository.findByCity(city);
        List<Integer> id = new ArrayList<>();
        for (House house: list) {
            id.add(house.getId_house());
        }
        houseRepository.deleteAllById(id);
        cityRepository.delete(city);
        return "Delete successful";
    }
}
