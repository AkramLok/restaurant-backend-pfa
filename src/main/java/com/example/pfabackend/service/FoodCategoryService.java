package com.example.pfabackend.service;

import com.example.pfabackend.entities.FoodCategory;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.repository.FoodCategoryRepository;
import com.example.pfabackend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodCategoryService {

    @Autowired
    private  FoodCategoryRepository foodCategoryRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<FoodCategory> getAllFoodCategories() {
        return foodCategoryRepository.findAll();
    }

    public List<FoodCategory> getFoodCategoriesByRestaurantId(Long restaurantId) {
        return foodCategoryRepository.findByRestaurantId(restaurantId);
    }

    public Optional<FoodCategory> getFoodCategoryById(Long id) {
        return foodCategoryRepository.findById(id);
    }

    public FoodCategory saveFoodCategory(Long restaurantId, FoodCategory foodCategory) {
        // Retrieve the restaurant by ID
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantId);
        if (optionalRestaurant.isPresent()) {

            Optional<FoodCategory> existingCategory = foodCategoryRepository.findByRestaurantIdAndNameIgnoreCase(restaurantId, foodCategory.getName());
            if (existingCategory.isPresent()) {
                throw new IllegalArgumentException("Category with name " + foodCategory.getName() + " already exists for restaurant with ID " + restaurantId);
            }
            // Set the restaurant for the food category
            foodCategory.setRestaurant(optionalRestaurant.get());
            // Save the food category
            return foodCategoryRepository.save(foodCategory);
        } else {
            // Handle the case where the restaurant ID is not found
            throw new IllegalArgumentException("Restaurant with ID " + restaurantId + " not found");
        }
    }


    public void deleteFoodCategory(Long id) {
        foodCategoryRepository.deleteById(id);
    }
}
