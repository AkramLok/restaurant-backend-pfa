package com.example.pfabackend.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import com.example.pfabackend.entities.Client;
import com.example.pfabackend.service.ClientService;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ClientController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ClientControllerTest {
    @Autowired
    private ClientController clientController;

    @MockBean
    private ClientService clientService;

    /**
     * Method under test: {@link ClientController#getAllClients()}
     */
    @Test
    void testGetAllClients() throws Exception {
        // Arrange
        when(clientService.getAllClients()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/clients");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(clientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ClientController#getClientById(Long)}
     */
    @Test
    void testGetClientById() throws Exception {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");
        when(clientService.getClientById(Mockito.<Long>any())).thenReturn(client);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/clients/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(clientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"phone\":\"6625550144\",\"participations\":[],"
                                        + "\"favoriteRestaurants\":[]}"));
    }

    /**
     * Method under test: {@link ClientController#addFavoriteRestaurant(Long, Long)}
     */
    @Test
    void testAddFavoriteRestaurant() throws Exception {
        // Arrange
        doNothing().when(clientService).addRestaurantToFavorites(Mockito.<Long>any(), Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/clients/{clientId}/add-favorite-restaurant/{restaurantId}", 1L, 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(clientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(
                        MockMvcResultMatchers.content().string("Restaurant added to favorites successfully for client ID: 1"));
    }

    /**
     * Method under test: {@link ClientController#createClient(Client)}
     */
    @Test
    void testCreateClient() throws Exception {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");
        when(clientService.createClient(Mockito.<Client>any())).thenReturn(client);

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");
        String content = (new ObjectMapper()).writeValueAsString(client2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(clientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"phone\":\"6625550144\",\"participations\":[],"
                                        + "\"favoriteRestaurants\":[]}"));
    }

    /**
     * Method under test: {@link ClientController#updateClient(Long, Client)}
     */
    @Test
    void testUpdateClient() throws Exception {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");
        when(clientService.updateClient(Mockito.<Long>any(), Mockito.<Client>any())).thenReturn(client);

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");
        String content = (new ObjectMapper()).writeValueAsString(client2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/clients/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(clientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"phone\":\"6625550144\",\"participations\":[],"
                                        + "\"favoriteRestaurants\":[]}"));
    }

    /**
     * Method under test: {@link ClientController#deleteClient(Long)}
     */
    @Test
    void testDeleteClient() throws Exception {
        // Arrange
        doNothing().when(clientService).deleteClient(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/clients/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(clientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link ClientController#addFavoriteRestaurant(Long, Long)}
     */
    @Test
    void testAddFavoriteRestaurant2() throws Exception {
        // Arrange
        doThrow(new IllegalArgumentException("foo")).when(clientService)
                .addRestaurantToFavorites(Mockito.<Long>any(), Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/clients/{clientId}/add-favorite-restaurant/{restaurantId}", 1L, 1L);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(clientController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("foo"));
    }

    /**
     * Method under test: {@link ClientController#addFavoriteRestaurant(Long, Long)}
     */
    @Test
    void testAddFavoriteRestaurant3() throws Exception {
        // Arrange
        doNothing().when(clientService).addRestaurantToFavorites(Mockito.<Long>any(), Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/clients/{clientId}/add-favorite-restaurant/{restaurantId}", 1L, 1L);
        requestBuilder.contentType("https://example.org/example");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(clientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(
                        MockMvcResultMatchers.content().string("Restaurant added to favorites successfully for client ID: 1"));
    }
}
