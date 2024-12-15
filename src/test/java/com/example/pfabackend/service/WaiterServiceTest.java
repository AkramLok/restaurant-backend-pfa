package com.example.pfabackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.entities.Waiter;
import com.example.pfabackend.repository.RestaurantRepository;
import com.example.pfabackend.repository.WaiterRepository;

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

@ContextConfiguration(classes = {WaiterService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class WaiterServiceTest {
    @MockBean
    private RestaurantRepository restaurantRepository;

    @MockBean
    private WaiterRepository waiterRepository;

    @Autowired
    private WaiterService waiterService;

    /**
     * Method under test: {@link WaiterService#getAllWaiters()}
     */
    @Test
    void testGetAllWaiters() {
        // Arrange
        ArrayList<Waiter> waiterList = new ArrayList<>();
        when(waiterRepository.findAll()).thenReturn(waiterList);

        // Act
        List<Waiter> actualAllWaiters = waiterService.getAllWaiters();

        // Assert
        verify(waiterRepository).findAll();
        assertTrue(actualAllWaiters.isEmpty());
        assertSame(waiterList, actualAllWaiters);
    }

    /**
     * Method under test: {@link WaiterService#getAllWaiters()}
     */
    @Test
    void testGetAllWaiters2() {
        // Arrange
        when(waiterRepository.findAll()).thenThrow(new IllegalArgumentException("foo"));

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> waiterService.getAllWaiters());
        verify(waiterRepository).findAll();
    }

    /**
     * Method under test: {@link WaiterService#getWaiterById(Long)}
     */
    @Test
    void testGetWaiterById() {
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

        Waiter waiter = new Waiter();
        waiter.setCin("Cin");
        waiter.setEmail("jane.doe@example.org");
        waiter.setId(1L);
        waiter.setName("Name");
        waiter.setPhone("6625550144");
        waiter.setRestaurant(restaurant2);
        Optional<Waiter> ofResult = Optional.of(waiter);
        when(waiterRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Waiter actualWaiterById = waiterService.getWaiterById(1L);

        // Assert
        verify(waiterRepository).findById(eq(1L));
        assertSame(waiter, actualWaiterById);
    }

    /**
     * Method under test:
     * {@link WaiterService#createWaiterForRestaurant(Long, Waiter)}
     */
    @Test
    void testCreateWaiterForRestaurant() {
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
        Restaurant restaurant = new Restaurant();
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
        Optional<Restaurant> ofResult = Optional.of(restaurant3);
        when(restaurantRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

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

        Waiter waiter = new Waiter();
        waiter.setCin("Cin");
        waiter.setEmail("jane.doe@example.org");
        waiter.setId(1L);
        waiter.setName("Name");
        waiter.setPhone("6625550144");
        waiter.setRestaurant(restaurant5);
        when(waiterRepository.save(Mockito.<Waiter>any())).thenReturn(waiter);

        Location location5 = new Location();
        location5.setLatitude(10.0d);
        location5.setLongitude(10.0d);

        Restaurant restaurant6 = new Restaurant();
        restaurant6.setCoverImageUrl("https://example.org/example");
        restaurant6.setCuisine("Cuisine");
        restaurant6.setDescription("The characteristics of someone or something");
        restaurant6.setEmail("jane.doe@example.org");
        restaurant6.setFoodCategories(new ArrayList<>());
        restaurant6.setId(1L);
        restaurant6.setInstagram("Instagram");
        restaurant6.setLikes(1);
        restaurant6.setLocation(new Location());
        restaurant6.setLogoUrl("https://example.org/example");
        restaurant6.setName("Name");
        restaurant6.setOwner(new Owner());
        restaurant6.setParticipations(new HashSet<>());
        restaurant6.setPhoneNumber("6625550144");
        restaurant6.setPriceRange("Price Range");
        restaurant6.setRating(10.0d);
        restaurant6.setWaiters(new ArrayList<>());

        Owner owner5 = new Owner();
        owner5.setEmail("jane.doe@example.org");
        owner5.setId(1L);
        owner5.setName("Name");
        owner5.setPhone("6625550144");
        owner5.setRestaurant(restaurant6);

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
        restaurant7.setOwner(owner5);
        restaurant7.setParticipations(new HashSet<>());
        restaurant7.setPhoneNumber("6625550144");
        restaurant7.setPriceRange("Price Range");
        restaurant7.setRating(10.0d);
        restaurant7.setWaiters(new ArrayList<>());

        Waiter newWaiter = new Waiter();
        newWaiter.setCin("Cin");
        newWaiter.setEmail("jane.doe@example.org");
        newWaiter.setId(1L);
        newWaiter.setName("Name");
        newWaiter.setPhone("6625550144");
        newWaiter.setRestaurant(restaurant7);

        // Act
        Waiter actualCreateWaiterForRestaurantResult = waiterService.createWaiterForRestaurant(1L, newWaiter);

        // Assert
        verify(restaurantRepository).findById(eq(1L));
        verify(waiterRepository).save(isA(Waiter.class));
        Restaurant restaurant8 = newWaiter.getRestaurant().getOwner().getRestaurant();
        Owner owner6 = restaurant8.getOwner();
        assertEquals("6625550144", owner6.getPhone());
        assertEquals("Name", owner6.getName());
        assertEquals("jane.doe@example.org", owner6.getEmail());
        assertEquals(1L, owner6.getId().longValue());
        assertEquals(location, restaurant8.getLocation());
        assertSame(restaurant, owner6.getRestaurant());
        assertSame(waiter, actualCreateWaiterForRestaurantResult);
    }

    /**
     * Method under test:
     * {@link WaiterService#createWaiterForRestaurant(Long, Waiter)}
     */
    @Test
    void testCreateWaiterForRestaurant2() {
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
        Optional<Restaurant> ofResult = Optional.of(restaurant2);
        when(restaurantRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        when(waiterRepository.save(Mockito.<Waiter>any())).thenThrow(new IllegalArgumentException("foo"));

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

        Waiter newWaiter = new Waiter();
        newWaiter.setCin("Cin");
        newWaiter.setEmail("jane.doe@example.org");
        newWaiter.setId(1L);
        newWaiter.setName("Name");
        newWaiter.setPhone("6625550144");
        newWaiter.setRestaurant(restaurant4);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> waiterService.createWaiterForRestaurant(1L, newWaiter));
        verify(restaurantRepository).findById(eq(1L));
        verify(waiterRepository).save(isA(Waiter.class));
    }

    /**
     * Method under test: {@link WaiterService#getWaitersByRestaurantId(Long)}
     */
    @Test
    void testGetWaitersByRestaurantId() {
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
        ArrayList<Waiter> waiters = new ArrayList<>();
        restaurant2.setWaiters(waiters);
        Optional<Restaurant> ofResult = Optional.of(restaurant2);
        when(restaurantRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        List<Waiter> actualWaitersByRestaurantId = waiterService.getWaitersByRestaurantId(1L);

        // Assert
        verify(restaurantRepository).findById(eq(1L));
        assertTrue(actualWaitersByRestaurantId.isEmpty());
        assertSame(waiters, actualWaitersByRestaurantId);
    }

    /**
     * Method under test: {@link WaiterService#updateWaiter(Long, Waiter)}
     */
    @Test
    void testUpdateWaiter() {
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

        Waiter waiter = new Waiter();
        waiter.setCin("Cin");
        waiter.setEmail("jane.doe@example.org");
        waiter.setId(1L);
        waiter.setName("Name");
        waiter.setPhone("6625550144");
        waiter.setRestaurant(restaurant2);
        Optional<Waiter> ofResult = Optional.of(waiter);

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

        Waiter waiter2 = new Waiter();
        waiter2.setCin("Cin");
        waiter2.setEmail("jane.doe@example.org");
        waiter2.setId(1L);
        waiter2.setName("Name");
        waiter2.setPhone("6625550144");
        waiter2.setRestaurant(restaurant4);
        when(waiterRepository.save(Mockito.<Waiter>any())).thenReturn(waiter2);
        when(waiterRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

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

        Waiter updatedWaiter = new Waiter();
        updatedWaiter.setCin("Cin");
        updatedWaiter.setEmail("jane.doe@example.org");
        updatedWaiter.setId(1L);
        updatedWaiter.setName("Name");
        updatedWaiter.setPhone("6625550144");
        updatedWaiter.setRestaurant(restaurant6);

        // Act
        Waiter actualUpdateWaiterResult = waiterService.updateWaiter(1L, updatedWaiter);

        // Assert
        verify(waiterRepository).findById(eq(1L));
        verify(waiterRepository).save(isA(Waiter.class));
        assertSame(waiter2, actualUpdateWaiterResult);
    }

    /**
     * Method under test: {@link WaiterService#updateWaiter(Long, Waiter)}
     */
    @Test
    void testUpdateWaiter2() {
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

        Waiter waiter = new Waiter();
        waiter.setCin("Cin");
        waiter.setEmail("jane.doe@example.org");
        waiter.setId(1L);
        waiter.setName("Name");
        waiter.setPhone("6625550144");
        waiter.setRestaurant(restaurant2);
        Optional<Waiter> ofResult = Optional.of(waiter);
        when(waiterRepository.save(Mockito.<Waiter>any())).thenThrow(new IllegalArgumentException("foo"));
        when(waiterRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

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

        Waiter updatedWaiter = new Waiter();
        updatedWaiter.setCin("Cin");
        updatedWaiter.setEmail("jane.doe@example.org");
        updatedWaiter.setId(1L);
        updatedWaiter.setName("Name");
        updatedWaiter.setPhone("6625550144");
        updatedWaiter.setRestaurant(restaurant4);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> waiterService.updateWaiter(1L, updatedWaiter));
        verify(waiterRepository).findById(eq(1L));
        verify(waiterRepository).save(isA(Waiter.class));
    }

    /**
     * Method under test: {@link WaiterService#deleteWaiter(Long)}
     */
    @Test
    void testDeleteWaiter() {
        // Arrange
        doNothing().when(waiterRepository).deleteById(Mockito.<Long>any());

        // Act
        waiterService.deleteWaiter(1L);

        // Assert that nothing has changed
        verify(waiterRepository).deleteById(eq(1L));
    }

    /**
     * Method under test: {@link WaiterService#deleteWaiter(Long)}
     */
    @Test
    void testDeleteWaiter2() {
        // Arrange
        doThrow(new IllegalArgumentException("foo")).when(waiterRepository).deleteById(Mockito.<Long>any());

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> waiterService.deleteWaiter(1L));
        verify(waiterRepository).deleteById(eq(1L));
    }
}
