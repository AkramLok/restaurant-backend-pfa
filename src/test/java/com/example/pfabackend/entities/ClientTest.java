package com.example.pfabackend.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class ClientTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Client#equals(Object)}
     *   <li>{@link Client#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");

        // Act and Assert
        assertEquals(client, client2);
        int expectedHashCodeResult = client.hashCode();
        assertEquals(expectedHashCodeResult, client2.hashCode());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Client#equals(Object)}
     *   <li>{@link Client#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

        // Act and Assert
        assertEquals(client, client);
        int expectedHashCodeResult = client.hashCode();
        assertEquals(expectedHashCodeResult, client.hashCode());
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
        // Arrange
        Client client = new Client();
        client.setEmail("john.smith@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");

        // Act and Assert
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
        // Arrange
        Client client = new Client();
        client.setEmail(null);
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");

        // Act and Assert
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
        restaurant.setCuisine("Name");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Name");
        restaurant.setLikes(1);
        restaurant.setLocation(location2);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(owner);
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("Name");
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
        restaurant2.setCuisine("Name");
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setEmail("jane.doe@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(1L);
        restaurant2.setInstagram("Name");
        restaurant2.setLikes(1);
        restaurant2.setLocation(location);
        restaurant2.setLogoUrl("https://example.org/example");
        restaurant2.setName("Name");
        restaurant2.setOwner(owner2);
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("Name");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());

        HashSet<Restaurant> favoriteRestaurants = new HashSet<>();
        favoriteRestaurants.add(restaurant2);

        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(favoriteRestaurants);
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");

        // Act and Assert
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsNull_thenReturnNotEqual() {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

        // Act and Assert
        assertNotEquals(client, null);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

        // Act and Assert
        assertNotEquals(client, "Different type to Client");
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Client#Client()}
     *   <li>{@link Client#setEmail(String)}
     *   <li>{@link Client#setFavoriteRestaurants(Set)}
     *   <li>{@link Client#setId(Long)}
     *   <li>{@link Client#setName(String)}
     *   <li>{@link Client#setParticipations(Set)}
     *   <li>{@link Client#setPhone(String)}
     *   <li>{@link Client#toString()}
     *   <li>{@link Client#getEmail()}
     *   <li>{@link Client#getFavoriteRestaurants()}
     *   <li>{@link Client#getId()}
     *   <li>{@link Client#getName()}
     *   <li>{@link Client#getParticipations()}
     *   <li>{@link Client#getPhone()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        Client actualClient = new Client();
        actualClient.setEmail("jane.doe@example.org");
        HashSet<Restaurant> favoriteRestaurants = new HashSet<>();
        actualClient.setFavoriteRestaurants(favoriteRestaurants);
        actualClient.setId(1L);
        actualClient.setName("Name");
        HashSet<Participation> participations = new HashSet<>();
        actualClient.setParticipations(participations);
        actualClient.setPhone("6625550144");
        String actualToStringResult = actualClient.toString();
        String actualEmail = actualClient.getEmail();
        Set<Restaurant> actualFavoriteRestaurants = actualClient.getFavoriteRestaurants();
        Long actualId = actualClient.getId();
        String actualName = actualClient.getName();
        Set<Participation> actualParticipations = actualClient.getParticipations();

        // Assert that nothing has changed
        assertEquals("6625550144", actualClient.getPhone());
        assertEquals(
                "Client(id=1, name=Name, email=jane.doe@example.org, phone=6625550144, participations=[], favoriteRestaurants"
                        + "=[])",
                actualToStringResult);
        assertEquals("Name", actualName);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals(1L, actualId.longValue());
        assertTrue(actualFavoriteRestaurants.isEmpty());
        assertTrue(actualParticipations.isEmpty());
        assertSame(favoriteRestaurants, actualFavoriteRestaurants);
        assertSame(participations, actualParticipations);
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Client#Client(Long, String, String, String, Set, Set)}
     *   <li>{@link Client#setEmail(String)}
     *   <li>{@link Client#setFavoriteRestaurants(Set)}
     *   <li>{@link Client#setId(Long)}
     *   <li>{@link Client#setName(String)}
     *   <li>{@link Client#setParticipations(Set)}
     *   <li>{@link Client#setPhone(String)}
     *   <li>{@link Client#toString()}
     *   <li>{@link Client#getEmail()}
     *   <li>{@link Client#getFavoriteRestaurants()}
     *   <li>{@link Client#getId()}
     *   <li>{@link Client#getName()}
     *   <li>{@link Client#getParticipations()}
     *   <li>{@link Client#getPhone()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange
        HashSet<Participation> participations = new HashSet<>();

        // Act
        Client actualClient = new Client(1L, "Name", "jane.doe@example.org", "6625550144", participations, new HashSet<>());
        actualClient.setEmail("jane.doe@example.org");
        HashSet<Restaurant> favoriteRestaurants = new HashSet<>();
        actualClient.setFavoriteRestaurants(favoriteRestaurants);
        actualClient.setId(1L);
        actualClient.setName("Name");
        HashSet<Participation> participations2 = new HashSet<>();
        actualClient.setParticipations(participations2);
        actualClient.setPhone("6625550144");
        String actualToStringResult = actualClient.toString();
        String actualEmail = actualClient.getEmail();
        Set<Restaurant> actualFavoriteRestaurants = actualClient.getFavoriteRestaurants();
        Long actualId = actualClient.getId();
        String actualName = actualClient.getName();
        Set<Participation> actualParticipations = actualClient.getParticipations();

        // Assert that nothing has changed
        assertEquals("6625550144", actualClient.getPhone());
        assertEquals(
                "Client(id=1, name=Name, email=jane.doe@example.org, phone=6625550144, participations=[], favoriteRestaurants"
                        + "=[])",
                actualToStringResult);
        assertEquals("Name", actualName);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals(1L, actualId.longValue());
        assertTrue(actualFavoriteRestaurants.isEmpty());
        assertTrue(actualParticipations.isEmpty());
        assertSame(favoriteRestaurants, actualFavoriteRestaurants);
        assertSame(participations2, actualParticipations);
    }
}
