package com.example.pfabackend.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(Lifecycle.PER_CLASS)
class WaiterTest {

    private Waiter waiter;

    @BeforeEach
    public void setUp() {
        waiter = new Waiter();
    }

    @Test
    void testGetAndSetIdWhenIdIsSetThenIdIsReturned() {
        // Arrange
        Long expectedId = 1L;

        // Act
        waiter.setId(expectedId);
        Long actualId = waiter.getId();

        // Assert
        assertThat(actualId).isEqualTo(expectedId);
    }

    @Test
    void testGetAndSetNameWhenNameIsSetThenNameIsReturned() {
        // Arrange
        String expectedName = "John Doe";

        // Act
        waiter.setName(expectedName);
        String actualName = waiter.getName();

        // Assert
        assertThat(actualName).isEqualTo(expectedName);
    }

    @Test
    void testGetAndSetCinWhenCinIsSetThenCinIsReturned() {
        // Arrange
        String expectedCin = "CIN123456";

        // Act
        waiter.setCin(expectedCin);
        String actualCin = waiter.getCin();

        // Assert
        assertThat(actualCin).isEqualTo(expectedCin);
    }

    @Test
    void testGetAndSetPhoneWhenPhoneIsSetThenPhoneIsReturned() {
        // Arrange
        String expectedPhone = "123-456-7890";

        // Act
        waiter.setPhone(expectedPhone);
        String actualPhone = waiter.getPhone();

        // Assert
        assertThat(actualPhone).isEqualTo(expectedPhone);
    }

    @Test
    void testGetAndSetEmailWhenEmailIsSetThenEmailIsReturned() {
        // Arrange
        String expectedEmail = "john.doe@example.com";

        // Act
        waiter.setEmail(expectedEmail);
        String actualEmail = waiter.getEmail();

        // Assert
        assertThat(actualEmail).isEqualTo(expectedEmail);
    }

    @Test
    void testGetAndSetRestaurantWhenRestaurantIsSetThenRestaurantIsReturned() {
        // Arrange
        Restaurant expectedRestaurant = new Restaurant();
        expectedRestaurant.setId(1L);
        expectedRestaurant.setName("Test Restaurant");

        // Act
        waiter.setRestaurant(expectedRestaurant);
        Restaurant actualRestaurant = waiter.getRestaurant();

        // Assert
        assertThat(actualRestaurant).isEqualTo(expectedRestaurant);
    }
}