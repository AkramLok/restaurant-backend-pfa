package com.example.pfabackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.pfabackend.entities.Client;
import com.example.pfabackend.entities.FeedBack;
import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.repository.ClientRepository;
import com.example.pfabackend.repository.FeedBackRepository;
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

@ContextConfiguration(classes = {FeedBackService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class FeedBackServiceTest {
    @MockBean
    private ClientRepository clientRepository;

    @MockBean
    private FeedBackRepository feedBackRepository;

    @Autowired
    private FeedBackService feedBackService;

    @MockBean
    private RestaurantRepository restaurantRepository;

    /**
     * Method under test: {@link FeedBackService#getAllFeedBacks()}
     */
    @Test
    void testGetAllFeedBacks() {
        // Arrange
        ArrayList<FeedBack> feedBackList = new ArrayList<>();
        when(feedBackRepository.findAll()).thenReturn(feedBackList);

        // Act
        List<FeedBack> actualAllFeedBacks = feedBackService.getAllFeedBacks();

        // Assert
        verify(feedBackRepository).findAll();
        assertTrue(actualAllFeedBacks.isEmpty());
        assertSame(feedBackList, actualAllFeedBacks);
    }

    /**
     * Method under test: {@link FeedBackService#getAllFeedBacksForRestaurant(Long)}
     */
    @Test
    void testGetAllFeedBacksForRestaurant() {
        // Arrange
        ArrayList<FeedBack> feedBackList = new ArrayList<>();
        when(feedBackRepository.findByRestaurantId(Mockito.<Long>any())).thenReturn(feedBackList);

        // Act
        List<FeedBack> actualAllFeedBacksForRestaurant = feedBackService.getAllFeedBacksForRestaurant(1L);

        // Assert
        verify(feedBackRepository).findByRestaurantId(eq(1L));
        assertTrue(actualAllFeedBacksForRestaurant.isEmpty());
        assertSame(feedBackList, actualAllFeedBacksForRestaurant);
    }

    /**
     * Method under test: {@link FeedBackService#getAllFeedBacksForClient(Long)}
     */
    @Test
    void testGetAllFeedBacksForClient() {
        // Arrange
        ArrayList<FeedBack> feedBackList = new ArrayList<>();
        when(feedBackRepository.findByClientId(Mockito.<Long>any())).thenReturn(feedBackList);

        // Act
        List<FeedBack> actualAllFeedBacksForClient = feedBackService.getAllFeedBacksForClient(1L);

        // Assert
        verify(feedBackRepository).findByClientId(eq(1L));
        assertTrue(actualAllFeedBacksForClient.isEmpty());
        assertSame(feedBackList, actualAllFeedBacksForClient);
    }

    /**
     * Method under test: {@link FeedBackService#postFeedBack(Long, Long, FeedBack)}
     */
    @Test
    void testPostFeedBack() {
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

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");

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
        feedBack.setClient(client2);
        feedBack.setDescription("The characteristics of someone or something");
        feedBack.setId(1L);
        feedBack.setRating(1);
        feedBack.setRestaurant(restaurant2);
        when(feedBackRepository.save(Mockito.<FeedBack>any())).thenReturn(feedBack);

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
        Restaurant restaurant3 = new Restaurant();
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
        Optional<Restaurant> ofResult2 = Optional.of(restaurant5);
        when(restaurantRepository.findById(Mockito.<Long>any())).thenReturn(ofResult2);

        Client client3 = new Client();
        client3.setEmail("jane.doe@example.org");
        client3.setFavoriteRestaurants(new HashSet<>());
        client3.setId(1L);
        client3.setName("Name");
        client3.setParticipations(new HashSet<>());
        client3.setPhone("6625550144");

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

        FeedBack feedBack2 = new FeedBack();
        feedBack2.setClient(client3);
        feedBack2.setDescription("The characteristics of someone or something");
        feedBack2.setId(1L);
        feedBack2.setRating(1);
        feedBack2.setRestaurant(restaurant7);

        // Act
        FeedBack actualPostFeedBackResult = feedBackService.postFeedBack(1L, 1L, feedBack2);

        // Assert
        verify(clientRepository).findById(eq(1L));
        verify(restaurantRepository).findById(eq(1L));
        verify(feedBackRepository).save(isA(FeedBack.class));
        Restaurant restaurant8 = feedBack2.getRestaurant().getOwner().getRestaurant();
        Owner owner6 = restaurant8.getOwner();
        assertEquals("6625550144", owner6.getPhone());
        assertEquals("Name", owner6.getName());
        assertEquals("jane.doe@example.org", owner6.getEmail());
        assertEquals(1L, owner6.getId().longValue());
        assertEquals(location, restaurant8.getLocation());
        assertSame(feedBack, actualPostFeedBackResult);
        assertSame(restaurant3, owner6.getRestaurant());
    }

    /**
     * Method under test: {@link FeedBackService#deleteFeedBack(Long)}
     */
    @Test
    void testDeleteFeedBack() {
        // Arrange
        doNothing().when(feedBackRepository).deleteById(Mockito.<Long>any());

        // Act
        feedBackService.deleteFeedBack(1L);

        // Assert that nothing has changed
        verify(feedBackRepository).deleteById(eq(1L));
    }
}
