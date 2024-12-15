package com.example.pfabackend.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class ProductInCollectionTest {

    private ProductInCollection productInCollection;

    @BeforeEach
    public void setUp() {
        productInCollection = new ProductInCollection();
    }

    @Test
    void testGetIdWhenIdIsSetThenReturnCorrectId() {
        // Arrange
        Long expectedId = 1L;
        productInCollection.setId(expectedId);

        // Act
        Long actualId = productInCollection.getId();

        // Assert
        Assertions.assertThat(actualId).isEqualTo(expectedId);
    }

    @Test
    void testSetIdWhenIdIsSetThenReturnCorrectId() {
        // Arrange
        Long expectedId = 2L;

        // Act
        productInCollection.setId(expectedId);
        Long actualId = productInCollection.getId();

        // Assert
        Assertions.assertThat(actualId).isEqualTo(expectedId);
    }

    @Test
    void testGetProductWhenProductIsSetThenReturnCorrectProduct() {
        // Arrange
        Product expectedProduct = new Product();
        expectedProduct.setId(1L);
        expectedProduct.setName("Test Product");
        expectedProduct.setPrice(10.0);
        expectedProduct.setBonusPoints(100);
        expectedProduct.setInfo("Test Info");
        expectedProduct.setImg("test.jpg");
        expectedProduct.setIsActivated(true);
        productInCollection.setProduct(expectedProduct);

        // Act
        Product actualProduct = productInCollection.getProduct();

        // Assert
        Assertions.assertThat(actualProduct).isEqualTo(expectedProduct);
    }

    @Test
    void testSetProductWhenProductIsSetThenReturnCorrectProduct() {
        // Arrange
        Product expectedProduct = new Product();
        expectedProduct.setId(2L);
        expectedProduct.setName("Test Product 2");
        expectedProduct.setPrice(20.0);
        expectedProduct.setBonusPoints(200);
        expectedProduct.setInfo("Test2 Info");
        expectedProduct.setImg("test2.jpg");
        expectedProduct.setIsActivated(true);

        // Act
        productInCollection.setProduct(expectedProduct);
        Product actualProduct = productInCollection.getProduct();

        // Assert
        Assertions.assertThat(actualProduct).isEqualTo(expectedProduct);
    }

    @Test
    void testGetCollectionWhenCollectionIsSetThenReturnCorrectCollection() {
        // Arrange
        ProductCollection expectedCollection = new ProductCollection();
        expectedCollection.setId(1L);
        expectedCollection.setTotalPrice(100.0);
        productInCollection.setCollection(expectedCollection);

        // Act
        ProductCollection actualCollection = productInCollection.getCollection();

        // Assert
        Assertions.assertThat(actualCollection).isEqualTo(expectedCollection);
    }

    @Test
    void testSetCollectionWhenCollectionIsSetThenReturnCorrectCollection() {
        // Arrange
        ProductCollection expectedCollection = new ProductCollection();
        expectedCollection.setId(2L);
        expectedCollection.setTotalPrice(200.0);

        // Act
        productInCollection.setCollection(expectedCollection);
        ProductCollection actualCollection = productInCollection.getCollection();

        // Assert
        Assertions.assertThat(actualCollection).isEqualTo(expectedCollection);
    }

    @Test
    void testGetQuantityWhenQuantityIsSetThenReturnCorrectQuantity() {
        // Arrange
        int expectedQuantity = 5;
        productInCollection.setQuantity(expectedQuantity);

        // Act
        int actualQuantity = productInCollection.getQuantity();

        // Assert
        Assertions.assertThat(actualQuantity).isEqualTo(expectedQuantity);
    }

    @Test
    void testSetQuantityWhenQuantityIsSetThenReturnCorrectQuantity() {
        // Arrange
        int expectedQuantity = 10;

        // Act
        productInCollection.setQuantity(expectedQuantity);
        int actualQuantity = productInCollection.getQuantity();

        // Assert
        Assertions.assertThat(actualQuantity).isEqualTo(expectedQuantity);
    }
}
