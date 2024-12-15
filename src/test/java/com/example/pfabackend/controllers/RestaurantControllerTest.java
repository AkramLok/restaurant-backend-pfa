package com.example.pfabackend.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.service.RestaurantService;

import java.io.DataInputStream;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {RestaurantController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class RestaurantControllerTest {
    @Autowired
    private RestaurantController restaurantController;

    @MockBean
    private RestaurantService restaurantService;

    /**
     * Method under test: {@link RestaurantController#getAllRestaurants()}
     */
    @Test
    void testGetAllRestaurants() throws Exception {
        // Arrange
        when(restaurantService.getAllRestaurants()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/restaurants");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(restaurantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RestaurantController#getAllRestaurantsWithLinks()}
     */
    @Test
    void testGetAllRestaurantsWithLinks() throws Exception {
        // Arrange
        when(restaurantService.getAllRestaurants()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/restaurants/imagesIncluded");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(restaurantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RestaurantController#getAllRestaurantsWithLinks()}
     */
    @Test
    void testGetAllRestaurantsWithLinks2() throws Exception {
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
        owner.setName("http://localhost:8080/api/restaurants/files/");
        owner.setPhone("6625550144");
        owner.setRestaurant(new Restaurant());

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("http://localhost:8080/api/restaurants/files/");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("http://localhost:8080/api/restaurants/files/");
        restaurant.setLikes(1);
        restaurant.setLocation(location2);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("http://localhost:8080/api/restaurants/files/");
        restaurant.setOwner(owner);
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("http://localhost:8080/api/restaurants/files/");
        restaurant.setRating(10.0d);
        restaurant.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("http://localhost:8080/api/restaurants/files/");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCoverImageUrl("https://example.org/example");
        restaurant2.setCuisine("http://localhost:8080/api/restaurants/files/");
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setEmail("jane.doe@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(1L);
        restaurant2.setInstagram("http://localhost:8080/api/restaurants/files/");
        restaurant2.setLikes(1);
        restaurant2.setLocation(location);
        restaurant2.setLogoUrl("https://example.org/example");
        restaurant2.setName("http://localhost:8080/api/restaurants/files/");
        restaurant2.setOwner(owner2);
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("http://localhost:8080/api/restaurants/files/");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());

        ArrayList<Restaurant> restaurantList = new ArrayList<>();
        restaurantList.add(restaurant2);
        when(restaurantService.getAllRestaurants()).thenReturn(restaurantList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/restaurants/imagesIncluded");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(restaurantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":1,\"name\":\"http://localhost:8080/api/restaurants/files/\",\"location\":{\"latitude\":10.0,\"longitude"
                                        + "\":10.0},\"coverImageUrl\":\"http://localhost:8080/api/restaurants/files/https://example.org/example\","
                                        + "\"logoUrl\":\"http://localhost:8080/api/restaurants/files/https://example.org/example\",\"cuisine\":\"http:"
                                        + "//localhost:8080/api/restaurants/files/\",\"rating\":10.0,\"description\":\"The characteristics of someone"
                                        + " or something\",\"instagram\":\"http://localhost:8080/api/restaurants/files/\",\"phoneNumber\":\"6625550144\""
                                        + ",\"email\":\"jane.doe@example.org\",\"likes\":1,\"priceRange\":\"http://localhost:8080/api/restaurants/files/"
                                        + "\",\"participations\":[],\"waiters\":[],\"foodCategories\":[],\"owner\":{\"id\":1,\"name\":\"http://localhost:8080"
                                        + "/api/restaurants/files/\",\"email\":\"jane.doe@example.org\",\"phone\":\"6625550144\"}}]"));
    }

    /**
     * Method under test: {@link RestaurantController#getAllRestaurantsWithLinks()}
     */
    @Test
    void testGetAllRestaurantsWithLinks3() throws Exception {
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
        owner.setName("http://localhost:8080/api/restaurants/files/");
        owner.setPhone("6625550144");
        owner.setRestaurant(new Restaurant());

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("http://localhost:8080/api/restaurants/files/");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("http://localhost:8080/api/restaurants/files/");
        restaurant.setLikes(1);
        restaurant.setLocation(location2);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("http://localhost:8080/api/restaurants/files/");
        restaurant.setOwner(owner);
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("http://localhost:8080/api/restaurants/files/");
        restaurant.setRating(10.0d);
        restaurant.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("http://localhost:8080/api/restaurants/files/");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCoverImageUrl("https://example.org/example");
        restaurant2.setCuisine("http://localhost:8080/api/restaurants/files/");
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setEmail("jane.doe@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(1L);
        restaurant2.setInstagram("http://localhost:8080/api/restaurants/files/");
        restaurant2.setLikes(1);
        restaurant2.setLocation(location);
        restaurant2.setLogoUrl("https://example.org/example");
        restaurant2.setName("http://localhost:8080/api/restaurants/files/");
        restaurant2.setOwner(owner2);
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("http://localhost:8080/api/restaurants/files/");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());

        Location location3 = new Location();
        location3.setLatitude(0.5d);
        location3.setLongitude(0.5d);

        Location location4 = new Location();
        location4.setLatitude(0.5d);
        location4.setLongitude(0.5d);

        Owner owner3 = new Owner();
        owner3.setEmail("john.smith@example.org");
        owner3.setId(2L);
        owner3.setName("Name");
        owner3.setPhone("8605550118");
        owner3.setRestaurant(new Restaurant());

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("http://localhost:8080/api/restaurants/files/");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("http://localhost:8080/api/restaurants/files/");
        restaurant3.setEmail("john.smith@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(2L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(0);
        restaurant3.setLocation(location4);
        restaurant3.setLogoUrl("http://localhost:8080/api/restaurants/files/");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner3);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("8605550118");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(0.5d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("john.smith@example.org");
        owner4.setId(2L);
        owner4.setName("Name");
        owner4.setPhone("8605550118");
        owner4.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("http://localhost:8080/api/restaurants/files/");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("http://localhost:8080/api/restaurants/files/");
        restaurant4.setEmail("john.smith@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(2L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(0);
        restaurant4.setLocation(location3);
        restaurant4.setLogoUrl("http://localhost:8080/api/restaurants/files/");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner4);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("8605550118");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(0.5d);
        restaurant4.setWaiters(new ArrayList<>());

        ArrayList<Restaurant> restaurantList = new ArrayList<>();
        restaurantList.add(restaurant4);
        restaurantList.add(restaurant2);
        when(restaurantService.getAllRestaurants()).thenReturn(restaurantList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/restaurants/imagesIncluded");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(restaurantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":2,\"name\":\"Name\",\"location\":{\"latitude\":0.5,\"longitude\":0.5},\"coverImageUrl\":\"http://localhost"
                                        + ":8080/api/restaurants/files/http://localhost:8080/api/restaurants/files/\",\"logoUrl\":\"http://localhost"
                                        + ":8080/api/restaurants/files/http://localhost:8080/api/restaurants/files/\",\"cuisine\":\"Cuisine\",\"rating"
                                        + "\":0.5,\"description\":\"http://localhost:8080/api/restaurants/files/\",\"instagram\":\"Instagram\",\"phoneNumber"
                                        + "\":\"8605550118\",\"email\":\"john.smith@example.org\",\"likes\":0,\"priceRange\":\"Price Range\",\"participations"
                                        + "\":[],\"waiters\":[],\"foodCategories\":[],\"owner\":{\"id\":2,\"name\":\"Name\",\"email\":\"john.smith@example.org"
                                        + "\",\"phone\":\"8605550118\"}},{\"id\":1,\"name\":\"http://localhost:8080/api/restaurants/files/\",\"location\":{"
                                        + "\"latitude\":10.0,\"longitude\":10.0},\"coverImageUrl\":\"http://localhost:8080/api/restaurants/files/https"
                                        + "://example.org/example\",\"logoUrl\":\"http://localhost:8080/api/restaurants/files/https://example.org"
                                        + "/example\",\"cuisine\":\"http://localhost:8080/api/restaurants/files/\",\"rating\":10.0,\"description\":\"The"
                                        + " characteristics of someone or something\",\"instagram\":\"http://localhost:8080/api/restaurants/files/"
                                        + "\",\"phoneNumber\":\"6625550144\",\"email\":\"jane.doe@example.org\",\"likes\":1,\"priceRange\":\"http://localhost"
                                        + ":8080/api/restaurants/files/\",\"participations\":[],\"waiters\":[],\"foodCategories\":[],\"owner\":{\"id\":1,"
                                        + "\"name\":\"http://localhost:8080/api/restaurants/files/\",\"email\":\"jane.doe@example.org\",\"phone\":\"6625550144"
                                        + "\"}}]"));
    }

    /**
     * Method under test: {@link RestaurantController#getAllRestaurantsWithLinks()}
     */
    @Test
    void testGetAllRestaurantsWithLinks4() throws Exception {
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
        owner.setName("http://localhost:8080/api/restaurants/files/");
        owner.setPhone("6625550144");
        owner.setRestaurant(new Restaurant());

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("http://localhost:8080/api/restaurants/files/");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("http://localhost:8080/api/restaurants/files/");
        restaurant.setLikes(1);
        restaurant.setLocation(location2);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("http://localhost:8080/api/restaurants/files/");
        restaurant.setOwner(owner);
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("http://localhost:8080/api/restaurants/files/");
        restaurant.setRating(10.0d);
        restaurant.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("http://localhost:8080/api/restaurants/files/");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCoverImageUrl(null);
        restaurant2.setCuisine("http://localhost:8080/api/restaurants/files/");
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setEmail("jane.doe@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(1L);
        restaurant2.setInstagram("http://localhost:8080/api/restaurants/files/");
        restaurant2.setLikes(1);
        restaurant2.setLocation(location);
        restaurant2.setLogoUrl("https://example.org/example");
        restaurant2.setName("http://localhost:8080/api/restaurants/files/");
        restaurant2.setOwner(owner2);
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("http://localhost:8080/api/restaurants/files/");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());

        Location location3 = new Location();
        location3.setLatitude(0.5d);
        location3.setLongitude(0.5d);

        Location location4 = new Location();
        location4.setLatitude(0.5d);
        location4.setLongitude(0.5d);

        Owner owner3 = new Owner();
        owner3.setEmail("john.smith@example.org");
        owner3.setId(2L);
        owner3.setName("Name");
        owner3.setPhone("8605550118");
        owner3.setRestaurant(new Restaurant());

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("http://localhost:8080/api/restaurants/files/");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("http://localhost:8080/api/restaurants/files/");
        restaurant3.setEmail("john.smith@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(2L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(0);
        restaurant3.setLocation(location4);
        restaurant3.setLogoUrl("http://localhost:8080/api/restaurants/files/");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner3);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("8605550118");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(0.5d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("john.smith@example.org");
        owner4.setId(2L);
        owner4.setName("Name");
        owner4.setPhone("8605550118");
        owner4.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("http://localhost:8080/api/restaurants/files/");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("http://localhost:8080/api/restaurants/files/");
        restaurant4.setEmail("john.smith@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(2L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(0);
        restaurant4.setLocation(location3);
        restaurant4.setLogoUrl("http://localhost:8080/api/restaurants/files/");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner4);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("8605550118");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(0.5d);
        restaurant4.setWaiters(new ArrayList<>());

        ArrayList<Restaurant> restaurantList = new ArrayList<>();
        restaurantList.add(restaurant4);
        restaurantList.add(restaurant2);
        when(restaurantService.getAllRestaurants()).thenReturn(restaurantList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/restaurants/imagesIncluded");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(restaurantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":2,\"name\":\"Name\",\"location\":{\"latitude\":0.5,\"longitude\":0.5},\"coverImageUrl\":\"http://localhost"
                                        + ":8080/api/restaurants/files/http://localhost:8080/api/restaurants/files/\",\"logoUrl\":\"http://localhost"
                                        + ":8080/api/restaurants/files/http://localhost:8080/api/restaurants/files/\",\"cuisine\":\"Cuisine\",\"rating"
                                        + "\":0.5,\"description\":\"http://localhost:8080/api/restaurants/files/\",\"instagram\":\"Instagram\",\"phoneNumber"
                                        + "\":\"8605550118\",\"email\":\"john.smith@example.org\",\"likes\":0,\"priceRange\":\"Price Range\",\"participations"
                                        + "\":[],\"waiters\":[],\"foodCategories\":[],\"owner\":{\"id\":2,\"name\":\"Name\",\"email\":\"john.smith@example.org\""
                                        + ",\"phone\":\"8605550118\"}},{\"id\":1,\"name\":\"http://localhost:8080/api/restaurants/files/\",\"location\":{"
                                        + "\"latitude\":10.0,\"longitude\":10.0},\"coverImageUrl\":null,\"logoUrl\":\"http://localhost:8080/api/restaurants"
                                        + "/files/https://example.org/example\",\"cuisine\":\"http://localhost:8080/api/restaurants/files/\",\"rating"
                                        + "\":10.0,\"description\":\"The characteristics of someone or something\",\"instagram\":\"http://localhost:8080"
                                        + "/api/restaurants/files/\",\"phoneNumber\":\"6625550144\",\"email\":\"jane.doe@example.org\",\"likes\":1,\"priceRange"
                                        + "\":\"http://localhost:8080/api/restaurants/files/\",\"participations\":[],\"waiters\":[],\"foodCategories\":["
                                        + "],\"owner\":{\"id\":1,\"name\":\"http://localhost:8080/api/restaurants/files/\",\"email\":\"jane.doe@example.org"
                                        + "\",\"phone\":\"6625550144\"}}]"));
    }

    /**
     * Method under test: {@link RestaurantController#getAllRestaurantsWithLinks()}
     */
    @Test
    void testGetAllRestaurantsWithLinks5() throws Exception {
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
        owner.setName("http://localhost:8080/api/restaurants/files/");
        owner.setPhone("6625550144");
        owner.setRestaurant(new Restaurant());

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("http://localhost:8080/api/restaurants/files/");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("http://localhost:8080/api/restaurants/files/");
        restaurant.setLikes(1);
        restaurant.setLocation(location2);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("http://localhost:8080/api/restaurants/files/");
        restaurant.setOwner(owner);
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("http://localhost:8080/api/restaurants/files/");
        restaurant.setRating(10.0d);
        restaurant.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("http://localhost:8080/api/restaurants/files/");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCoverImageUrl("https://example.org/example");
        restaurant2.setCuisine("http://localhost:8080/api/restaurants/files/");
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setEmail("jane.doe@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(1L);
        restaurant2.setInstagram("http://localhost:8080/api/restaurants/files/");
        restaurant2.setLikes(1);
        restaurant2.setLocation(location);
        restaurant2.setLogoUrl(null);
        restaurant2.setName("http://localhost:8080/api/restaurants/files/");
        restaurant2.setOwner(owner2);
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("http://localhost:8080/api/restaurants/files/");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());

        Location location3 = new Location();
        location3.setLatitude(0.5d);
        location3.setLongitude(0.5d);

        Location location4 = new Location();
        location4.setLatitude(0.5d);
        location4.setLongitude(0.5d);

        Owner owner3 = new Owner();
        owner3.setEmail("john.smith@example.org");
        owner3.setId(2L);
        owner3.setName("Name");
        owner3.setPhone("8605550118");
        owner3.setRestaurant(new Restaurant());

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("http://localhost:8080/api/restaurants/files/");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("http://localhost:8080/api/restaurants/files/");
        restaurant3.setEmail("john.smith@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(2L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(0);
        restaurant3.setLocation(location4);
        restaurant3.setLogoUrl("http://localhost:8080/api/restaurants/files/");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner3);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("8605550118");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(0.5d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("john.smith@example.org");
        owner4.setId(2L);
        owner4.setName("Name");
        owner4.setPhone("8605550118");
        owner4.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("http://localhost:8080/api/restaurants/files/");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("http://localhost:8080/api/restaurants/files/");
        restaurant4.setEmail("john.smith@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(2L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(0);
        restaurant4.setLocation(location3);
        restaurant4.setLogoUrl("http://localhost:8080/api/restaurants/files/");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner4);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("8605550118");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(0.5d);
        restaurant4.setWaiters(new ArrayList<>());

        ArrayList<Restaurant> restaurantList = new ArrayList<>();
        restaurantList.add(restaurant4);
        restaurantList.add(restaurant2);
        when(restaurantService.getAllRestaurants()).thenReturn(restaurantList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/restaurants/imagesIncluded");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(restaurantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":2,\"name\":\"Name\",\"location\":{\"latitude\":0.5,\"longitude\":0.5},\"coverImageUrl\":\"http://localhost"
                                        + ":8080/api/restaurants/files/http://localhost:8080/api/restaurants/files/\",\"logoUrl\":\"http://localhost"
                                        + ":8080/api/restaurants/files/http://localhost:8080/api/restaurants/files/\",\"cuisine\":\"Cuisine\",\"rating"
                                        + "\":0.5,\"description\":\"http://localhost:8080/api/restaurants/files/\",\"instagram\":\"Instagram\",\"phoneNumber"
                                        + "\":\"8605550118\",\"email\":\"john.smith@example.org\",\"likes\":0,\"priceRange\":\"Price Range\",\"participations"
                                        + "\":[],\"waiters\":[],\"foodCategories\":[],\"owner\":{\"id\":2,\"name\":\"Name\",\"email\":\"john.smith@example.org\""
                                        + ",\"phone\":\"8605550118\"}},{\"id\":1,\"name\":\"http://localhost:8080/api/restaurants/files/\",\"location\":{"
                                        + "\"latitude\":10.0,\"longitude\":10.0},\"coverImageUrl\":\"http://localhost:8080/api/restaurants/files/https"
                                        + "://example.org/example\",\"logoUrl\":null,\"cuisine\":\"http://localhost:8080/api/restaurants/files/\",\"rating"
                                        + "\":10.0,\"description\":\"The characteristics of someone or something\",\"instagram\":\"http://localhost:8080"
                                        + "/api/restaurants/files/\",\"phoneNumber\":\"6625550144\",\"email\":\"jane.doe@example.org\",\"likes\":1,\"priceRange"
                                        + "\":\"http://localhost:8080/api/restaurants/files/\",\"participations\":[],\"waiters\":[],\"foodCategories\":["
                                        + "],\"owner\":{\"id\":1,\"name\":\"http://localhost:8080/api/restaurants/files/\",\"email\":\"jane.doe@example.org"
                                        + "\",\"phone\":\"6625550144\"}}]"));
    }

    /**
     * Method under test: {@link RestaurantController#getRestaurantById(Long)}
     */
    @Test
    void testGetRestaurantById() throws Exception {
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
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/restaurants/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(restaurantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"name\":\"Name\",\"location\":{\"latitude\":10.0,\"longitude\":10.0},\"coverImageUrl\":\"https://example"
                                        + ".org/example\",\"logoUrl\":\"https://example.org/example\",\"cuisine\":\"Cuisine\",\"rating\":10.0,\"description\":\"The"
                                        + " characteristics of someone or something\",\"instagram\":\"Instagram\",\"phoneNumber\":\"6625550144\",\"email"
                                        + "\":\"jane.doe@example.org\",\"likes\":1,\"priceRange\":\"Price Range\",\"participations\":[],\"waiters\":[],"
                                        + "\"foodCategories\":[],\"owner\":{\"id\":1,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"phone\":\"6625550144"
                                        + "\"}}"));
    }

    /**
     * Method under test: {@link RestaurantController#getRestaurantByOwnerId(Long)}
     */
    @Test
    void testGetRestaurantByOwnerId() throws Exception {
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
        when(restaurantService.getRestaurantByOwnerId(Mockito.<Long>any())).thenReturn(restaurant3);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/restaurants/owner/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(restaurantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"name\":\"Name\",\"location\":{\"latitude\":10.0,\"longitude\":10.0},\"coverImageUrl\":\"https://example"
                                        + ".org/example\",\"logoUrl\":\"https://example.org/example\",\"cuisine\":\"Cuisine\",\"rating\":10.0,\"description\":\"The"
                                        + " characteristics of someone or something\",\"instagram\":\"Instagram\",\"phoneNumber\":\"6625550144\",\"email"
                                        + "\":\"jane.doe@example.org\",\"likes\":1,\"priceRange\":\"Price Range\",\"participations\":[],\"waiters\":[],"
                                        + "\"foodCategories\":[],\"owner\":{\"id\":1,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"phone\":\"6625550144"
                                        + "\"}}"));
    }

    /**
     * Method under test:
     * {@link RestaurantController#createRestaurant(Restaurant, MultipartFile, MultipartFile, String)}
     */
    @Test
    void testCreateRestaurant() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/restaurants");
        MockHttpServletRequestBuilder paramResult = postResult.param("coverFile",
                String.valueOf(new MockMultipartFile("Name", (InputStream) null)));
        MockHttpServletRequestBuilder requestBuilder = paramResult
                .param("logoFile", String.valueOf(new MockMultipartFile("Name", (InputStream) null)))
                .param("ownerId", "foo");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(restaurantController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link RestaurantController#deleteRestaurant(Long)}
     */
    @Test
    void testDeleteRestaurant() throws Exception {
        // Arrange
        doNothing().when(restaurantService).deleteRestaurant(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/restaurants/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(restaurantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link RestaurantController#deleteRestaurant(Long)}
     */
    @Test
    void testDeleteRestaurant2() throws Exception {
        // Arrange
        doNothing().when(restaurantService).deleteRestaurant(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/restaurants/{id}", 1L);
        requestBuilder.contentType("https://example.org/example");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(restaurantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test:
     * {@link RestaurantController#createRestaurant(Restaurant, MultipartFile, MultipartFile, String)}
     */
    @Test
    void testCreateRestaurant2() throws Exception {
        // Arrange
        DataInputStream contentStream = mock(DataInputStream.class);
        when(contentStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
        doNothing().when(contentStream).close();
        MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.post("/api/restaurants")
                .param("coverFile", String.valueOf(new MockMultipartFile("Name", contentStream)));
        MockHttpServletRequestBuilder requestBuilder = paramResult
                .param("logoFile", String.valueOf(new MockMultipartFile("Name", (InputStream) null)))
                .param("ownerId", "foo");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(restaurantController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link RestaurantController#getFile(String)}
     */
    @Test
    void testGetFile() throws Exception {
        // Arrange
        when(restaurantService.load(Mockito.<String>any())).thenReturn(new ByteArrayResource("AXAXAXAX".getBytes("UTF-8")));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/restaurants/files/{filename:[a-zA-Z0-9._-]+}", "U");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(restaurantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("AXAXAXAX"));
    }

    /**
     * Method under test:
     * {@link RestaurantController#updateRestaurant(Restaurant, MultipartFile, MultipartFile, String)}
     */
    @Test
    void testUpdateRestaurant() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders.put("/api/restaurants");
        MockHttpServletRequestBuilder paramResult = putResult.param("coverFile",
                String.valueOf(new MockMultipartFile("Name", (InputStream) null)));
        MockHttpServletRequestBuilder requestBuilder = paramResult
                .param("logoFile", String.valueOf(new MockMultipartFile("Name", (InputStream) null)))
                .param("restaurantId", "foo");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(restaurantController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test:
     * {@link RestaurantController#updateRestaurant(Restaurant, MultipartFile, MultipartFile, String)}
     */
    @Test
    void testUpdateRestaurant2() throws Exception {
        // Arrange
        DataInputStream contentStream = mock(DataInputStream.class);
        when(contentStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
        doNothing().when(contentStream).close();
        MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.put("/api/restaurants")
                .param("coverFile", String.valueOf(new MockMultipartFile("Name", contentStream)));
        MockHttpServletRequestBuilder requestBuilder = paramResult
                .param("logoFile", String.valueOf(new MockMultipartFile("Name", (InputStream) null)))
                .param("restaurantId", "foo");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(restaurantController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}
