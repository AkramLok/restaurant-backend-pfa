package com.example.pfabackend.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.pfabackend.entities.FoodCategory;
import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Product;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.repository.FoodCategoryRepository;
import com.example.pfabackend.repository.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FoodCategoryService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class FoodCategoryServiceTest {
    @MockBean
    private FoodCategoryRepository foodCategoryRepository;

    @Autowired
    private FoodCategoryService foodCategoryService;

    @MockBean
    private ProductService productService;

    @MockBean
    private RestaurantRepository restaurantRepository;

    /**
     * Method under test: {@link FoodCategoryService#getAllFoodCategories()}
     */
    @Test
    void testGetAllFoodCategories() {
        // Arrange
        ArrayList<FoodCategory> foodCategoryList = new ArrayList<>();
        when(foodCategoryRepository.findAll()).thenReturn(foodCategoryList);

        // Act
        List<FoodCategory> actualAllFoodCategories = foodCategoryService.getAllFoodCategories();

        // Assert
        verify(foodCategoryRepository).findAll();
        assertTrue(actualAllFoodCategories.isEmpty());
        assertSame(foodCategoryList, actualAllFoodCategories);
    }

    /**
     * Method under test: {@link FoodCategoryService#getAllFoodCategories()}
     */
    @Test
    void testGetAllFoodCategories2() {
        // Arrange
        when(foodCategoryRepository.findAll()).thenThrow(new IllegalArgumentException("foo"));

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> foodCategoryService.getAllFoodCategories());
        verify(foodCategoryRepository).findAll();
    }

    /**
     * Method under test:
     * {@link FoodCategoryService#getFoodCategoriesByRestaurantId(Long)}
     */
    @Test
    void testGetFoodCategoriesByRestaurantId() {
        // Arrange
        ArrayList<FoodCategory> foodCategoryList = new ArrayList<>();
        when(foodCategoryRepository.findByRestaurantId(Mockito.<Long>any())).thenReturn(foodCategoryList);

        // Act
        List<FoodCategory> actualFoodCategoriesByRestaurantId = foodCategoryService.getFoodCategoriesByRestaurantId(1L);

        // Assert
        verify(foodCategoryRepository).findByRestaurantId(eq(1L));
        assertTrue(actualFoodCategoriesByRestaurantId.isEmpty());
        assertSame(foodCategoryList, actualFoodCategoriesByRestaurantId);
    }

    /**
     * Method under test:
     * {@link FoodCategoryService#getFoodCategoriesByRestaurantId(Long)}
     */
    @Test
    void testGetFoodCategoriesByRestaurantId2() {
        // Arrange
        when(foodCategoryRepository.findByRestaurantId(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("foo"));

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> foodCategoryService.getFoodCategoriesByRestaurantId(1L));
        verify(foodCategoryRepository).findByRestaurantId(eq(1L));
    }

    /**
     * Method under test: {@link FoodCategoryService#getFoodCategoryById(Long)}
     */
    @Test
    void testGetFoodCategoryById() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Cuisine");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Instagram");
        restaurant.setLikes(1);
        restaurant.setLocation(new Location());
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(new Owner());
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("Price Range");
        restaurant.setRating(10.0d);
        restaurant.setWaiters(new ArrayList<>());

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(restaurant);

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
        restaurant2.setOwner(owner);
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
        Optional<FoodCategory> ofResult = Optional.of(foodCategory);
        when(foodCategoryRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Optional<FoodCategory> actualFoodCategoryById = foodCategoryService.getFoodCategoryById(1L);

        // Assert
        verify(foodCategoryRepository).findById(eq(1L));
        assertSame(ofResult, actualFoodCategoryById);
    }

    /**
     * Method under test:
     * {@link FoodCategoryService#saveFoodCategory(Long, FoodCategory)}
     */
    @Test
    void testSaveFoodCategory() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Cuisine");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Instagram");
        restaurant.setLikes(1);
        restaurant.setLocation(new Location());
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(new Owner());
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("Price Range");
        restaurant.setRating(10.0d);
        restaurant.setWaiters(new ArrayList<>());

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(restaurant);

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
        restaurant2.setOwner(owner);
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
        Optional<FoodCategory> ofResult = Optional.of(foodCategory);
        when(foodCategoryRepository.findByRestaurantIdAndNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(ofResult);

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(new Restaurant());

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location3);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner2);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location2);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner3);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());
        Optional<Restaurant> ofResult2 = Optional.of(restaurant4);
        when(restaurantRepository.findById(Mockito.<Long>any())).thenReturn(ofResult2);

        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);

        Restaurant restaurant5 = new Restaurant();
        restaurant5.setCoverImageUrl("https://example.org/example");
        restaurant5.setCuisine("Cuisine");
        restaurant5.setDescription("The characteristics of someone or something");
        restaurant5.setEmail("jane.doe@example.org");
        restaurant5.setFoodCategories(new ArrayList<>());
        restaurant5.setId(1L);
        restaurant5.setInstagram("Instagram");
        restaurant5.setLikes(1);
        restaurant5.setLocation(new Location());
        restaurant5.setLogoUrl("https://example.org/example");
        restaurant5.setName("Name");
        restaurant5.setOwner(new Owner());
        restaurant5.setParticipations(new HashSet<>());
        restaurant5.setPhoneNumber("6625550144");
        restaurant5.setPriceRange("Price Range");
        restaurant5.setRating(10.0d);
        restaurant5.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(restaurant5);

        Restaurant restaurant6 = new Restaurant();
        restaurant6.setCoverImageUrl("https://example.org/example");
        restaurant6.setCuisine("Cuisine");
        restaurant6.setDescription("The characteristics of someone or something");
        restaurant6.setEmail("jane.doe@example.org");
        restaurant6.setFoodCategories(new ArrayList<>());
        restaurant6.setId(1L);
        restaurant6.setInstagram("Instagram");
        restaurant6.setLikes(1);
        restaurant6.setLocation(location4);
        restaurant6.setLogoUrl("https://example.org/example");
        restaurant6.setName("Name");
        restaurant6.setOwner(owner4);
        restaurant6.setParticipations(new HashSet<>());
        restaurant6.setPhoneNumber("6625550144");
        restaurant6.setPriceRange("Price Range");
        restaurant6.setRating(10.0d);
        restaurant6.setWaiters(new ArrayList<>());

        FoodCategory foodCategory2 = new FoodCategory();
        foodCategory2.setId(1L);
        foodCategory2.setIsActivated(true);
        foodCategory2.setName("Name");
        foodCategory2.setProducts(new ArrayList<>());
        foodCategory2.setRestaurant(restaurant6);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> foodCategoryService.saveFoodCategory(1L, foodCategory2));
        verify(foodCategoryRepository).findByRestaurantIdAndNameIgnoreCase(eq(1L), eq("Name"));
        verify(restaurantRepository).findById(eq(1L));
    }

    /**
     * Method under test:
     * {@link FoodCategoryService#saveFoodCategory(Long, FoodCategory)}
     */
    @Test
    void testSaveFoodCategory2() {
        // Arrange
        when(foodCategoryRepository.findByRestaurantIdAndNameIgnoreCase(Mockito.<Long>any(), Mockito.<String>any()))
                .thenThrow(new EntityNotFoundException("An error occurred"));

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
        Optional<Restaurant> ofResult = Optional.of(restaurant2);
        when(restaurantRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(new Location());
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(new Owner());
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(restaurant3);

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
        restaurant4.setOwner(owner3);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(1L);
        foodCategory.setIsActivated(true);
        foodCategory.setName("Name");
        foodCategory.setProducts(new ArrayList<>());
        foodCategory.setRestaurant(restaurant4);

        // Act and Assert
        assertThrows(EntityNotFoundException.class, () -> foodCategoryService.saveFoodCategory(1L, foodCategory));
        verify(foodCategoryRepository).findByRestaurantIdAndNameIgnoreCase(eq(1L), eq("Name"));
        verify(restaurantRepository).findById(eq(1L));
    }

    /**
     * Method under test:
     * {@link FoodCategoryService#updateFoodCategory(Long, FoodCategory)}
     */
    @Test
    void testUpdateFoodCategory() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Cuisine");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Instagram");
        restaurant.setLikes(1);
        restaurant.setLocation(new Location());
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(new Owner());
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("Price Range");
        restaurant.setRating(10.0d);
        restaurant.setWaiters(new ArrayList<>());

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(restaurant);

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
        restaurant2.setOwner(owner);
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
        Optional<FoodCategory> ofResult = Optional.of(foodCategory);

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(new Restaurant());

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location3);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner2);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location2);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner3);
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
        when(foodCategoryRepository.save(Mockito.<FoodCategory>any())).thenReturn(foodCategory2);
        when(foodCategoryRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);

        Restaurant restaurant5 = new Restaurant();
        restaurant5.setCoverImageUrl("https://example.org/example");
        restaurant5.setCuisine("Cuisine");
        restaurant5.setDescription("The characteristics of someone or something");
        restaurant5.setEmail("jane.doe@example.org");
        restaurant5.setFoodCategories(new ArrayList<>());
        restaurant5.setId(1L);
        restaurant5.setInstagram("Instagram");
        restaurant5.setLikes(1);
        restaurant5.setLocation(new Location());
        restaurant5.setLogoUrl("https://example.org/example");
        restaurant5.setName("Name");
        restaurant5.setOwner(new Owner());
        restaurant5.setParticipations(new HashSet<>());
        restaurant5.setPhoneNumber("6625550144");
        restaurant5.setPriceRange("Price Range");
        restaurant5.setRating(10.0d);
        restaurant5.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(restaurant5);

        Restaurant restaurant6 = new Restaurant();
        restaurant6.setCoverImageUrl("https://example.org/example");
        restaurant6.setCuisine("Cuisine");
        restaurant6.setDescription("The characteristics of someone or something");
        restaurant6.setEmail("jane.doe@example.org");
        restaurant6.setFoodCategories(new ArrayList<>());
        restaurant6.setId(1L);
        restaurant6.setInstagram("Instagram");
        restaurant6.setLikes(1);
        restaurant6.setLocation(location4);
        restaurant6.setLogoUrl("https://example.org/example");
        restaurant6.setName("Name");
        restaurant6.setOwner(owner4);
        restaurant6.setParticipations(new HashSet<>());
        restaurant6.setPhoneNumber("6625550144");
        restaurant6.setPriceRange("Price Range");
        restaurant6.setRating(10.0d);
        restaurant6.setWaiters(new ArrayList<>());

        FoodCategory updatedCategory = new FoodCategory();
        updatedCategory.setId(1L);
        updatedCategory.setIsActivated(true);
        updatedCategory.setName("Name");
        updatedCategory.setProducts(new ArrayList<>());
        updatedCategory.setRestaurant(restaurant6);

        // Act
        FoodCategory actualUpdateFoodCategoryResult = foodCategoryService.updateFoodCategory(1L, updatedCategory);

        // Assert
        verify(foodCategoryRepository).findById(eq(1L));
        verify(foodCategoryRepository).save(isA(FoodCategory.class));
        assertSame(foodCategory2, actualUpdateFoodCategoryResult);
    }

    /**
     * Method under test:
     * {@link FoodCategoryService#updateFoodCategory(Long, FoodCategory)}
     */
    @Test
    void testUpdateFoodCategory2() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Cuisine");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Instagram");
        restaurant.setLikes(1);
        restaurant.setLocation(new Location());
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(new Owner());
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("Price Range");
        restaurant.setRating(10.0d);
        restaurant.setWaiters(new ArrayList<>());

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(restaurant);

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
        restaurant2.setOwner(owner);
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
        Optional<FoodCategory> ofResult = Optional.of(foodCategory);
        when(foodCategoryRepository.save(Mockito.<FoodCategory>any())).thenThrow(new IllegalArgumentException("foo"));
        when(foodCategoryRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(new Location());
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(new Owner());
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location2);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner2);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        FoodCategory updatedCategory = new FoodCategory();
        updatedCategory.setId(1L);
        updatedCategory.setIsActivated(true);
        updatedCategory.setName("Name");
        updatedCategory.setProducts(new ArrayList<>());
        updatedCategory.setRestaurant(restaurant4);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> foodCategoryService.updateFoodCategory(1L, updatedCategory));
        verify(foodCategoryRepository).findById(eq(1L));
        verify(foodCategoryRepository).save(isA(FoodCategory.class));
    }

    /**
     * Method under test: {@link FoodCategoryService#deleteFoodCategory(Long)}
     */
    @Test
    void testDeleteFoodCategory() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Cuisine");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Instagram");
        restaurant.setLikes(1);
        restaurant.setLocation(new Location());
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(new Owner());
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("Price Range");
        restaurant.setRating(10.0d);
        restaurant.setWaiters(new ArrayList<>());

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(restaurant);

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
        restaurant2.setOwner(owner);
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
        Optional<FoodCategory> ofResult = Optional.of(foodCategory);
        doNothing().when(foodCategoryRepository).delete(Mockito.<FoodCategory>any());
        when(foodCategoryRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        foodCategoryService.deleteFoodCategory(1L);

        // Assert that nothing has changed
        verify(foodCategoryRepository).delete(isA(FoodCategory.class));
        verify(foodCategoryRepository).findById(eq(1L));
    }

    /**
     * Method under test: {@link FoodCategoryService#deleteFoodCategory(Long)}
     */
    @Test
    void testDeleteFoodCategory2() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Cuisine");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Instagram");
        restaurant.setLikes(1);
        restaurant.setLocation(new Location());
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(new Owner());
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("Price Range");
        restaurant.setRating(10.0d);
        restaurant.setWaiters(new ArrayList<>());

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(restaurant);

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
        restaurant2.setOwner(owner);
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
        Optional<FoodCategory> ofResult = Optional.of(foodCategory);
        doThrow(new IllegalArgumentException("foo")).when(foodCategoryRepository).delete(Mockito.<FoodCategory>any());
        when(foodCategoryRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> foodCategoryService.deleteFoodCategory(1L));
        verify(foodCategoryRepository).delete(isA(FoodCategory.class));
        verify(foodCategoryRepository).findById(eq(1L));
    }

    /**
     * Method under test: {@link FoodCategoryService#deleteFoodCategory(Long)}
     */
    @Test
    void testDeleteFoodCategory3() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

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
        restaurant.setLocation(location);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(owner);
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("Price Range");
        restaurant.setRating(10.0d);
        restaurant.setWaiters(new ArrayList<>());

        FoodCategory category = new FoodCategory();
        category.setId(1L);
        category.setIsActivated(true);
        category.setName("Name");
        category.setProducts(new ArrayList<>());
        category.setRestaurant(restaurant);

        Product product = new Product();
        product.setBonusPoints(1);
        product.setCategory(category);
        product.setId(1L);
        product.setImg("Img");
        product.setInfo("Info");
        product.setIsActivated(true);
        product.setName("Name");
        product.setPrice(10.0d);

        ArrayList<Product> products = new ArrayList<>();
        products.add(product);

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCoverImageUrl("https://example.org/example");
        restaurant2.setCuisine("Cuisine");
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setEmail("jane.doe@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(1L);
        restaurant2.setInstagram("Instagram");
        restaurant2.setLikes(1);
        restaurant2.setLocation(new Location());
        restaurant2.setLogoUrl("https://example.org/example");
        restaurant2.setName("Name");
        restaurant2.setOwner(new Owner());
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("Price Range");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant2);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location2);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner2);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(1L);
        foodCategory.setIsActivated(true);
        foodCategory.setName("Name");
        foodCategory.setProducts(products);
        foodCategory.setRestaurant(restaurant3);
        Optional<FoodCategory> ofResult = Optional.of(foodCategory);
        doNothing().when(foodCategoryRepository).delete(Mockito.<FoodCategory>any());
        when(foodCategoryRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Mockito.<ResponseEntity<?>>when(productService.deleteProduct(Mockito.<Long>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));

        // Act
        foodCategoryService.deleteFoodCategory(1L);

        // Assert that nothing has changed
        verify(productService).deleteProduct(eq(1L));
        verify(foodCategoryRepository).delete(isA(FoodCategory.class));
        verify(foodCategoryRepository).findById(eq(1L));
    }

    /**
     * Method under test: {@link FoodCategoryService#deleteFoodCategory(Long)}
     */
    @Test
    void testDeleteFoodCategory4() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

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
        restaurant.setLocation(location);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(owner);
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("Price Range");
        restaurant.setRating(10.0d);
        restaurant.setWaiters(new ArrayList<>());

        FoodCategory category = new FoodCategory();
        category.setId(1L);
        category.setIsActivated(true);
        category.setName("Name");
        category.setProducts(new ArrayList<>());
        category.setRestaurant(restaurant);

        Product product = new Product();
        product.setBonusPoints(1);
        product.setCategory(category);
        product.setId(1L);
        product.setImg("Img");
        product.setInfo("Info");
        product.setIsActivated(true);
        product.setName("Name");
        product.setPrice(10.0d);

        Location location2 = new Location();
        location2.setLatitude(0.5d);
        location2.setLongitude(0.5d);

        Owner owner2 = new Owner();
        owner2.setEmail("john.smith@example.org");
        owner2.setId(2L);
        owner2.setName("com.example.pfabackend.entities.Owner");
        owner2.setPhone("8605550118");
        owner2.setRestaurant(new Restaurant());

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCoverImageUrl("Cover Image Url");
        restaurant2.setCuisine("42");
        restaurant2.setDescription("Description");
        restaurant2.setEmail("john.smith@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(2L);
        restaurant2.setInstagram("42");
        restaurant2.setLikes(0);
        restaurant2.setLocation(location2);
        restaurant2.setLogoUrl("Logo Url");
        restaurant2.setName("42");
        restaurant2.setOwner(owner2);
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("8605550118");
        restaurant2.setPriceRange("42");
        restaurant2.setRating(0.5d);
        restaurant2.setWaiters(new ArrayList<>());

        FoodCategory category2 = new FoodCategory();
        category2.setId(2L);
        category2.setIsActivated(false);
        category2.setName("com.example.pfabackend.entities.FoodCategory");
        category2.setProducts(new ArrayList<>());
        category2.setRestaurant(restaurant2);

        Product product2 = new Product();
        product2.setBonusPoints(0);
        product2.setCategory(category2);
        product2.setId(2L);
        product2.setImg("com.example.pfabackend.entities.Product");
        product2.setInfo("com.example.pfabackend.entities.Product");
        product2.setIsActivated(false);
        product2.setName("com.example.pfabackend.entities.Product");
        product2.setPrice(0.5d);

        ArrayList<Product> products = new ArrayList<>();
        products.add(product2);
        products.add(product);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(new Location());
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(new Owner());
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(restaurant3);

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
        restaurant4.setOwner(owner3);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(1L);
        foodCategory.setIsActivated(true);
        foodCategory.setName("Name");
        foodCategory.setProducts(products);
        foodCategory.setRestaurant(restaurant4);
        Optional<FoodCategory> ofResult = Optional.of(foodCategory);
        doNothing().when(foodCategoryRepository).delete(Mockito.<FoodCategory>any());
        when(foodCategoryRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Mockito.<ResponseEntity<?>>when(productService.deleteProduct(Mockito.<Long>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));

        // Act
        foodCategoryService.deleteFoodCategory(1L);

        // Assert that nothing has changed
        verify(productService, atLeast(1)).deleteProduct(Mockito.<Long>any());
        verify(foodCategoryRepository).delete(isA(FoodCategory.class));
        verify(foodCategoryRepository).findById(eq(1L));
    }
}
