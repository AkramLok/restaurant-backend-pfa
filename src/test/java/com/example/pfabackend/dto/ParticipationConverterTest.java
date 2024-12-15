package com.example.pfabackend.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.pfabackend.entities.Client;
import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Participation;
import com.example.pfabackend.entities.ParticipationId;
import com.example.pfabackend.entities.Restaurant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ParticipationConverter.class})
@ExtendWith(SpringExtension.class)
class ParticipationConverterTest {
    @Autowired
    private ParticipationConverter participationConverter;

    /**
     * Method under test: {@link ParticipationConverter#convertToDto(Participation)}
     */
    @Test
    void testConvertToDto() {
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

        // Act
        ParticipationDTO actualConvertToDtoResult = participationConverter.convertToDto(participation);

        // Assert
        assertEquals(1, actualConvertToDtoResult.getPoints());
        assertEquals(1L, actualConvertToDtoResult.getClientId().longValue());
        assertEquals(1L, actualConvertToDtoResult.getRestaurantId().longValue());
    }

    /**
     * Method under test: {@link ParticipationConverter#convertToDto(Participation)}
     */
    @Test
    void testConvertToDto2() {
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
        restaurant4.setLocation(location3);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner2);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(restaurant4);

        Restaurant restaurant5 = new Restaurant();
        restaurant5.setCoverImageUrl("https://example.org/example");
        restaurant5.setCuisine("Cuisine");
        restaurant5.setDescription("The characteristics of someone or something");
        restaurant5.setEmail("jane.doe@example.org");
        restaurant5.setFoodCategories(new ArrayList<>());
        restaurant5.setId(1L);
        restaurant5.setInstagram("Instagram");
        restaurant5.setLikes(1);
        restaurant5.setLocation(location2);
        restaurant5.setLogoUrl("https://example.org/example");
        restaurant5.setName("Name");
        restaurant5.setOwner(owner3);
        restaurant5.setParticipations(new HashSet<>());
        restaurant5.setPhoneNumber("6625550144");
        restaurant5.setPriceRange("Price Range");
        restaurant5.setRating(10.0d);
        restaurant5.setWaiters(new ArrayList<>());
        Participation participation = mock(Participation.class);
        when(participation.getPoints()).thenReturn(1);
        when(participation.getRestaurant()).thenReturn(restaurant5);
        when(participation.getClient()).thenReturn(client2);
        doNothing().when(participation).setClient(Mockito.<Client>any());
        doNothing().when(participation).setId(Mockito.<ParticipationId>any());
        doNothing().when(participation).setPoints(anyInt());
        doNothing().when(participation).setRestaurant(Mockito.<Restaurant>any());
        participation.setClient(client);
        participation.setId(new ParticipationId());
        participation.setPoints(1);
        participation.setRestaurant(restaurant2);

        // Act
        ParticipationDTO actualConvertToDtoResult = participationConverter.convertToDto(participation);

        // Assert
        verify(participation).getClient();
        verify(participation).getPoints();
        verify(participation).getRestaurant();
        verify(participation).setClient(isA(Client.class));
        verify(participation).setId(isA(ParticipationId.class));
        verify(participation).setPoints(eq(1));
        verify(participation).setRestaurant(isA(Restaurant.class));
        assertEquals(1, actualConvertToDtoResult.getPoints());
        assertEquals(1L, actualConvertToDtoResult.getClientId().longValue());
        assertEquals(1L, actualConvertToDtoResult.getRestaurantId().longValue());
    }

    /**
     * Method under test: {@link ParticipationConverter#convertToDtoList(List)}
     */
    @Test
    void testConvertToDtoList() {
        // Arrange, Act and Assert
        assertTrue(participationConverter.convertToDtoList(new ArrayList<>()).isEmpty());
    }

    /**
     * Method under test: {@link ParticipationConverter#convertToDtoList(List)}
     */
    @Test
    void testConvertToDtoList2() {
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

        ArrayList<Participation> participations = new ArrayList<>();
        participations.add(participation);

        // Act
        List<ParticipationDTO> actualConvertToDtoListResult = participationConverter.convertToDtoList(participations);

        // Assert
        assertEquals(1, actualConvertToDtoListResult.size());
        ParticipationDTO getResult = actualConvertToDtoListResult.get(0);
        assertEquals(1, getResult.getPoints());
        assertEquals(1L, getResult.getClientId().longValue());
        assertEquals(1L, getResult.getRestaurantId().longValue());
    }

    /**
     * Method under test: {@link ParticipationConverter#convertToDtoList(List)}
     */
    @Test
    void testConvertToDtoList3() {
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

        ArrayList<Participation> participations = new ArrayList<>();
        participations.add(participation2);
        participations.add(participation);

        // Act
        List<ParticipationDTO> actualConvertToDtoListResult = participationConverter.convertToDtoList(participations);

        // Assert
        assertEquals(2, actualConvertToDtoListResult.size());
        ParticipationDTO getResult = actualConvertToDtoListResult.get(0);
        assertEquals(0, getResult.getPoints());
        ParticipationDTO getResult2 = actualConvertToDtoListResult.get(1);
        assertEquals(1, getResult2.getPoints());
        assertEquals(1L, getResult2.getClientId().longValue());
        assertEquals(1L, getResult2.getRestaurantId().longValue());
        assertEquals(2L, getResult.getClientId().longValue());
        assertEquals(2L, getResult.getRestaurantId().longValue());
    }
}
