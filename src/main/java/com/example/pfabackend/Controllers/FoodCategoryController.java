package com.example.pfabackend.Controllers;

import com.example.pfabackend.entities.FoodCategory;
import com.example.pfabackend.service.FoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food-categories")
public class FoodCategoryController {

    private final FoodCategoryService foodCategoryService;

    @Autowired
    public FoodCategoryController(FoodCategoryService foodCategoryService) {
        this.foodCategoryService = foodCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<FoodCategory>> getAllFoodCategories() {
        List<FoodCategory> foodCategories = foodCategoryService.getAllFoodCategories();
        return new ResponseEntity<>(foodCategories, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<FoodCategory>> getFoodCategoriesByRestaurantId(@PathVariable Long restaurantId) {
        List<FoodCategory> foodCategories = foodCategoryService.getFoodCategoriesByRestaurantId(restaurantId);
        return new ResponseEntity<>(foodCategories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodCategory> getFoodCategoryById(@PathVariable Long id) {
        return foodCategoryService.getFoodCategoryById(id)
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{restaurantId}")
    public ResponseEntity<FoodCategory> createFoodCategory(@PathVariable Long restaurantId,
                                                           @RequestBody FoodCategory foodCategory) {
        FoodCategory createdCategory = foodCategoryService.saveFoodCategory(restaurantId, foodCategory);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodCategory(@PathVariable Long id) {
        foodCategoryService.deleteFoodCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
