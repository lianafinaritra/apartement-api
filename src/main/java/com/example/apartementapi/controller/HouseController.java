package com.example.apartementapi.controller;

import com.example.apartementapi.mapper.HouseMapper;
import com.example.apartementapi.model.Category;
import com.example.apartementapi.model.CreateHouse;
import com.example.apartementapi.model.House;
import com.example.apartementapi.model.Users;
import com.example.apartementapi.service.HouseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class HouseController {

    private final HouseService houseService;
    private final HouseMapper houseMapper;

    @GetMapping("/ping")
    public String test(){
        return "pong";
    }

    @GetMapping("/houses")
    public List<House> getHouses(
            @RequestParam(name = "pageNumber") int page,
            @RequestParam(name = "pageSize") int pageSize,
            @RequestParam String categoryName,
            @RequestParam String type,
            @RequestParam int minPrice,
            @RequestParam int maxPrice,
            @RequestParam String cityName
    ) {
        if (categoryName.equals("All") && !type.equals("All"))
            return houseService.getHouseWithCategoryAll(type, minPrice, maxPrice, cityName, page, pageSize);
        else if (!categoryName.equals("All") && type.equals("All")) {
            return houseService.getHouseWithTypeAll(categoryName, minPrice, maxPrice, cityName, page, pageSize);
        } else if (categoryName.equals("All") && type.equals("All")) {
            return houseService.getHouseWithTwoAll(minPrice, maxPrice, cityName, page, pageSize);
        } else
            return houseService.getHouseWithCriteria(categoryName, type, minPrice, maxPrice, cityName, page, pageSize);
    }

    @PostMapping("/houses")
    public List<House> postHouse(@RequestBody List<CreateHouse> createHouses) {
        return houseService.createHouses(createHouses.stream().map(houseMapper::toDomain).toList());
    }

    @PutMapping("/houses")
    public House putHouse(@RequestBody House house) {
        return houseService.updateHouse(house);
    }

    @PutMapping("/buy/houses")
    public House buyHouse(@RequestParam int id_house /*, @RequestBody Users users*/ ) {
        return houseService.buyHouse(id_house /*, users*/);
    };
}
