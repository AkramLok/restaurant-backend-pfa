package com.example.pfabackend.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.pfabackend.entities.FoodCategory;
import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Product;
import com.example.pfabackend.entities.ProductCollection;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.entities.Reward;
import com.example.pfabackend.repository.ProductRepository;
import com.example.pfabackend.repository.RewardRepository;

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

@ContextConfiguration(classes = {RewardService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class RewardServiceTest {
    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private RewardRepository rewardRepository;

    @Autowired
    private RewardService rewardService;

    /**
     * Method under test: {@link RewardService#getAllRewards()}
     */
    @Test
    void testGetAllRewards() {
        // Arrange
        ArrayList<Reward> rewardList = new ArrayList<>();
        when(rewardRepository.findAll()).thenReturn(rewardList);

        // Act
        List<Reward> actualAllRewards = rewardService.getAllRewards();

        // Assert
        verify(rewardRepository).findAll();
        assertTrue(actualAllRewards.isEmpty());
        assertSame(rewardList, actualAllRewards);
    }

    /**
     * Method under test: {@link RewardService#getAllRewardsForRestaurant(Long)}
     */
    @Test
    void testGetAllRewardsForRestaurant() {
        // Arrange
        ArrayList<Reward> rewardList = new ArrayList<>();
        when(rewardRepository.findAllByRestaurantId(Mockito.<Long>any())).thenReturn(rewardList);

        // Act
        List<Reward> actualAllRewardsForRestaurant = rewardService.getAllRewardsForRestaurant(1L);

        // Assert
        verify(rewardRepository).findAllByRestaurantId(eq(1L));
        assertTrue(actualAllRewardsForRestaurant.isEmpty());
        assertSame(rewardList, actualAllRewardsForRestaurant);
    }

    /**
     * Method under test: {@link RewardService#getRewardByProductId(Long)}
     */
    @Test
    void testGetRewardByProductId() {
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

        Reward reward = new Reward();
        reward.setId(1L);
        reward.setProduct(product);
        reward.setProductCollection(productCollection);
        reward.setRequiredPoints(1);
        Optional<Reward> ofResult = Optional.of(reward);
        when(rewardRepository.findByProductId(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Optional<Reward> actualRewardByProductId = rewardService.getRewardByProductId(1L);

        // Assert
        verify(rewardRepository).findByProductId(eq(1L));
        assertSame(ofResult, actualRewardByProductId);
    }

    /**
     * Method under test: {@link RewardService#createOrUpdateReward(Long, Reward)}
     */
    @Test
    void testCreateOrUpdateReward() {
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

        Reward reward = new Reward();
        reward.setId(1L);
        reward.setProduct(product);
        reward.setProductCollection(productCollection);
        reward.setRequiredPoints(1);
        Optional<Reward> ofResult = Optional.of(reward);

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

        Reward reward2 = new Reward();
        reward2.setId(1L);
        reward2.setProduct(product2);
        reward2.setProductCollection(productCollection2);
        reward2.setRequiredPoints(1);
        when(rewardRepository.save(Mockito.<Reward>any())).thenReturn(reward2);
        when(rewardRepository.findByProductId(Mockito.<Long>any())).thenReturn(ofResult);

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

        Reward reward3 = new Reward();
        reward3.setId(1L);
        reward3.setProduct(product3);
        reward3.setProductCollection(productCollection3);
        reward3.setRequiredPoints(1);

        // Act
        Reward actualCreateOrUpdateRewardResult = rewardService.createOrUpdateReward(1L, reward3);

        // Assert
        verify(rewardRepository).findByProductId(eq(1L));
        verify(rewardRepository).save(isA(Reward.class));
        assertSame(reward2, actualCreateOrUpdateRewardResult);
    }

    /**
     * Method under test: {@link RewardService#deleteReward(Long)}
     */
    @Test
    void testDeleteReward() {
        // Arrange
        doNothing().when(rewardRepository).deleteById(Mockito.<Long>any());

        // Act
        rewardService.deleteReward(1L);

        // Assert that nothing has changed
        verify(rewardRepository).deleteById(eq(1L));
    }
}
