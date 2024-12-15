package com.example.pfabackend.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class RewardTest {

    private Reward reward;

    @BeforeEach
    public void setUp() {
        reward = new Reward();
    }

    @Test
    void testGetAndSetIdWhenIdIsSetThenIdIsReturned() {
        // Arrange
        Long expectedId = 1L;

        // Act
        reward.setId(expectedId);
        Long actualId = reward.getId();

        // Assert
        Assertions.assertThat(actualId).isEqualTo(expectedId);
    }

    @Test
    void testGetAndSetProductWhenProductIsSetThenProductIsReturned() {
        // Arrange
        Product expectedProduct = new Product();
        expectedProduct.setId(1L);
        expectedProduct.setName("Test Product");
        expectedProduct.setPrice(10.0);
        expectedProduct.setBonusPoints(100);
        expectedProduct.setInfo("Test Info");
        expectedProduct.setImg("test.jpg");
        expectedProduct.setIsActivated(true);

        // Act
        reward.setProduct(expectedProduct);
        Product actualProduct = reward.getProduct();

        // Assert
        Assertions.assertThat(actualProduct).isEqualTo(expectedProduct);
    }

    @Test
    void testGetAndSetProductCollectionWhenProductCollectionIsSetThenProductCollectionIsReturned() {
        // Arrange
        ProductCollection expectedProductCollection = new ProductCollection();
        expectedProductCollection.setId(1L);
        expectedProductCollection.setTotalPrice(100.0);

        // Act
        reward.setProductCollection(expectedProductCollection);
        ProductCollection actualProductCollection = reward.getProductCollection();

        // Assert
        Assertions.assertThat(actualProductCollection).isEqualTo(expectedProductCollection);
    }

    @Test
    void testGetAndSetRequiredPointsWhenRequiredPointsIsSetThenRequiredPointsIsReturned() {
        // Arrange
        int expectedRequiredPoints = 500;

        // Act
        reward.setRequiredPoints(expectedRequiredPoints);
        int actualRequiredPoints = reward.getRequiredPoints();

        // Assert
        Assertions.assertThat(actualRequiredPoints).isEqualTo(expectedRequiredPoints);
    }
}