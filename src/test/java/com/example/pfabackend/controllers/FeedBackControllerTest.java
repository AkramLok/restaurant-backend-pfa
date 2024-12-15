package com.example.pfabackend.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.pfabackend.entities.Client;
import com.example.pfabackend.entities.FeedBack;
import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.service.FeedBackService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {FeedBackController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class FeedBackControllerTest {
    @Autowired
    private FeedBackController feedBackController;

    @MockBean
    private FeedBackService feedBackService;

    /**
     * Method under test: {@link FeedBackController#getAllFeedBacks()}
     */
    @Test
    void testGetAllFeedBacks() throws Exception {
        // Arrange
        when(feedBackService.getAllFeedBacks()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/feedback");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(feedBackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link FeedBackController#getAllFeedBacks()}
     */
    @Test
    void testGetAllFeedBacks2() throws Exception {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

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

        FeedBack feedBack = new FeedBack();
        feedBack.setClient(client);
        feedBack.setDescription("The characteristics of someone or something");
        feedBack.setId(1L);
        feedBack.setRating(1);
        feedBack.setRestaurant(restaurant2);

        ArrayList<FeedBack> feedBackList = new ArrayList<>();
        feedBackList.add(feedBack);
        when(feedBackService.getAllFeedBacks()).thenReturn(feedBackList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/feedback");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(feedBackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("[{\"id\":1,\"description\":\"The characteristics of someone or something\",\"rating\":1}]"));
    }

    /**
     * Method under test: {@link FeedBackController#getAllFeedBacks()}
     */
    @Test
    void testGetAllFeedBacks3() throws Exception {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

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

        FeedBack feedBack = new FeedBack();
        feedBack.setClient(client);
        feedBack.setDescription("The characteristics of someone or something");
        feedBack.setId(1L);
        feedBack.setRating(1);
        feedBack.setRestaurant(restaurant2);

        Client client2 = new Client();
        client2.setEmail("john.smith@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(2L);
        client2.setName("com.example.pfabackend.entities.Client");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("8605550118");

        Location location2 = new Location();
        location2.setLatitude(0.5d);
        location2.setLongitude(0.5d);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("Cover Image Url");
        restaurant3.setCuisine("42");
        restaurant3.setDescription("Description");
        restaurant3.setEmail("john.smith@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(2L);
        restaurant3.setInstagram("42");
        restaurant3.setLikes(0);
        restaurant3.setLocation(new Location());
        restaurant3.setLogoUrl("Logo Url");
        restaurant3.setName("42");
        restaurant3.setOwner(new Owner());
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("8605550118");
        restaurant3.setPriceRange("42");
        restaurant3.setRating(0.5d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("john.smith@example.org");
        owner2.setId(2L);
        owner2.setName("com.example.pfabackend.entities.Owner");
        owner2.setPhone("8605550118");
        owner2.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("Cover Image Url");
        restaurant4.setCuisine("42");
        restaurant4.setDescription("Description");
        restaurant4.setEmail("john.smith@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(2L);
        restaurant4.setInstagram("42");
        restaurant4.setLikes(0);
        restaurant4.setLocation(location2);
        restaurant4.setLogoUrl("Logo Url");
        restaurant4.setName("42");
        restaurant4.setOwner(owner2);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("8605550118");
        restaurant4.setPriceRange("42");
        restaurant4.setRating(0.5d);
        restaurant4.setWaiters(new ArrayList<>());

        FeedBack feedBack2 = new FeedBack();
        feedBack2.setClient(client2);
        feedBack2.setDescription("Description");
        feedBack2.setId(2L);
        feedBack2.setRating(0);
        feedBack2.setRestaurant(restaurant4);

        ArrayList<FeedBack> feedBackList = new ArrayList<>();
        feedBackList.add(feedBack2);
        feedBackList.add(feedBack);
        when(feedBackService.getAllFeedBacks()).thenReturn(feedBackList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/feedback");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(feedBackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":2,\"description\":\"Description\",\"rating\":0},{\"id\":1,\"description\":\"The characteristics of someone"
                                        + " or something\",\"rating\":1}]"));
    }

    /**
     * Method under test:
     * {@link FeedBackController#getAllFeedBacksForRestaurant(Long)}
     */
    @Test
    void testGetAllFeedBacksForRestaurant() throws Exception {
        // Arrange
        when(feedBackService.getAllFeedBacksForRestaurant(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/feedback/restaurant/{restaurantId}",
                1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(feedBackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link FeedBackController#getAllFeedBacksForClient(Long)}
     */
    @Test
    void testGetAllFeedBacksForClient() throws Exception {
        // Arrange
        when(feedBackService.getAllFeedBacksForClient(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/feedback/client/{clientId}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(feedBackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test:
     * {@link FeedBackController#postFeedBack(Long, Long, FeedBack)}
     */
    @Test
    void testPostFeedBack() throws Exception {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

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

        FeedBack feedBack = new FeedBack();
        feedBack.setClient(client);
        feedBack.setDescription("The characteristics of someone or something");
        feedBack.setId(1L);
        feedBack.setRating(1);
        feedBack.setRestaurant(restaurant2);
        when(feedBackService.postFeedBack(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<FeedBack>any()))
                .thenReturn(feedBack);

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");

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

        FeedBack feedBack2 = new FeedBack();
        feedBack2.setClient(client2);
        feedBack2.setDescription("The characteristics of someone or something");
        feedBack2.setId(1L);
        feedBack2.setRating(1);
        feedBack2.setRestaurant(restaurant4);
        String content = (new ObjectMapper()).writeValueAsString(feedBack2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/feedback/restaurant/{restaurantId}/client/{clientId}", 1L, 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(feedBackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"description\":\"The characteristics of someone or something\",\"rating\":1,\"client\":{\"id\":1,\"name"
                                        + "\":\"Name\",\"email\":\"jane.doe@example.org\",\"phone\":\"6625550144\",\"participations\":[],\"favoriteRestaurants"
                                        + "\":[]},\"restaurant\":{\"id\":1,\"name\":\"Name\",\"location\":{\"latitude\":10.0,\"longitude\":10.0},\"coverImageUrl"
                                        + "\":\"https://example.org/example\",\"logoUrl\":\"https://example.org/example\",\"cuisine\":\"Cuisine\",\"rating\""
                                        + ":10.0,\"description\":\"The characteristics of someone or something\",\"instagram\":\"Instagram\",\"phoneNumber"
                                        + "\":\"6625550144\",\"email\":\"jane.doe@example.org\",\"likes\":1,\"priceRange\":\"Price Range\",\"participations\":"
                                        + "[],\"waiters\":[],\"foodCategories\":[],\"owner\":{\"id\":1,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"phone"
                                        + "\":\"6625550144\"}}}"));
    }

    /**
     * Method under test: {@link FeedBackController#deleteFeedBack(Long)}
     */
    @Test
    void testDeleteFeedBack() throws Exception {
        // Arrange
        doNothing().when(feedBackService).deleteFeedBack(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/feedback/{feedBackId}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(feedBackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link FeedBackController#deleteFeedBack(Long)}
     */
    @Test
    void testDeleteFeedBack2() throws Exception {
        // Arrange
        doNothing().when(feedBackService).deleteFeedBack(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/feedback/{feedBackId}", 1L);
        requestBuilder.contentType("https://example.org/example");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(feedBackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
