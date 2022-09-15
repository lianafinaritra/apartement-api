package com.example.apartementapi.service;

import com.example.apartementapi.model.Category;
import com.example.apartementapi.model.House;
import com.example.apartementapi.repository.CategoryRepository;
import com.example.apartementapi.repository.HouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final HouseRepository houseRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public String deleteCategory(int id_category, String name) {
        Category category = new Category();
        category.setId_category(id_category);
        category.setName(name);
        List<House> list = houseRepository.findByCategory(category);
        for (House house: list) {
            house.setCategory(null);
        }
        categoryRepository.delete(category);
        return "Delete successful";
    }
}
