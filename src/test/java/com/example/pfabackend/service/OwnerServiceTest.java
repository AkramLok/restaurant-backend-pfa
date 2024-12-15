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

import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.repository.OwnerRepository;

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

@ContextConfiguration(classes = {OwnerService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class OwnerServiceTest {
    @MockBean
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerService ownerService;

    /**
     * Method under test: {@link OwnerService#getAllOwners()}
     */
    @Test
    void testGetAllOwners() {
        // Arrange
        ArrayList<Owner> ownerList = new ArrayList<>();
        when(ownerRepository.findAll()).thenReturn(ownerList);

        // Act
        List<Owner> actualAllOwners = ownerService.getAllOwners();

        // Assert
        verify(ownerRepository).findAll();
        assertTrue(actualAllOwners.isEmpty());
        assertSame(ownerList, actualAllOwners);
    }

    /**
     * Method under test: {@link OwnerService#getAllOwners()}
     */
    @Test
    void testGetAllOwners2() {
        // Arrange
        when(ownerRepository.findAll()).thenThrow(new RuntimeException("foo"));

        // Act and Assert
        assertThrows(RuntimeException.class, () -> ownerService.getAllOwners());
        verify(ownerRepository).findAll();
    }

    /**
     * Method under test: {@link OwnerService#getOwnerById(Long)}
     */
    @Test
    void testGetOwnerById() {
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

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant2);
        Optional<Owner> ofResult = Optional.of(owner2);
        when(ownerRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Optional<Owner> actualOwnerById = ownerService.getOwnerById(1L);

        // Assert
        verify(ownerRepository).findById(eq(1L));
        assertSame(ofResult, actualOwnerById);
    }

    /**
     * Method under test: {@link OwnerService#getOwnersByRestaurantId(Long)}
     */
    @Test
    void testGetOwnersByRestaurantId() {
        // Arrange
        ArrayList<Owner> ownerList = new ArrayList<>();
        when(ownerRepository.findByRestaurantId(Mockito.<Long>any())).thenReturn(ownerList);

        // Act
        List<Owner> actualOwnersByRestaurantId = ownerService.getOwnersByRestaurantId(1L);

        // Assert
        verify(ownerRepository).findByRestaurantId(eq(1L));
        assertTrue(actualOwnersByRestaurantId.isEmpty());
        assertSame(ownerList, actualOwnersByRestaurantId);
    }

    /**
     * Method under test: {@link OwnerService#getOwnersByRestaurantId(Long)}
     */
    @Test
    void testGetOwnersByRestaurantId2() {
        // Arrange
        when(ownerRepository.findByRestaurantId(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

        // Act and Assert
        assertThrows(RuntimeException.class, () -> ownerService.getOwnersByRestaurantId(1L));
        verify(ownerRepository).findByRestaurantId(eq(1L));
    }

    /**
     * Method under test: {@link OwnerService#createOwner(Owner)}
     */
    @Test
    void testCreateOwner() {
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

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(restaurant2);
        when(ownerRepository.save(Mockito.<Owner>any())).thenReturn(owner3);

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

        Owner owner5 = new Owner();
        owner5.setEmail("jane.doe@example.org");
        owner5.setId(1L);
        owner5.setName("Name");
        owner5.setPhone("6625550144");
        owner5.setRestaurant(restaurant4);

        // Act
        Owner actualCreateOwnerResult = ownerService.createOwner(owner5);

        // Assert
        verify(ownerRepository).save(isA(Owner.class));
        assertSame(owner3, actualCreateOwnerResult);
    }

    /**
     * Method under test: {@link OwnerService#updateOwner(Long, Owner)}
     */
    @Test
    void testUpdateOwner() {
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

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(restaurant2);
        when(ownerRepository.save(Mockito.<Owner>any())).thenReturn(owner3);
        when(ownerRepository.existsById(Mockito.<Long>any())).thenReturn(true);

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

        Owner updatedOwner = new Owner();
        updatedOwner.setEmail("jane.doe@example.org");
        updatedOwner.setId(1L);
        updatedOwner.setName("Name");
        updatedOwner.setPhone("6625550144");
        updatedOwner.setRestaurant(restaurant4);

        // Act
        Owner actualUpdateOwnerResult = ownerService.updateOwner(1L, updatedOwner);

        // Assert
        verify(ownerRepository).existsById(eq(1L));
        verify(ownerRepository).save(isA(Owner.class));
        assertSame(owner3, actualUpdateOwnerResult);
    }

    /**
     * Method under test: {@link OwnerService#updateOwner(Long, Owner)}
     */
    @Test
    void testUpdateOwner2() {
        // Arrange
        when(ownerRepository.save(Mockito.<Owner>any())).thenThrow(new RuntimeException("foo"));
        when(ownerRepository.existsById(Mockito.<Long>any())).thenReturn(true);

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

        Owner updatedOwner = new Owner();
        updatedOwner.setEmail("jane.doe@example.org");
        updatedOwner.setId(1L);
        updatedOwner.setName("Name");
        updatedOwner.setPhone("6625550144");
        updatedOwner.setRestaurant(restaurant2);

        // Act and Assert
        assertThrows(RuntimeException.class, () -> ownerService.updateOwner(1L, updatedOwner));
        verify(ownerRepository).existsById(eq(1L));
        verify(ownerRepository).save(isA(Owner.class));
    }

    /**
     * Method under test: {@link OwnerService#deleteOwner(Long)}
     */
    @Test
    void testDeleteOwner() {
        // Arrange
        doNothing().when(ownerRepository).deleteById(Mockito.<Long>any());

        // Act
        ownerService.deleteOwner(1L);

        // Assert that nothing has changed
        verify(ownerRepository).deleteById(eq(1L));
    }

    /**
     * Method under test: {@link OwnerService#deleteOwner(Long)}
     */
    @Test
    void testDeleteOwner2() {
        // Arrange
        doThrow(new RuntimeException("foo")).when(ownerRepository).deleteById(Mockito.<Long>any());

        // Act and Assert
        assertThrows(RuntimeException.class, () -> ownerService.deleteOwner(1L));
        verify(ownerRepository).deleteById(eq(1L));
    }
}
