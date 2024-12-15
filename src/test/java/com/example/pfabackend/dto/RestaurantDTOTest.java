package com.example.pfabackend.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.pfabackend.entities.Location;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RestaurantDTOTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link RestaurantDTO#equals(Object)}
     *   <li>{@link RestaurantDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);
        RestaurantDTO buildResult = RestaurantDTO.builder()
                .coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1)
                .location(location)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);
        RestaurantDTO buildResult2 = RestaurantDTO.builder()
                .coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1)
                .location(location2)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        // Act and Assert
        assertEquals(buildResult, buildResult2);
        int expectedHashCodeResult = buildResult.hashCode();
        assertEquals(expectedHashCodeResult, buildResult2.hashCode());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link RestaurantDTO#equals(Object)}
     *   <li>{@link RestaurantDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);
        RestaurantDTO buildResult = RestaurantDTO.builder()
                .coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1)
                .location(location)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        // Act and Assert
        assertEquals(buildResult, buildResult);
        int expectedHashCodeResult = buildResult.hashCode();
        assertEquals(expectedHashCodeResult, buildResult.hashCode());
    }

    /**
     * Method under test: {@link RestaurantDTO#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
        // Arrange
        RestaurantDTO.RestaurantDTOBuilder restaurantDTOBuilder = mock(RestaurantDTO.RestaurantDTOBuilder.class);
        when(restaurantDTOBuilder.coverImageUrl(Mockito.<String>any())).thenReturn(RestaurantDTO.builder());
        RestaurantDTO.RestaurantDTOBuilder likesResult = restaurantDTOBuilder.coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1);

        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);
        RestaurantDTO buildResult = likesResult.location(location)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);
        RestaurantDTO buildResult2 = RestaurantDTO.builder()
                .coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1)
                .location(location2)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }

    /**
     * Method under test: {@link RestaurantDTO#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
        // Arrange
        RestaurantDTO.RestaurantDTOBuilder restaurantDTOBuilder = mock(RestaurantDTO.RestaurantDTOBuilder.class);
        when(restaurantDTOBuilder.coverImageUrl(Mockito.<String>any())).thenReturn(RestaurantDTO.builder());
        RestaurantDTO.RestaurantDTOBuilder likesResult = restaurantDTOBuilder.coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(2L)
                .instagram("Instagram")
                .likes(1);

        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);
        RestaurantDTO buildResult = likesResult.location(location)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);
        RestaurantDTO buildResult2 = RestaurantDTO.builder()
                .coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1)
                .location(location2)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }

    /**
     * Method under test: {@link RestaurantDTO#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
        // Arrange
        RestaurantDTO.RestaurantDTOBuilder restaurantDTOBuilder = mock(RestaurantDTO.RestaurantDTOBuilder.class);
        when(restaurantDTOBuilder.coverImageUrl(Mockito.<String>any())).thenReturn(RestaurantDTO.builder());
        RestaurantDTO.RestaurantDTOBuilder likesResult = restaurantDTOBuilder.coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(null)
                .instagram("Instagram")
                .likes(1);

        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);
        RestaurantDTO buildResult = likesResult.location(location)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);
        RestaurantDTO buildResult2 = RestaurantDTO.builder()
                .coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1)
                .location(location2)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }

    /**
     * Method under test: {@link RestaurantDTO#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
        // Arrange
        RestaurantDTO.RestaurantDTOBuilder restaurantDTOBuilder = mock(RestaurantDTO.RestaurantDTOBuilder.class);
        when(restaurantDTOBuilder.coverImageUrl(Mockito.<String>any())).thenReturn(RestaurantDTO.builder());
        RestaurantDTO.RestaurantDTOBuilder likesResult = restaurantDTOBuilder.coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(3);

        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);
        RestaurantDTO buildResult = likesResult.location(location)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);
        RestaurantDTO buildResult2 = RestaurantDTO.builder()
                .coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1)
                .location(location2)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }

    /**
     * Method under test: {@link RestaurantDTO#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
        // Arrange
        RestaurantDTO.RestaurantDTOBuilder restaurantDTOBuilder = mock(RestaurantDTO.RestaurantDTOBuilder.class);
        when(restaurantDTOBuilder.coverImageUrl(Mockito.<String>any())).thenReturn(RestaurantDTO.builder());
        RestaurantDTO.RestaurantDTOBuilder likesResult = restaurantDTOBuilder.coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1);
        Location location = mock(Location.class);
        doNothing().when(location).setLatitude(anyDouble());
        doNothing().when(location).setLongitude(anyDouble());
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);
        RestaurantDTO buildResult = likesResult.location(location)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);
        RestaurantDTO buildResult2 = RestaurantDTO.builder()
                .coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1)
                .location(location2)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }

    /**
     * Method under test: {@link RestaurantDTO#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
        // Arrange
        RestaurantDTO.RestaurantDTOBuilder restaurantDTOBuilder = mock(RestaurantDTO.RestaurantDTOBuilder.class);
        when(restaurantDTOBuilder.coverImageUrl(Mockito.<String>any())).thenReturn(RestaurantDTO.builder());
        RestaurantDTO.RestaurantDTOBuilder likesResult = restaurantDTOBuilder.coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1);
        Location location = mock(Location.class);
        doNothing().when(location).setLatitude(anyDouble());
        doNothing().when(location).setLongitude(anyDouble());
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);
        RestaurantDTO buildResult = likesResult.location(location)
                .logoUrl("https://example.org/example")
                .name(null)
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);
        RestaurantDTO buildResult2 = RestaurantDTO.builder()
                .coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1)
                .location(location2)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }

    /**
     * Method under test: {@link RestaurantDTO#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
        // Arrange
        RestaurantDTO.RestaurantDTOBuilder restaurantDTOBuilder = mock(RestaurantDTO.RestaurantDTOBuilder.class);
        when(restaurantDTOBuilder.coverImageUrl(Mockito.<String>any())).thenReturn(RestaurantDTO.builder());
        RestaurantDTO.RestaurantDTOBuilder likesResult = restaurantDTOBuilder.coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1);
        Location location = mock(Location.class);
        doNothing().when(location).setLatitude(anyDouble());
        doNothing().when(location).setLongitude(anyDouble());
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);
        RestaurantDTO buildResult = likesResult.location(location)
                .logoUrl("https://example.org/example")
                .name("42")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);
        RestaurantDTO buildResult2 = RestaurantDTO.builder()
                .coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1)
                .location(location2)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }

    /**
     * Method under test: {@link RestaurantDTO#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
        // Arrange
        RestaurantDTO.RestaurantDTOBuilder restaurantDTOBuilder = mock(RestaurantDTO.RestaurantDTOBuilder.class);
        when(restaurantDTOBuilder.coverImageUrl(Mockito.<String>any())).thenReturn(RestaurantDTO.builder());
        RestaurantDTO.RestaurantDTOBuilder likesResult = restaurantDTOBuilder.coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1);
        Location location = mock(Location.class);
        doNothing().when(location).setLatitude(anyDouble());
        doNothing().when(location).setLongitude(anyDouble());
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);
        RestaurantDTO buildResult = likesResult.location(location)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(0.5d)
                .build();

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);
        RestaurantDTO buildResult2 = RestaurantDTO.builder()
                .coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1)
                .location(location2)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }

    /**
     * Method under test: {@link RestaurantDTO#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
        // Arrange
        RestaurantDTO.RestaurantDTOBuilder restaurantDTOBuilder = mock(RestaurantDTO.RestaurantDTOBuilder.class);
        when(restaurantDTOBuilder.coverImageUrl(Mockito.<String>any())).thenReturn(RestaurantDTO.builder());
        RestaurantDTO.RestaurantDTOBuilder likesResult = restaurantDTOBuilder.coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1);
        Location location = mock(Location.class);
        doNothing().when(location).setLatitude(anyDouble());
        doNothing().when(location).setLongitude(anyDouble());
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);
        RestaurantDTO buildResult = likesResult.location(location)
                .logoUrl("https://example.org/example")
                .name(null)
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);
        RestaurantDTO buildResult2 = RestaurantDTO.builder()
                .coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1)
                .location(location2)
                .logoUrl("https://example.org/example")
                .name(null)
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        // Act and Assert
        assertNotEquals(buildResult, buildResult2);
    }

    /**
     * Method under test: {@link RestaurantDTO#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsNull_thenReturnNotEqual() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);
        RestaurantDTO buildResult = RestaurantDTO.builder()
                .coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1)
                .location(location)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        // Act and Assert
        assertNotEquals(buildResult, null);
    }

    /**
     * Method under test: {@link RestaurantDTO#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);
        RestaurantDTO buildResult = RestaurantDTO.builder()
                .coverImageUrl("https://example.org/example")
                .cuisine("Cuisine")
                .description("The characteristics of someone or something")
                .email("jane.doe@example.org")
                .id(1L)
                .instagram("Instagram")
                .likes(1)
                .location(location)
                .logoUrl("https://example.org/example")
                .name("Name")
                .phoneNumber("6625550144")
                .priceRange("Price Range")
                .rating(10.0d)
                .build();

        // Act and Assert
        assertNotEquals(buildResult, "Different type to RestaurantDTO");
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link RestaurantDTO#RestaurantDTO()}
     *   <li>{@link RestaurantDTO#setCoverImageUrl(String)}
     *   <li>{@link RestaurantDTO#setCuisine(String)}
     *   <li>{@link RestaurantDTO#setDescription(String)}
     *   <li>{@link RestaurantDTO#setEmail(String)}
     *   <li>{@link RestaurantDTO#setId(Long)}
     *   <li>{@link RestaurantDTO#setInstagram(String)}
     *   <li>{@link RestaurantDTO#setLikes(int)}
     *   <li>{@link RestaurantDTO#setLocation(Location)}
     *   <li>{@link RestaurantDTO#setLogoUrl(String)}
     *   <li>{@link RestaurantDTO#setName(String)}
     *   <li>{@link RestaurantDTO#setPhoneNumber(String)}
     *   <li>{@link RestaurantDTO#setPriceRange(String)}
     *   <li>{@link RestaurantDTO#setRating(double)}
     *   <li>{@link RestaurantDTO#toString()}
     *   <li>{@link RestaurantDTO#getCoverImageUrl()}
     *   <li>{@link RestaurantDTO#getCuisine()}
     *   <li>{@link RestaurantDTO#getDescription()}
     *   <li>{@link RestaurantDTO#getEmail()}
     *   <li>{@link RestaurantDTO#getId()}
     *   <li>{@link RestaurantDTO#getInstagram()}
     *   <li>{@link RestaurantDTO#getLikes()}
     *   <li>{@link RestaurantDTO#getLocation()}
     *   <li>{@link RestaurantDTO#getLogoUrl()}
     *   <li>{@link RestaurantDTO#getName()}
     *   <li>{@link RestaurantDTO#getPhoneNumber()}
     *   <li>{@link RestaurantDTO#getPriceRange()}
     *   <li>{@link RestaurantDTO#getRating()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        RestaurantDTO actualRestaurantDTO = new RestaurantDTO();
        actualRestaurantDTO.setCoverImageUrl("https://example.org/example");
        actualRestaurantDTO.setCuisine("Cuisine");
        actualRestaurantDTO.setDescription("The characteristics of someone or something");
        actualRestaurantDTO.setEmail("jane.doe@example.org");
        actualRestaurantDTO.setId(1L);
        actualRestaurantDTO.setInstagram("Instagram");
        actualRestaurantDTO.setLikes(1);
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);
        actualRestaurantDTO.setLocation(location);
        actualRestaurantDTO.setLogoUrl("https://example.org/example");
        actualRestaurantDTO.setName("Name");
        actualRestaurantDTO.setPhoneNumber("6625550144");
        actualRestaurantDTO.setPriceRange("Price Range");
        actualRestaurantDTO.setRating(10.0d);
        String actualToStringResult = actualRestaurantDTO.toString();
        String actualCoverImageUrl = actualRestaurantDTO.getCoverImageUrl();
        String actualCuisine = actualRestaurantDTO.getCuisine();
        String actualDescription = actualRestaurantDTO.getDescription();
        String actualEmail = actualRestaurantDTO.getEmail();
        Long actualId = actualRestaurantDTO.getId();
        String actualInstagram = actualRestaurantDTO.getInstagram();
        int actualLikes = actualRestaurantDTO.getLikes();
        Location actualLocation = actualRestaurantDTO.getLocation();
        String actualLogoUrl = actualRestaurantDTO.getLogoUrl();
        String actualName = actualRestaurantDTO.getName();
        String actualPhoneNumber = actualRestaurantDTO.getPhoneNumber();
        String actualPriceRange = actualRestaurantDTO.getPriceRange();

        // Assert that nothing has changed
        assertEquals("6625550144", actualPhoneNumber);
        assertEquals("Cuisine", actualCuisine);
        assertEquals("Instagram", actualInstagram);
        assertEquals("Name", actualName);
        assertEquals("Price Range", actualPriceRange);
        assertEquals("RestaurantDTO(id=1, name=Name, location=Location(latitude=10.0, longitude=10.0), coverImageUrl=https"
                + "://example.org/example, logoUrl=https://example.org/example, cuisine=Cuisine, rating=10.0, description=The"
                + " characteristics of someone or something, instagram=Instagram, phoneNumber=6625550144, email=jane.doe"
                + "@example.org, likes=1, priceRange=Price Range)", actualToStringResult);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals("https://example.org/example", actualCoverImageUrl);
        assertEquals("https://example.org/example", actualLogoUrl);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals(1, actualLikes);
        assertEquals(10.0d, actualRestaurantDTO.getRating());
        assertEquals(1L, actualId.longValue());
        assertSame(location, actualLocation);
    }

    /**
     * Method under test:
     * {@link RestaurantDTO#RestaurantDTO(Long, String, Location, String, String, String, double, String, String, String, String, int, String)}
     */
    @Test
    void testNewRestaurantDTO() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        // Act
        RestaurantDTO actualRestaurantDTO = new RestaurantDTO(1L, "Name", location, "https://example.org/example",
                "https://example.org/example", "Cuisine", 10.0d, "The characteristics of someone or something", "Instagram",
                "6625550144", "jane.doe@example.org", 1, "Price Range");

        // Assert
        assertEquals("6625550144", actualRestaurantDTO.getPhoneNumber());
        assertEquals("Cuisine", actualRestaurantDTO.getCuisine());
        assertEquals("Instagram", actualRestaurantDTO.getInstagram());
        assertEquals("Name", actualRestaurantDTO.getName());
        assertEquals("Price Range", actualRestaurantDTO.getPriceRange());
        assertEquals("The characteristics of someone or something", actualRestaurantDTO.getDescription());
        assertEquals("https://example.org/example", actualRestaurantDTO.getCoverImageUrl());
        assertEquals("https://example.org/example", actualRestaurantDTO.getLogoUrl());
        assertEquals("jane.doe@example.org", actualRestaurantDTO.getEmail());
        assertEquals(1, actualRestaurantDTO.getLikes());
        assertEquals(10.0d, actualRestaurantDTO.getRating());
        assertEquals(1L, actualRestaurantDTO.getId().longValue());
        assertSame(location, actualRestaurantDTO.getLocation());
    }
}
