package com.example.pfabackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.pfabackend.entities.Discount;
import com.example.pfabackend.entities.FoodCategory;
import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Product;
import com.example.pfabackend.entities.ProductCollection;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.repository.DiscountRepository;
import com.example.pfabackend.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DiscountService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class DiscountServiceTest {
    @MockBean
    private DiscountRepository discountRepository;

    @Autowired
    private DiscountService discountService;

    @MockBean
    private ProductRepository productRepository;

    /**
     * Method under test: {@link DiscountService#getAllDiscounts()}
     */
    @Test
    void testGetAllDiscounts() {
        // Arrange
        ArrayList<Discount> discountList = new ArrayList<>();
        when(discountRepository.findAll()).thenReturn(discountList);

        // Act
        List<Discount> actualAllDiscounts = discountService.getAllDiscounts();

        // Assert
        verify(discountRepository).findAll();
        assertTrue(actualAllDiscounts.isEmpty());
        assertSame(discountList, actualAllDiscounts);
    }

    /**
     * Method under test: {@link DiscountService#getDiscountsByRestaurantId(Long)}
     */
    @Test
    void testGetDiscountsByRestaurantId() {
        // Arrange
        ArrayList<Discount> discountList = new ArrayList<>();
        when(discountRepository.findByProductCategoryRestaurantId(Mockito.<Long>any())).thenReturn(discountList);

        // Act
        List<Discount> actualDiscountsByRestaurantId = discountService.getDiscountsByRestaurantId(1L);

        // Assert
        verify(discountRepository).findByProductCategoryRestaurantId(eq(1L));
        assertTrue(actualDiscountsByRestaurantId.isEmpty());
        assertSame(discountList, actualDiscountsByRestaurantId);
    }

    /**
     * Method under test: {@link DiscountService#getDiscountByProductId(Long)}
     */
    @Test
    void testGetDiscountByProductId() {
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
        Optional<Discount> ofResult = Optional.of(discount);
        when(discountRepository.findByProductId(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Discount actualDiscountByProductId = discountService.getDiscountByProductId(1L);

        // Assert
        verify(discountRepository).findByProductId(eq(1L));
        assertSame(discount, actualDiscountByProductId);
    }

    /**
     * Method under test:
     * {@link DiscountService#createOrUpdateDiscount(Long, Discount)}
     */
    @Test
    void testCreateOrUpdateDiscount() {
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
        Optional<Discount> ofResult = Optional.of(discount);

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(new Restaurant());

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

        FoodCategory category2 = new FoodCategory();
        category2.setId(1L);
        category2.setIsActivated(true);
        category2.setName("Name");
        category2.setProducts(new ArrayList<>());
        category2.setRestaurant(restaurant3);

        Product product2 = new Product();
        product2.setBonusPoints(1);
        product2.setCategory(category2);
        product2.setId(1L);
        product2.setImg("Img");
        product2.setInfo("Info");
        product2.setIsActivated(true);
        product2.setName("Name");
        product2.setPrice(10.0d);

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

        ProductCollection productCollection2 = new ProductCollection();
        productCollection2.setId(1L);
        productCollection2.setProducts(new HashSet<>());
        productCollection2.setRestaurant(restaurant5);
        productCollection2.setTotalPrice(10.0d);

        Discount discount2 = new Discount();
        discount2.setDiscountPercentage(3);
        discount2.setId(1L);
        discount2.setProduct(product2);
        discount2.setProductCollection(productCollection2);
        when(discountRepository.save(Mockito.<Discount>any())).thenReturn(discount2);
        when(discountRepository.findByProductId(Mockito.<Long>any())).thenReturn(ofResult);

        Restaurant restaurant6 = new Restaurant();
        restaurant6.setCoverImageUrl("https://example.org/example");
        restaurant6.setCuisine("Cuisine");
        restaurant6.setDescription("The characteristics of someone or something");
        restaurant6.setEmail("jane.doe@example.org");
        restaurant6.setFoodCategories(new ArrayList<>());
        restaurant6.setId(1L);
        restaurant6.setInstagram("Instagram");
        restaurant6.setLikes(1);
        restaurant6.setLocation(new Location());
        restaurant6.setLogoUrl("https://example.org/example");
        restaurant6.setName("Name");
        restaurant6.setOwner(new Owner());
        restaurant6.setParticipations(new HashSet<>());
        restaurant6.setPhoneNumber("6625550144");
        restaurant6.setPriceRange("Price Range");
        restaurant6.setRating(10.0d);
        restaurant6.setWaiters(new ArrayList<>());

        FoodCategory category3 = new FoodCategory();
        category3.setId(1L);
        category3.setIsActivated(true);
        category3.setName("Name");
        category3.setProducts(new ArrayList<>());
        category3.setRestaurant(restaurant6);

        Product product3 = new Product();
        product3.setBonusPoints(1);
        product3.setCategory(category3);
        product3.setId(1L);
        product3.setImg("Img");
        product3.setInfo("Info");
        product3.setIsActivated(true);
        product3.setName("Name");
        product3.setPrice(10.0d);

        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);

        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(new Restaurant());

        Restaurant restaurant7 = new Restaurant();
        restaurant7.setCoverImageUrl("https://example.org/example");
        restaurant7.setCuisine("Cuisine");
        restaurant7.setDescription("The characteristics of someone or something");
        restaurant7.setEmail("jane.doe@example.org");
        restaurant7.setFoodCategories(new ArrayList<>());
        restaurant7.setId(1L);
        restaurant7.setInstagram("Instagram");
        restaurant7.setLikes(1);
        restaurant7.setLocation(location4);
        restaurant7.setLogoUrl("https://example.org/example");
        restaurant7.setName("Name");
        restaurant7.setOwner(owner4);
        restaurant7.setParticipations(new HashSet<>());
        restaurant7.setPhoneNumber("6625550144");
        restaurant7.setPriceRange("Price Range");
        restaurant7.setRating(10.0d);
        restaurant7.setWaiters(new ArrayList<>());

        ProductCollection productCollection3 = new ProductCollection();
        productCollection3.setId(1L);
        productCollection3.setProducts(new HashSet<>());
        productCollection3.setRestaurant(restaurant7);
        productCollection3.setTotalPrice(10.0d);

        Discount discount3 = new Discount();
        discount3.setDiscountPercentage(3);
        discount3.setId(1L);
        discount3.setProduct(product3);
        discount3.setProductCollection(productCollection3);

        // Act
        Discount actualCreateOrUpdateDiscountResult = discountService.createOrUpdateDiscount(1L, discount3);

        // Assert
        verify(discountRepository).findByProductId(eq(1L));
        verify(discountRepository).save(isA(Discount.class));
        assertSame(discount2, actualCreateOrUpdateDiscountResult);
    }

    /**
     * Method under test: {@link DiscountService#updateDiscount(Long, Discount)}
     */
    @Test
    void testUpdateDiscount() {
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
        Optional<Discount> ofResult = Optional.of(discount);

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(new Restaurant());

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

        FoodCategory category2 = new FoodCategory();
        category2.setId(1L);
        category2.setIsActivated(true);
        category2.setName("Name");
        category2.setProducts(new ArrayList<>());
        category2.setRestaurant(restaurant3);

        Product product2 = new Product();
        product2.setBonusPoints(1);
        product2.setCategory(category2);
        product2.setId(1L);
        product2.setImg("Img");
        product2.setInfo("Info");
        product2.setIsActivated(true);
        product2.setName("Name");
        product2.setPrice(10.0d);

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

        ProductCollection productCollection2 = new ProductCollection();
        productCollection2.setId(1L);
        productCollection2.setProducts(new HashSet<>());
        productCollection2.setRestaurant(restaurant5);
        productCollection2.setTotalPrice(10.0d);

        Discount discount2 = new Discount();
        discount2.setDiscountPercentage(3);
        discount2.setId(1L);
        discount2.setProduct(product2);
        discount2.setProductCollection(productCollection2);
        when(discountRepository.save(Mockito.<Discount>any())).thenReturn(discount2);
        when(discountRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Restaurant restaurant6 = new Restaurant();
        restaurant6.setCoverImageUrl("https://example.org/example");
        restaurant6.setCuisine("Cuisine");
        restaurant6.setDescription("The characteristics of someone or something");
        restaurant6.setEmail("jane.doe@example.org");
        restaurant6.setFoodCategories(new ArrayList<>());
        restaurant6.setId(1L);
        restaurant6.setInstagram("Instagram");
        restaurant6.setLikes(1);
        restaurant6.setLocation(new Location());
        restaurant6.setLogoUrl("https://example.org/example");
        restaurant6.setName("Name");
        restaurant6.setOwner(new Owner());
        restaurant6.setParticipations(new HashSet<>());
        restaurant6.setPhoneNumber("6625550144");
        restaurant6.setPriceRange("Price Range");
        restaurant6.setRating(10.0d);
        restaurant6.setWaiters(new ArrayList<>());

        FoodCategory category3 = new FoodCategory();
        category3.setId(1L);
        category3.setIsActivated(true);
        category3.setName("Name");
        category3.setProducts(new ArrayList<>());
        category3.setRestaurant(restaurant6);

        Product product3 = new Product();
        product3.setBonusPoints(1);
        product3.setCategory(category3);
        product3.setId(1L);
        product3.setImg("Img");
        product3.setInfo("Info");
        product3.setIsActivated(true);
        product3.setName("Name");
        product3.setPrice(10.0d);

        Location location4 = new Location();
        location4.setLatitude(10.0d);
        location4.setLongitude(10.0d);

        Owner owner4 = new Owner();
        owner4.setEmail("jane.doe@example.org");
        owner4.setId(1L);
        owner4.setName("Name");
        owner4.setPhone("6625550144");
        owner4.setRestaurant(new Restaurant());

        Restaurant restaurant7 = new Restaurant();
        restaurant7.setCoverImageUrl("https://example.org/example");
        restaurant7.setCuisine("Cuisine");
        restaurant7.setDescription("The characteristics of someone or something");
        restaurant7.setEmail("jane.doe@example.org");
        restaurant7.setFoodCategories(new ArrayList<>());
        restaurant7.setId(1L);
        restaurant7.setInstagram("Instagram");
        restaurant7.setLikes(1);
        restaurant7.setLocation(location4);
        restaurant7.setLogoUrl("https://example.org/example");
        restaurant7.setName("Name");
        restaurant7.setOwner(owner4);
        restaurant7.setParticipations(new HashSet<>());
        restaurant7.setPhoneNumber("6625550144");
        restaurant7.setPriceRange("Price Range");
        restaurant7.setRating(10.0d);
        restaurant7.setWaiters(new ArrayList<>());

        ProductCollection productCollection3 = new ProductCollection();
        productCollection3.setId(1L);
        productCollection3.setProducts(new HashSet<>());
        productCollection3.setRestaurant(restaurant7);
        productCollection3.setTotalPrice(10.0d);

        Discount newDiscount = new Discount();
        newDiscount.setDiscountPercentage(3);
        newDiscount.setId(1L);
        newDiscount.setProduct(product3);
        newDiscount.setProductCollection(productCollection3);

        // Act
        Discount actualUpdateDiscountResult = discountService.updateDiscount(1L, newDiscount);

        // Assert
        verify(discountRepository).findById(eq(1L));
        verify(discountRepository).save(isA(Discount.class));
        assertEquals(discount, newDiscount);
        assertSame(discount2, actualUpdateDiscountResult);
    }

    /**
     * Method under test: {@link DiscountService#deleteDiscount(Long)}
     */
    @Test
    void testDeleteDiscount() {
        // Arrange
        doNothing().when(discountRepository).deleteById(Mockito.<Long>any());

        // Act
        discountService.deleteDiscount(1L);

        // Assert that nothing has changed
        verify(discountRepository).deleteById(eq(1L));
    }
}
