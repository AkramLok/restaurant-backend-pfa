package com.example.pfabackend.service;

import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        return optionalRestaurant.orElse(null);
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Long id, Restaurant updatedRestaurant) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant restaurant = optionalRestaurant.get();
            restaurant.setName(updatedRestaurant.getName());
            restaurant.setAddress(updatedRestaurant.getAddress());
            restaurant.setPhone(updatedRestaurant.getPhone());
            //restaurant.setParticipations(updatedRestaurant.getParticipations());
            //            restaurant.setWaiters(updatedRestaurant.getWaiters());
            //            restaurant.setFoodCategories(updatedRestaurant.getFoodCategories());
            //            restaurant.setOwner(updatedRestaurant.getOwner());
            // Update other fields as needed
            return restaurantRepository.save(restaurant);
        } else {
            return null; // Restaurant with given id not found
        }
    }


    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
