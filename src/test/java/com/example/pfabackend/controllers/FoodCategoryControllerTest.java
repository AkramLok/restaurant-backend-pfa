package com.example.pfabackend.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.pfabackend.entities.FoodCategory;
import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.service.FoodCategoryService;
import com.example.pfabackend.service.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {FoodCategoryController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class FoodCategoryControllerTest {
    @Autowired
    private FoodCategoryController foodCategoryController;

    @MockBean
    private FoodCategoryService foodCategoryService;

    @MockBean
    private RestaurantService restaurantService;

    /**
     * Method under test: {@link FoodCategoryController#getAllFoodCategories()}
     */
    @Test
    void testGetAllFoodCategories() throws Exception {
        // Arrange
        when(foodCategoryService.getAllFoodCategories()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/food-categories");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(foodCategoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test:
     * {@link FoodCategoryController#getFoodCategoriesByRestaurantId(Long)}
     */
    @Test
    void testGetFoodCategoriesByRestaurantId() throws Exception {
        // Arrange
        when(foodCategoryService.getFoodCategoriesByRestaurantId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/food-categories/restaurant/{restaurantId}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(foodCategoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link FoodCategoryController#getFoodCategoryById(Long)}
     */
    @Test
    void testGetFoodCategoryById() throws Exception {
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
        when(foodCategoryService.getFoodCategoryById(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/food-categories/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(foodCategoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":1,\"name\":\"Name\",\"isActivated\":true,\"products\":[]}"));
    }

    /**
     * Method under test: {@link FoodCategoryController#getFoodCategoryById(Long)}
     */
    @Test
    void testGetFoodCategoryById2() throws Exception {
        // Arrange
        Optional<FoodCategory> emptyResult = Optional.empty();
        when(foodCategoryService.getFoodCategoryById(Mockito.<Long>any())).thenReturn(emptyResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/food-categories/{id}", 1L);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(foodCategoryController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test:
     * {@link FoodCategoryController#updateFoodCategory(Long, FoodCategory)}
     */
    @Test
    void testUpdateFoodCategory() throws Exception {
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
        when(foodCategoryService.updateFoodCategory(Mockito.<Long>any(), Mockito.<FoodCategory>any()))
                .thenReturn(foodCategory);

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
        String content = (new ObjectMapper()).writeValueAsString(foodCategory2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/food-categories/{categoryId}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(foodCategoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":1,\"name\":\"Name\",\"isActivated\":true,\"products\":[]}"));
    }

    /**
     * Method under test:
     * {@link FoodCategoryController#createFoodCategory(Long, FoodCategory)}
     */
    @Test
    void testCreateFoodCategory() throws Exception {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

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
        restaurant2.setLocation(location2);
        restaurant2.setLogoUrl("https://example.org/example");
        restaurant2.setName("Name");
        restaurant2.setOwner(owner);
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
        restaurant3.setLocation(location);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner2);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());
        when(restaurantService.getRestaurantById(Mockito.<Long>any())).thenReturn(restaurant3);

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

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location4);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner3);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(restaurant4);

        Restaurant restaurant5 = new Restaurant();
        restaurant5.setCoverImageUrl("https://example.org/example");
        restaurant5.setCuisine("Cuisine");
        restaurant5.setDescription("The characteristics of someone or something");
        restaurant5.setEmail("jane.doe@example.org");
        restaurant5.setFoodCategories(new ArrayList<>());
        restaurant5.setId(1L);
        restaurant5.setInstagram("Instagram");
        restaurant5.setLikes(1);
        restaurant5.setLocation(location3);
        restaurant5.setLogoUrl("https://example.org/example");
        restaurant5.setName("Name");
        restaurant5.setOwner(owner4);
        restaurant5.setParticipations(new HashSet<>());
        restaurant5.setPhoneNumber("6625550144");
        restaurant5.setPriceRange("Price Range");
        restaurant5.setRating(10.0d);
        restaurant5.setWaiters(new ArrayList<>());

        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(1L);
        foodCategory.setIsActivated(true);
        foodCategory.setName("Name");
        foodCategory.setProducts(new ArrayList<>());
        foodCategory.setRestaurant(restaurant5);
        when(foodCategoryService.saveFoodCategory(Mockito.<Long>any(), Mockito.<FoodCategory>any()))
                .thenReturn(foodCategory);

        Location location5 = new Location();
        location5.setLatitude(10.0d);
        location5.setLongitude(10.0d);

        Location location6 = new Location();
        location6.setLatitude(10.0d);
        location6.setLongitude(10.0d);

        Owner owner5 = new Owner();
        owner5.setEmail("jane.doe@example.org");
        owner5.setId(1L);
        owner5.setName("Name");
        owner5.setPhone("6625550144");
        owner5.setRestaurant(new Restaurant());

        Restaurant restaurant6 = new Restaurant();
        restaurant6.setCoverImageUrl("https://example.org/example");
        restaurant6.setCuisine("Cuisine");
        restaurant6.setDescription("The characteristics of someone or something");
        restaurant6.setEmail("jane.doe@example.org");
        restaurant6.setFoodCategories(new ArrayList<>());
        restaurant6.setId(1L);
        restaurant6.setInstagram("Instagram");
        restaurant6.setLikes(1);
        restaurant6.setLocation(location6);
        restaurant6.setLogoUrl("https://example.org/example");
        restaurant6.setName("Name");
        restaurant6.setOwner(owner5);
        restaurant6.setParticipations(new HashSet<>());
        restaurant6.setPhoneNumber("6625550144");
        restaurant6.setPriceRange("Price Range");
        restaurant6.setRating(10.0d);
        restaurant6.setWaiters(new ArrayList<>());

        Owner owner6 = new Owner();
        owner6.setEmail("jane.doe@example.org");
        owner6.setId(1L);
        owner6.setName("Name");
        owner6.setPhone("6625550144");
        owner6.setRestaurant(restaurant6);

        Restaurant restaurant7 = new Restaurant();
        restaurant7.setCoverImageUrl("https://example.org/example");
        restaurant7.setCuisine("Cuisine");
        restaurant7.setDescription("The characteristics of someone or something");
        restaurant7.setEmail("jane.doe@example.org");
        restaurant7.setFoodCategories(new ArrayList<>());
        restaurant7.setId(1L);
        restaurant7.setInstagram("Instagram");
        restaurant7.setLikes(1);
        restaurant7.setLocation(location5);
        restaurant7.setLogoUrl("https://example.org/example");
        restaurant7.setName("Name");
        restaurant7.setOwner(owner6);
        restaurant7.setParticipations(new HashSet<>());
        restaurant7.setPhoneNumber("6625550144");
        restaurant7.setPriceRange("Price Range");
        restaurant7.setRating(10.0d);
        restaurant7.setWaiters(new ArrayList<>());

        FoodCategory foodCategory2 = new FoodCategory();
        foodCategory2.setId(1L);
        foodCategory2.setIsActivated(true);
        foodCategory2.setName("Name");
        foodCategory2.setProducts(new ArrayList<>());
        foodCategory2.setRestaurant(restaurant7);
        String content = (new ObjectMapper()).writeValueAsString(foodCategory2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/food-categories/{restaurantId}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(foodCategoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"message\":\"Category created successfully in restaurant Name\"}"));
    }

    /**
     * Method under test: {@link FoodCategoryController#deleteFoodCategory(Long)}
     */
    @Test
    void testDeleteFoodCategory() throws Exception {
        // Arrange
        doNothing().when(foodCategoryService).deleteFoodCategory(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/food-categories/{id}", 1L);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(foodCategoryController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link FoodCategoryController#deleteFoodCategory(Long)}
     */
    @Test
    void testDeleteFoodCategory2() throws Exception {
        // Arrange
        doNothing().when(foodCategoryService).deleteFoodCategory(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/food-categories/{id}", 1L);
        requestBuilder.contentType("https://example.org/example");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(foodCategoryController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
