package com.example.apartementapi.controller;

import com.example.apartementapi.model.Category;
import com.example.apartementapi.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/category")
    public Category postCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @DeleteMapping("/category")
    public String deleteCategory(@RequestParam int id_category, @RequestParam String name){
        return categoryService.deleteCategory(id_category, name);
    }
}
