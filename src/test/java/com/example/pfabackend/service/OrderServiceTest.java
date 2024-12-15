package com.example.pfabackend.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.pfabackend.entities.Client;
import com.example.pfabackend.entities.Discount;
import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Order;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Product;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.entities.Waiter;
import com.example.pfabackend.repository.ClientRepository;
import com.example.pfabackend.repository.OrderRepository;
import com.example.pfabackend.repository.WaiterRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OrderService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class OrderServiceTest {
    @MockBean
    private ClientRepository clientRepository;

    @MockBean
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @MockBean
    private WaiterRepository waiterRepository;

    /**
     * Method under test: {@link OrderService#getOrdersByClientId(Long)}
     */
    @Test
    void testGetOrdersByClientId() {
        // Arrange
        ArrayList<Order> orderList = new ArrayList<>();
        when(orderRepository.findByClientId(Mockito.<Long>any())).thenReturn(orderList);

        // Act
        List<Order> actualOrdersByClientId = orderService.getOrdersByClientId(1L);

        // Assert
        verify(orderRepository).findByClientId(eq(1L));
        assertTrue(actualOrdersByClientId.isEmpty());
        assertSame(orderList, actualOrdersByClientId);
    }

    /**
     * Method under test: {@link OrderService#getOrdersByClientId(Long)}
     */
    @Test
    void testGetOrdersByClientId2() {
        // Arrange
        when(orderRepository.findByClientId(Mockito.<Long>any()))
                .thenThrow(new EntityNotFoundException("An error occurred"));

        // Act and Assert
        assertThrows(EntityNotFoundException.class, () -> orderService.getOrdersByClientId(1L));
        verify(orderRepository).findByClientId(eq(1L));
    }

    /**
     * Method under test: {@link OrderService#getOrdersByWaiterId(Long)}
     */
    @Test
    void testGetOrdersByWaiterId() {
        // Arrange
        ArrayList<Order> orderList = new ArrayList<>();
        when(orderRepository.findByWaiterId(Mockito.<Long>any())).thenReturn(orderList);

        // Act
        List<Order> actualOrdersByWaiterId = orderService.getOrdersByWaiterId(1L);

        // Assert
        verify(orderRepository).findByWaiterId(eq(1L));
        assertTrue(actualOrdersByWaiterId.isEmpty());
        assertSame(orderList, actualOrdersByWaiterId);
    }

    /**
     * Method under test: {@link OrderService#getOrdersByWaiterId(Long)}
     */
    @Test
    void testGetOrdersByWaiterId2() {
        // Arrange
        when(orderRepository.findByWaiterId(Mockito.<Long>any()))
                .thenThrow(new EntityNotFoundException("An error occurred"));

        // Act and Assert
        assertThrows(EntityNotFoundException.class, () -> orderService.getOrdersByWaiterId(1L));
        verify(orderRepository).findByWaiterId(eq(1L));
    }

    /**
     * Method under test:
     * {@link OrderService#createOrder(Long, Long, Set, Set, Set, double)}
     */
    @Test
    void testCreateOrder() {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");
        Optional<Client> ofResult = Optional.of(client);
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Client client2 = new Client();
        client2.setEmail("jane.doe@example.org");
        client2.setFavoriteRestaurants(new HashSet<>());
        client2.setId(1L);
        client2.setName("Name");
        client2.setParticipations(new HashSet<>());
        client2.setPhone("6625550144");

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
        order.setClient(client2);
        order.setDiscounts(new HashSet<>());
        order.setId(1L);
        order.setProductCollections(new HashSet<>());
        order.setProducts(new HashSet<>());
        order.setRewards(new HashSet<>());
        order.setTotalPrice(10.0d);
        order.setWaiter(waiter);
        when(orderRepository.save(Mockito.<Order>any())).thenReturn(order);

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
        Optional<Waiter> ofResult2 = Optional.of(waiter2);
        when(waiterRepository.findById(Mockito.<Long>any())).thenReturn(ofResult2);
        HashSet<Product> products = new HashSet<>();
        HashSet<Discount> discounts = new HashSet<>();

        // Act
        Order actualCreateOrderResult = orderService.createOrder(1L, 1L, products, discounts, new HashSet<>(), 10.0d);

        // Assert
        verify(clientRepository).findById(eq(1L));
        verify(waiterRepository).findById(eq(1L));
        verify(orderRepository).save(isA(Order.class));
        assertSame(order, actualCreateOrderResult);
    }

    /**
     * Method under test:
     * {@link OrderService#createOrder(Long, Long, Set, Set, Set, double)}
     */
    @Test
    void testCreateOrder2() {
        // Arrange
        Client client = new Client();
        client.setEmail("jane.doe@example.org");
        client.setFavoriteRestaurants(new HashSet<>());
        client.setId(1L);
        client.setName("Name");
        client.setParticipations(new HashSet<>());
        client.setPhone("6625550144");
        Optional<Client> ofResult = Optional.of(client);
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        when(orderRepository.save(Mockito.<Order>any())).thenThrow(new EntityNotFoundException("An error occurred"));

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
        Optional<Waiter> ofResult2 = Optional.of(waiter);
        when(waiterRepository.findById(Mockito.<Long>any())).thenReturn(ofResult2);
        HashSet<Product> products = new HashSet<>();
        HashSet<Discount> discounts = new HashSet<>();

        // Act and Assert
        assertThrows(EntityNotFoundException.class,
                () -> orderService.createOrder(1L, 1L, products, discounts, new HashSet<>(), 10.0d));
        verify(clientRepository).findById(eq(1L));
        verify(waiterRepository).findById(eq(1L));
        verify(orderRepository).save(isA(Order.class));
    }

    /**
     * Method under test:
     * {@link OrderService#createOrder(Long, Long, Set, Set, Set, double)}
     */
    @Test
    void testCreateOrder3() {
        // Arrange
        Optional<Client> emptyResult = Optional.empty();
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

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
        Optional<Waiter> ofResult = Optional.of(waiter);
        when(waiterRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        HashSet<Product> products = new HashSet<>();
        HashSet<Discount> discounts = new HashSet<>();

        // Act and Assert
        assertThrows(EntityNotFoundException.class,
                () -> orderService.createOrder(1L, 1L, products, discounts, new HashSet<>(), 10.0d));
        verify(clientRepository).findById(eq(1L));
    }
}
