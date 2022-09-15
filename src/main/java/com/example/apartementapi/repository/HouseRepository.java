package com.example.apartementapi.repository;

import com.example.apartementapi.model.Category;
import com.example.apartementapi.model.City;
import com.example.apartementapi.model.House;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {

    @Query("SELECT h FROM House h " +
            "inner join City ci on ci.id_city = h.city.id_city where " +
            "h.type = ?1 and " +
            "h.price > ?2 and " +
            "h.price < ?3 and " +
            "h.city.name = ?4")
    List<House> getHouseWithOnlyCategoryAll(House.Type type, int minPrice, int maxPrice, String cityName, Pageable pageable);

    @Query("SELECT h FROM House h " +
            "inner join Category ca on ca.id_category = h.category.id_category where " +
            "h.category.name = ?1 and " +
            "h.price > ?2 and " +
            "h.price < ?3 and " +
            "h.city.name = ?4")
    List<House> getHouseWithOnlyTypeAll(String categoryName, int minPrice, int maxPrice, String cityName, Pageable pageable);

    @Query("SELECT h FROM House h where " +
            "h.price > ?1 and " +
            "h.price < ?2 and " +
            "h.city.name = ?3")
    List<House> getHouseWithCategoryAndTypeAll(int minPrice, int maxPrice, String cityName, Pageable pageable);

    @Query("SELECT h FROM House h " +
            "inner join Category ca on ca.id_category = h.category.id_category " +
            "inner join City ci on ci.id_city = h.city.id_city " +
            "where h.category.name = ?1 and " +
            "h.type = ?2 and " +
            "h.price > ?3 and " +
            "h.price < ?4 and " +
            "h.city.name = ?5")
    List<House> getHouseWithAllCriteria(String categoryName, House.Type type, int minPrice, int maxPrice, String cityName, Pageable pageable);

    List<House> findByCategory(Category category);

    List<House> findByCity(City city);
}
