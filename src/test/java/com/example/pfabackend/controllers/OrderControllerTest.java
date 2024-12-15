package com.example.pfabackend.controllers;

import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.when;

import com.example.pfabackend.dto.OrderRequestDto;
import com.example.pfabackend.entities.Client;
import com.example.pfabackend.entities.Discount;
import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Order;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Product;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.entities.Reward;
import com.example.pfabackend.entities.Waiter;
import com.example.pfabackend.service.OrderService;
import com.example.pfabackend.service.WaiterService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {OrderController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class OrderControllerTest {
    @Autowired
    private OrderController orderController;

    @MockBean
    private OrderService orderService;

    @MockBean
    private WaiterService waiterService;

    /**
     * Method under test: {@link OrderController#getOrdersByClientId(Long)}
     */
    @Test
    void testGetOrdersByClientId() throws Exception {
        // Arrange
        when(orderService.getOrdersByClientId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/orders/client/{clientId}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link OrderController#getOrdersByWaiterId(Long)}
     */
    @Test
    void testGetOrdersByWaiterId() throws Exception {
        // Arrange
        when(orderService.getOrdersByWaiterId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/orders/waiter/{waiterId}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test:
     * {@link OrderController#createOrder(Long, Long, OrderRequestDto)}
     */
    @Test
    void testCreateOrder() throws Exception {
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
        when(orderService.createOrder(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Set<Product>>any(),
                Mockito.<Set<Discount>>any(), Mockito.<Set<Reward>>any(), anyDouble())).thenReturn(order);

        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setDiscounts(new HashSet<>());
        orderRequestDto.setProducts(new HashSet<>());
        orderRequestDto.setRewards(new HashSet<>());
        orderRequestDto.setTotalPrice(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(orderRequestDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/orders/client/{clientId}/waiter/{waiterId}", 1L, 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"products\":[],\"productCollections\":[],\"discounts\":[],\"rewards\":[],\"totalPrice\":10.0,\"waiter\""
                                        + ":{\"id\":1,\"name\":\"Name\",\"cin\":\"Cin\",\"phone\":\"6625550144\",\"email\":\"jane.doe@example.org\"},\"client\":{\"id"
                                        + "\":1,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"phone\":\"6625550144\",\"participations\":[],\"favoriteR"
                                        + "estaurants\":[]}}"));
    }

    /**
     * Method under test: {@link OrderController#getOrdersByRestaurantId(Long)}
     */
    @Test
    void testGetOrdersByRestaurantId() throws Exception {
        // Arrange
        when(waiterService.getWaitersByRestaurantId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/orders/restaurant/{restaurantId}",
                1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link OrderController#getOrdersByRestaurantId(Long)}
     */
    @Test
    void testGetOrdersByRestaurantId2() throws Exception {
        // Arrange
        when(orderService.getOrdersByWaiterId(Mockito.<Long>any())).thenReturn(new ArrayList<>());

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

        ArrayList<Waiter> waiterList = new ArrayList<>();
        waiterList.add(waiter);
        when(waiterService.getWaitersByRestaurantId(Mockito.<Long>any())).thenReturn(waiterList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/orders/restaurant/{restaurantId}",
                1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}
