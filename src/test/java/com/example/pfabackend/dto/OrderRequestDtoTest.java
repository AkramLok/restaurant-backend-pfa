package com.example.pfabackend.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.pfabackend.entities.Discount;
import com.example.pfabackend.entities.FoodCategory;
import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Product;
import com.example.pfabackend.entities.ProductCollection;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.entities.Reward;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class OrderRequestDtoTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link OrderRequestDto#equals(Object)}
     *   <li>{@link OrderRequestDto#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
        // Arrange
        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setDiscounts(new HashSet<>());
        orderRequestDto.setProducts(new HashSet<>());
        orderRequestDto.setRewards(new HashSet<>());
        orderRequestDto.setTotalPrice(10.0d);

        OrderRequestDto orderRequestDto2 = new OrderRequestDto();
        orderRequestDto2.setDiscounts(new HashSet<>());
        orderRequestDto2.setProducts(new HashSet<>());
        orderRequestDto2.setRewards(new HashSet<>());
        orderRequestDto2.setTotalPrice(10.0d);

        // Act and Assert
        assertEquals(orderRequestDto, orderRequestDto2);
        int expectedHashCodeResult = orderRequestDto.hashCode();
        assertEquals(expectedHashCodeResult, orderRequestDto2.hashCode());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link OrderRequestDto#equals(Object)}
     *   <li>{@link OrderRequestDto#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
        // Arrange
        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setDiscounts(new HashSet<>());
        orderRequestDto.setProducts(new HashSet<>());
        orderRequestDto.setRewards(new HashSet<>());
        orderRequestDto.setTotalPrice(10.0d);

        // Act and Assert
        assertEquals(orderRequestDto, orderRequestDto);
        int expectedHashCodeResult = orderRequestDto.hashCode();
        assertEquals(expectedHashCodeResult, orderRequestDto.hashCode());
    }

    /**
     * Method under test: {@link OrderRequestDto#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
        // Arrange
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

        FoodCategory category = new FoodCategory();
        category.setId(1L);
        category.setIsActivated(true);
        category.setName("Name");
        category.setProducts(new ArrayList<>());
        category.setRestaurant(restaurant);

        Product product = new Product();
        product.setBonusPoints(1);
        product.setCategory(category);
        product.setId(1L);
        product.setImg("Img");
        product.setInfo("Info");
        product.setIsActivated(true);
        product.setName("Name");
        product.setPrice(10.0d);

        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(new Restaurant());

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

        ProductCollection productCollection = new ProductCollection();
        productCollection.setId(1L);
        productCollection.setProducts(new HashSet<>());
        productCollection.setRestaurant(restaurant2);
        productCollection.setTotalPrice(10.0d);

        Discount discount = new Discount();
        discount.setDiscountPercentage(3);
        discount.setId(1L);
        discount.setProduct(product);
        discount.setProductCollection(productCollection);

        HashSet<Discount> discounts = new HashSet<>();
        discounts.add(discount);

        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setDiscounts(discounts);
        orderRequestDto.setProducts(new HashSet<>());
        orderRequestDto.setRewards(new HashSet<>());
        orderRequestDto.setTotalPrice(10.0d);

        OrderRequestDto orderRequestDto2 = new OrderRequestDto();
        orderRequestDto2.setDiscounts(new HashSet<>());
        orderRequestDto2.setProducts(new HashSet<>());
        orderRequestDto2.setRewards(new HashSet<>());
        orderRequestDto2.setTotalPrice(10.0d);

        // Act and Assert
        assertNotEquals(orderRequestDto, orderRequestDto2);
    }

    /**
     * Method under test: {@link OrderRequestDto#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsNull_thenReturnNotEqual() {
        // Arrange
        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setDiscounts(new HashSet<>());
        orderRequestDto.setProducts(new HashSet<>());
        orderRequestDto.setRewards(new HashSet<>());
        orderRequestDto.setTotalPrice(10.0d);

        // Act and Assert
        assertNotEquals(orderRequestDto, null);
    }

    /**
     * Method under test: {@link OrderRequestDto#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
        // Arrange
        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setDiscounts(new HashSet<>());
        orderRequestDto.setProducts(new HashSet<>());
        orderRequestDto.setRewards(new HashSet<>());
        orderRequestDto.setTotalPrice(10.0d);

        // Act and Assert
        assertNotEquals(orderRequestDto, "Different type to OrderRequestDto");
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>default or parameterless constructor of {@link OrderRequestDto}
     *   <li>{@link OrderRequestDto#setDiscounts(Set)}
     *   <li>{@link OrderRequestDto#setProducts(Set)}
     *   <li>{@link OrderRequestDto#setRewards(Set)}
     *   <li>{@link OrderRequestDto#setTotalPrice(double)}
     *   <li>{@link OrderRequestDto#toString()}
     *   <li>{@link OrderRequestDto#getDiscounts()}
     *   <li>{@link OrderRequestDto#getProducts()}
     *   <li>{@link OrderRequestDto#getRewards()}
     *   <li>{@link OrderRequestDto#getTotalPrice()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        OrderRequestDto actualOrderRequestDto = new OrderRequestDto();
        HashSet<Discount> discounts = new HashSet<>();
        actualOrderRequestDto.setDiscounts(discounts);
        HashSet<Product> products = new HashSet<>();
        actualOrderRequestDto.setProducts(products);
        HashSet<Reward> rewards = new HashSet<>();
        actualOrderRequestDto.setRewards(rewards);
        actualOrderRequestDto.setTotalPrice(10.0d);
        String actualToStringResult = actualOrderRequestDto.toString();
        Set<Discount> actualDiscounts = actualOrderRequestDto.getDiscounts();
        Set<Product> actualProducts = actualOrderRequestDto.getProducts();
        Set<Reward> actualRewards = actualOrderRequestDto.getRewards();

        // Assert that nothing has changed
        assertEquals("OrderRequestDto(products=[], discounts=[], rewards=[], totalPrice=10.0)", actualToStringResult);
        assertEquals(10.0d, actualOrderRequestDto.getTotalPrice());
        assertTrue(actualDiscounts.isEmpty());
        assertTrue(actualProducts.isEmpty());
        assertTrue(actualRewards.isEmpty());
        assertSame(discounts, actualDiscounts);
        assertSame(products, actualProducts);
        assertSame(rewards, actualRewards);
    }
}
