package com.example.pfabackend.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FoodCategoryTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link FoodCategory#equals(Object)}
     *   <li>{@link FoodCategory#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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

        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(1L);
        foodCategory.setIsActivated(true);
        foodCategory.setName("Name");
        foodCategory.setProducts(new ArrayList<>());
        foodCategory.setRestaurant(restaurant2);

        // Act and Assert
        assertEquals(foodCategory, foodCategory);
        int expectedHashCodeResult = foodCategory.hashCode();
        assertEquals(expectedHashCodeResult, foodCategory.hashCode());
    }

    /**
     * Method under test: {@link FoodCategory#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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

        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(1L);
        foodCategory.setIsActivated(true);
        foodCategory.setName("Name");
        foodCategory.setProducts(new ArrayList<>());
        foodCategory.setRestaurant(restaurant2);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(new Restaurant());

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location4);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner3);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location3);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner4);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        FoodCategory foodCategory2 = new FoodCategory();
        foodCategory2.setId(1L);
        foodCategory2.setIsActivated(true);
        foodCategory2.setName("Name");
        foodCategory2.setProducts(new ArrayList<>());
        foodCategory2.setRestaurant(restaurant4);

        // Act and Assert
        assertNotEquals(foodCategory, foodCategory2);
    }

    /**
     * Method under test: {@link FoodCategory#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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

        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(2L);
        foodCategory.setIsActivated(true);
        foodCategory.setName("Name");
        foodCategory.setProducts(new ArrayList<>());
        foodCategory.setRestaurant(restaurant2);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(new Restaurant());

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location4);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner3);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location3);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner4);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        FoodCategory foodCategory2 = new FoodCategory();
        foodCategory2.setId(1L);
        foodCategory2.setIsActivated(true);
        foodCategory2.setName("Name");
        foodCategory2.setProducts(new ArrayList<>());
        foodCategory2.setRestaurant(restaurant4);

        // Act and Assert
        assertNotEquals(foodCategory, foodCategory2);
    }

    /**
     * Method under test: {@link FoodCategory#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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

        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(null);
        foodCategory.setIsActivated(true);
        foodCategory.setName("Name");
        foodCategory.setProducts(new ArrayList<>());
        foodCategory.setRestaurant(restaurant2);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(new Restaurant());

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location4);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner3);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location3);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner4);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        FoodCategory foodCategory2 = new FoodCategory();
        foodCategory2.setId(1L);
        foodCategory2.setIsActivated(true);
        foodCategory2.setName("Name");
        foodCategory2.setProducts(new ArrayList<>());
        foodCategory2.setRestaurant(restaurant4);

        // Act and Assert
        assertNotEquals(foodCategory, foodCategory2);
    }

    /**
     * Method under test: {@link FoodCategory#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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

        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(1L);
        foodCategory.setIsActivated(false);
        foodCategory.setName("Name");
        foodCategory.setProducts(new ArrayList<>());
        foodCategory.setRestaurant(restaurant2);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(new Restaurant());

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location4);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner3);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location3);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner4);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        FoodCategory foodCategory2 = new FoodCategory();
        foodCategory2.setId(1L);
        foodCategory2.setIsActivated(true);
        foodCategory2.setName("Name");
        foodCategory2.setProducts(new ArrayList<>());
        foodCategory2.setRestaurant(restaurant4);

        // Act and Assert
        assertNotEquals(foodCategory, foodCategory2);
    }

    /**
     * Method under test: {@link FoodCategory#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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

        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(1L);
        foodCategory.setIsActivated(null);
        foodCategory.setName("Name");
        foodCategory.setProducts(new ArrayList<>());
        foodCategory.setRestaurant(restaurant2);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(new Restaurant());

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location4);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner3);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location3);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner4);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        FoodCategory foodCategory2 = new FoodCategory();
        foodCategory2.setId(1L);
        foodCategory2.setIsActivated(true);
        foodCategory2.setName("Name");
        foodCategory2.setProducts(new ArrayList<>());
        foodCategory2.setRestaurant(restaurant4);

        // Act and Assert
        assertNotEquals(foodCategory, foodCategory2);
    }

    /**
     * Method under test: {@link FoodCategory#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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

        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(1L);
        foodCategory.setIsActivated(true);
        foodCategory.setName(null);
        foodCategory.setProducts(new ArrayList<>());
        foodCategory.setRestaurant(restaurant2);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(new Restaurant());

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location4);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner3);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location3);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner4);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        FoodCategory foodCategory2 = new FoodCategory();
        foodCategory2.setId(1L);
        foodCategory2.setIsActivated(true);
        foodCategory2.setName("Name");
        foodCategory2.setProducts(new ArrayList<>());
        foodCategory2.setRestaurant(restaurant4);

        // Act and Assert
        assertNotEquals(foodCategory, foodCategory2);
    }

    /**
     * Method under test: {@link FoodCategory#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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

        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(1L);
        foodCategory.setIsActivated(true);
        foodCategory.setName("com.example.pfabackend.entities.FoodCategory");
        foodCategory.setProducts(new ArrayList<>());
        foodCategory.setRestaurant(restaurant2);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(new Restaurant());

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location4);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner3);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location3);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner4);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        FoodCategory foodCategory2 = new FoodCategory();
        foodCategory2.setId(1L);
        foodCategory2.setIsActivated(true);
        foodCategory2.setName("Name");
        foodCategory2.setProducts(new ArrayList<>());
        foodCategory2.setRestaurant(restaurant4);

        // Act and Assert
        assertNotEquals(foodCategory, foodCategory2);
    }

    /**
     * Method under test: {@link FoodCategory#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
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
        Restaurant restaurant2 = mock(Restaurant.class);
        doNothing().when(restaurant2).setCoverImageUrl(Mockito.<String>any());
        doNothing().when(restaurant2).setCuisine(Mockito.<String>any());
        doNothing().when(restaurant2).setDescription(Mockito.<String>any());
        doNothing().when(restaurant2).setEmail(Mockito.<String>any());
        doNothing().when(restaurant2).setFoodCategories(Mockito.<List<FoodCategory>>any());
        doNothing().when(restaurant2).setId(Mockito.<Long>any());
        doNothing().when(restaurant2).setInstagram(Mockito.<String>any());
        doNothing().when(restaurant2).setLikes(anyInt());
        doNothing().when(restaurant2).setLocation(Mockito.<Location>any());
        doNothing().when(restaurant2).setLogoUrl(Mockito.<String>any());
        doNothing().when(restaurant2).setName(Mockito.<String>any());
        doNothing().when(restaurant2).setOwner(Mockito.<Owner>any());
        doNothing().when(restaurant2).setParticipations(Mockito.<Set<Participation>>any());
        doNothing().when(restaurant2).setPhoneNumber(Mockito.<String>any());
        doNothing().when(restaurant2).setPriceRange(Mockito.<String>any());
        doNothing().when(restaurant2).setRating(anyDouble());
        doNothing().when(restaurant2).setWaiters(Mockito.<List<Waiter>>any());
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

        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(1L);
        foodCategory.setIsActivated(true);
        foodCategory.setName("Name");
        foodCategory.setProducts(new ArrayList<>());
        foodCategory.setRestaurant(restaurant2);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(new Restaurant());

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location4);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner3);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location3);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner4);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        FoodCategory foodCategory2 = new FoodCategory();
        foodCategory2.setId(1L);
        foodCategory2.setIsActivated(true);
        foodCategory2.setName("Name");
        foodCategory2.setProducts(new ArrayList<>());
        foodCategory2.setRestaurant(restaurant4);

        // Act and Assert
        assertNotEquals(foodCategory, foodCategory2);
    }

    /**
     * Method under test: {@link FoodCategory#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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

        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(1L);
        foodCategory.setIsActivated(true);
        foodCategory.setName("Name");
        foodCategory.setProducts(new ArrayList<>());
        foodCategory.setRestaurant(restaurant2);

        // Act and Assert
        assertNotEquals(foodCategory, null);
    }

    /**
     * Method under test: {@link FoodCategory#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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

        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(1L);
        foodCategory.setIsActivated(true);
        foodCategory.setName("Name");
        foodCategory.setProducts(new ArrayList<>());
        foodCategory.setRestaurant(restaurant2);

        // Act and Assert
        assertNotEquals(foodCategory, "Different type to FoodCategory");
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link FoodCategory#FoodCategory()}
     *   <li>{@link FoodCategory#setId(Long)}
     *   <li>{@link FoodCategory#setIsActivated(Boolean)}
     *   <li>{@link FoodCategory#setName(String)}
     *   <li>{@link FoodCategory#setProducts(List)}
     *   <li>{@link FoodCategory#setRestaurant(Restaurant)}
     *   <li>{@link FoodCategory#toString()}
     *   <li>{@link FoodCategory#getId()}
     *   <li>{@link FoodCategory#getIsActivated()}
     *   <li>{@link FoodCategory#getName()}
     *   <li>{@link FoodCategory#getProducts()}
     *   <li>{@link FoodCategory#getRestaurant()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        FoodCategory actualFoodCategory = new FoodCategory();
        actualFoodCategory.setId(1L);
        actualFoodCategory.setIsActivated(true);
        actualFoodCategory.setName("Name");
        ArrayList<Product> products = new ArrayList<>();
        actualFoodCategory.setProducts(products);
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
        actualFoodCategory.setRestaurant(restaurant2);
        String actualToStringResult = actualFoodCategory.toString();
        Long actualId = actualFoodCategory.getId();
        Boolean actualIsActivated = actualFoodCategory.getIsActivated();
        String actualName = actualFoodCategory.getName();
        List<Product> actualProducts = actualFoodCategory.getProducts();
        Restaurant actualRestaurant = actualFoodCategory.getRestaurant();

        // Assert that nothing has changed
        assertEquals("FoodCategory(id=1, name=Name, restaurant=Restaurant(id=1, name=Name, location=Location(latitude=10.0,"
                + " longitude=10.0), coverImageUrl=https://example.org/example, logoUrl=https://example.org/example,"
                + " cuisine=Cuisine, rating=10.0, description=The characteristics of someone or something, instagram=Instagram,"
                + " phoneNumber=6625550144, email=jane.doe@example.org, likes=1, priceRange=Price Range, participations=[],"
                + " waiters=[], foodCategories=[], owner=Owner(id=1, name=Name, email=jane.doe@example.org, phone=6625550144,"
                + " restaurant=Restaurant(id=1, name=Name, location=Location(latitude=10.0, longitude=10.0), coverImageUrl"
                + "=https://example.org/example, logoUrl=https://example.org/example, cuisine=Cuisine, rating=10.0,"
                + " description=The characteristics of someone or something, instagram=Instagram, phoneNumber=6625550144,"
                + " email=jane.doe@example.org, likes=1, priceRange=Price Range, participations=[], waiters=[],"
                + " foodCategories=[], owner=Owner(id=1, name=Name, email=jane.doe@example.org, phone=6625550144,"
                + " restaurant=Restaurant(id=null, name=null, location=null, coverImageUrl=null, logoUrl=null, cuisine=null,"
                + " rating=0.0, description=null, instagram=null, phoneNumber=null, email=null, likes=0, priceRange=null,"
                + " participations=null, waiters=null, foodCategories=null, owner=null))))), isActivated=true,"
                + " products=[])", actualToStringResult);
        assertEquals("Name", actualName);
        assertEquals(1L, actualId.longValue());
        assertTrue(actualIsActivated);
        assertTrue(actualProducts.isEmpty());
        assertSame(restaurant2, actualRestaurant);
        assertSame(products, actualProducts);
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>
     * {@link FoodCategory#FoodCategory(Long, String, Restaurant, Boolean, List)}
     *   <li>{@link FoodCategory#setId(Long)}
     *   <li>{@link FoodCategory#setIsActivated(Boolean)}
     *   <li>{@link FoodCategory#setName(String)}
     *   <li>{@link FoodCategory#setProducts(List)}
     *   <li>{@link FoodCategory#setRestaurant(Restaurant)}
     *   <li>{@link FoodCategory#toString()}
     *   <li>{@link FoodCategory#getId()}
     *   <li>{@link FoodCategory#getIsActivated()}
     *   <li>{@link FoodCategory#getName()}
     *   <li>{@link FoodCategory#getProducts()}
     *   <li>{@link FoodCategory#getRestaurant()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
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
        FoodCategory actualFoodCategory = new FoodCategory(1L, "Name", restaurant2, true, new ArrayList<>());
        actualFoodCategory.setId(1L);
        actualFoodCategory.setIsActivated(true);
        actualFoodCategory.setName("Name");
        ArrayList<Product> products = new ArrayList<>();
        actualFoodCategory.setProducts(products);
        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);
        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);
        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(new Restaurant());
        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location4);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner3);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());
        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(restaurant3);
        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location3);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner4);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());
        actualFoodCategory.setRestaurant(restaurant4);
        String actualToStringResult = actualFoodCategory.toString();
        Long actualId = actualFoodCategory.getId();
        Boolean actualIsActivated = actualFoodCategory.getIsActivated();
        String actualName = actualFoodCategory.getName();
        List<Product> actualProducts = actualFoodCategory.getProducts();
        Restaurant actualRestaurant = actualFoodCategory.getRestaurant();

        // Assert that nothing has changed
        assertEquals("FoodCategory(id=1, name=Name, restaurant=Restaurant(id=1, name=Name, location=Location(latitude=10.0,"
                + " longitude=10.0), coverImageUrl=https://example.org/example, logoUrl=https://example.org/example,"
                + " cuisine=Cuisine, rating=10.0, description=The characteristics of someone or something, instagram=Instagram,"
                + " phoneNumber=6625550144, email=jane.doe@example.org, likes=1, priceRange=Price Range, participations=[],"
                + " waiters=[], foodCategories=[], owner=Owner(id=1, name=Name, email=jane.doe@example.org, phone=6625550144,"
                + " restaurant=Restaurant(id=1, name=Name, location=Location(latitude=10.0, longitude=10.0), coverImageUrl"
                + "=https://example.org/example, logoUrl=https://example.org/example, cuisine=Cuisine, rating=10.0,"
                + " description=The characteristics of someone or something, instagram=Instagram, phoneNumber=6625550144,"
                + " email=jane.doe@example.org, likes=1, priceRange=Price Range, participations=[], waiters=[],"
                + " foodCategories=[], owner=Owner(id=1, name=Name, email=jane.doe@example.org, phone=6625550144,"
                + " restaurant=Restaurant(id=null, name=null, location=null, coverImageUrl=null, logoUrl=null, cuisine=null,"
                + " rating=0.0, description=null, instagram=null, phoneNumber=null, email=null, likes=0, priceRange=null,"
                + " participations=null, waiters=null, foodCategories=null, owner=null))))), isActivated=true,"
                + " products=[])", actualToStringResult);
        assertEquals("Name", actualName);
        assertEquals(1L, actualId.longValue());
        assertTrue(actualIsActivated);
        assertTrue(actualProducts.isEmpty());
        assertSame(restaurant4, actualRestaurant);
        assertSame(products, actualProducts);
    }
}
