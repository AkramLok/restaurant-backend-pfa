package com.example.pfabackend.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.assertj.core.api.Assertions;

import java.util.HashSet;
import java.util.Set;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductCollectionTest {

    @Test
    void testSetIdWhenIdIsSetThenReturnId() {
        // Arrange
        ProductCollection productCollection = new ProductCollection();
        Long expectedId = 2L;

        // Act
        productCollection.setId(expectedId);
        Long actualId = productCollection.getId();

        // Assert
        Assertions.assertThat(actualId).isEqualTo(expectedId);
    }

    @Test
    void testSetProductsWhenProductsAreSetThenReturnProducts() {
        // Arrange
        ProductCollection productCollection = new ProductCollection();
        Set<ProductInCollection> expectedProducts = new HashSet<>();
        expectedProducts.add(new ProductInCollection());

        // Act
        productCollection.setProducts(expectedProducts);
        Set<ProductInCollection> actualProducts = productCollection.getProducts();

        // Assert
        Assertions.assertThat(actualProducts).isEqualTo(expectedProducts);
    }

    @Test
    void testSetTotalPriceWhenTotalPriceIsSetThenReturnTotalPrice() {
        // Arrange
        ProductCollection productCollection = new ProductCollection();
        double expectedTotalPrice = 200.0;

        // Act
        productCollection.setTotalPrice(expectedTotalPrice);
        double actualTotalPrice = productCollection.getTotalPrice();

        // Assert
        Assertions.assertThat(actualTotalPrice).isEqualTo(expectedTotalPrice);
    }

    @Test
    void testSetRestaurantWhenRestaurantIsSetThenReturnRestaurant() {
        // Arrange
        ProductCollection productCollection = new ProductCollection();
        Restaurant expectedRestaurant = new Restaurant();

        // Act
        productCollection.setRestaurant(expectedRestaurant);
        Restaurant actualRestaurant = productCollection.getRestaurant();

        // Assert
        Assertions.assertThat(actualRestaurant).isEqualTo(expectedRestaurant);
    }
}
