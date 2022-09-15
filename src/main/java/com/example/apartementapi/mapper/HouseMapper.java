package com.example.apartementapi.mapper;

import com.example.apartementapi.model.CreateHouse;
import com.example.apartementapi.model.House;
import com.example.apartementapi.repository.CategoryRepository;
import com.example.apartementapi.repository.CityRepository;
import com.example.apartementapi.repository.HouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static com.example.apartementapi.model.House.Status.libre;

@Component
@AllArgsConstructor
public class HouseMapper {
    private final CategoryRepository categoryRepository;
    private final CityRepository cityRepository;

    public House toDomain(CreateHouse createHouse) {
        House newHouse = new House();
        newHouse.setCategory(categoryRepository.findByName(createHouse.getCategoryName()));
        newHouse.setType(House.Type.valueOf(createHouse.getType()));
        newHouse.setCity(cityRepository.findByName(createHouse.getCityName()));
        newHouse.setTerritory(createHouse.getTerritory());
        newHouse.setRooms(createHouse.getRooms());
        newHouse.setDescription(createHouse.getDescription());
        newHouse.setPrice(createHouse.getPrice());
        newHouse.setPhone(createHouse.getPhone());
        newHouse.setStatus(libre);
        return newHouse;
    }
}
