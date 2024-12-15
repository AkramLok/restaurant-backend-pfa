package com.example.pfabackend.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OrderTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Order#equals(Object)}
     *   <li>{@link Order#hashCode()}
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

        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

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

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(restaurant);

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

        Waiter waiter = new Waiter();
        waiter.setCin("Cin");
        waiter.setEmail("jane.doe@example.org");
        waiter.setId(1L);
        waiter.setName("Name");
        waiter.setPhone("6625550144");
        waiter.setRestaurant(restaurant2);

        Order order = new Order();
        order.setClient(client);
        order.setDiscounts(new HashSet<>());
        order.setId(1L);
        order.setProductCollections(new HashSet<>());
        order.setProducts(new HashSet<>());
        order.setRewards(new HashSet<>());
        order.setTotalPrice(10.0d);
        order.setWaiter(waiter);

        // Act and Assert
        assertEquals(order, order);
        int expectedHashCodeResult = order.hashCode();
        assertEquals(expectedHashCodeResult, order.hashCode());
    }

    /**
     * Method under test: {@link Order#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

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

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(restaurant);

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

        Waiter waiter = new Waiter();
        waiter.setCin("Cin");
        waiter.setEmail("jane.doe@example.org");
        waiter.setId(1L);
        waiter.setName("Name");
        waiter.setPhone("6625550144");
        waiter.setRestaurant(restaurant2);

        Order order = new Order();
        order.setClient(client);
        order.setDiscounts(new HashSet<>());
        order.setId(1L);
        order.setProductCollections(new HashSet<>());
        order.setProducts(new HashSet<>());
        order.setRewards(new HashSet<>());
        order.setTotalPrice(10.0d);
        order.setWaiter(waiter);

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(new Location());
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(new Owner());
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location2);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner2);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        Waiter waiter2 = new Waiter();
        waiter2.setCin("Cin");
        waiter2.setEmail("jane.doe@example.org");
        waiter2.setId(1L);
        waiter2.setName("Name");
        waiter2.setPhone("6625550144");
        waiter2.setRestaurant(restaurant4);

        Order order2 = new Order();
        order2.setClient(client2);
        order2.setDiscounts(new HashSet<>());
        order2.setId(1L);
        order2.setProductCollections(new HashSet<>());
        order2.setProducts(new HashSet<>());
        order2.setRewards(new HashSet<>());
        order2.setTotalPrice(10.0d);
        order2.setWaiter(waiter2);

        // Act and Assert
        assertNotEquals(order, order2);
    }

    /**
     * Method under test: {@link Order#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
        // Arrange
        Client client = mock(Client.class);
        doNothing().when(client).setEmail(Mockito.<String>any());
        doNothing().when(client).setFavoriteRestaurants(Mockito.<Set<Restaurant>>any());
        doNothing().when(client).setId(Mockito.<Long>any());
        doNothing().when(client).setName(Mockito.<String>any());
        doNothing().when(client).setParticipations(Mockito.<Set<Participation>>any());
        doNothing().when(client).setPhone(Mockito.<String>any());
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

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

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(restaurant);

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

        Waiter waiter = new Waiter();
        waiter.setCin("Cin");
        waiter.setEmail("jane.doe@example.org");
        waiter.setId(1L);
        waiter.setName("Name");
        waiter.setPhone("6625550144");
        waiter.setRestaurant(restaurant2);

        Order order = new Order();
        order.setClient(client);
        order.setDiscounts(new HashSet<>());
        order.setId(1L);
        order.setProductCollections(new HashSet<>());
        order.setProducts(new HashSet<>());
        order.setRewards(new HashSet<>());
        order.setTotalPrice(10.0d);
        order.setWaiter(waiter);

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(new Location());
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(new Owner());
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location2);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner2);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        Waiter waiter2 = new Waiter();
        waiter2.setCin("Cin");
        waiter2.setEmail("jane.doe@example.org");
        waiter2.setId(1L);
        waiter2.setName("Name");
        waiter2.setPhone("6625550144");
        waiter2.setRestaurant(restaurant4);

        Order order2 = new Order();
        order2.setClient(client2);
        order2.setDiscounts(new HashSet<>());
        order2.setId(1L);
        order2.setProductCollections(new HashSet<>());
        order2.setProducts(new HashSet<>());
        order2.setRewards(new HashSet<>());
        order2.setTotalPrice(10.0d);
        order2.setWaiter(waiter2);

        // Act and Assert
        assertNotEquals(order, order2);
    }

    /**
     * Method under test: {@link Order#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
        // Arrange
        Client client = mock(Client.class);
        doNothing().when(client).setEmail(Mockito.<String>any());
        doNothing().when(client).setFavoriteRestaurants(Mockito.<Set<Restaurant>>any());
        doNothing().when(client).setId(Mockito.<Long>any());
        doNothing().when(client).setName(Mockito.<String>any());
        doNothing().when(client).setParticipations(Mockito.<Set<Participation>>any());
        doNothing().when(client).setPhone(Mockito.<String>any());
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Name");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Name");
        restaurant.setLikes(1);
        restaurant.setLocation(new Location());
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(new Owner());
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("Name");
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
        product.setImg("Name");
        product.setInfo("Name");
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
        restaurant2.setOwner(owner);
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("Name");
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

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(new Location());
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(new Owner());
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location2);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner2);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        Waiter waiter = new Waiter();
        waiter.setCin("Cin");
        waiter.setEmail("jane.doe@example.org");
        waiter.setId(1L);
        waiter.setName("Name");
        waiter.setPhone("6625550144");
        waiter.setRestaurant(restaurant4);

        Order order = new Order();
        order.setClient(client);
        order.setDiscounts(discounts);
        order.setId(1L);
        order.setProductCollections(new HashSet<>());
        order.setProducts(new HashSet<>());
        order.setRewards(new HashSet<>());
        order.setTotalPrice(10.0d);
        order.setWaiter(waiter);

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

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

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(restaurant5);

        Restaurant restaurant6 = new Restaurant();
        restaurant6.setCoverImageUrl("https://example.org/example");
        restaurant6.setCuisine("Cuisine");
        restaurant6.setDescription("The characteristics of someone or something");
        restaurant6.setEmail("jane.doe@example.org");
        restaurant6.setFoodCategories(new ArrayList<>());
        restaurant6.setId(1L);
        restaurant6.setInstagram("Instagram");
        restaurant6.setLikes(1);
        restaurant6.setLocation(location3);
        restaurant6.setLogoUrl("https://example.org/example");
        restaurant6.setName("Name");
        restaurant6.setOwner(owner3);
        restaurant6.setParticipations(new HashSet<>());
        restaurant6.setPhoneNumber("6625550144");
        restaurant6.setPriceRange("Price Range");
        restaurant6.setRating(10.0d);
        restaurant6.setWaiters(new ArrayList<>());

        Waiter waiter2 = new Waiter();
        waiter2.setCin("Cin");
        waiter2.setEmail("jane.doe@example.org");
        waiter2.setId(1L);
        waiter2.setName("Name");
        waiter2.setPhone("6625550144");
        waiter2.setRestaurant(restaurant6);

        Order order2 = new Order();
        order2.setClient(client2);
        order2.setDiscounts(new HashSet<>());
        order2.setId(1L);
        order2.setProductCollections(new HashSet<>());
        order2.setProducts(new HashSet<>());
        order2.setRewards(new HashSet<>());
        order2.setTotalPrice(10.0d);
        order2.setWaiter(waiter2);

        // Act and Assert
        assertNotEquals(order, order2);
    }

    /**
     * Method under test: {@link Order#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
        // Arrange
        Client client = mock(Client.class);
        doNothing().when(client).setEmail(Mockito.<String>any());
        doNothing().when(client).setFavoriteRestaurants(Mockito.<Set<Restaurant>>any());
        doNothing().when(client).setId(Mockito.<Long>any());
        doNothing().when(client).setName(Mockito.<String>any());
        doNothing().when(client).setParticipations(Mockito.<Set<Participation>>any());
        doNothing().when(client).setPhone(Mockito.<String>any());
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

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

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(restaurant);

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

        Waiter waiter = new Waiter();
        waiter.setCin("Cin");
        waiter.setEmail("jane.doe@example.org");
        waiter.setId(1L);
        waiter.setName("Name");
        waiter.setPhone("6625550144");
        waiter.setRestaurant(restaurant2);

        Order order = new Order();
        order.setClient(client);
        order.setDiscounts(new HashSet<>());
        order.setId(2L);
        order.setProductCollections(new HashSet<>());
        order.setProducts(new HashSet<>());
        order.setRewards(new HashSet<>());
        order.setTotalPrice(10.0d);
        order.setWaiter(waiter);

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(new Location());
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(new Owner());
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location2);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner2);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        Waiter waiter2 = new Waiter();
        waiter2.setCin("Cin");
        waiter2.setEmail("jane.doe@example.org");
        waiter2.setId(1L);
        waiter2.setName("Name");
        waiter2.setPhone("6625550144");
        waiter2.setRestaurant(restaurant4);

        Order order2 = new Order();
        order2.setClient(client2);
        order2.setDiscounts(new HashSet<>());
        order2.setId(1L);
        order2.setProductCollections(new HashSet<>());
        order2.setProducts(new HashSet<>());
        order2.setRewards(new HashSet<>());
        order2.setTotalPrice(10.0d);
        order2.setWaiter(waiter2);

        // Act and Assert
        assertNotEquals(order, order2);
    }

    /**
     * Method under test: {@link Order#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
        // Arrange
        Client client = mock(Client.class);
        doNothing().when(client).setEmail(Mockito.<String>any());
        doNothing().when(client).setFavoriteRestaurants(Mockito.<Set<Restaurant>>any());
        doNothing().when(client).setId(Mockito.<Long>any());
        doNothing().when(client).setName(Mockito.<String>any());
        doNothing().when(client).setParticipations(Mockito.<Set<Participation>>any());
        doNothing().when(client).setPhone(Mockito.<String>any());
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

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

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(restaurant);

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

        Waiter waiter = new Waiter();
        waiter.setCin("Cin");
        waiter.setEmail("jane.doe@example.org");
        waiter.setId(1L);
        waiter.setName("Name");
        waiter.setPhone("6625550144");
        waiter.setRestaurant(restaurant2);

        Order order = new Order();
        order.setClient(client);
        order.setDiscounts(new HashSet<>());
        order.setId(null);
        order.setProductCollections(new HashSet<>());
        order.setProducts(new HashSet<>());
        order.setRewards(new HashSet<>());
        order.setTotalPrice(10.0d);
        order.setWaiter(waiter);

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(new Location());
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(new Owner());
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location2);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner2);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        Waiter waiter2 = new Waiter();
        waiter2.setCin("Cin");
        waiter2.setEmail("jane.doe@example.org");
        waiter2.setId(1L);
        waiter2.setName("Name");
        waiter2.setPhone("6625550144");
        waiter2.setRestaurant(restaurant4);

        Order order2 = new Order();
        order2.setClient(client2);
        order2.setDiscounts(new HashSet<>());
        order2.setId(1L);
        order2.setProductCollections(new HashSet<>());
        order2.setProducts(new HashSet<>());
        order2.setRewards(new HashSet<>());
        order2.setTotalPrice(10.0d);
        order2.setWaiter(waiter2);

        // Act and Assert
        assertNotEquals(order, order2);
    }

    /**
     * Method under test: {@link Order#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
        // Arrange
        Client client = mock(Client.class);
        doNothing().when(client).setEmail(Mockito.<String>any());
        doNothing().when(client).setFavoriteRestaurants(Mockito.<Set<Restaurant>>any());
        doNothing().when(client).setId(Mockito.<Long>any());
        doNothing().when(client).setName(Mockito.<String>any());
        doNothing().when(client).setParticipations(Mockito.<Set<Participation>>any());
        doNothing().when(client).setPhone(Mockito.<String>any());
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Name");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Name");
        restaurant.setLikes(1);
        restaurant.setLocation(new Location());
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(new Owner());
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("Name");
        restaurant.setRating(10.0d);
        restaurant.setWaiters(new ArrayList<>());

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(restaurant);

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
        restaurant2.setOwner(owner);
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("Name");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());

        ProductCollection productCollection = new ProductCollection();
        productCollection.setId(1L);
        productCollection.setProducts(new HashSet<>());
        productCollection.setRestaurant(restaurant2);
        productCollection.setTotalPrice(10.0d);

        HashSet<ProductCollection> productCollections = new HashSet<>();
        productCollections.add(productCollection);

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(new Location());
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(new Owner());
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location2);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner2);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        Waiter waiter = new Waiter();
        waiter.setCin("Cin");
        waiter.setEmail("jane.doe@example.org");
        waiter.setId(1L);
        waiter.setName("Name");
        waiter.setPhone("6625550144");
        waiter.setRestaurant(restaurant4);

        Order order = new Order();
        order.setClient(client);
        order.setDiscounts(new HashSet<>());
        order.setId(1L);
        order.setProductCollections(productCollections);
        order.setProducts(new HashSet<>());
        order.setRewards(new HashSet<>());
        order.setTotalPrice(10.0d);
        order.setWaiter(waiter);

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

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

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(restaurant5);

        Restaurant restaurant6 = new Restaurant();
        restaurant6.setCoverImageUrl("https://example.org/example");
        restaurant6.setCuisine("Cuisine");
        restaurant6.setDescription("The characteristics of someone or something");
        restaurant6.setEmail("jane.doe@example.org");
        restaurant6.setFoodCategories(new ArrayList<>());
        restaurant6.setId(1L);
        restaurant6.setInstagram("Instagram");
        restaurant6.setLikes(1);
        restaurant6.setLocation(location3);
        restaurant6.setLogoUrl("https://example.org/example");
        restaurant6.setName("Name");
        restaurant6.setOwner(owner3);
        restaurant6.setParticipations(new HashSet<>());
        restaurant6.setPhoneNumber("6625550144");
        restaurant6.setPriceRange("Price Range");
        restaurant6.setRating(10.0d);
        restaurant6.setWaiters(new ArrayList<>());

        Waiter waiter2 = new Waiter();
        waiter2.setCin("Cin");
        waiter2.setEmail("jane.doe@example.org");
        waiter2.setId(1L);
        waiter2.setName("Name");
        waiter2.setPhone("6625550144");
        waiter2.setRestaurant(restaurant6);

        Order order2 = new Order();
        order2.setClient(client2);
        order2.setDiscounts(new HashSet<>());
        order2.setId(1L);
        order2.setProductCollections(new HashSet<>());
        order2.setProducts(new HashSet<>());
        order2.setRewards(new HashSet<>());
        order2.setTotalPrice(10.0d);
        order2.setWaiter(waiter2);

        // Act and Assert
        assertNotEquals(order, order2);
    }

    /**
     * Method under test: {@link Order#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
        // Arrange
        Client client = mock(Client.class);
        doNothing().when(client).setEmail(Mockito.<String>any());
        doNothing().when(client).setFavoriteRestaurants(Mockito.<Set<Restaurant>>any());
        doNothing().when(client).setId(Mockito.<Long>any());
        doNothing().when(client).setName(Mockito.<String>any());
        doNothing().when(client).setParticipations(Mockito.<Set<Participation>>any());
        doNothing().when(client).setPhone(Mockito.<String>any());
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

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
        restaurant.setCuisine("Name");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Name");
        restaurant.setLikes(1);
        restaurant.setLocation(location);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(owner);
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("Name");
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
        product.setImg("Name");
        product.setInfo("Name");
        product.setIsActivated(true);
        product.setName("Name");
        product.setPrice(10.0d);

        HashSet<Product> products = new HashSet<>();
        products.add(product);

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

        Waiter waiter = new Waiter();
        waiter.setCin("Cin");
        waiter.setEmail("jane.doe@example.org");
        waiter.setId(1L);
        waiter.setName("Name");
        waiter.setPhone("6625550144");
        waiter.setRestaurant(restaurant3);

        Order order = new Order();
        order.setClient(client);
        order.setDiscounts(new HashSet<>());
        order.setId(1L);
        order.setProductCollections(new HashSet<>());
        order.setProducts(products);
        order.setRewards(new HashSet<>());
        order.setTotalPrice(10.0d);
        order.setWaiter(waiter);

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(new Location());
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(new Owner());
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(restaurant4);

        Restaurant restaurant5 = new Restaurant();
        restaurant5.setCoverImageUrl("https://example.org/example");
        restaurant5.setCuisine("Cuisine");
        restaurant5.setDescription("The characteristics of someone or something");
        restaurant5.setEmail("jane.doe@example.org");
        restaurant5.setFoodCategories(new ArrayList<>());
        restaurant5.setId(1L);
        restaurant5.setInstagram("Instagram");
        restaurant5.setLikes(1);
        restaurant5.setLocation(location3);
        restaurant5.setLogoUrl("https://example.org/example");
        restaurant5.setName("Name");
        restaurant5.setOwner(owner3);
        restaurant5.setParticipations(new HashSet<>());
        restaurant5.setPhoneNumber("6625550144");
        restaurant5.setPriceRange("Price Range");
        restaurant5.setRating(10.0d);
        restaurant5.setWaiters(new ArrayList<>());

        Waiter waiter2 = new Waiter();
        waiter2.setCin("Cin");
        waiter2.setEmail("jane.doe@example.org");
        waiter2.setId(1L);
        waiter2.setName("Name");
        waiter2.setPhone("6625550144");
        waiter2.setRestaurant(restaurant5);

        Order order2 = new Order();
        order2.setClient(client2);
        order2.setDiscounts(new HashSet<>());
        order2.setId(1L);
        order2.setProductCollections(new HashSet<>());
        order2.setProducts(new HashSet<>());
        order2.setRewards(new HashSet<>());
        order2.setTotalPrice(10.0d);
        order2.setWaiter(waiter2);

        // Act and Assert
        assertNotEquals(order, order2);
    }

    /**
     * Method under test: {@link Order#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
        // Arrange
        Client client = mock(Client.class);
        doNothing().when(client).setEmail(Mockito.<String>any());
        doNothing().when(client).setFavoriteRestaurants(Mockito.<Set<Restaurant>>any());
        doNothing().when(client).setId(Mockito.<Long>any());
        doNothing().when(client).setName(Mockito.<String>any());
        doNothing().when(client).setParticipations(Mockito.<Set<Participation>>any());
        doNothing().when(client).setPhone(Mockito.<String>any());
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");

        Restaurant restaurant = new Restaurant();
        restaurant.setCoverImageUrl("https://example.org/example");
        restaurant.setCuisine("Name");
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setEmail("jane.doe@example.org");
        restaurant.setFoodCategories(new ArrayList<>());
        restaurant.setId(1L);
        restaurant.setInstagram("Name");
        restaurant.setLikes(1);
        restaurant.setLocation(new Location());
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(new Owner());
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("Name");
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
        product.setImg("Name");
        product.setInfo("Name");
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
        restaurant2.setOwner(owner);
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("Name");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());

        ProductCollection productCollection = new ProductCollection();
        productCollection.setId(1L);
        productCollection.setProducts(new HashSet<>());
        productCollection.setRestaurant(restaurant2);
        productCollection.setTotalPrice(10.0d);

        Reward reward = new Reward();
        reward.setId(1L);
        reward.setProduct(product);
        reward.setProductCollection(productCollection);
        reward.setRequiredPoints(1);

        HashSet<Reward> rewards = new HashSet<>();
        rewards.add(reward);

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setCoverImageUrl("https://example.org/example");
        restaurant3.setCuisine("Cuisine");
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setEmail("jane.doe@example.org");
        restaurant3.setFoodCategories(new ArrayList<>());
        restaurant3.setId(1L);
        restaurant3.setInstagram("Instagram");
        restaurant3.setLikes(1);
        restaurant3.setLocation(new Location());
        restaurant3.setLogoUrl("https://example.org/example");
        restaurant3.setName("Name");
        restaurant3.setOwner(new Owner());
        restaurant3.setParticipations(new HashSet<>());
        restaurant3.setPhoneNumber("6625550144");
        restaurant3.setPriceRange("Price Range");
        restaurant3.setRating(10.0d);
        restaurant3.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant3);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setCoverImageUrl("https://example.org/example");
        restaurant4.setCuisine("Cuisine");
        restaurant4.setDescription("The characteristics of someone or something");
        restaurant4.setEmail("jane.doe@example.org");
        restaurant4.setFoodCategories(new ArrayList<>());
        restaurant4.setId(1L);
        restaurant4.setInstagram("Instagram");
        restaurant4.setLikes(1);
        restaurant4.setLocation(location2);
        restaurant4.setLogoUrl("https://example.org/example");
        restaurant4.setName("Name");
        restaurant4.setOwner(owner2);
        restaurant4.setParticipations(new HashSet<>());
        restaurant4.setPhoneNumber("6625550144");
        restaurant4.setPriceRange("Price Range");
        restaurant4.setRating(10.0d);
        restaurant4.setWaiters(new ArrayList<>());

        Waiter waiter = new Waiter();
        waiter.setCin("Cin");
        waiter.setEmail("jane.doe@example.org");
        waiter.setId(1L);
        waiter.setName("Name");
        waiter.setPhone("6625550144");
        waiter.setRestaurant(restaurant4);

        Order order = new Order();
        order.setClient(client);
        order.setDiscounts(new HashSet<>());
        order.setId(1L);
        order.setProductCollections(new HashSet<>());
        order.setProducts(new HashSet<>());
        order.setRewards(rewards);
        order.setTotalPrice(10.0d);
        order.setWaiter(waiter);

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");

        Location location3 = new Location();
        location3.setLatitude(10.0d);
        location3.setLongitude(10.0d);

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

        Owner owner3 = new Owner();
        owner3.setEmail("jane.doe@example.org");
        owner3.setId(1L);
        owner3.setName("Name");
        owner3.setPhone("6625550144");
        owner3.setRestaurant(restaurant5);

        Restaurant restaurant6 = new Restaurant();
        restaurant6.setCoverImageUrl("https://example.org/example");
        restaurant6.setCuisine("Cuisine");
        restaurant6.setDescription("The characteristics of someone or something");
        restaurant6.setEmail("jane.doe@example.org");
        restaurant6.setFoodCategories(new ArrayList<>());
        restaurant6.setId(1L);
        restaurant6.setInstagram("Instagram");
        restaurant6.setLikes(1);
        restaurant6.setLocation(location3);
        restaurant6.setLogoUrl("https://example.org/example");
        restaurant6.setName("Name");
        restaurant6.setOwner(owner3);
        restaurant6.setParticipations(new HashSet<>());
        restaurant6.setPhoneNumber("6625550144");
        restaurant6.setPriceRange("Price Range");
        restaurant6.setRating(10.0d);
        restaurant6.setWaiters(new ArrayList<>());

        Waiter waiter2 = new Waiter();
        waiter2.setCin("Cin");
        waiter2.setEmail("jane.doe@example.org");
        waiter2.setId(1L);
        waiter2.setName("Name");
        waiter2.setPhone("6625550144");
        waiter2.setRestaurant(restaurant6);

        Order order2 = new Order();
        order2.setClient(client2);
        order2.setDiscounts(new HashSet<>());
        order2.setId(1L);
        order2.setProductCollections(new HashSet<>());
        order2.setProducts(new HashSet<>());
        order2.setRewards(new HashSet<>());
        order2.setTotalPrice(10.0d);
        order2.setWaiter(waiter2);

        // Act and Assert
        assertNotEquals(order, order2);
    }

    /**
     * Method under test: {@link Order#equals(Object)}
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

        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

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

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(restaurant);

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

        Waiter waiter = new Waiter();
        waiter.setCin("Cin");
        waiter.setEmail("jane.doe@example.org");
        waiter.setId(1L);
        waiter.setName("Name");
        waiter.setPhone("6625550144");
        waiter.setRestaurant(restaurant2);

        Order order = new Order();
        order.setClient(client);
        order.setDiscounts(new HashSet<>());
        order.setId(1L);
        order.setProductCollections(new HashSet<>());
        order.setProducts(new HashSet<>());
        order.setRewards(new HashSet<>());
        order.setTotalPrice(10.0d);
        order.setWaiter(waiter);

        // Act and Assert
        assertNotEquals(null, order);
    }

    /**
     * Method under test: {@link Order#equals(Object)}
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

        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

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

        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(restaurant);

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

        Waiter waiter = new Waiter();
        waiter.setCin("Cin");
        waiter.setEmail("jane.doe@example.org");
        waiter.setId(1L);
        waiter.setName("Name");
        waiter.setPhone("6625550144");
        waiter.setRestaurant(restaurant2);

        Order order = new Order();
        order.setClient(client);
        order.setDiscounts(new HashSet<>());
        order.setId(1L);
        order.setProductCollections(new HashSet<>());
        order.setProducts(new HashSet<>());
        order.setRewards(new HashSet<>());
        order.setTotalPrice(10.0d);
        order.setWaiter(waiter);

        // Act and Assert
        assertNotEquals("Different type to Order", order);
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Order#Order()}
     *   <li>{@link Order#setClient(Client)}
     *   <li>{@link Order#setDiscounts(Set)}
     *   <li>{@link Order#setId(Long)}
     *   <li>{@link Order#setProductCollections(Set)}
     *   <li>{@link Order#setProducts(Set)}
     *   <li>{@link Order#setRewards(Set)}
     *   <li>{@link Order#setTotalPrice(double)}
     *   <li>{@link Order#setWaiter(Waiter)}
     *   <li>{@link Order#toString()}
     *   <li>{@link Order#getClient()}
     *   <li>{@link Order#getDiscounts()}
     *   <li>{@link Order#getId()}
     *   <li>{@link Order#getProductCollections()}
     *   <li>{@link Order#getProducts()}
     *   <li>{@link Order#getRewards()}
     *   <li>{@link Order#getTotalPrice()}
     *   <li>{@link Order#getWaiter()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        Order actualOrder = new Order();
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");
        actualOrder.setClient(client);
        HashSet<Discount> discounts = new HashSet<>();
        actualOrder.setDiscounts(discounts);
        actualOrder.setId(1L);
        HashSet<ProductCollection> productCollections = new HashSet<>();
        actualOrder.setProductCollections(productCollections);
        HashSet<Product> products = new HashSet<>();
        actualOrder.setProducts(products);
        HashSet<Reward> rewards = new HashSet<>();
        actualOrder.setRewards(rewards);
        actualOrder.setTotalPrice(10.0d);
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);
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
        Owner owner = new Owner();
        owner.setEmail("jane.doe@example.org");
        owner.setId(1L);
        owner.setName("Name");
        owner.setPhone("6625550144");
        owner.setRestaurant(restaurant);
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
        Waiter waiter = new Waiter();
        waiter.setCin("Cin");
        waiter.setEmail("jane.doe@example.org");
        waiter.setId(1L);
        waiter.setName("Name");
        waiter.setPhone("6625550144");
        waiter.setRestaurant(restaurant2);
        actualOrder.setWaiter(waiter);
        String actualToStringResult = actualOrder.toString();
        Client actualClient = actualOrder.getClient();
        Set<Discount> actualDiscounts = actualOrder.getDiscounts();
        Long actualId = actualOrder.getId();
        Set<ProductCollection> actualProductCollections = actualOrder.getProductCollections();
        Set<Product> actualProducts = actualOrder.getProducts();
        Set<Reward> actualRewards = actualOrder.getRewards();
        double actualTotalPrice = actualOrder.getTotalPrice();
        Waiter actualWaiter = actualOrder.getWaiter();

        // Assert that nothing has changed
        assertEquals("Order(id=1, products=[], productCollections=[], discounts=[], rewards=[], totalPrice=10.0, waiter"
                + "=Waiter(id=1, name=Name, cin=Cin, phone=6625550144, email=jane.doe@example.org, restaurant=Restaurant(id=1,"
                + " name=Name, location=Location(latitude=10.0, longitude=10.0), coverImageUrl=https://example.org/example,"
                + " logoUrl=https://example.org/example, cuisine=Cuisine, rating=10.0, description=The characteristics"
                + " of someone or something, instagram=Instagram, phoneNumber=6625550144, email=jane.doe@example.org,"
                + " likes=1, priceRange=Price Range, participations=[], waiters=[], foodCategories=[], owner=Owner(id=1,"
                + " name=Name, email=jane.doe@example.org, phone=6625550144, restaurant=Restaurant(id=1, name=Name,"
                + " location=Location(latitude=0.0, longitude=0.0), coverImageUrl=https://example.org/example,"
                + " logoUrl=https://example.org/example, cuisine=Cuisine, rating=10.0, description=The characteristics"
                + " of someone or something, instagram=Instagram, phoneNumber=6625550144, email=jane.doe@example.org,"
                + " likes=1, priceRange=Price Range, participations=[], waiters=[], foodCategories=[], owner=Owner(id=null,"
                + " name=null, email=null, phone=null, restaurant=null))))), client=Client(id=1, name=Name, email=jane"
                + ".doe@example.org, phone=6625550144, participations=[], favoriteRestaurants=[]))", actualToStringResult);
        assertEquals(10.0d, actualTotalPrice);
        assertEquals(1L, actualId.longValue());
        assertTrue(actualDiscounts.isEmpty());
        assertTrue(actualProductCollections.isEmpty());
        assertTrue(actualProducts.isEmpty());
        assertTrue(actualRewards.isEmpty());
        assertSame(client, actualClient);
        assertSame(waiter, actualWaiter);
        assertSame(discounts, actualDiscounts);
        assertSame(productCollections, actualProductCollections);
        assertSame(products, actualProducts);
        assertSame(rewards, actualRewards);
    }

    /**
     * Method under test:
     * {@link Order#Order(Long, Set, Set, Set, Set, double, Waiter, Client)}
     */
    @Test
    void testNewOrder() {
        // Arrange
        HashSet<Product> products = new HashSet<>();
        HashSet<ProductCollection> productCollections = new HashSet<>();
        HashSet<Discount> discounts = new HashSet<>();
        HashSet<Reward> rewards = new HashSet<>();
        Waiter waiter = mock(Waiter.class);
        Client client = mock(Client.class);

        // Act
        Order actualOrder = new Order(1L, products, productCollections, discounts, rewards, 10.0d, waiter, client);

        // Assert
        assertEquals(10.0d, actualOrder.getTotalPrice());
        assertEquals(1L, actualOrder.getId().longValue());
        Set<Discount> discounts2 = actualOrder.getDiscounts();
        assertTrue(discounts2.isEmpty());
        Set<ProductCollection> productCollections2 = actualOrder.getProductCollections();
        assertTrue(productCollections2.isEmpty());
        Set<Product> products2 = actualOrder.getProducts();
        assertTrue(products2.isEmpty());
        Set<Reward> rewards2 = actualOrder.getRewards();
        assertTrue(rewards2.isEmpty());
        assertSame(discounts, discounts2);
        assertSame(productCollections, productCollections2);
        assertSame(products, products2);
        assertSame(rewards, rewards2);
        assertSame(client, actualOrder.getClient());
        assertSame(waiter, actualOrder.getWaiter());
    }

    /**
     * Method under test:
     * {@link Order#Order(Long, Set, Set, Set, Set, double, Waiter, Client)}
     */
    @Test
    void testNewOrder2() {
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

        HashSet<Product> products = new HashSet<>();
        products.add(product);
        HashSet<ProductCollection> productCollections = new HashSet<>();
        HashSet<Discount> discounts = new HashSet<>();
        HashSet<Reward> rewards = new HashSet<>();
        Waiter waiter = mock(Waiter.class);
        Client client = mock(Client.class);

        // Act
        Order actualOrder = new Order(1L, products, productCollections, discounts, rewards, 10.0d, waiter, client);

        // Assert
        Set<Product> products2 = actualOrder.getProducts();
        assertEquals(1, products2.size());
        assertEquals(10.0d, actualOrder.getTotalPrice());
        assertEquals(1L, actualOrder.getId().longValue());
        Set<Discount> discounts2 = actualOrder.getDiscounts();
        assertTrue(discounts2.isEmpty());
        Set<ProductCollection> productCollections2 = actualOrder.getProductCollections();
        assertTrue(productCollections2.isEmpty());
        Set<Reward> rewards2 = actualOrder.getRewards();
        assertTrue(rewards2.isEmpty());
        assertSame(discounts, discounts2);
        assertSame(productCollections, productCollections2);
        assertSame(products, products2);
        assertSame(rewards, rewards2);
        assertSame(client, actualOrder.getClient());
        assertSame(waiter, actualOrder.getWaiter());
    }

    /**
     * Method under test:
     * {@link Order#Order(Long, Set, Set, Set, Set, double, Waiter, Client)}
     */
    @Test
    void testNewOrder3() {
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
        location2.setLatitude(0.5d);
        location2.setLongitude(0.5d);

        Owner owner2 = new Owner();
        owner2.setEmail("john.smith@example.org");
        owner2.setId(2L);
        owner2.setName("com.example.pfabackend.entities.Owner");
        owner2.setPhone("8605550118");
        owner2.setRestaurant(new Restaurant());

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCoverImageUrl("Cover Image Url");
        restaurant2.setCuisine("42");
        restaurant2.setDescription("Description");
        restaurant2.setEmail("john.smith@example.org");
        restaurant2.setFoodCategories(new ArrayList<>());
        restaurant2.setId(2L);
        restaurant2.setInstagram("42");
        restaurant2.setLikes(0);
        restaurant2.setLocation(location2);
        restaurant2.setLogoUrl("Logo Url");
        restaurant2.setName("42");
        restaurant2.setOwner(owner2);
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("8605550118");
        restaurant2.setPriceRange("42");
        restaurant2.setRating(0.5d);
        restaurant2.setWaiters(new ArrayList<>());

        FoodCategory category2 = new FoodCategory();
        category2.setId(2L);
        category2.setIsActivated(false);
        category2.setName("com.example.pfabackend.entities.FoodCategory");
        category2.setProducts(new ArrayList<>());
        category2.setRestaurant(restaurant2);

        Product product2 = new Product();
        product2.setBonusPoints(0);
        product2.setCategory(category2);
        product2.setId(2L);
        product2.setImg("com.example.pfabackend.entities.Product");
        product2.setInfo("com.example.pfabackend.entities.Product");
        product2.setIsActivated(false);
        product2.setName("com.example.pfabackend.entities.Product");
        product2.setPrice(0.5d);

        HashSet<Product> products = new HashSet<>();
        products.add(product2);
        products.add(product);
        HashSet<ProductCollection> productCollections = new HashSet<>();
        HashSet<Discount> discounts = new HashSet<>();
        HashSet<Reward> rewards = new HashSet<>();
        Waiter waiter = mock(Waiter.class);
        Client client = mock(Client.class);

        // Act
        Order actualOrder = new Order(1L, products, productCollections, discounts, rewards, 10.0d, waiter, client);

        // Assert
        assertEquals(10.0d, actualOrder.getTotalPrice());
        assertEquals(1L, actualOrder.getId().longValue());
        Set<Discount> discounts2 = actualOrder.getDiscounts();
        assertTrue(discounts2.isEmpty());
        Set<ProductCollection> productCollections2 = actualOrder.getProductCollections();
        assertTrue(productCollections2.isEmpty());
        Set<Reward> rewards2 = actualOrder.getRewards();
        assertTrue(rewards2.isEmpty());
        assertSame(discounts, discounts2);
        assertSame(productCollections, productCollections2);
        assertSame(products, actualOrder.getProducts());
        assertSame(rewards, rewards2);
        assertSame(client, actualOrder.getClient());
        assertSame(waiter, actualOrder.getWaiter());
    }
}
