package com.example.pfabackend.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DiscountTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Discount#equals(Object)}
     *   <li>{@link Discount#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(new Restaurant());

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Cuisine");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Instagram");
        restaurant.setLikes(1);
        restaurant.setLocation(location);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(owner);
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

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCoverImageUrl("https://example.org/example");
        restaurant2.setCuisine("Cuisine");
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setEmail("jane.doe@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(1L);
        restaurant2.setInstagram("Instagram");
        restaurant2.setLikes(1);
        restaurant2.setLocation(new Location());
        restaurant2.setLogoUrl("https://example.org/example");
        restaurant2.setName("Name");
        restaurant2.setOwner(new Owner());
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("Price Range");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant2);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location2);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner2);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        ProductCollection productCollection = new ProductCollection();
        productCollection.setId(1L);
        productCollection.setProducts(new HashSet<>());
        productCollection.setRestaurant(restaurant3);
        productCollection.setTotalPrice(10.0d);

        Discount discount = new Discount();
        discount.setDiscountPercentage(3);
        discount.setId(1L);
        discount.setProduct(product);
        discount.setProductCollection(productCollection);

        // Act and Assert
        assertEquals(discount, discount);
        int expectedHashCodeResult = discount.hashCode();
        assertEquals(expectedHashCodeResult, discount.hashCode());
    }

    /**
     * Method under test: {@link Discount#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(new Restaurant());

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Cuisine");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Instagram");
        restaurant.setLikes(1);
        restaurant.setLocation(location);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(owner);
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

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCoverImageUrl("https://example.org/example");
        restaurant2.setCuisine("Cuisine");
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setEmail("jane.doe@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(1L);
        restaurant2.setInstagram("Instagram");
        restaurant2.setLikes(1);
        restaurant2.setLocation(new Location());
        restaurant2.setLogoUrl("https://example.org/example");
        restaurant2.setName("Name");
        restaurant2.setOwner(new Owner());
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("Price Range");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant2);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location2);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner2);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        ProductCollection productCollection = new ProductCollection();
        productCollection.setId(1L);
        productCollection.setProducts(new HashSet<>());
        productCollection.setRestaurant(restaurant3);
        productCollection.setTotalPrice(10.0d);

        Discount discount = new Discount();
        discount.setDiscountPercentage(3);
        discount.setId(1L);
        discount.setProduct(product);
        discount.setProductCollection(productCollection);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(new Restaurant());

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
        restaurant4.setOwner(owner3);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        FoodCategory category2 = new FoodCategory();
        category2.setId(1L);
        category2.setIsActivated(true);
        category2.setName("Name");
        category2.setProducts(new ArrayList<>());
        category2.setRestaurant(restaurant4);

        Product product2 = new Product();
        product2.setBonusPoints(1);
        product2.setCategory(category2);
        product2.setId(1L);
        product2.setImg("Img");
        product2.setInfo("Info");
        product2.setIsActivated(true);
        product2.setName("Name");
        product2.setPrice(10.0d);

        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);

        Restaurant restaurant5 = new Restaurant();
        restaurant5.setCoverImageUrl("https://example.org/example");
        restaurant5.setCuisine("Cuisine");
        restaurant5.setDescription("The characteristics of someone or something");
        restaurant5.setEmail("jane.doe@example.org");
        restaurant5.setFoodCategories(new ArrayList<>());
        restaurant5.setId(1L);
        restaurant5.setInstagram("Instagram");
        restaurant5.setLikes(1);
        restaurant5.setLocation(new Location());
        restaurant5.setLogoUrl("https://example.org/example");
        restaurant5.setName("Name");
        restaurant5.setOwner(new Owner());
        restaurant5.setParticipations(new HashSet<>());
        restaurant5.setPhoneNumber("6625550144");
        restaurant5.setPriceRange("Price Range");
        restaurant5.setRating(10.0d);
        restaurant5.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(restaurant5);

        Restaurant restaurant6 = new Restaurant();
        restaurant6.setCoverImageUrl("https://example.org/example");
        restaurant6.setCuisine("Cuisine");
        restaurant6.setDescription("The characteristics of someone or something");
        restaurant6.setEmail("jane.doe@example.org");
        restaurant6.setFoodCategories(new ArrayList<>());
        restaurant6.setId(1L);
        restaurant6.setInstagram("Instagram");
        restaurant6.setLikes(1);
        restaurant6.setLocation(location4);
        restaurant6.setLogoUrl("https://example.org/example");
        restaurant6.setName("Name");
        restaurant6.setOwner(owner4);
        restaurant6.setParticipations(new HashSet<>());
        restaurant6.setPhoneNumber("6625550144");
        restaurant6.setPriceRange("Price Range");
        restaurant6.setRating(10.0d);
        restaurant6.setWaiters(new ArrayList<>());

        ProductCollection productCollection2 = new ProductCollection();
        productCollection2.setId(1L);
        productCollection2.setProducts(new HashSet<>());
        productCollection2.setRestaurant(restaurant6);
        productCollection2.setTotalPrice(10.0d);

        Discount discount2 = new Discount();
        discount2.setDiscountPercentage(3);
        discount2.setId(1L);
        discount2.setProduct(product2);
        discount2.setProductCollection(productCollection2);

        // Act and Assert
        assertNotEquals(discount, discount2);
    }

    /**
     * Method under test: {@link Discount#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(new Restaurant());

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Cuisine");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Instagram");
        restaurant.setLikes(1);
        restaurant.setLocation(location);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(owner);
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

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCoverImageUrl("https://example.org/example");
        restaurant2.setCuisine("Cuisine");
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setEmail("jane.doe@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(1L);
        restaurant2.setInstagram("Instagram");
        restaurant2.setLikes(1);
        restaurant2.setLocation(new Location());
        restaurant2.setLogoUrl("https://example.org/example");
        restaurant2.setName("Name");
        restaurant2.setOwner(new Owner());
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("Price Range");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant2);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location2);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner2);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        ProductCollection productCollection = new ProductCollection();
        productCollection.setId(1L);
        productCollection.setProducts(new HashSet<>());
        productCollection.setRestaurant(restaurant3);
        productCollection.setTotalPrice(10.0d);

        Discount discount = new Discount();
        discount.setDiscountPercentage(1);
        discount.setId(1L);
        discount.setProduct(product);
        discount.setProductCollection(productCollection);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(new Restaurant());

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
        restaurant4.setOwner(owner3);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        FoodCategory category2 = new FoodCategory();
        category2.setId(1L);
        category2.setIsActivated(true);
        category2.setName("Name");
        category2.setProducts(new ArrayList<>());
        category2.setRestaurant(restaurant4);

        Product product2 = new Product();
        product2.setBonusPoints(1);
        product2.setCategory(category2);
        product2.setId(1L);
        product2.setImg("Img");
        product2.setInfo("Info");
        product2.setIsActivated(true);
        product2.setName("Name");
        product2.setPrice(10.0d);

        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);

        Restaurant restaurant5 = new Restaurant();
        restaurant5.setCoverImageUrl("https://example.org/example");
        restaurant5.setCuisine("Cuisine");
        restaurant5.setDescription("The characteristics of someone or something");
        restaurant5.setEmail("jane.doe@example.org");
        restaurant5.setFoodCategories(new ArrayList<>());
        restaurant5.setId(1L);
        restaurant5.setInstagram("Instagram");
        restaurant5.setLikes(1);
        restaurant5.setLocation(new Location());
        restaurant5.setLogoUrl("https://example.org/example");
        restaurant5.setName("Name");
        restaurant5.setOwner(new Owner());
        restaurant5.setParticipations(new HashSet<>());
        restaurant5.setPhoneNumber("6625550144");
        restaurant5.setPriceRange("Price Range");
        restaurant5.setRating(10.0d);
        restaurant5.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(restaurant5);

        Restaurant restaurant6 = new Restaurant();
        restaurant6.setCoverImageUrl("https://example.org/example");
        restaurant6.setCuisine("Cuisine");
        restaurant6.setDescription("The characteristics of someone or something");
        restaurant6.setEmail("jane.doe@example.org");
        restaurant6.setFoodCategories(new ArrayList<>());
        restaurant6.setId(1L);
        restaurant6.setInstagram("Instagram");
        restaurant6.setLikes(1);
        restaurant6.setLocation(location4);
        restaurant6.setLogoUrl("https://example.org/example");
        restaurant6.setName("Name");
        restaurant6.setOwner(owner4);
        restaurant6.setParticipations(new HashSet<>());
        restaurant6.setPhoneNumber("6625550144");
        restaurant6.setPriceRange("Price Range");
        restaurant6.setRating(10.0d);
        restaurant6.setWaiters(new ArrayList<>());

        ProductCollection productCollection2 = new ProductCollection();
        productCollection2.setId(1L);
        productCollection2.setProducts(new HashSet<>());
        productCollection2.setRestaurant(restaurant6);
        productCollection2.setTotalPrice(10.0d);

        Discount discount2 = new Discount();
        discount2.setDiscountPercentage(3);
        discount2.setId(1L);
        discount2.setProduct(product2);
        discount2.setProductCollection(productCollection2);

        // Act and Assert
        assertNotEquals(discount, discount2);
    }

    /**
     * Method under test: {@link Discount#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(new Restaurant());

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Cuisine");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Instagram");
        restaurant.setLikes(1);
        restaurant.setLocation(location);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(owner);
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

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCoverImageUrl("https://example.org/example");
        restaurant2.setCuisine("Cuisine");
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setEmail("jane.doe@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(1L);
        restaurant2.setInstagram("Instagram");
        restaurant2.setLikes(1);
        restaurant2.setLocation(new Location());
        restaurant2.setLogoUrl("https://example.org/example");
        restaurant2.setName("Name");
        restaurant2.setOwner(new Owner());
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("Price Range");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant2);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location2);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner2);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        ProductCollection productCollection = new ProductCollection();
        productCollection.setId(1L);
        productCollection.setProducts(new HashSet<>());
        productCollection.setRestaurant(restaurant3);
        productCollection.setTotalPrice(10.0d);

        Discount discount = new Discount();
        discount.setDiscountPercentage(3);
        discount.setId(2L);
        discount.setProduct(product);
        discount.setProductCollection(productCollection);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(new Restaurant());

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
        restaurant4.setOwner(owner3);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        FoodCategory category2 = new FoodCategory();
        category2.setId(1L);
        category2.setIsActivated(true);
        category2.setName("Name");
        category2.setProducts(new ArrayList<>());
        category2.setRestaurant(restaurant4);

        Product product2 = new Product();
        product2.setBonusPoints(1);
        product2.setCategory(category2);
        product2.setId(1L);
        product2.setImg("Img");
        product2.setInfo("Info");
        product2.setIsActivated(true);
        product2.setName("Name");
        product2.setPrice(10.0d);

        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);

        Restaurant restaurant5 = new Restaurant();
        restaurant5.setCoverImageUrl("https://example.org/example");
        restaurant5.setCuisine("Cuisine");
        restaurant5.setDescription("The characteristics of someone or something");
        restaurant5.setEmail("jane.doe@example.org");
        restaurant5.setFoodCategories(new ArrayList<>());
        restaurant5.setId(1L);
        restaurant5.setInstagram("Instagram");
        restaurant5.setLikes(1);
        restaurant5.setLocation(new Location());
        restaurant5.setLogoUrl("https://example.org/example");
        restaurant5.setName("Name");
        restaurant5.setOwner(new Owner());
        restaurant5.setParticipations(new HashSet<>());
        restaurant5.setPhoneNumber("6625550144");
        restaurant5.setPriceRange("Price Range");
        restaurant5.setRating(10.0d);
        restaurant5.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(restaurant5);

        Restaurant restaurant6 = new Restaurant();
        restaurant6.setCoverImageUrl("https://example.org/example");
        restaurant6.setCuisine("Cuisine");
        restaurant6.setDescription("The characteristics of someone or something");
        restaurant6.setEmail("jane.doe@example.org");
        restaurant6.setFoodCategories(new ArrayList<>());
        restaurant6.setId(1L);
        restaurant6.setInstagram("Instagram");
        restaurant6.setLikes(1);
        restaurant6.setLocation(location4);
        restaurant6.setLogoUrl("https://example.org/example");
        restaurant6.setName("Name");
        restaurant6.setOwner(owner4);
        restaurant6.setParticipations(new HashSet<>());
        restaurant6.setPhoneNumber("6625550144");
        restaurant6.setPriceRange("Price Range");
        restaurant6.setRating(10.0d);
        restaurant6.setWaiters(new ArrayList<>());

        ProductCollection productCollection2 = new ProductCollection();
        productCollection2.setId(1L);
        productCollection2.setProducts(new HashSet<>());
        productCollection2.setRestaurant(restaurant6);
        productCollection2.setTotalPrice(10.0d);

        Discount discount2 = new Discount();
        discount2.setDiscountPercentage(3);
        discount2.setId(1L);
        discount2.setProduct(product2);
        discount2.setProductCollection(productCollection2);

        // Act and Assert
        assertNotEquals(discount, discount2);
    }

    /**
     * Method under test: {@link Discount#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(new Restaurant());

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Cuisine");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Instagram");
        restaurant.setLikes(1);
        restaurant.setLocation(location);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(owner);
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

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCoverImageUrl("https://example.org/example");
        restaurant2.setCuisine("Cuisine");
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setEmail("jane.doe@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(1L);
        restaurant2.setInstagram("Instagram");
        restaurant2.setLikes(1);
        restaurant2.setLocation(new Location());
        restaurant2.setLogoUrl("https://example.org/example");
        restaurant2.setName("Name");
        restaurant2.setOwner(new Owner());
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("Price Range");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant2);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location2);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner2);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        ProductCollection productCollection = new ProductCollection();
        productCollection.setId(1L);
        productCollection.setProducts(new HashSet<>());
        productCollection.setRestaurant(restaurant3);
        productCollection.setTotalPrice(10.0d);

        Discount discount = new Discount();
        discount.setDiscountPercentage(3);
        discount.setId(null);
        discount.setProduct(product);
        discount.setProductCollection(productCollection);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(new Restaurant());

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
        restaurant4.setOwner(owner3);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        FoodCategory category2 = new FoodCategory();
        category2.setId(1L);
        category2.setIsActivated(true);
        category2.setName("Name");
        category2.setProducts(new ArrayList<>());
        category2.setRestaurant(restaurant4);

        Product product2 = new Product();
        product2.setBonusPoints(1);
        product2.setCategory(category2);
        product2.setId(1L);
        product2.setImg("Img");
        product2.setInfo("Info");
        product2.setIsActivated(true);
        product2.setName("Name");
        product2.setPrice(10.0d);

        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);

        Restaurant restaurant5 = new Restaurant();
        restaurant5.setCoverImageUrl("https://example.org/example");
        restaurant5.setCuisine("Cuisine");
        restaurant5.setDescription("The characteristics of someone or something");
        restaurant5.setEmail("jane.doe@example.org");
        restaurant5.setFoodCategories(new ArrayList<>());
        restaurant5.setId(1L);
        restaurant5.setInstagram("Instagram");
        restaurant5.setLikes(1);
        restaurant5.setLocation(new Location());
        restaurant5.setLogoUrl("https://example.org/example");
        restaurant5.setName("Name");
        restaurant5.setOwner(new Owner());
        restaurant5.setParticipations(new HashSet<>());
        restaurant5.setPhoneNumber("6625550144");
        restaurant5.setPriceRange("Price Range");
        restaurant5.setRating(10.0d);
        restaurant5.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(restaurant5);

        Restaurant restaurant6 = new Restaurant();
        restaurant6.setCoverImageUrl("https://example.org/example");
        restaurant6.setCuisine("Cuisine");
        restaurant6.setDescription("The characteristics of someone or something");
        restaurant6.setEmail("jane.doe@example.org");
        restaurant6.setFoodCategories(new ArrayList<>());
        restaurant6.setId(1L);
        restaurant6.setInstagram("Instagram");
        restaurant6.setLikes(1);
        restaurant6.setLocation(location4);
        restaurant6.setLogoUrl("https://example.org/example");
        restaurant6.setName("Name");
        restaurant6.setOwner(owner4);
        restaurant6.setParticipations(new HashSet<>());
        restaurant6.setPhoneNumber("6625550144");
        restaurant6.setPriceRange("Price Range");
        restaurant6.setRating(10.0d);
        restaurant6.setWaiters(new ArrayList<>());

        ProductCollection productCollection2 = new ProductCollection();
        productCollection2.setId(1L);
        productCollection2.setProducts(new HashSet<>());
        productCollection2.setRestaurant(restaurant6);
        productCollection2.setTotalPrice(10.0d);

        Discount discount2 = new Discount();
        discount2.setDiscountPercentage(3);
        discount2.setId(1L);
        discount2.setProduct(product2);
        discount2.setProductCollection(productCollection2);

        // Act and Assert
        assertNotEquals(discount, discount2);
    }

    /**
     * Method under test: {@link Discount#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(new Restaurant());

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Cuisine");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Instagram");
        restaurant.setLikes(1);
        restaurant.setLocation(location);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(owner);
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
        Product product = mock(Product.class);
        doNothing().when(product).setBonusPoints(anyInt());
        doNothing().when(product).setCategory(Mockito.<FoodCategory>any());
        doNothing().when(product).setId(Mockito.<Long>any());
        doNothing().when(product).setImg(Mockito.<String>any());
        doNothing().when(product).setInfo(Mockito.<String>any());
        doNothing().when(product).setIsActivated(Mockito.<Boolean>any());
        doNothing().when(product).setName(Mockito.<String>any());
        doNothing().when(product).setPrice(anyDouble());
        product.setBonusPoints(1);
        product.setCategory(category);
        product.setId(1L);
        product.setImg("Img");
        product.setInfo("Info");
        product.setIsActivated(true);
        product.setName("Name");
        product.setPrice(10.0d);

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCoverImageUrl("https://example.org/example");
        restaurant2.setCuisine("Cuisine");
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setEmail("jane.doe@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(1L);
        restaurant2.setInstagram("Instagram");
        restaurant2.setLikes(1);
        restaurant2.setLocation(new Location());
        restaurant2.setLogoUrl("https://example.org/example");
        restaurant2.setName("Name");
        restaurant2.setOwner(new Owner());
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("Price Range");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant2);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location2);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner2);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        ProductCollection productCollection = new ProductCollection();
        productCollection.setId(1L);
        productCollection.setProducts(new HashSet<>());
        productCollection.setRestaurant(restaurant3);
        productCollection.setTotalPrice(10.0d);

        Discount discount = new Discount();
        discount.setDiscountPercentage(3);
        discount.setId(1L);
        discount.setProduct(product);
        discount.setProductCollection(productCollection);

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(new Restaurant());

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
        restaurant4.setOwner(owner3);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        FoodCategory category2 = new FoodCategory();
        category2.setId(1L);
        category2.setIsActivated(true);
        category2.setName("Name");
        category2.setProducts(new ArrayList<>());
        category2.setRestaurant(restaurant4);

        Product product2 = new Product();
        product2.setBonusPoints(1);
        product2.setCategory(category2);
        product2.setId(1L);
        product2.setImg("Img");
        product2.setInfo("Info");
        product2.setIsActivated(true);
        product2.setName("Name");
        product2.setPrice(10.0d);

        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);

        Restaurant restaurant5 = new Restaurant();
        restaurant5.setCoverImageUrl("https://example.org/example");
        restaurant5.setCuisine("Cuisine");
        restaurant5.setDescription("The characteristics of someone or something");
        restaurant5.setEmail("jane.doe@example.org");
        restaurant5.setFoodCategories(new ArrayList<>());
        restaurant5.setId(1L);
        restaurant5.setInstagram("Instagram");
        restaurant5.setLikes(1);
        restaurant5.setLocation(new Location());
        restaurant5.setLogoUrl("https://example.org/example");
        restaurant5.setName("Name");
        restaurant5.setOwner(new Owner());
        restaurant5.setParticipations(new HashSet<>());
        restaurant5.setPhoneNumber("6625550144");
        restaurant5.setPriceRange("Price Range");
        restaurant5.setRating(10.0d);
        restaurant5.setWaiters(new ArrayList<>());

        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(restaurant5);

        Restaurant restaurant6 = new Restaurant();
        restaurant6.setCoverImageUrl("https://example.org/example");
        restaurant6.setCuisine("Cuisine");
        restaurant6.setDescription("The characteristics of someone or something");
        restaurant6.setEmail("jane.doe@example.org");
        restaurant6.setFoodCategories(new ArrayList<>());
        restaurant6.setId(1L);
        restaurant6.setInstagram("Instagram");
        restaurant6.setLikes(1);
        restaurant6.setLocation(location4);
        restaurant6.setLogoUrl("https://example.org/example");
        restaurant6.setName("Name");
        restaurant6.setOwner(owner4);
        restaurant6.setParticipations(new HashSet<>());
        restaurant6.setPhoneNumber("6625550144");
        restaurant6.setPriceRange("Price Range");
        restaurant6.setRating(10.0d);
        restaurant6.setWaiters(new ArrayList<>());

        ProductCollection productCollection2 = new ProductCollection();
        productCollection2.setId(1L);
        productCollection2.setProducts(new HashSet<>());
        productCollection2.setRestaurant(restaurant6);
        productCollection2.setTotalPrice(10.0d);

        Discount discount2 = new Discount();
        discount2.setDiscountPercentage(3);
        discount2.setId(1L);
        discount2.setProduct(product2);
        discount2.setProductCollection(productCollection2);

        // Act and Assert
        assertNotEquals(discount, discount2);
    }

    /**
     * Method under test: {@link Discount#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsNull_thenReturnNotEqual() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(new Restaurant());

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Cuisine");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Instagram");
        restaurant.setLikes(1);
        restaurant.setLocation(location);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(owner);
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

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCoverImageUrl("https://example.org/example");
        restaurant2.setCuisine("Cuisine");
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setEmail("jane.doe@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(1L);
        restaurant2.setInstagram("Instagram");
        restaurant2.setLikes(1);
        restaurant2.setLocation(new Location());
        restaurant2.setLogoUrl("https://example.org/example");
        restaurant2.setName("Name");
        restaurant2.setOwner(new Owner());
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("Price Range");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant2);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location2);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner2);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        ProductCollection productCollection = new ProductCollection();
        productCollection.setId(1L);
        productCollection.setProducts(new HashSet<>());
        productCollection.setRestaurant(restaurant3);
        productCollection.setTotalPrice(10.0d);

        Discount discount = new Discount();
        discount.setDiscountPercentage(3);
        discount.setId(1L);
        discount.setProduct(product);
        discount.setProductCollection(productCollection);

        // Act and Assert
        assertNotEquals(discount, null);
    }

    /**
     * Method under test: {@link Discount#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(new Restaurant());

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Cuisine");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Instagram");
        restaurant.setLikes(1);
        restaurant.setLocation(location);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(owner);
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

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCoverImageUrl("https://example.org/example");
        restaurant2.setCuisine("Cuisine");
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setEmail("jane.doe@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(1L);
        restaurant2.setInstagram("Instagram");
        restaurant2.setLikes(1);
        restaurant2.setLocation(new Location());
        restaurant2.setLogoUrl("https://example.org/example");
        restaurant2.setName("Name");
        restaurant2.setOwner(new Owner());
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("Price Range");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant2);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location2);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner2);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        ProductCollection productCollection = new ProductCollection();
        productCollection.setId(1L);
        productCollection.setProducts(new HashSet<>());
        productCollection.setRestaurant(restaurant3);
        productCollection.setTotalPrice(10.0d);

        Discount discount = new Discount();
        discount.setDiscountPercentage(3);
        discount.setId(1L);
        discount.setProduct(product);
        discount.setProductCollection(productCollection);

        // Act and Assert
        assertNotEquals(discount, "Different type to Discount");
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Discount#Discount()}
     *   <li>{@link Discount#setDiscountPercentage(int)}
     *   <li>{@link Discount#setId(Long)}
     *   <li>{@link Discount#setProduct(Product)}
     *   <li>{@link Discount#setProductCollection(ProductCollection)}
     *   <li>{@link Discount#toString()}
     *   <li>{@link Discount#getDiscountPercentage()}
     *   <li>{@link Discount#getId()}
     *   <li>{@link Discount#getProduct()}
     *   <li>{@link Discount#getProductCollection()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        Discount actualDiscount = new Discount();
        actualDiscount.setDiscountPercentage(3);
        actualDiscount.setId(1L);
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);
        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(new Restaurant());
        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Cuisine");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Instagram");
        restaurant.setLikes(1);
        restaurant.setLocation(location);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(owner);
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
        actualDiscount.setProduct(product);
        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);
        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCoverImageUrl("https://example.org/example");
        restaurant2.setCuisine("Cuisine");
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setEmail("jane.doe@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(1L);
        restaurant2.setInstagram("Instagram");
        restaurant2.setLikes(1);
        restaurant2.setLocation(new Location());
        restaurant2.setLogoUrl("https://example.org/example");
        restaurant2.setName("Name");
        restaurant2.setOwner(new Owner());
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("Price Range");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());
        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant2);
        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location2);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner2);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());
        ProductCollection productCollection = new ProductCollection();
        productCollection.setId(1L);
        productCollection.setProducts(new HashSet<>());
        productCollection.setRestaurant(restaurant3);
        productCollection.setTotalPrice(10.0d);
        actualDiscount.setProductCollection(productCollection);
        String actualToStringResult = actualDiscount.toString();
        int actualDiscountPercentage = actualDiscount.getDiscountPercentage();
        Long actualId = actualDiscount.getId();
        Product actualProduct = actualDiscount.getProduct();
        ProductCollection actualProductCollection = actualDiscount.getProductCollection();

        // Assert that nothing has changed
        assertEquals("Discount(id=1, product=Product(id=1, name=Name, price=10.0, bonusPoints=1, info=Info, img=Img,"
                + " isActivated=true, category=FoodCategory(id=1, name=Name, restaurant=Restaurant(id=1, name=Name,"
                + " location=Location(latitude=10.0, longitude=10.0), coverImageUrl=https://example.org/example,"
                + " logoUrl=https://example.org/example, cuisine=Cuisine, rating=10.0, description=The characteristics"
                + " of someone or something, instagram=Instagram, phoneNumber=6625550144, email=jane.doe@example.org,"
                + " likes=1, priceRange=Price Range, participations=[], waiters=[], foodCategories=[], owner=Owner(id=1,"
                + " name=Name, email=jane.doe@example.org, phone=6625550144, restaurant=Restaurant(id=null, name=null,"
                + " location=null, coverImageUrl=null, logoUrl=null, cuisine=null, rating=0.0, description=null,"
                + " instagram=null, phoneNumber=null, email=null, likes=0, priceRange=null, participations=null, waiters=null,"
                + " foodCategories=null, owner=null))), isActivated=true, products=[])), productCollection=ProductCollection"
                + "(id=1, products=[], totalPrice=10.0, restaurant=Restaurant(id=1, name=Name, location=Location(latitude=10.0,"
                + " longitude=10.0), coverImageUrl=https://example.org/example, logoUrl=https://example.org/example,"
                + " cuisine=Cuisine, rating=10.0, description=The characteristics of someone or something, instagram=Instagram,"
                + " phoneNumber=6625550144, email=jane.doe@example.org, likes=1, priceRange=Price Range, participations=[],"
                + " waiters=[], foodCategories=[], owner=Owner(id=1, name=Name, email=jane.doe@example.org, phone=6625550144,"
                + " restaurant=Restaurant(id=1, name=Name, location=Location(latitude=0.0, longitude=0.0), coverImageUrl"
                + "=https://example.org/example, logoUrl=https://example.org/example, cuisine=Cuisine, rating=10.0,"
                + " description=The characteristics of someone or something, instagram=Instagram, phoneNumber=6625550144,"
                + " email=jane.doe@example.org, likes=1, priceRange=Price Range, participations=[], waiters=[],"
                + " foodCategories=[], owner=Owner(id=null, name=null, email=null, phone=null, restaurant=null))))),"
                + " discountPercentage=3)", actualToStringResult);
        assertEquals(1L, actualId.longValue());
        assertEquals(3, actualDiscountPercentage);
        assertSame(product, actualProduct);
        assertSame(productCollection, actualProductCollection);
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Discount#Discount(Long, Product, ProductCollection, int)}
     *   <li>{@link Discount#setDiscountPercentage(int)}
     *   <li>{@link Discount#setId(Long)}
     *   <li>{@link Discount#setProduct(Product)}
     *   <li>{@link Discount#setProductCollection(ProductCollection)}
     *   <li>{@link Discount#toString()}
     *   <li>{@link Discount#getDiscountPercentage()}
     *   <li>{@link Discount#getId()}
     *   <li>{@link Discount#getProduct()}
     *   <li>{@link Discount#getProductCollection()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(new Restaurant());

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Cuisine");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Instagram");
        restaurant.setLikes(1);
        restaurant.setLocation(location);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(owner);
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

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCoverImageUrl("https://example.org/example");
        restaurant2.setCuisine("Cuisine");
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setEmail("jane.doe@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(1L);
        restaurant2.setInstagram("Instagram");
        restaurant2.setLikes(1);
        restaurant2.setLocation(new Location());
        restaurant2.setLogoUrl("https://example.org/example");
        restaurant2.setName("Name");
        restaurant2.setOwner(new Owner());
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("Price Range");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant2);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(location2);
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(owner2);
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        ProductCollection productCollection = new ProductCollection();
        productCollection.setId(1L);
        productCollection.setProducts(new HashSet<>());
        productCollection.setRestaurant(restaurant3);
        productCollection.setTotalPrice(10.0d);

        // Act
        Discount actualDiscount = new Discount(1L, product, productCollection, 3);
        actualDiscount.setDiscountPercentage(3);
        actualDiscount.setId(1L);
        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);
        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(new Restaurant());
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
        restaurant4.setOwner(owner3);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());
        FoodCategory category2 = new FoodCategory();
        category2.setId(1L);
        category2.setIsActivated(true);
        category2.setName("Name");
        category2.setProducts(new ArrayList<>());
        category2.setRestaurant(restaurant4);
        Product product2 = new Product();
        product2.setBonusPoints(1);
        product2.setCategory(category2);
        product2.setId(1L);
        product2.setImg("Img");
        product2.setInfo("Info");
        product2.setIsActivated(true);
        product2.setName("Name");
        product2.setPrice(10.0d);
        actualDiscount.setProduct(product2);
        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);
        Restaurant restaurant5 = new Restaurant();
        restaurant5.setCoverImageUrl("https://example.org/example");
        restaurant5.setCuisine("Cuisine");
        restaurant5.setDescription("The characteristics of someone or something");
        restaurant5.setEmail("jane.doe@example.org");
        restaurant5.setFoodCategories(new ArrayList<>());
        restaurant5.setId(1L);
        restaurant5.setInstagram("Instagram");
        restaurant5.setLikes(1);
        restaurant5.setLocation(new Location());
        restaurant5.setLogoUrl("https://example.org/example");
        restaurant5.setName("Name");
        restaurant5.setOwner(new Owner());
        restaurant5.setParticipations(new HashSet<>());
        restaurant5.setPhoneNumber("6625550144");
        restaurant5.setPriceRange("Price Range");
        restaurant5.setRating(10.0d);
        restaurant5.setWaiters(new ArrayList<>());
        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(restaurant5);
        Restaurant restaurant6 = new Restaurant();
        restaurant6.setCoverImageUrl("https://example.org/example");
        restaurant6.setCuisine("Cuisine");
        restaurant6.setDescription("The characteristics of someone or something");
        restaurant6.setEmail("jane.doe@example.org");
        restaurant6.setFoodCategories(new ArrayList<>());
        restaurant6.setId(1L);
        restaurant6.setInstagram("Instagram");
        restaurant6.setLikes(1);
        restaurant6.setLocation(location4);
        restaurant6.setLogoUrl("https://example.org/example");
        restaurant6.setName("Name");
        restaurant6.setOwner(owner4);
        restaurant6.setParticipations(new HashSet<>());
        restaurant6.setPhoneNumber("6625550144");
        restaurant6.setPriceRange("Price Range");
        restaurant6.setRating(10.0d);
        restaurant6.setWaiters(new ArrayList<>());
        ProductCollection productCollection2 = new ProductCollection();
        productCollection2.setId(1L);
        productCollection2.setProducts(new HashSet<>());
        productCollection2.setRestaurant(restaurant6);
        productCollection2.setTotalPrice(10.0d);
        actualDiscount.setProductCollection(productCollection2);
        String actualToStringResult = actualDiscount.toString();
        int actualDiscountPercentage = actualDiscount.getDiscountPercentage();
        Long actualId = actualDiscount.getId();
        Product actualProduct = actualDiscount.getProduct();
        ProductCollection actualProductCollection = actualDiscount.getProductCollection();

        // Assert that nothing has changed
        assertEquals("Discount(id=1, product=Product(id=1, name=Name, price=10.0, bonusPoints=1, info=Info, img=Img,"
                + " isActivated=true, category=FoodCategory(id=1, name=Name, restaurant=Restaurant(id=1, name=Name,"
                + " location=Location(latitude=10.0, longitude=10.0), coverImageUrl=https://example.org/example,"
                + " logoUrl=https://example.org/example, cuisine=Cuisine, rating=10.0, description=The characteristics"
                + " of someone or something, instagram=Instagram, phoneNumber=6625550144, email=jane.doe@example.org,"
                + " likes=1, priceRange=Price Range, participations=[], waiters=[], foodCategories=[], owner=Owner(id=1,"
                + " name=Name, email=jane.doe@example.org, phone=6625550144, restaurant=Restaurant(id=null, name=null,"
                + " location=null, coverImageUrl=null, logoUrl=null, cuisine=null, rating=0.0, description=null,"
                + " instagram=null, phoneNumber=null, email=null, likes=0, priceRange=null, participations=null, waiters=null,"
                + " foodCategories=null, owner=null))), isActivated=true, products=[])), productCollection=ProductCollection"
                + "(id=1, products=[], totalPrice=10.0, restaurant=Restaurant(id=1, name=Name, location=Location(latitude=10.0,"
                + " longitude=10.0), coverImageUrl=https://example.org/example, logoUrl=https://example.org/example,"
                + " cuisine=Cuisine, rating=10.0, description=The characteristics of someone or something, instagram=Instagram,"
                + " phoneNumber=6625550144, email=jane.doe@example.org, likes=1, priceRange=Price Range, participations=[],"
                + " waiters=[], foodCategories=[], owner=Owner(id=1, name=Name, email=jane.doe@example.org, phone=6625550144,"
                + " restaurant=Restaurant(id=1, name=Name, location=Location(latitude=0.0, longitude=0.0), coverImageUrl"
                + "=https://example.org/example, logoUrl=https://example.org/example, cuisine=Cuisine, rating=10.0,"
                + " description=The characteristics of someone or something, instagram=Instagram, phoneNumber=6625550144,"
                + " email=jane.doe@example.org, likes=1, priceRange=Price Range, participations=[], waiters=[],"
                + " foodCategories=[], owner=Owner(id=null, name=null, email=null, phone=null, restaurant=null))))),"
                + " discountPercentage=3)", actualToStringResult);
        assertEquals(1L, actualId.longValue());
        assertEquals(3, actualDiscountPercentage);
        assertSame(product2, actualProduct);
        assertSame(productCollection2, actualProductCollection);
    }
}
