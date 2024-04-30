package com.example.pfabackend.service;

import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
            if (updatedRestaurant.getName() != null) {
                restaurant.setName(updatedRestaurant.getName());
            }
            if (updatedRestaurant.getCoverImageUrl() != null) {
                restaurant.setCoverImageUrl(updatedRestaurant.getCoverImageUrl());
            }
            if (updatedRestaurant.getLogoUrl() != null) {
                restaurant.setLogoUrl(updatedRestaurant.getLogoUrl());
            }
            if (updatedRestaurant.getCuisine() != null) {
                restaurant.setCuisine(updatedRestaurant.getCuisine());
            }
            if (updatedRestaurant.getRating() != 0) {
                restaurant.setRating(updatedRestaurant.getRating());
            }
            if (updatedRestaurant.getDescription() != null) {
                restaurant.setDescription(updatedRestaurant.getDescription());
            }
            if (updatedRestaurant.getInstagram() != null) {
                restaurant.setInstagram(updatedRestaurant.getInstagram());
            }
            if (updatedRestaurant.getPhoneNumber() != null) {
                restaurant.setPhoneNumber(updatedRestaurant.getPhoneNumber());
            }
            if (updatedRestaurant.getEmail() != null) {
                restaurant.setEmail(updatedRestaurant.getEmail());
            }
            if (updatedRestaurant.getLikes() != 0) {
                restaurant.setLikes(updatedRestaurant.getLikes());
            }
            if (updatedRestaurant.getPriceRange() != null) {
                restaurant.setPriceRange(updatedRestaurant.getPriceRange());
            }
            // Update location fields if provided
            if (updatedRestaurant.getLocation() != null) {
                if (updatedRestaurant.getLocation().getLatitude() != 0) {
                    restaurant.getLocation().setLatitude(updatedRestaurant.getLocation().getLatitude());
                }
                if (updatedRestaurant.getLocation().getLongitude() != 0) {
                    restaurant.getLocation().setLongitude(updatedRestaurant.getLocation().getLongitude());
                }
            }
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
