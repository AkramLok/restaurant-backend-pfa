package com.example.pfabackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.repository.RestaurantRepository;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {RestaurantService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class RestaurantServiceTest {
    @MockBean
    private OwnerService ownerService;

    @MockBean
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantService restaurantService;

    /**
     * Method under test: {@link RestaurantService#init()}
     */
    @Test
    void testInit() throws IOException {
        try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
            // Arrange
            mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
                    .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

            // Act
            restaurantService.init();

            // Assert that nothing has changed
            mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
        }
    }

    /**
     * Method under test: {@link RestaurantService#init()}
     */
    @Test
    void testInit2() throws IOException {
        try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
            // Arrange
            mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
                    .thenThrow(new IOException("foo"));

            // Act and Assert
            assertThrows(RuntimeException.class, () -> restaurantService.init());
            mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
        }
    }

    /**
     * Method under test: {@link RestaurantService#init()}
     */
    @Test
    void testInit3() throws IOException {
        try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
            // Arrange
            mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
                    .thenThrow(new RuntimeException("foo"));

            // Act and Assert
            assertThrows(RuntimeException.class, () -> restaurantService.init());
            mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
        }
    }

    /**
     * Method under test: {@link RestaurantService#getAllRestaurants()}
     */
    @Test
    void testGetAllRestaurants() {
        // Arrange
        ArrayList<Restaurant> restaurantList = new ArrayList<>();
        when(restaurantRepository.findAll()).thenReturn(restaurantList);

        // Act
        List<Restaurant> actualAllRestaurants = restaurantService.getAllRestaurants();

        // Assert
        verify(restaurantRepository).findAll();
        assertTrue(actualAllRestaurants.isEmpty());
        assertSame(restaurantList, actualAllRestaurants);
    }

    /**
     * Method under test: {@link RestaurantService#getAllRestaurants()}
     */
    @Test
    void testGetAllRestaurants2() {
        // Arrange
        when(restaurantRepository.findAll()).thenThrow(new RuntimeException("foo"));

        // Act and Assert
        assertThrows(RuntimeException.class, () -> restaurantService.getAllRestaurants());
        verify(restaurantRepository).findAll();
    }

    /**
     * Method under test: {@link RestaurantService#getRestaurantById(Long)}
     */
    @Test
    void testGetRestaurantById() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

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
        restaurant.setLocation(location2);
        restaurant.setLogoUrl("https://example.org/example");
        restaurant.setName("Name");
        restaurant.setOwner(owner);
        restaurant.setParticipations(new HashSet<>());
        restaurant.setPhoneNumber("6625550144");
        restaurant.setPriceRange("Price Range");
        restaurant.setRating(10.0d);
        restaurant.setWaiters(new ArrayList<>());

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant);

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
        restaurant2.setOwner(owner2);
        restaurant2.setParticipations(new HashSet<>());
        restaurant2.setPhoneNumber("6625550144");
        restaurant2.setPriceRange("Price Range");
        restaurant2.setRating(10.0d);
        restaurant2.setWaiters(new ArrayList<>());
        Optional<Restaurant> ofResult = Optional.of(restaurant2);
        when(restaurantRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Restaurant actualRestaurantById = restaurantService.getRestaurantById(1L);

        // Assert
        verify(restaurantRepository).findById(eq(1L));
        assertSame(restaurant2, actualRestaurantById);
    }

    /**
     * Method under test:
     * {@link RestaurantService#createRestaurant(Restaurant, MultipartFile, MultipartFile, String)}
     */
    @Test
    void testCreateRestaurant() throws IOException {
        try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
            // Arrange
            mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
                    .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
            mockFiles.when(() -> Files.copy(Mockito.<InputStream>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
                    .thenReturn(1L);

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

            Owner owner2 = new Owner();
            owner2.setEmail("jane.doe@example.org");
            owner2.setId(1L);
            owner2.setName("Name");
            owner2.setPhone("6625550144");
            owner2.setRestaurant(restaurant2);
            Optional<Owner> ofResult = Optional.of(owner2);

            Location location2 = new Location();
            location2.setLatitude(10.0d);
            location2.setLongitude(10.0d);

            Location location3 = new Location();
            location3.setLatitude(10.0d);
            location3.setLongitude(10.0d);

            Owner owner3 = new Owner();
            owner3.setEmail("jane.doe@example.org");
            owner3.setId(1L);
            owner3.setName("Name");
            owner3.setPhone("6625550144");
            owner3.setRestaurant(new Restaurant());

            Restaurant restaurant3 = new Restaurant();
            restaurant3.setCoverImageUrl("https://example.org/example");
            restaurant3.setCuisine("Cuisine");
            restaurant3.setDescription("The characteristics of someone or something");
            restaurant3.setEmail("jane.doe@example.org");
            restaurant3.setFoodCategories(new ArrayList<>());
            restaurant3.setId(1L);
            restaurant3.setInstagram("Instagram");
            restaurant3.setLikes(1);
            restaurant3.setLocation(location3);
            restaurant3.setLogoUrl("https://example.org/example");
            restaurant3.setName("Name");
            restaurant3.setOwner(owner3);
            restaurant3.setParticipations(new HashSet<>());
            restaurant3.setPhoneNumber("6625550144");
            restaurant3.setPriceRange("Price Range");
            restaurant3.setRating(10.0d);
            restaurant3.setWaiters(new ArrayList<>());

            Owner owner4 = new Owner();
            owner4.setEmail("jane.doe@example.org");
            owner4.setId(1L);
            owner4.setName("Name");
            owner4.setPhone("6625550144");
            owner4.setRestaurant(restaurant3);

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
            restaurant4.setOwner(owner4);
            restaurant4.setParticipations(new HashSet<>());
            restaurant4.setPhoneNumber("6625550144");
            restaurant4.setPriceRange("Price Range");
            restaurant4.setRating(10.0d);
            restaurant4.setWaiters(new ArrayList<>());

            Owner owner5 = new Owner();
            owner5.setEmail("jane.doe@example.org");
            owner5.setId(1L);
            owner5.setName("Name");
            owner5.setPhone("6625550144");
            owner5.setRestaurant(restaurant4);
            when(ownerService.updateOwner(Mockito.<Long>any(), Mockito.<Owner>any())).thenReturn(owner5);
            when(ownerService.getOwnerById(Mockito.<Long>any())).thenReturn(ofResult);

            Location location4 = new Location();
            location4.setLatitude(10.0d);
            location4.setLongitude(10.0d);

            Location location5 = new Location();
            location5.setLatitude(10.0d);
            location5.setLongitude(10.0d);

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

            Owner owner6 = new Owner();
            owner6.setEmail("jane.doe@example.org");
            owner6.setId(1L);
            owner6.setName("Name");
            owner6.setPhone("6625550144");
            owner6.setRestaurant(restaurant5);

            Restaurant restaurant6 = new Restaurant();
            restaurant6.setCoverImageUrl("https://example.org/example");
            restaurant6.setCuisine("Cuisine");
            restaurant6.setDescription("The characteristics of someone or something");
            restaurant6.setEmail("jane.doe@example.org");
            restaurant6.setFoodCategories(new ArrayList<>());
            restaurant6.setId(1L);
            restaurant6.setInstagram("Instagram");
            restaurant6.setLikes(1);
            restaurant6.setLocation(location5);
            restaurant6.setLogoUrl("https://example.org/example");
            restaurant6.setName("Name");
            restaurant6.setOwner(owner6);
            restaurant6.setParticipations(new HashSet<>());
            restaurant6.setPhoneNumber("6625550144");
            restaurant6.setPriceRange("Price Range");
            restaurant6.setRating(10.0d);
            restaurant6.setWaiters(new ArrayList<>());

            Owner owner7 = new Owner();
            owner7.setEmail("jane.doe@example.org");
            owner7.setId(1L);
            owner7.setName("Name");
            owner7.setPhone("6625550144");
            owner7.setRestaurant(restaurant6);

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
            restaurant7.setOwner(owner7);
            restaurant7.setParticipations(new HashSet<>());
            restaurant7.setPhoneNumber("6625550144");
            restaurant7.setPriceRange("Price Range");
            restaurant7.setRating(10.0d);
            restaurant7.setWaiters(new ArrayList<>());
            when(restaurantRepository.save(Mockito.<Restaurant>any())).thenReturn(restaurant7);

            Location location6 = new Location();
            location6.setLatitude(10.0d);
            location6.setLongitude(10.0d);

            Location location7 = new Location();
            location7.setLatitude(10.0d);
            location7.setLongitude(10.0d);

            Owner owner8 = new Owner();
            owner8.setEmail("jane.doe@example.org");
            owner8.setId(1L);
            owner8.setName("Name");
            owner8.setPhone("6625550144");
            owner8.setRestaurant(new Restaurant());

            Restaurant restaurant8 = new Restaurant();
            restaurant8.setCoverImageUrl("https://example.org/example");
            restaurant8.setCuisine("Cuisine");
            restaurant8.setDescription("The characteristics of someone or something");
            restaurant8.setEmail("jane.doe@example.org");
            restaurant8.setFoodCategories(new ArrayList<>());
            restaurant8.setId(1L);
            restaurant8.setInstagram("Instagram");
            restaurant8.setLikes(1);
            restaurant8.setLocation(location7);
            restaurant8.setLogoUrl("https://example.org/example");
            restaurant8.setName("Name");
            restaurant8.setOwner(owner8);
            restaurant8.setParticipations(new HashSet<>());
            restaurant8.setPhoneNumber("6625550144");
            restaurant8.setPriceRange("Price Range");
            restaurant8.setRating(10.0d);
            restaurant8.setWaiters(new ArrayList<>());

            Owner owner9 = new Owner();
            owner9.setEmail("jane.doe@example.org");
            owner9.setId(1L);
            owner9.setName("Name");
            owner9.setPhone("6625550144");
            owner9.setRestaurant(restaurant8);

            Restaurant restaurant9 = new Restaurant();
            restaurant9.setCoverImageUrl("https://example.org/example");
            restaurant9.setCuisine("Cuisine");
            restaurant9.setDescription("The characteristics of someone or something");
            restaurant9.setEmail("jane.doe@example.org");
            restaurant9.setFoodCategories(new ArrayList<>());
            restaurant9.setId(1L);
            restaurant9.setInstagram("Instagram");
            restaurant9.setLikes(1);
            restaurant9.setLocation(location6);
            restaurant9.setLogoUrl("https://example.org/example");
            restaurant9.setName("Name");
            restaurant9.setOwner(owner9);
            restaurant9.setParticipations(new HashSet<>());
            restaurant9.setPhoneNumber("6625550144");
            restaurant9.setPriceRange("Price Range");
            restaurant9.setRating(10.0d);
            restaurant9.setWaiters(new ArrayList<>());
            MockMultipartFile logoFile = new MockMultipartFile("Name",
                    new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

            // Act
            restaurantService.createRestaurant(restaurant9, logoFile,
                    new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))), "42");

            // Assert
            verify(ownerService).getOwnerById(eq(42L));
            verify(ownerService).updateOwner(eq(42L), isA(Owner.class));
            mockFiles.verify(() -> Files.copy(Mockito.<InputStream>any(), Mockito.<Path>any(), isA(CopyOption[].class)),
                    atLeast(1));
            mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
            verify(restaurantRepository).save(isA(Restaurant.class));
            assertEquals(0, restaurant9.getLikes());
            assertEquals(0.0d, restaurant9.getRating());
        }
    }

    /**
     * Method under test:
     * {@link RestaurantService#createRestaurant(Restaurant, MultipartFile, MultipartFile, String)}
     */
    @Test
    void testCreateRestaurant2() throws IOException {
        try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
            // Arrange
            mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
                    .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
            mockFiles.when(() -> Files.copy(Mockito.<InputStream>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
                    .thenReturn(1L);
            when(restaurantRepository.save(Mockito.<Restaurant>any()))
                    .thenThrow(new RuntimeException("Restaurant Created !"));

            Location location = new Location();
            location.setLatitude(10.0d);
            location.setLongitude(10.0d);

            Location location2 = new Location();
            location2.setLatitude(10.0d);
            location2.setLongitude(10.0d);

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
            restaurant.setLocation(location2);
            restaurant.setLogoUrl("https://example.org/example");
            restaurant.setName("Name");
            restaurant.setOwner(owner);
            restaurant.setParticipations(new HashSet<>());
            restaurant.setPhoneNumber("6625550144");
            restaurant.setPriceRange("Price Range");
            restaurant.setRating(10.0d);
            restaurant.setWaiters(new ArrayList<>());

            Owner owner2 = new Owner();
            owner2.setEmail("jane.doe@example.org");
            owner2.setId(1L);
            owner2.setName("Name");
            owner2.setPhone("6625550144");
            owner2.setRestaurant(restaurant);

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
            restaurant2.setOwner(owner2);
            restaurant2.setParticipations(new HashSet<>());
            restaurant2.setPhoneNumber("6625550144");
            restaurant2.setPriceRange("Price Range");
            restaurant2.setRating(10.0d);
            restaurant2.setWaiters(new ArrayList<>());
            MockMultipartFile logoFile = new MockMultipartFile("Name",
                    new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

            // Act and Assert
            assertThrows(RuntimeException.class, () -> restaurantService.createRestaurant(restaurant2, logoFile,
                    new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))), "42"));
            mockFiles.verify(() -> Files.copy(Mockito.<InputStream>any(), Mockito.<Path>any(), isA(CopyOption[].class)),
                    atLeast(1));
            mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
            verify(restaurantRepository).save(isA(Restaurant.class));
        }
    }

    /**
     * Method under test:
     * {@link RestaurantService#updateRestaurant(Long, MultipartFile, MultipartFile, Restaurant)}
     */
    @Test
    void testUpdateRestaurant() throws IOException {
        try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
            // Arrange
            mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
                    .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
            mockFiles.when(() -> Files.copy(Mockito.<InputStream>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
                    .thenReturn(1L);

            Location location = new Location();
            location.setLatitude(10.0d);
            location.setLongitude(10.0d);

            Location location2 = new Location();
            location2.setLatitude(10.0d);
            location2.setLongitude(10.0d);

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
            restaurant.setLocation(location2);
            restaurant.setLogoUrl("https://example.org/example");
            restaurant.setName("Name");
            restaurant.setOwner(owner);
            restaurant.setParticipations(new HashSet<>());
            restaurant.setPhoneNumber("6625550144");
            restaurant.setPriceRange("Price Range");
            restaurant.setRating(10.0d);
            restaurant.setWaiters(new ArrayList<>());

            Owner owner2 = new Owner();
            owner2.setEmail("jane.doe@example.org");
            owner2.setId(1L);
            owner2.setName("Name");
            owner2.setPhone("6625550144");
            owner2.setRestaurant(restaurant);

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
            restaurant2.setOwner(owner2);
            restaurant2.setParticipations(new HashSet<>());
            restaurant2.setPhoneNumber("6625550144");
            restaurant2.setPriceRange("Price Range");
            restaurant2.setRating(10.0d);
            restaurant2.setWaiters(new ArrayList<>());
            Optional<Restaurant> ofResult = Optional.of(restaurant2);

            Location location3 = new Location();
            location3.setLatitude(10.0d);
            location3.setLongitude(10.0d);

            Location location4 = new Location();
            location4.setLatitude(10.0d);
            location4.setLongitude(10.0d);

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

            Owner owner3 = new Owner();
            owner3.setEmail("jane.doe@example.org");
            owner3.setId(1L);
            owner3.setName("Name");
            owner3.setPhone("6625550144");
            owner3.setRestaurant(restaurant3);

            Restaurant restaurant4 = new Restaurant();
            restaurant4.setCoverImageUrl("https://example.org/example");
            restaurant4.setCuisine("Cuisine");
            restaurant4.setDescription("The characteristics of someone or something");
            restaurant4.setEmail("jane.doe@example.org");
            restaurant4.setFoodCategories(new ArrayList<>());
            restaurant4.setId(1L);
            restaurant4.setInstagram("Instagram");
            restaurant4.setLikes(1);
            restaurant4.setLocation(location4);
            restaurant4.setLogoUrl("https://example.org/example");
            restaurant4.setName("Name");
            restaurant4.setOwner(owner3);
            restaurant4.setParticipations(new HashSet<>());
            restaurant4.setPhoneNumber("6625550144");
            restaurant4.setPriceRange("Price Range");
            restaurant4.setRating(10.0d);
            restaurant4.setWaiters(new ArrayList<>());

            Owner owner4 = new Owner();
            owner4.setEmail("jane.doe@example.org");
            owner4.setId(1L);
            owner4.setName("Name");
            owner4.setPhone("6625550144");
            owner4.setRestaurant(restaurant4);

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
            restaurant5.setOwner(owner4);
            restaurant5.setParticipations(new HashSet<>());
            restaurant5.setPhoneNumber("6625550144");
            restaurant5.setPriceRange("Price Range");
            restaurant5.setRating(10.0d);
            restaurant5.setWaiters(new ArrayList<>());
            when(restaurantRepository.save(Mockito.<Restaurant>any())).thenReturn(restaurant5);
            when(restaurantRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
            MockMultipartFile logoFile = new MockMultipartFile("Name",
                    new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

            MockMultipartFile coverFile = new MockMultipartFile("Name",
                    new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

            Location location5 = new Location();
            location5.setLatitude(10.0d);
            location5.setLongitude(10.0d);

            Location location6 = new Location();
            location6.setLatitude(10.0d);
            location6.setLongitude(10.0d);

            Owner owner5 = new Owner();
            owner5.setEmail("jane.doe@example.org");
            owner5.setId(1L);
            owner5.setName("Name");
            owner5.setPhone("6625550144");
            owner5.setRestaurant(new Restaurant());

            Restaurant restaurant6 = new Restaurant();
            restaurant6.setCoverImageUrl("https://example.org/example");
            restaurant6.setCuisine("Cuisine");
            restaurant6.setDescription("The characteristics of someone or something");
            restaurant6.setEmail("jane.doe@example.org");
            restaurant6.setFoodCategories(new ArrayList<>());
            restaurant6.setId(1L);
            restaurant6.setInstagram("Instagram");
            restaurant6.setLikes(1);
            restaurant6.setLocation(location6);
            restaurant6.setLogoUrl("https://example.org/example");
            restaurant6.setName("Name");
            restaurant6.setOwner(owner5);
            restaurant6.setParticipations(new HashSet<>());
            restaurant6.setPhoneNumber("6625550144");
            restaurant6.setPriceRange("Price Range");
            restaurant6.setRating(10.0d);
            restaurant6.setWaiters(new ArrayList<>());

            Owner owner6 = new Owner();
            owner6.setEmail("jane.doe@example.org");
            owner6.setId(1L);
            owner6.setName("Name");
            owner6.setPhone("6625550144");
            owner6.setRestaurant(restaurant6);

            Restaurant updatedRestaurant = new Restaurant();
            updatedRestaurant.setCoverImageUrl("https://example.org/example");
            updatedRestaurant.setCuisine("Cuisine");
            updatedRestaurant.setDescription("The characteristics of someone or something");
            updatedRestaurant.setEmail("jane.doe@example.org");
            updatedRestaurant.setFoodCategories(new ArrayList<>());
            updatedRestaurant.setId(1L);
            updatedRestaurant.setInstagram("Instagram");
            updatedRestaurant.setLikes(1);
            updatedRestaurant.setLocation(location5);
            updatedRestaurant.setLogoUrl("https://example.org/example");
            updatedRestaurant.setName("Name");
            updatedRestaurant.setOwner(owner6);
            updatedRestaurant.setParticipations(new HashSet<>());
            updatedRestaurant.setPhoneNumber("6625550144");
            updatedRestaurant.setPriceRange("Price Range");
            updatedRestaurant.setRating(10.0d);
            updatedRestaurant.setWaiters(new ArrayList<>());

            // Act
            restaurantService.updateRestaurant(1L, logoFile, coverFile, updatedRestaurant);

            // Assert
            mockFiles.verify(() -> Files.copy(Mockito.<InputStream>any(), Mockito.<Path>any(), isA(CopyOption[].class)),
                    atLeast(1));
            mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
            verify(restaurantRepository).findById(eq(1L));
            verify(restaurantRepository).save(isA(Restaurant.class));
        }
    }

    /**
     * Method under test:
     * {@link RestaurantService#updateRestaurant(Long, MultipartFile, MultipartFile, Restaurant)}
     */
    @Test
    void testUpdateRestaurant2() throws IOException {
        try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
            // Arrange
            mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
                    .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
            mockFiles.when(() -> Files.copy(Mockito.<InputStream>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
                    .thenReturn(1L);

            Location location = new Location();
            location.setLatitude(10.0d);
            location.setLongitude(10.0d);

            Location location2 = new Location();
            location2.setLatitude(10.0d);
            location2.setLongitude(10.0d);

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
            restaurant.setLocation(location2);
            restaurant.setLogoUrl("https://example.org/example");
            restaurant.setName("Name");
            restaurant.setOwner(owner);
            restaurant.setParticipations(new HashSet<>());
            restaurant.setPhoneNumber("6625550144");
            restaurant.setPriceRange("Price Range");
            restaurant.setRating(10.0d);
            restaurant.setWaiters(new ArrayList<>());

            Owner owner2 = new Owner();
            owner2.setEmail("jane.doe@example.org");
            owner2.setId(1L);
            owner2.setName("Name");
            owner2.setPhone("6625550144");
            owner2.setRestaurant(restaurant);

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
            restaurant2.setOwner(owner2);
            restaurant2.setParticipations(new HashSet<>());
            restaurant2.setPhoneNumber("6625550144");
            restaurant2.setPriceRange("Price Range");
            restaurant2.setRating(10.0d);
            restaurant2.setWaiters(new ArrayList<>());
            Optional<Restaurant> ofResult = Optional.of(restaurant2);
            when(restaurantRepository.save(Mockito.<Restaurant>any())).thenThrow(new RuntimeException("foo"));
            when(restaurantRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
            MockMultipartFile logoFile = new MockMultipartFile("Name",
                    new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

            MockMultipartFile coverFile = new MockMultipartFile("Name",
                    new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

            Location location3 = new Location();
            location3.setLatitude(10.0d);
            location3.setLongitude(10.0d);

            Location location4 = new Location();
            location4.setLatitude(10.0d);
            location4.setLongitude(10.0d);

            Owner owner3 = new Owner();
            owner3.setEmail("jane.doe@example.org");
            owner3.setId(1L);
            owner3.setName("Name");
            owner3.setPhone("6625550144");
            owner3.setRestaurant(new Restaurant());

            Restaurant restaurant3 = new Restaurant();
            restaurant3.setCoverImageUrl("https://example.org/example");
            restaurant3.setCuisine("Cuisine");
            restaurant3.setDescription("The characteristics of someone or something");
            restaurant3.setEmail("jane.doe@example.org");
            restaurant3.setFoodCategories(new ArrayList<>());
            restaurant3.setId(1L);
            restaurant3.setInstagram("Instagram");
            restaurant3.setLikes(1);
            restaurant3.setLocation(location4);
            restaurant3.setLogoUrl("https://example.org/example");
            restaurant3.setName("Name");
            restaurant3.setOwner(owner3);
            restaurant3.setParticipations(new HashSet<>());
            restaurant3.setPhoneNumber("6625550144");
            restaurant3.setPriceRange("Price Range");
            restaurant3.setRating(10.0d);
            restaurant3.setWaiters(new ArrayList<>());

            Owner owner4 = new Owner();
            owner4.setEmail("jane.doe@example.org");
            owner4.setId(1L);
            owner4.setName("Name");
            owner4.setPhone("6625550144");
            owner4.setRestaurant(restaurant3);

            Restaurant updatedRestaurant = new Restaurant();
            updatedRestaurant.setCoverImageUrl("https://example.org/example");
            updatedRestaurant.setCuisine("Cuisine");
            updatedRestaurant.setDescription("The characteristics of someone or something");
            updatedRestaurant.setEmail("jane.doe@example.org");
            updatedRestaurant.setFoodCategories(new ArrayList<>());
            updatedRestaurant.setId(1L);
            updatedRestaurant.setInstagram("Instagram");
            updatedRestaurant.setLikes(1);
            updatedRestaurant.setLocation(location3);
            updatedRestaurant.setLogoUrl("https://example.org/example");
            updatedRestaurant.setName("Name");
            updatedRestaurant.setOwner(owner4);
            updatedRestaurant.setParticipations(new HashSet<>());
            updatedRestaurant.setPhoneNumber("6625550144");
            updatedRestaurant.setPriceRange("Price Range");
            updatedRestaurant.setRating(10.0d);
            updatedRestaurant.setWaiters(new ArrayList<>());

            // Act and Assert
            assertThrows(RuntimeException.class,
                    () -> restaurantService.updateRestaurant(1L, logoFile, coverFile, updatedRestaurant));
            mockFiles.verify(() -> Files.copy(Mockito.<InputStream>any(), Mockito.<Path>any(), isA(CopyOption[].class)),
                    atLeast(1));
            mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
            verify(restaurantRepository).findById(eq(1L));
            verify(restaurantRepository).save(isA(Restaurant.class));
        }
    }

    /**
     * Method under test:
     * {@link RestaurantService#saveRestaurantImage(MultipartFile, String)}
     */
    @Test
    void testSaveRestaurantImage() throws IOException {
        // Arrange, Act and Assert
        assertThrows(RuntimeException.class, () -> restaurantService.saveRestaurantImage(
                new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))), "foo.txt"));
        assertThrows(RuntimeException.class, () -> restaurantService.saveRestaurantImage(null, "foo.txt"));
    }

    /**
     * Method under test:
     * {@link RestaurantService#saveRestaurantImage(MultipartFile, String)}
     */
    @Test
    void testSaveRestaurantImage2() throws IOException {
        // Arrange
        MultipartFile file = mock(MultipartFile.class);
        when(file.getInputStream()).thenThrow(new IOException("foo"));

        // Act and Assert
        assertThrows(RuntimeException.class, () -> restaurantService.saveRestaurantImage(file, "foo.txt"));
        verify(file).getInputStream();
    }

    /**
     * Method under test:
     * {@link RestaurantService#saveRestaurantImage(MultipartFile, String)}
     */
    @Test
    void testSaveRestaurantImage3() throws IOException {
        // Arrange
        MultipartFile file = mock(MultipartFile.class);
        when(file.getInputStream()).thenThrow(new FileAlreadyExistsException("foo"));

        // Act and Assert
        assertThrows(RuntimeException.class, () -> restaurantService.saveRestaurantImage(file, "foo.txt"));
        verify(file).getInputStream();
    }

    /**
     * Method under test: {@link RestaurantService#load(String)}
     */
    /*@Test
    void testLoad() {
        // Arrange, Act and Assert
        assertThrows(RuntimeException.class, () -> restaurantService.load("foo.txt"));
    }*/

    /**
     * Method under test: {@link RestaurantService#deleteRestaurant(Long)}
     */
    @Test
    void testDeleteRestaurant() {
        // Arrange
        doNothing().when(restaurantRepository).deleteById(Mockito.<Long>any());

        // Act
        restaurantService.deleteRestaurant(1L);

        // Assert that nothing has changed
        verify(restaurantRepository).deleteById(eq(1L));
    }

    /**
     * Method under test: {@link RestaurantService#deleteRestaurant(Long)}
     */
    @Test
    void testDeleteRestaurant2() {
        // Arrange
        doThrow(new RuntimeException("foo")).when(restaurantRepository).deleteById(Mockito.<Long>any());

        // Act and Assert
        assertThrows(RuntimeException.class, () -> restaurantService.deleteRestaurant(1L));
        verify(restaurantRepository).deleteById(eq(1L));
    }

    /**
     * Method under test: {@link RestaurantService#getRestaurantByOwnerId(Long)}
     */
    @Test
    void testGetRestaurantByOwnerId() {
        // Arrange
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

        Owner owner2 = new Owner();
        owner2.setEmail("jane.doe@example.org");
        owner2.setId(1L);
        owner2.setName("Name");
        owner2.setPhone("6625550144");
        owner2.setRestaurant(restaurant2);
        Optional<Owner> ofResult = Optional.of(owner2);
        when(ownerService.getOwnerById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Restaurant actualRestaurantByOwnerId = restaurantService.getRestaurantByOwnerId(1L);

        // Assert
        verify(ownerService).getOwnerById(eq(1L));
        assertSame(restaurant2, actualRestaurantByOwnerId);
    }

    /**
     * Method under test: {@link RestaurantService#getRestaurantByOwnerId(Long)}
     */
    @Test
    void testGetRestaurantByOwnerId2() {
        // Arrange
        Optional<Owner> emptyResult = Optional.empty();
        when(ownerService.getOwnerById(Mockito.<Long>any())).thenReturn(emptyResult);

        // Act
        Restaurant actualRestaurantByOwnerId = restaurantService.getRestaurantByOwnerId(1L);

        // Assert
        verify(ownerService).getOwnerById(eq(1L));
        assertNull(actualRestaurantByOwnerId);
    }
}
