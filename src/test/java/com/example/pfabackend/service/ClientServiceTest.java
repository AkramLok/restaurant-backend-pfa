package com.example.pfabackend.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.pfabackend.entities.Client;
import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.repository.ClientRepository;
import com.example.pfabackend.repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ClientService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ClientServiceTest {
    @MockBean
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    @MockBean
    private RestaurantRepository restaurantRepository;

    /**
     * Method under test: {@link ClientService#getAllClients()}
     */
    @Test
    void testGetAllClients() {
        // Arrange
        ArrayList<Client> clientList = new ArrayList<>();
        when(clientRepository.findAll()).thenReturn(clientList);

        // Act
        List<Client> actualAllClients = clientService.getAllClients();

        // Assert
        verify(clientRepository).findAll();
        assertTrue(actualAllClients.isEmpty());
        assertSame(clientList, actualAllClients);
    }

    /**
     * Method under test: {@link ClientService#getAllClients()}
     */
    @Test
    void testGetAllClients2() {
        // Arrange
        when(clientRepository.findAll()).thenThrow(new IllegalArgumentException("foo"));

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> clientService.getAllClients());
        verify(clientRepository).findAll();
    }

    /**
     * Method under test: {@link ClientService#getClientById(Long)}
     */
    @Test
    void testGetClientById() {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");
        Optional<Client> ofResult = Optional.of(client);
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Client actualClientById = clientService.getClientById(1L);

        // Assert
        verify(clientRepository).findById(eq(1L));
        assertSame(client, actualClientById);
    }

    /**
     * Method under test: {@link ClientService#getClientById(Long)}
     */
    @Test
    void testGetClientById2() {
        // Arrange
        when(clientRepository.findById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("foo"));

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> clientService.getClientById(1L));
        verify(clientRepository).findById(eq(1L));
    }

    /**
     * Method under test: {@link ClientService#createClient(Client)}
     */
    @Test
    void testCreateClient() {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");
        when(clientRepository.save(Mockito.<Client>any())).thenReturn(client);

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");

        // Act
        Client actualCreateClientResult = clientService.createClient(client2);

        // Assert
        verify(clientRepository).save(isA(Client.class));
        assertSame(client, actualCreateClientResult);
    }

    /**
     * Method under test: {@link ClientService#createClient(Client)}
     */
    @Test
    void testCreateClient2() {
        // Arrange
        when(clientRepository.save(Mockito.<Client>any())).thenThrow(new IllegalArgumentException("foo"));

        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> clientService.createClient(client));
        verify(clientRepository).save(isA(Client.class));
    }

    /**
     * Method under test: {@link ClientService#updateClient(Long, Client)}
     */
    @Test
    void testUpdateClient() {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");
        Optional<Client> ofResult = Optional.of(client);

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");
        when(clientRepository.save(Mockito.<Client>any())).thenReturn(client2);
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Client updatedClient = new Client();
        updatedClient.setEmail("jane.doe@example.org");
        updatedClient.setFavoriteRestaurants(new HashSet<>());
        updatedClient.setId(1L);
        updatedClient.setName("Name");
        updatedClient.setParticipations(new HashSet<>());
        updatedClient.setPhone("6625550144");

        // Act
        Client actualUpdateClientResult = clientService.updateClient(1L, updatedClient);

        // Assert
        verify(clientRepository).findById(eq(1L));
        verify(clientRepository).save(isA(Client.class));
        assertSame(client2, actualUpdateClientResult);
    }

    /**
     * Method under test: {@link ClientService#updateClient(Long, Client)}
     */
    @Test
    void testUpdateClient2() {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");
        Optional<Client> ofResult = Optional.of(client);
        when(clientRepository.save(Mockito.<Client>any())).thenThrow(new IllegalArgumentException("foo"));
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Client updatedClient = new Client();
        updatedClient.setEmail("jane.doe@example.org");
        updatedClient.setFavoriteRestaurants(new HashSet<>());
        updatedClient.setId(1L);
        updatedClient.setName("Name");
        updatedClient.setParticipations(new HashSet<>());
        updatedClient.setPhone("6625550144");

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> clientService.updateClient(1L, updatedClient));
        verify(clientRepository).findById(eq(1L));
        verify(clientRepository).save(isA(Client.class));
    }

    /**
     * Method under test: {@link ClientService#updateClient(Long, Client)}
     */
    @Test
    void testUpdateClient3() {
        // Arrange
        Optional<Client> emptyResult = Optional.empty();
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

        Client updatedClient = new Client();
        updatedClient.setEmail("jane.doe@example.org");
        updatedClient.setFavoriteRestaurants(new HashSet<>());
        updatedClient.setId(1L);
        updatedClient.setName("Name");
        updatedClient.setParticipations(new HashSet<>());
        updatedClient.setPhone("6625550144");

        // Act
        Client actualUpdateClientResult = clientService.updateClient(1L, updatedClient);

        // Assert
        verify(clientRepository).findById(eq(1L));
        assertNull(actualUpdateClientResult);
    }

    /**
     * Method under test: {@link ClientService#deleteClient(Long)}
     */
    @Test
    void testDeleteClient() {
        // Arrange
        doNothing().when(clientRepository).deleteById(Mockito.<Long>any());

        // Act
        clientService.deleteClient(1L);

        // Assert that nothing has changed
        verify(clientRepository).deleteById(eq(1L));
    }

    /**
     * Method under test: {@link ClientService#deleteClient(Long)}
     */
    @Test
    void testDeleteClient2() {
        // Arrange
        doThrow(new IllegalArgumentException("foo")).when(clientRepository).deleteById(Mockito.<Long>any());

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> clientService.deleteClient(1L));
        verify(clientRepository).deleteById(eq(1L));
    }

    /**
     * Method under test: {@link ClientService#addRestaurantToFavorites(Long, Long)}
     */
    @Test
    void testAddRestaurantToFavorites() {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");
        Optional<Client> ofResult = Optional.of(client);

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");
        when(clientRepository.save(Mockito.<Client>any())).thenReturn(client2);
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

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
        Optional<Restaurant> ofResult2 = Optional.of(restaurant2);
        when(restaurantRepository.findById(Mockito.<Long>any())).thenReturn(ofResult2);

        // Act
        clientService.addRestaurantToFavorites(1L, 1L);

        // Assert
        verify(clientRepository).findById(eq(1L));
        verify(restaurantRepository).findById(eq(1L));
        verify(clientRepository).save(isA(Client.class));
    }

    /**
     * Method under test: {@link ClientService#addRestaurantToFavorites(Long, Long)}
     */
    @Test
    void testAddRestaurantToFavorites2() {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");
        Optional<Client> ofResult = Optional.of(client);
        when(clientRepository.save(Mockito.<Client>any())).thenThrow(new IllegalArgumentException("foo"));
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

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
        Optional<Restaurant> ofResult2 = Optional.of(restaurant2);
        when(restaurantRepository.findById(Mockito.<Long>any())).thenReturn(ofResult2);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> clientService.addRestaurantToFavorites(1L, 1L));
        verify(clientRepository).findById(eq(1L));
        verify(restaurantRepository).findById(eq(1L));
        verify(clientRepository).save(isA(Client.class));
    }

    /**
     * Method under test: {@link ClientService#addRestaurantToFavorites(Long, Long)}
     */
    @Test
    void testAddRestaurantToFavorites3() {
        // Arrange
        Optional<Client> emptyResult = Optional.empty();
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

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

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> clientService.addRestaurantToFavorites(1L, 1L));
        verify(clientRepository).findById(eq(1L));
    }
}
