package com.example.pfabackend.controllers;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.pfabackend.dto.ParticipationConverter;
import com.example.pfabackend.dto.ParticipationDTO;
import com.example.pfabackend.entities.Client;
import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Participation;
import com.example.pfabackend.entities.ParticipationId;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.service.ParticipationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

@ContextConfiguration(classes = {ParticipationController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ParticipationControllerTest {
    @Autowired
    private ParticipationController participationController;

    @MockBean
    private ParticipationConverter participationConverter;

    @MockBean
    private ParticipationService participationService;

    /**
     * Method under test: {@link ParticipationController#getAllParticipations()}
     */
    @Test
    void testGetAllParticipations() throws Exception {
        // Arrange
        when(participationConverter.convertToDtoList(Mockito.<List<Participation>>any())).thenReturn(new ArrayList<>());
        when(participationService.getAllParticipations()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/participation");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(participationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test:
     * {@link ParticipationController#getAllParticipationsForRestaurant(Long)}
     */
    @Test
    void testGetAllParticipationsForRestaurant() throws Exception {
        // Arrange
        when(participationConverter.convertToDtoList(Mockito.<List<Participation>>any())).thenReturn(new ArrayList<>());
        when(participationService.getAllParticipationsForRestaurant(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/participation/restaurant/{restaurantId}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(participationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test:
     * {@link ParticipationController#getAllParticipationsForClient(Long)}
     */
    @Test
    void testGetAllParticipationsForClient() throws Exception {
        // Arrange
        when(participationConverter.convertToDtoList(Mockito.<List<Participation>>any())).thenReturn(new ArrayList<>());
        when(participationService.getAllParticipationsForClient(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/participation/client/{clientId}",
                1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(participationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test:
     * {@link ParticipationController#createParticipation(ParticipationDTO)}
     */
    @Test
    void testCreateParticipation() throws Exception {
        // Arrange
        when(participationConverter.convertToDto(Mockito.<Participation>any())).thenReturn(new ParticipationDTO());

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

        Participation participation = new Participation();
        participation.setClient(client);
        participation.setId(new ParticipationId());
        participation.setPoints(1);
        participation.setRestaurant(restaurant2);
        when(participationService.createParticipation(Mockito.<Long>any(), Mockito.<Long>any(), anyInt()))
                .thenReturn(participation);

        ParticipationDTO participationDTO = new ParticipationDTO();
        participationDTO.setClientId(1L);
        participationDTO.setPoints(1);
        participationDTO.setRestaurantId(1L);
        String content = (new ObjectMapper()).writeValueAsString(participationDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/participation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(participationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"clientId\":null,\"restaurantId\":null,\"points\":0}"));
    }

    /**
     * Method under test:
     * {@link ParticipationController#deleteParticipation(Long, Long)}
     */
    @Test
    void testDeleteParticipation() throws Exception {
        // Arrange
        doNothing().when(participationService).deleteParticipation(Mockito.<Long>any(), Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/api/participation/{clientId}/{restaurantId}", 1L, 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(participationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"message\":\"Participation with clientId 1 and restaurantId 1 deleted successfully.\"}"));
    }

    /**
     * Method under test:
     * {@link ParticipationController#deleteParticipation(Long, Long)}
     */
    @Test
    void testDeleteParticipation2() throws Exception {
        // Arrange
        doNothing().when(participationService).deleteParticipation(Mockito.<Long>any(), Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/api/participation/{clientId}/{restaurantId}", 1L, 1L);
        requestBuilder.contentType("https://example.org/example");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(participationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"message\":\"Participation with clientId 1 and restaurantId 1 deleted successfully.\"}"));
    }

    /**
     * Method under test: {@link ParticipationController#addPoints(Long, Long, int)}
     */
    @Test
    void testAddPoints() throws Exception {
        // Arrange
        doNothing().when(participationService).addPoints(Mockito.<Long>any(), Mockito.<Long>any(), anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/participation/add-points/{clientId}/{restaurantId}/{pointsToAdd}", 1L, 1L, 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(participationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Points added successfully!\"}"));
    }

    /**
     * Method under test: {@link ParticipationController#addPoints(Long, Long, int)}
     */
    @Test
    void testAddPoints2() throws Exception {
        // Arrange
        doNothing().when(participationService).addPoints(Mockito.<Long>any(), Mockito.<Long>any(), anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/participation/add-points/{clientId}/{restaurantId}/{pointsToAdd}", 1L, 1L, 1);
        requestBuilder.contentType("https://example.org/example");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(participationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Points added successfully!\"}"));
    }

    /**
     * Method under test:
     * {@link ParticipationController#reducePoints(Long, Long, int)}
     */
    @Test
    void testReducePoints() throws Exception {
        // Arrange
        doNothing().when(participationService).reducePoints(Mockito.<Long>any(), Mockito.<Long>any(), anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/participation/reduce-points/{clientId}/{restaurantId}/{pointsToReduce}", 1L, 1L, 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(participationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Points reduced successfully!\"}"));
    }

    /**
     * Method under test:
     * {@link ParticipationController#reducePoints(Long, Long, int)}
     */
    @Test
    void testReducePoints2() throws Exception {
        // Arrange
        doNothing().when(participationService).reducePoints(Mockito.<Long>any(), Mockito.<Long>any(), anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/participation/reduce-points/{clientId}/{restaurantId}/{pointsToReduce}", 1L, 1L, 1);
        requestBuilder.contentType("https://example.org/example");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(participationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Points reduced successfully!\"}"));
    }
}
