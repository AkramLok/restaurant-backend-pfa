package com.example.pfabackend.service;

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
import com.example.pfabackend.entities.Participation;
import com.example.pfabackend.entities.ParticipationId;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.repository.ClientRepository;
import com.example.pfabackend.repository.ParticipationRepository;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ParticipationService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ParticipationServiceTest {
    @MockBean
    private ClientRepository clientRepository;

    @MockBean
    private ClientService clientService;

    @MockBean
    private ParticipationRepository participationRepository;

    @Autowired
    private ParticipationService participationService;

    @MockBean
    private RestaurantRepository restaurantRepository;

    @MockBean
    private RestaurantService restaurantService;

    /**
     * Method under test: {@link ParticipationService#getAllParticipations()}
     */
    @Test
    void testGetAllParticipations() {
        // Arrange
        ArrayList<Participation> participationList = new ArrayList<>();
        when(participationRepository.findAll()).thenReturn(participationList);

        // Act
        List<Participation> actualAllParticipations = participationService.getAllParticipations();

        // Assert
        verify(participationRepository).findAll();
        assertTrue(actualAllParticipations.isEmpty());
        assertSame(participationList, actualAllParticipations);
    }

    /**
     * Method under test: {@link ParticipationService#getAllParticipations()}
     */
    @Test
    void testGetAllParticipations2() {
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

        Participation participation = new Participation();
        participation.setClient(client);
        participation.setId(new ParticipationId());
        participation.setPoints(1);
        participation.setRestaurant(restaurant2);

        ArrayList<Participation> participationList = new ArrayList<>();
        participationList.add(participation);
        when(participationRepository.findAll()).thenReturn(participationList);

        // Act
        List<Participation> actualAllParticipations = participationService.getAllParticipations();

        // Assert
        verify(participationRepository).findAll();
        assertSame(participationList, actualAllParticipations);
    }

    /**
     * Method under test: {@link ParticipationService#getAllParticipations()}
     */
    @Test
    void testGetAllParticipations3() {
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

        Participation participation = new Participation();
        participation.setClient(client);
        participation.setId(new ParticipationId());
        participation.setPoints(1);
        participation.setRestaurant(restaurant2);

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

        Participation participation2 = new Participation();
        participation2.setClient(client2);
        participation2.setId(new ParticipationId());
        participation2.setPoints(0);
        participation2.setRestaurant(restaurant4);

        ArrayList<Participation> participationList = new ArrayList<>();
        participationList.add(participation2);
        participationList.add(participation);
        when(participationRepository.findAll()).thenReturn(participationList);

        // Act
        List<Participation> actualAllParticipations = participationService.getAllParticipations();

        // Assert
        verify(participationRepository).findAll();
        assertSame(participationList, actualAllParticipations);
    }

    /**
     * Method under test: {@link ParticipationService#getAllParticipations()}
     */
    @Test
    void testGetAllParticipations4() {
        // Arrange
        when(participationRepository.findAll()).thenThrow(new IllegalArgumentException("foo"));

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> participationService.getAllParticipations());
        verify(participationRepository).findAll();
    }

    /**
     * Method under test:
     * {@link ParticipationService#getAllParticipationsForRestaurant(Long)}
     */
    @Test
    void testGetAllParticipationsForRestaurant() {
        // Arrange
        ArrayList<Participation> participationList = new ArrayList<>();
        when(participationRepository.findByRestaurantId(Mockito.<Long>any())).thenReturn(participationList);

        // Act
        List<Participation> actualAllParticipationsForRestaurant = participationService
                .getAllParticipationsForRestaurant(1L);

        // Assert
        verify(participationRepository).findByRestaurantId(eq(1L));
        assertTrue(actualAllParticipationsForRestaurant.isEmpty());
        assertSame(participationList, actualAllParticipationsForRestaurant);
    }

    /**
     * Method under test:
     * {@link ParticipationService#getAllParticipationsForRestaurant(Long)}
     */
    @Test
    void testGetAllParticipationsForRestaurant2() {
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

        Participation participation = new Participation();
        participation.setClient(client);
        participation.setId(new ParticipationId());
        participation.setPoints(1);
        participation.setRestaurant(restaurant2);

        ArrayList<Participation> participationList = new ArrayList<>();
        participationList.add(participation);
        when(participationRepository.findByRestaurantId(Mockito.<Long>any())).thenReturn(participationList);

        // Act
        List<Participation> actualAllParticipationsForRestaurant = participationService
                .getAllParticipationsForRestaurant(1L);

        // Assert
        verify(participationRepository).findByRestaurantId(eq(1L));
        assertSame(participationList, actualAllParticipationsForRestaurant);
    }

    /**
     * Method under test:
     * {@link ParticipationService#getAllParticipationsForRestaurant(Long)}
     */
    @Test
    void testGetAllParticipationsForRestaurant3() {
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

        Participation participation = new Participation();
        participation.setClient(client);
        participation.setId(new ParticipationId());
        participation.setPoints(1);
        participation.setRestaurant(restaurant2);

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

        Participation participation2 = new Participation();
        participation2.setClient(client2);
        participation2.setId(new ParticipationId());
        participation2.setPoints(0);
        participation2.setRestaurant(restaurant4);

        ArrayList<Participation> participationList = new ArrayList<>();
        participationList.add(participation2);
        participationList.add(participation);
        when(participationRepository.findByRestaurantId(Mockito.<Long>any())).thenReturn(participationList);

        // Act
        List<Participation> actualAllParticipationsForRestaurant = participationService
                .getAllParticipationsForRestaurant(1L);

        // Assert
        verify(participationRepository).findByRestaurantId(eq(1L));
        assertSame(participationList, actualAllParticipationsForRestaurant);
    }

    /**
     * Method under test:
     * {@link ParticipationService#getAllParticipationsForRestaurant(Long)}
     */
    @Test
    void testGetAllParticipationsForRestaurant4() {
        // Arrange
        when(participationRepository.findByRestaurantId(Mockito.<Long>any()))
                .thenThrow(new IllegalArgumentException("foo"));

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> participationService.getAllParticipationsForRestaurant(1L));
        verify(participationRepository).findByRestaurantId(eq(1L));
    }

    /**
     * Method under test:
     * {@link ParticipationService#getAllParticipationsForClient(Long)}
     */
    @Test
    void testGetAllParticipationsForClient() {
        // Arrange
        ArrayList<Participation> participationList = new ArrayList<>();
        when(participationRepository.findByClientId(Mockito.<Long>any())).thenReturn(participationList);

        // Act
        List<Participation> actualAllParticipationsForClient = participationService.getAllParticipationsForClient(1L);

        // Assert
        verify(participationRepository).findByClientId(eq(1L));
        assertTrue(actualAllParticipationsForClient.isEmpty());
        assertSame(participationList, actualAllParticipationsForClient);
    }

    /**
     * Method under test:
     * {@link ParticipationService#getAllParticipationsForClient(Long)}
     */
    @Test
    void testGetAllParticipationsForClient2() {
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

        Participation participation = new Participation();
        participation.setClient(client);
        participation.setId(new ParticipationId());
        participation.setPoints(1);
        participation.setRestaurant(restaurant2);

        ArrayList<Participation> participationList = new ArrayList<>();
        participationList.add(participation);
        when(participationRepository.findByClientId(Mockito.<Long>any())).thenReturn(participationList);

        // Act
        List<Participation> actualAllParticipationsForClient = participationService.getAllParticipationsForClient(1L);

        // Assert
        verify(participationRepository).findByClientId(eq(1L));
        assertSame(participationList, actualAllParticipationsForClient);
    }

    /**
     * Method under test:
     * {@link ParticipationService#getAllParticipationsForClient(Long)}
     */
    @Test
    void testGetAllParticipationsForClient3() {
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

        Participation participation = new Participation();
        participation.setClient(client);
        participation.setId(new ParticipationId());
        participation.setPoints(1);
        participation.setRestaurant(restaurant2);

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

        Participation participation2 = new Participation();
        participation2.setClient(client2);
        participation2.setId(new ParticipationId());
        participation2.setPoints(0);
        participation2.setRestaurant(restaurant4);

        ArrayList<Participation> participationList = new ArrayList<>();
        participationList.add(participation2);
        participationList.add(participation);
        when(participationRepository.findByClientId(Mockito.<Long>any())).thenReturn(participationList);

        // Act
        List<Participation> actualAllParticipationsForClient = participationService.getAllParticipationsForClient(1L);

        // Assert
        verify(participationRepository).findByClientId(eq(1L));
        assertSame(participationList, actualAllParticipationsForClient);
    }

    /**
     * Method under test:
     * {@link ParticipationService#getAllParticipationsForClient(Long)}
     */
    @Test
    void testGetAllParticipationsForClient4() {
        // Arrange
        when(participationRepository.findByClientId(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("foo"));

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> participationService.getAllParticipationsForClient(1L));
        verify(participationRepository).findByClientId(eq(1L));
    }

    /**
     * Method under test:
     * {@link ParticipationService#createParticipation(Long, Long, int)}
     */
    @Test
    void testCreateParticipation() {
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

        Participation participation = new Participation();
        participation.setClient(client2);
        participation.setId(new ParticipationId());
        participation.setPoints(1);
        participation.setRestaurant(restaurant4);
        when(participationRepository.save(Mockito.<Participation>any())).thenReturn(participation);

        // Act
        Participation actualCreateParticipationResult = participationService.createParticipation(1L, 1L, 1);

        // Assert
        verify(clientRepository).findById(eq(1L));
        verify(restaurantRepository).findById(eq(1L));
        verify(participationRepository).save(isA(Participation.class));
        assertSame(participation, actualCreateParticipationResult);
    }

    /**
     * Method under test:
     * {@link ParticipationService#createParticipation(Long, Long, int)}
     */
    @Test
    void testCreateParticipation2() {
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
        when(participationRepository.save(Mockito.<Participation>any())).thenThrow(new IllegalArgumentException("foo"));

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> participationService.createParticipation(1L, 1L, 1));
        verify(clientRepository).findById(eq(1L));
        verify(restaurantRepository).findById(eq(1L));
        verify(participationRepository).save(isA(Participation.class));
    }

    /**
     * Method under test:
     * {@link ParticipationService#createParticipation(Long, Long, int)}
     */
    @Test
    void testCreateParticipation3() {
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
        assertThrows(EntityNotFoundException.class, () -> participationService.createParticipation(1L, 1L, 1));
        verify(clientRepository).findById(eq(1L));
    }

    /**
     * Method under test:
     * {@link ParticipationService#deleteParticipation(Long, Long)}
     */
    @Test
    void testDeleteParticipation() {
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

        Participation participation = new Participation();
        participation.setClient(client);
        participation.setId(new ParticipationId());
        participation.setPoints(1);
        participation.setRestaurant(restaurant2);
        Optional<Participation> ofResult = Optional.of(participation);
        doNothing().when(participationRepository).delete(Mockito.<Participation>any());
        when(participationRepository.findById(Mockito.<ParticipationId>any())).thenReturn(ofResult);

        // Act
        participationService.deleteParticipation(1L, 1L);

        // Assert
        verify(participationRepository).delete(isA(Participation.class));
        verify(participationRepository).findById(isA(ParticipationId.class));
    }

    /**
     * Method under test:
     * {@link ParticipationService#deleteParticipation(Long, Long)}
     */
    @Test
    void testDeleteParticipation2() {
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

        Participation participation = new Participation();
        participation.setClient(client);
        participation.setId(new ParticipationId());
        participation.setPoints(1);
        participation.setRestaurant(restaurant2);
        Optional<Participation> ofResult = Optional.of(participation);
        doThrow(new IllegalArgumentException("foo")).when(participationRepository).delete(Mockito.<Participation>any());
        when(participationRepository.findById(Mockito.<ParticipationId>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> participationService.deleteParticipation(1L, 1L));
        verify(participationRepository).delete(isA(Participation.class));
        verify(participationRepository).findById(isA(ParticipationId.class));
    }

    /**
     * Method under test: {@link ParticipationService#addPoints(Long, Long, int)}
     */
    @Test
    void testAddPoints() {
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

        Participation participation = new Participation();
        participation.setClient(client);
        participation.setId(new ParticipationId());
        participation.setPoints(1);
        participation.setRestaurant(restaurant2);
        Optional<Participation> ofResult = Optional.of(participation);

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");

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

        Participation participation2 = new Participation();
        participation2.setClient(client2);
        participation2.setId(new ParticipationId());
        participation2.setPoints(1);
        participation2.setRestaurant(restaurant4);
        when(participationRepository.save(Mockito.<Participation>any())).thenReturn(participation2);
        when(participationRepository.findById(Mockito.<ParticipationId>any())).thenReturn(ofResult);

        // Act
        participationService.addPoints(1L, 1L, 2);

        // Assert
        verify(participationRepository).findById(isA(ParticipationId.class));
        verify(participationRepository).save(isA(Participation.class));
    }

    /**
     * Method under test: {@link ParticipationService#addPoints(Long, Long, int)}
     */
    @Test
    void testAddPoints2() {
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

        Participation participation = new Participation();
        participation.setClient(client);
        participation.setId(new ParticipationId());
        participation.setPoints(1);
        participation.setRestaurant(restaurant2);
        Optional<Participation> ofResult = Optional.of(participation);
        when(participationRepository.save(Mockito.<Participation>any())).thenThrow(new IllegalArgumentException("foo"));
        when(participationRepository.findById(Mockito.<ParticipationId>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> participationService.addPoints(1L, 1L, 2));
        verify(participationRepository).findById(isA(ParticipationId.class));
        verify(participationRepository).save(isA(Participation.class));
    }

    /**
     * Method under test: {@link ParticipationService#reducePoints(Long, Long, int)}
     */
    @Test
    void testReducePoints() {
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

        Participation participation = new Participation();
        participation.setClient(client);
        participation.setId(new ParticipationId());
        participation.setPoints(1);
        participation.setRestaurant(restaurant2);
        Optional<Participation> ofResult = Optional.of(participation);

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");

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

        Participation participation2 = new Participation();
        participation2.setClient(client2);
        participation2.setId(new ParticipationId());
        participation2.setPoints(1);
        participation2.setRestaurant(restaurant4);
        when(participationRepository.save(Mockito.<Participation>any())).thenReturn(participation2);
        when(participationRepository.findById(Mockito.<ParticipationId>any())).thenReturn(ofResult);

        // Act
        participationService.reducePoints(1L, 1L, 1);

        // Assert
        verify(participationRepository).findById(isA(ParticipationId.class));
        verify(participationRepository).save(isA(Participation.class));
    }

    /**
     * Method under test: {@link ParticipationService#reducePoints(Long, Long, int)}
     */
    @Test
    void testReducePoints2() {
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

        Participation participation = new Participation();
        participation.setClient(client);
        participation.setId(new ParticipationId());
        participation.setPoints(1);
        participation.setRestaurant(restaurant2);
        Optional<Participation> ofResult = Optional.of(participation);
        when(participationRepository.save(Mockito.<Participation>any())).thenThrow(new IllegalArgumentException("foo"));
        when(participationRepository.findById(Mockito.<ParticipationId>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> participationService.reducePoints(1L, 1L, 1));
        verify(participationRepository).findById(isA(ParticipationId.class));
        verify(participationRepository).save(isA(Participation.class));
    }
}
