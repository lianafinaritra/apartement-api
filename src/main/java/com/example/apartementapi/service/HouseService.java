package com.example.apartementapi.service;

import com.example.apartementapi.model.CreateHouse;
import com.example.apartementapi.model.History;
import com.example.apartementapi.model.House;
import com.example.apartementapi.model.Users;
import com.example.apartementapi.repository.CategoryRepository;
import com.example.apartementapi.repository.CityRepository;
import com.example.apartementapi.repository.HistoryRepository;
import com.example.apartementapi.repository.HouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

import static com.example.apartementapi.model.House.Status.*;

@Service
@AllArgsConstructor
public class HouseService {
    private final HouseRepository houseRepository;
    private final HistoryRepository historyRepository;

    public List<House> getHouseWithCategoryAll(String type, int minPrice, int maxPrice, String cityName, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return houseRepository.getHouseWithOnlyCategoryAll(House.Type.valueOf(type), minPrice, maxPrice, cityName, pageable);
    }

    public List<House> getHouseWithTypeAll(String categoryName, int minPrice, int maxPrice, String cityName, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return houseRepository.getHouseWithOnlyTypeAll(categoryName, minPrice, maxPrice, cityName, pageable);
    }

    public List<House> getHouseWithTwoAll(int minPrice, int maxPrice, String cityName, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return houseRepository.getHouseWithCategoryAndTypeAll(minPrice, maxPrice, cityName, pageable);
    }

    public List<House> getHouseWithCriteria(String categoryName, String type, int minPrice, int maxPrice, String cityName, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return houseRepository.getHouseWithAllCriteria(categoryName, House.Type.valueOf(type), minPrice, maxPrice, cityName, pageable);
    }

    public List<House> createHouses(List<House> houses) {
        return houseRepository.saveAll(houses);
    }

    public House updateHouse(House house) {
        House newHouse = houseRepository.findById(house.getId_house()).get();
        newHouse.setId_house(house.getId_house());
        newHouse.setCategory(house.getCategory());
        newHouse.setCity(house.getCity());
        newHouse.setDescription(house.getDescription());
        newHouse.setPhone(house.getPhone());
        newHouse.setPrice(house.getPrice());
        newHouse.setRooms(house.getRooms());
        newHouse.setStatus(house.getStatus());
        newHouse.setTerritory(house.getTerritory());
        newHouse.setType(house.getType());
        return houseRepository.save(newHouse);
    }

    public House buyHouse(int id_house /*, Users users*/) {
        House newHouse = houseRepository.findById(id_house).get();
        newHouse.setStatus(vendu);
        History newHistory = new History();
        newHistory.setHouse(newHouse);
        newHistory.setDate(Instant.now());
        historyRepository.save(newHistory);
        return houseRepository.save(newHouse);
    }
}
