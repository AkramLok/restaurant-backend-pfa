package com.example.pfabackend.entities;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    @Test
    void testSetIdWhenIdIsSetThenReturnId() {
        // Arrange
        Long expectedId = 1L;
        Product product = new Product();

        // Act
        product.setId(expectedId);
        Long actualId = product.getId();

        // Assert
        assertThat(actualId).isEqualTo(expectedId);
    }

    @Test
    void testSetNameWhenNameIsSetThenReturnName() {
        // Arrange
        String expectedName = "Pizza";
        Product product = new Product();

        // Act
        product.setName(expectedName);
        String actualName = product.getName();

        // Assert
        assertThat(actualName).isEqualTo(expectedName);
    }


    @Test
    void testSetPriceWhenPriceIsSetThenReturnPrice() {
        // Arrange
        double expectedPrice = 9.99;
        Product product = new Product();

        // Act
        product.setPrice(expectedPrice);
        double actualPrice = product.getPrice();

        // Assert
        assertThat(actualPrice).isEqualTo(expectedPrice);
    }


    @Test
    void testSetBonusPointsWhenBonusPointsIsSetThenReturnBonusPoints() {
        // Arrange
        int expectedBonusPoints = 100;
        Product product = new Product();

        // Act
        product.setBonusPoints(expectedBonusPoints);
        int actualBonusPoints = product.getBonusPoints();

        // Assert
        assertThat(actualBonusPoints).isEqualTo(expectedBonusPoints);
    }

    @Test
    void testSetInfoWhenInfoIsSetThenReturnInfo() {
        // Arrange
        String expectedInfo = "Delicious pizza with extra cheese";
        Product product = new Product();

        // Act
        product.setInfo(expectedInfo);
        String actualInfo = product.getInfo();

        // Assert
        assertThat(actualInfo).isEqualTo(expectedInfo);
    }

    @Test
    void testSetImgWhenImgIsSetThenReturnImg() {
        // Arrange
        String expectedImg = "pizza.jpg";
        Product product = new Product();

        // Act
        product.setImg(expectedImg);
        String actualImg = product.getImg();

        // Assert
        assertThat(actualImg).isEqualTo(expectedImg);
    }

    @Test
    void testSetIsActivatedWhenIsActivatedIsSetThenReturnIsActivated() {
        // Arrange
        Boolean expectedIsActivated = true;
        Product product = new Product();

        // Act
        product.setIsActivated(expectedIsActivated);
        Boolean actualIsActivated = product.getIsActivated();

        // Assert
        assertThat(actualIsActivated).isEqualTo(expectedIsActivated);
    }

    @Test
    void testSetCategoryWhenCategoryIsSetThenReturnCategory() {
        // Arrange
        FoodCategory expectedCategory = new FoodCategory();
        expectedCategory.setId(1L);
        expectedCategory.setName("Fast Food");
        Product product = new Product();

        // Act
        product.setCategory(expectedCategory);
        FoodCategory actualCategory = product.getCategory();

        // Assert
        assertThat(actualCategory).isEqualTo(expectedCategory);
    }
}
