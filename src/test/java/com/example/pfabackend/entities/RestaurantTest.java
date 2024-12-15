package com.example.pfabackend.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.assertj.core.api.Assertions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RestaurantTest {

    @Test
    void testGetAndSetIdWhenIdIsSetThenIdIsReturned() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        Long expectedId = 1L;

        // Act
        restaurant.setId(expectedId);
        Long actualId = restaurant.getId();

        // Assert
        Assertions.assertThat(actualId).isEqualTo(expectedId);
    }

    @Test
    void testGetAndSetNameWhenNameIsSetThenNameIsReturned() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        String expectedName = "Test Restaurant";

        // Act
        restaurant.setName(expectedName);
        String actualName = restaurant.getName();

        // Assert
        Assertions.assertThat(actualName).isEqualTo(expectedName);
    }

    @Test
    void testGetAndSetLocationWhenLocationIsSetThenLocationIsReturned() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        Location expectedLocation = new Location(40.7128, -74.0060);

        // Act
        restaurant.setLocation(expectedLocation);
        Location actualLocation = restaurant.getLocation();

        // Assert
        Assertions.assertThat(actualLocation).isEqualTo(expectedLocation);
    }

    @Test
    void testGetAndSetCoverImageUrlWhenCoverImageUrlIsSetThenCoverImageUrlIsReturned() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        String expectedCoverImageUrl = "http://example.com/cover.jpg";

        // Act
        restaurant.setCoverImageUrl(expectedCoverImageUrl);
        String actualCoverImageUrl = restaurant.getCoverImageUrl();

        // Assert
        Assertions.assertThat(actualCoverImageUrl).isEqualTo(expectedCoverImageUrl);
    }

    @Test
    void testGetAndSetLogoUrlWhenLogoUrlIsSetThenLogoUrlIsReturned() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        String expectedLogoUrl = "http://example.com/logo.jpg";

        // Act
        restaurant.setLogoUrl(expectedLogoUrl);
        String actualLogoUrl = restaurant.getLogoUrl();

        // Assert
        Assertions.assertThat(actualLogoUrl).isEqualTo(expectedLogoUrl);
    }

    @Test
    void testGetAndSetCuisineWhenCuisineIsSetThenCuisineIsReturned() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        String expectedCuisine = "Italian";

        // Act
        restaurant.setCuisine(expectedCuisine);
        String actualCuisine = restaurant.getCuisine();

        // Assert
        Assertions.assertThat(actualCuisine).isEqualTo(expectedCuisine);
    }

    @Test
    void testGetAndSetRatingWhenRatingIsSetThenRatingIsReturned() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        double expectedRating = 4.5;

        // Act
        restaurant.setRating(expectedRating);
        double actualRating = restaurant.getRating();

        // Assert
        Assertions.assertThat(actualRating).isEqualTo(expectedRating);
    }

    @Test
    void testGetAndSetDescriptionWhenDescriptionIsSetThenDescriptionIsReturned() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        String expectedDescription = "A cozy place with delicious food.";

        // Act
        restaurant.setDescription(expectedDescription);
        String actualDescription = restaurant.getDescription();

        // Assert
        Assertions.assertThat(actualDescription).isEqualTo(expectedDescription);
    }

    @Test
    void testGetAndSetInstagramWhenInstagramIsSetThenInstagramIsReturned() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        String expectedInstagram = "@testrestaurant";

        // Act
        restaurant.setInstagram(expectedInstagram);
        String actualInstagram = restaurant.getInstagram();

        // Assert
        Assertions.assertThat(actualInstagram).isEqualTo(expectedInstagram);
    }

    @Test
    void testGetAndSetPhoneNumberWhenPhoneNumberIsSetThenPhoneNumberIsReturned() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        String expectedPhoneNumber = "123-456-7890";

        // Act
        restaurant.setPhoneNumber(expectedPhoneNumber);
        String actualPhoneNumber = restaurant.getPhoneNumber();

        // Assert
        Assertions.assertThat(actualPhoneNumber).isEqualTo(expectedPhoneNumber);
    }

    @Test
    void testGetAndSetEmailWhenEmailIsSetThenEmailIsReturned() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        String expectedEmail = "test@example.com";

        // Act
        restaurant.setEmail(expectedEmail);
        String actualEmail = restaurant.getEmail();

        // Assert
        Assertions.assertThat(actualEmail).isEqualTo(expectedEmail);
    }

    @Test
    void testGetAndSetLikesWhenLikesIsSetThenLikesIsReturned() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        int expectedLikes = 100;

        // Act
        restaurant.setLikes(expectedLikes);
        int actualLikes = restaurant.getLikes();

        // Assert
        Assertions.assertThat(actualLikes).isEqualTo(expectedLikes);
    }

    @Test
    void testGetAndSetPriceRangeWhenPriceRangeIsSetThenPriceRangeIsReturned() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        String expectedPriceRange = "$$";

        // Act
        restaurant.setPriceRange(expectedPriceRange);
        String actualPriceRange = restaurant.getPriceRange();

        // Assert
        Assertions.assertThat(actualPriceRange).isEqualTo(expectedPriceRange);
    }

    @Test
    void testGetAndSetParticipationsWhenParticipationsIsSetThenParticipationsIsReturned() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        Set<Participation> expectedParticipations = new HashSet<>();

        // Act
        restaurant.setParticipations(expectedParticipations);
        Set<Participation> actualParticipations = restaurant.getParticipations();

        // Assert
        Assertions.assertThat(actualParticipations).isEqualTo(expectedParticipations);
    }

    @Test
    void testGetAndSetWaitersWhenWaitersIsSetThenWaitersIsReturned() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        List<Waiter> expectedWaiters = List.of(new Waiter());

        // Act
        restaurant.setWaiters(expectedWaiters);
        List<Waiter> actualWaiters = restaurant.getWaiters();

        // Assert
        Assertions.assertThat(actualWaiters).isEqualTo(expectedWaiters);
    }

    @Test
    void testGetAndSetFoodCategoriesWhenFoodCategoriesIsSetThenFoodCategoriesIsReturned() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        List<FoodCategory> expectedFoodCategories = List.of(new FoodCategory());

        // Act
        restaurant.setFoodCategories(expectedFoodCategories);
        List<FoodCategory> actualFoodCategories = restaurant.getFoodCategories();

        // Assert
        Assertions.assertThat(actualFoodCategories).isEqualTo(expectedFoodCategories);
    }

    @Test
    void testGetAndSetOwnerWhenOwnerIsSetThenOwnerIsReturned() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        Owner expectedOwner = new Owner();

        // Act
        restaurant.setOwner(expectedOwner);
        Owner actualOwner = restaurant.getOwner();

        // Assert
        Assertions.assertThat(actualOwner).isEqualTo(expectedOwner);
    }
}
