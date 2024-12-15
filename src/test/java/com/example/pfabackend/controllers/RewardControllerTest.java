package com.example.pfabackend.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.pfabackend.entities.FoodCategory;
import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Product;
import com.example.pfabackend.entities.ProductCollection;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.entities.Reward;
import com.example.pfabackend.service.RewardService;
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

@ContextConfiguration(classes = {RewardController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class RewardControllerTest {
    @Autowired
    private RewardController rewardController;

    @MockBean
    private RewardService rewardService;

    /**
     * Method under test: {@link RewardController#getAllRewards()}
     */
    @Test
    void testGetAllRewards() throws Exception {
        // Arrange
        when(rewardService.getAllRewards()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/reward");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(rewardController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RewardController#getAllRewardsForRestaurant(Long)}
     */
    @Test
    void testGetAllRewardsForRestaurant() throws Exception {
        // Arrange
        when(rewardService.getAllRewardsForRestaurant(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/reward/restaurant/{restaurantId}",
                1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(rewardController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RewardController#getRewardByProductId(Long)}
     */
    @Test
    void testGetRewardByProductId() throws Exception {
        // Arrange
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

        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(new Restaurant());

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

        ProductCollection productCollection = new ProductCollection();
        productCollection.setId(1L);
        productCollection.setProducts(new HashSet<>());
        productCollection.setRestaurant(restaurant2);
        productCollection.setTotalPrice(10.0d);

        Reward reward = new Reward();
        reward.setId(1L);
        reward.setProduct(product);
        reward.setProductCollection(productCollection);
        reward.setRequiredPoints(1);
        Optional<Reward> ofResult = Optional.of(reward);
        when(rewardService.getRewardByProductId(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/reward/product/{productId}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(rewardController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"product\":{\"id\":1,\"name\":\"Name\",\"price\":10.0,\"bonusPoints\":1,\"info\":\"Info\",\"img\":\"Img\","
                                        + "\"isActivated\":true},\"productCollection\":{\"id\":1,\"products\":[],\"totalPrice\":10.0,\"restaurant\":{\"id\":1"
                                        + ",\"name\":\"Name\",\"location\":{\"latitude\":10.0,\"longitude\":10.0},\"coverImageUrl\":\"https://example.org"
                                        + "/example\",\"logoUrl\":\"https://example.org/example\",\"cuisine\":\"Cuisine\",\"rating\":10.0,\"description\":\"The"
                                        + " characteristics of someone or something\",\"instagram\":\"Instagram\",\"phoneNumber\":\"6625550144\",\"email\""
                                        + ":\"jane.doe@example.org\",\"likes\":1,\"priceRange\":\"Price Range\",\"participations\":[],\"waiters\":[],"
                                        + "\"foodCategories\":[],\"owner\":{\"id\":1,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"phone\":\"6625550144"
                                        + "\"}}},\"requiredPoints\":1}"));
    }

    /**
     * Method under test:
     * {@link RewardController#createOrUpdateReward(Long, Reward)}
     */
    @Test
    void testCreateOrUpdateReward() throws Exception {
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

        ProductCollection productCollection = new ProductCollection();
        productCollection.setId(1L);
        productCollection.setProducts(new HashSet<>());
        productCollection.setRestaurant(restaurant3);
        productCollection.setTotalPrice(10.0d);

        Reward reward = new Reward();
        reward.setId(1L);
        reward.setProduct(product);
        reward.setProductCollection(productCollection);
        reward.setRequiredPoints(1);
        when(rewardService.createOrUpdateReward(Mockito.<Long>any(), Mockito.<Reward>any())).thenReturn(reward);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

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
        restaurant4.setLocation(location3);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner3);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        FoodCategory category2 = new FoodCategory();
        category2.setId(1L);
        category2.setIsActivated(true);
        category2.setName("Name");
        category2.setProducts(new ArrayList<>());
        category2.setRestaurant(restaurant4);

        Product product2 = new Product();
        product2.setBonusPoints(1);
        product2.setCategory(category2);
        product2.setId(1L);
        product2.setImg("Img");
        product2.setInfo("Info");
        product2.setIsActivated(true);
        product2.setName("Name");
        product2.setPrice(10.0d);

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

        ProductCollection productCollection2 = new ProductCollection();
        productCollection2.setId(1L);
        productCollection2.setProducts(new HashSet<>());
        productCollection2.setRestaurant(restaurant6);
        productCollection2.setTotalPrice(10.0d);

        Reward reward2 = new Reward();
        reward2.setId(1L);
        reward2.setProduct(product2);
        reward2.setProductCollection(productCollection2);
        reward2.setRequiredPoints(1);
        String content = (new ObjectMapper()).writeValueAsString(reward2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/reward/product/{productId}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(rewardController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"message\":\"Reward of number of points 1 created successfully of the product Name\"}"));
    }

    /**
     * Method under test: {@link RewardController#deleteReward(Long)}
     */
    @Test
    void testDeleteReward() throws Exception {
        // Arrange
        doNothing().when(rewardService).deleteReward(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/reward/{rewardId}", 1L);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(rewardController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link RewardController#deleteReward(Long)}
     */
    @Test
    void testDeleteReward2() throws Exception {
        // Arrange
        doNothing().when(rewardService).deleteReward(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/reward/{rewardId}", 1L);
        requestBuilder.contentType("https://example.org/example");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(rewardController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link RewardController#UpdateReward(Long, Reward)}
     */
    @Test
    void testUpdateReward() throws Exception {
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

        ProductCollection productCollection = new ProductCollection();
        productCollection.setId(1L);
        productCollection.setProducts(new HashSet<>());
        productCollection.setRestaurant(restaurant3);
        productCollection.setTotalPrice(10.0d);

        Reward reward = new Reward();
        reward.setId(1L);
        reward.setProduct(product);
        reward.setProductCollection(productCollection);
        reward.setRequiredPoints(1);
        when(rewardService.createOrUpdateReward(Mockito.<Long>any(), Mockito.<Reward>any())).thenReturn(reward);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

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
        restaurant4.setLocation(location3);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner3);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        FoodCategory category2 = new FoodCategory();
        category2.setId(1L);
        category2.setIsActivated(true);
        category2.setName("Name");
        category2.setProducts(new ArrayList<>());
        category2.setRestaurant(restaurant4);

        Product product2 = new Product();
        product2.setBonusPoints(1);
        product2.setCategory(category2);
        product2.setId(1L);
        product2.setImg("Img");
        product2.setInfo("Info");
        product2.setIsActivated(true);
        product2.setName("Name");
        product2.setPrice(10.0d);

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

        ProductCollection productCollection2 = new ProductCollection();
        productCollection2.setId(1L);
        productCollection2.setProducts(new HashSet<>());
        productCollection2.setRestaurant(restaurant6);
        productCollection2.setTotalPrice(10.0d);

        Reward reward2 = new Reward();
        reward2.setId(1L);
        reward2.setProduct(product2);
        reward2.setProductCollection(productCollection2);
        reward2.setRequiredPoints(1);
        String content = (new ObjectMapper()).writeValueAsString(reward2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/reward/product/{productId}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(rewardController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"message\":\"Reward of number of points 1 updated successfully of the product Name\"}"));
    }
}
