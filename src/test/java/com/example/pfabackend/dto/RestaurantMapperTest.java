package com.example.pfabackend.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Restaurant;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class RestaurantMapperTest {
    /**
     * Method under test: {@link RestaurantMapper#toDTO(Restaurant)}
     */
    @Test
    void testToDTO() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(new Restaurant());

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Cuisine");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Instagram");
        restaurant.setLikes(1);
        restaurant.setLocation(location2);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(owner);
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("Price Range");
        restaurant.setRating(10.0d);
        restaurant.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCoverImageUrl("https://example.org/example");
        restaurant2.setCuisine("Cuisine");
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setEmail("jane.doe@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(1L);
        restaurant2.setInstagram("Instagram");
        restaurant2.setLikes(1);
        restaurant2.setLocation(location);
        restaurant2.setLogoUrl("https://example.org/example");
        restaurant2.setName("Name");
        restaurant2.setOwner(owner2);
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("Price Range");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());

        // Act
        RestaurantDTO actualToDTOResult = RestaurantMapper.toDTO(restaurant2);

        // Assert
        assertEquals("6625550144", actualToDTOResult.getPhoneNumber());
        assertEquals("Cuisine", actualToDTOResult.getCuisine());
        assertEquals("Instagram", actualToDTOResult.getInstagram());
        assertEquals("Name", actualToDTOResult.getName());
        assertEquals("Price Range", actualToDTOResult.getPriceRange());
        assertEquals("The characteristics of someone or something", actualToDTOResult.getDescription());
        assertEquals("https://example.org/example", actualToDTOResult.getCoverImageUrl());
        assertEquals("https://example.org/example", actualToDTOResult.getLogoUrl());
        assertEquals("jane.doe@example.org", actualToDTOResult.getEmail());
        assertEquals(1, actualToDTOResult.getLikes());
        assertEquals(10.0d, actualToDTOResult.getRating());
        assertEquals(1L, actualToDTOResult.getId().longValue());
        assertSame(location, actualToDTOResult.getLocation());
    }
}
