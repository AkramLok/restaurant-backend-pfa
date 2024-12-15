package com.example.pfabackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.pfabackend.entities.FoodCategory;
import com.example.pfabackend.entities.Location;
import com.example.pfabackend.entities.Owner;
import com.example.pfabackend.entities.Participation;
import com.example.pfabackend.entities.Product;
import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.entities.Waiter;
import com.example.pfabackend.payload.response.MessageResponse;
import com.example.pfabackend.repository.FoodCategoryRepository;
import com.example.pfabackend.repository.ProductRepository;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {ProductService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ProductServiceTest {
    @MockBean
    private FoodCategoryRepository foodCategoryRepository;

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    /**
     * Method under test: {@link ProductService#init()}
     */
    @Test
    void testInit() {
        try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
            // Arrange
            mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
                    .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

            // Act
            productService.init();

            // Assert that nothing has changed
            mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
        }
    }

    /**
     * Method under test: {@link ProductService#init()}
     */
    @Test
    void testInit2() {
        try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
            // Arrange
            mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
                    .thenThrow(new IOException("foo"));

            // Act and Assert
            assertThrows(RuntimeException.class, () -> productService.init());
            mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
        }
    }

    /**
     * Method under test: {@link ProductService#init()}
     */
    @Test
    void testInit3() {
        try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
            // Arrange
            mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
                    .thenThrow(new RuntimeException("foo"));

            // Act and Assert
            assertThrows(RuntimeException.class, () -> productService.init());
            mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
        }
    }

    /**
     * Method under test: {@link ProductService#getAllProducts()}
     */
    @Test
    void testGetAllProducts() {
        // Arrange
        ArrayList<Product> productList = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(productList);

        // Act
        List<Product> actualAllProducts = productService.getAllProducts();

        // Assert
        verify(productRepository).findAll();
        assertTrue(actualAllProducts.isEmpty());
        assertSame(productList, actualAllProducts);
    }

    /**
     * Method under test: {@link ProductService#getAllProducts()}
     */
    @Test
    void testGetAllProducts2() {
        // Arrange
        when(productRepository.findAll()).thenThrow(new RuntimeException("foo"));

        // Act and Assert
        assertThrows(RuntimeException.class, () -> productService.getAllProducts());
        verify(productRepository).findAll();
    }

    /**
     * Method under test: {@link ProductService#getActivatedProducts()}
     */
    @Test
    void testGetActivatedProducts() {
        // Arrange
        ArrayList<Product> productList = new ArrayList<>();
        when(productRepository.findActivatedProducts()).thenReturn(productList);

        // Act
        List<Product> actualActivatedProducts = productService.getActivatedProducts();

        // Assert
        verify(productRepository).findActivatedProducts();
        assertTrue(actualActivatedProducts.isEmpty());
        assertSame(productList, actualActivatedProducts);
    }

    /**
     * Method under test: {@link ProductService#getActivatedProducts()}
     */
    @Test
    void testGetActivatedProducts2() {
        // Arrange
        when(productRepository.findActivatedProducts()).thenThrow(new RuntimeException("foo"));

        // Act and Assert
        assertThrows(RuntimeException.class, () -> productService.getActivatedProducts());
        verify(productRepository).findActivatedProducts();
    }

    /**
     * Method under test:
     * {@link ProductService#getActivatedProductsByCategoryId(Long)}
     */
    @Test
    void testGetActivatedProductsByCategoryId() {
        // Arrange
        ArrayList<Product> productList = new ArrayList<>();
        when(productRepository.findByCategory_IdAndIsActivated(Mockito.<Long>any(), anyBoolean())).thenReturn(productList);

        // Act
        List<Product> actualActivatedProductsByCategoryId = productService.getActivatedProductsByCategoryId(1L);

        // Assert
        verify(productRepository).findByCategory_IdAndIsActivated(1L, true);
        assertTrue(actualActivatedProductsByCategoryId.isEmpty());
        assertSame(productList, actualActivatedProductsByCategoryId);
    }

    /**
     * Method under test:
     * {@link ProductService#getActivatedProductsByCategoryId(Long)}
     */
    @Test
    void testGetActivatedProductsByCategoryId2() {
        // Arrange
        when(productRepository.findByCategory_IdAndIsActivated(Mockito.<Long>any(), anyBoolean()))
                .thenThrow(new RuntimeException("foo"));

        // Act and Assert
        assertThrows(RuntimeException.class, () -> productService.getActivatedProductsByCategoryId(1L));
        verify(productRepository).findByCategory_IdAndIsActivated(1L, true);
    }

    /**
     * Method under test: {@link ProductService#deactivateProduct(Long)}
     */
    @Test
    void testDeactivateProduct() {
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
        Optional<Product> ofResult = Optional.of(product);

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
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product2);
        when(productRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        productService.deactivateProduct(1L);

        // Assert
        verify(productRepository).findById(1L);
        verify(productRepository).save(isA(Product.class));
    }

    /**
     * Method under test: {@link ProductService#deactivateProduct(Long)}
     */
    @Test
    void testDeactivateProduct2() {
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
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.save(Mockito.<Product>any())).thenThrow(new RuntimeException("foo"));
        when(productRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(RuntimeException.class, () -> productService.deactivateProduct(1L));
        verify(productRepository).findById(1L);
        verify(productRepository).save(isA(Product.class));
    }

    /**
     * Method under test: {@link ProductService#activateProduct(Long)}
     */
    @Test
    void testActivateProduct() {
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
        Optional<Product> ofResult = Optional.of(product);

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
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product2);
        when(productRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        productService.activateProduct(1L);

        // Assert
        verify(productRepository).findById(1L);
        verify(productRepository).save(isA(Product.class));
    }

    /**
     * Method under test: {@link ProductService#activateProduct(Long)}
     */
    @Test
    void testActivateProduct2() {
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
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.save(Mockito.<Product>any())).thenThrow(new RuntimeException("foo"));
        when(productRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(RuntimeException.class, () -> productService.activateProduct(1L));
        verify(productRepository).findById(1L);
        verify(productRepository).save(isA(Product.class));
    }

    /**
     * Method under test: {@link ProductService#getProductById(Long)}
     */
    @Test
    void testGetProductById() {
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
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Optional<Product> actualProductById = productService.getProductById(1L);

        // Assert
        verify(productRepository).findById(1L);
        assertSame(ofResult, actualProductById);
    }

    /**
     * Method under test: {@link ProductService#getProductById(Long)}
     */
    @Test
    void testGetProductById2() {
        // Arrange
        when(productRepository.findById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

        // Act and Assert
        assertThrows(RuntimeException.class, () -> productService.getProductById(1L));
        verify(productRepository).findById(1L);
    }

    /**
     * Method under test:
     * {@link ProductService#createProduct(Long, Product, MultipartFile)}
     */
    @Test
    void testCreateProduct() throws IOException {
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

            FoodCategory category = new FoodCategory();
            category.setId(1L);
            category.setIsActivated(true);
            category.setName("Name");
            category.setProducts(new ArrayList<>());
            category.setRestaurant(restaurant2);

            Product product = new Product();
            product.setBonusPoints(1);
            product.setCategory(category);
            product.setId(1L);
            product.setImg("Img");
            product.setInfo("Info");
            product.setIsActivated(true);
            product.setName("Name");
            product.setPrice(10.0d);
            when(productRepository.save(Mockito.<Product>any())).thenReturn(product);

            Location location2 = new Location();
            location2.setLatitude(10.0d);
            location2.setLongitude(10.0d);

            Restaurant restaurant3 = new Restaurant();
            restaurant3.setCoverImageUrl("https://example.org/example");
            restaurant3.setCuisine("Cuisine");
            restaurant3.setDescription("The characteristics of someone or something");
            restaurant3.setEmail("jane.doe@example.org");
            ArrayList<FoodCategory> foodCategories = new ArrayList<>();
            restaurant3.setFoodCategories(foodCategories);
            restaurant3.setId(1L);
            restaurant3.setInstagram("Instagram");
            restaurant3.setLikes(1);
            Location location3 = new Location();
            restaurant3.setLocation(location3);
            restaurant3.setLogoUrl("https://example.org/example");
            restaurant3.setName("Name");
            Owner owner2 = new Owner();
            restaurant3.setOwner(owner2);
            HashSet<Participation> participations = new HashSet<>();
            restaurant3.setParticipations(participations);
            restaurant3.setPhoneNumber("6625550144");
            restaurant3.setPriceRange("Price Range");
            restaurant3.setRating(10.0d);
            ArrayList<Waiter> waiters = new ArrayList<>();
            restaurant3.setWaiters(waiters);

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
            restaurant4.setLocation(location2);
            restaurant4.setLogoUrl("https://example.org/example");
            restaurant4.setName("Name");
            restaurant4.setOwner(owner3);
            restaurant4.setParticipations(new HashSet<>());
            restaurant4.setPhoneNumber("6625550144");
            restaurant4.setPriceRange("Price Range");
            restaurant4.setRating(10.0d);
            restaurant4.setWaiters(new ArrayList<>());

            FoodCategory foodCategory = new FoodCategory();
            foodCategory.setId(1L);
            foodCategory.setIsActivated(true);
            foodCategory.setName("Name");
            foodCategory.setProducts(new ArrayList<>());
            foodCategory.setRestaurant(restaurant4);
            Optional<FoodCategory> ofResult = Optional.of(foodCategory);
            when(foodCategoryRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

            Location location4 = new Location();
            location4.setLatitude(10.0d);
            location4.setLongitude(10.0d);

            Owner owner4 = new Owner();
            owner4.setEmail("jane.doe@example.org");
            owner4.setId(1L);
            owner4.setName("Name");
            owner4.setPhone("6625550144");
            owner4.setRestaurant(new Restaurant());

            Restaurant restaurant5 = new Restaurant();
            restaurant5.setCoverImageUrl("https://example.org/example");
            restaurant5.setCuisine("Cuisine");
            restaurant5.setDescription("The characteristics of someone or something");
            restaurant5.setEmail("jane.doe@example.org");
            restaurant5.setFoodCategories(new ArrayList<>());
            restaurant5.setId(1L);
            restaurant5.setInstagram("Instagram");
            restaurant5.setLikes(1);
            restaurant5.setLocation(location4);
            restaurant5.setLogoUrl("https://example.org/example");
            restaurant5.setName("Name");
            restaurant5.setOwner(owner4);
            restaurant5.setParticipations(new HashSet<>());
            restaurant5.setPhoneNumber("6625550144");
            restaurant5.setPriceRange("Price Range");
            restaurant5.setRating(10.0d);
            restaurant5.setWaiters(new ArrayList<>());

            FoodCategory category2 = new FoodCategory();
            category2.setId(1L);
            category2.setIsActivated(true);
            category2.setName("Name");
            category2.setProducts(new ArrayList<>());
            category2.setRestaurant(restaurant5);

            Product product2 = new Product();
            product2.setBonusPoints(1);
            product2.setCategory(category2);
            product2.setId(1L);
            product2.setImg("Img");
            product2.setInfo("Info");
            product2.setIsActivated(true);
            product2.setName("Name");
            product2.setPrice(10.0d);

            // Act
            Product actualCreateProductResult = productService.createProduct(1L, product2,
                    new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

            // Assert
            mockFiles.verify(() -> Files.copy(Mockito.<InputStream>any(), Mockito.<Path>any(), isA(CopyOption[].class)));
            mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
            verify(foodCategoryRepository).findById(1L);
            verify(productRepository).save(isA(Product.class));
            Restaurant restaurant6 = product2.getCategory().getRestaurant().getOwner().getRestaurant();
            assertEquals("6625550144", restaurant6.getPhoneNumber());
            assertEquals("Cuisine", restaurant6.getCuisine());
            assertEquals("Instagram", restaurant6.getInstagram());
            assertEquals("Name", restaurant6.getName());
            assertEquals("Price Range", restaurant6.getPriceRange());
            assertEquals("The characteristics of someone or something", restaurant6.getDescription());
            assertEquals("https://example.org/example", restaurant6.getCoverImageUrl());
            assertEquals("https://example.org/example", restaurant6.getLogoUrl());
            assertEquals("jane.doe@example.org", restaurant6.getEmail());
            assertEquals(1, restaurant6.getLikes());
            assertEquals(10.0d, restaurant6.getRating());
            assertEquals(1L, restaurant6.getId().longValue());
            List<FoodCategory> foodCategories2 = restaurant6.getFoodCategories();
            assertTrue(foodCategories2.isEmpty());
            List<Waiter> waiters2 = restaurant6.getWaiters();
            assertTrue(waiters2.isEmpty());
            Set<Participation> participations2 = restaurant6.getParticipations();
            assertTrue(participations2.isEmpty());
            assertSame(location3, restaurant6.getLocation());
            assertSame(owner2, restaurant6.getOwner());
            assertSame(product, actualCreateProductResult);
            assertSame(foodCategories, foodCategories2);
            assertSame(waiters, waiters2);
            assertSame(participations, participations2);
        }
    }

    /**
     * Method under test:
     * {@link ProductService#createProduct(Long, Product, MultipartFile)}
     */
    @Test
    void testCreateProduct2() throws IOException {
        try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
            // Arrange
            mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
                    .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
            mockFiles.when(() -> Files.copy(Mockito.<InputStream>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
                    .thenReturn(1L);
            when(productRepository.save(Mockito.<Product>any())).thenThrow(new RuntimeException("Product Created !"));

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

            FoodCategory foodCategory = new FoodCategory();
            foodCategory.setId(1L);
            foodCategory.setIsActivated(true);
            foodCategory.setName("Name");
            foodCategory.setProducts(new ArrayList<>());
            foodCategory.setRestaurant(restaurant2);
            Optional<FoodCategory> ofResult = Optional.of(foodCategory);
            when(foodCategoryRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

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

            FoodCategory category = new FoodCategory();
            category.setId(1L);
            category.setIsActivated(true);
            category.setName("Name");
            category.setProducts(new ArrayList<>());
            category.setRestaurant(restaurant3);

            Product product = new Product();
            product.setBonusPoints(1);
            product.setCategory(category);
            product.setId(1L);
            product.setImg("Img");
            product.setInfo("Info");
            product.setIsActivated(true);
            product.setName("Name");
            product.setPrice(10.0d);

            // Act and Assert
            assertThrows(RuntimeException.class, () -> productService.createProduct(1L, product,
                    new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
            mockFiles.verify(() -> Files.copy(Mockito.<InputStream>any(), Mockito.<Path>any(), isA(CopyOption[].class)));
            mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
            verify(foodCategoryRepository).findById(1L);
            verify(productRepository).save(isA(Product.class));
        }
    }

    /**
     * Method under test: {@link ProductService#getProductsByCategoryId(Long)}
     */
    @Test
    void testGetProductsByCategoryId() {
        // Arrange
        ArrayList<Product> productList = new ArrayList<>();
        when(productRepository.findByCategory_Id(Mockito.<Long>any())).thenReturn(productList);

        // Act
        List<Product> actualProductsByCategoryId = productService.getProductsByCategoryId(1L);

        // Assert
        verify(productRepository).findByCategory_Id(1L);
        assertTrue(actualProductsByCategoryId.isEmpty());
        assertSame(productList, actualProductsByCategoryId);
    }

    /**
     * Method under test: {@link ProductService#getProductsByCategoryId(Long)}
     */
    @Test
    void testGetProductsByCategoryId2() {
        // Arrange
        when(productRepository.findByCategory_Id(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

        // Act and Assert
        assertThrows(RuntimeException.class, () -> productService.getProductsByCategoryId(1L));
        verify(productRepository).findByCategory_Id(1L);
    }

    /**
     * Method under test:
     * {@link ProductService#updateProduct(Long, Product, MultipartFile)}
     */
    @Test
    void testUpdateProduct() throws IOException {
        try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
            // Arrange
            mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
                    .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
            mockFiles.when(() -> Files.copy(Mockito.<InputStream>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
                    .thenReturn(1L);

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
            Optional<Product> ofResult = Optional.of(product);

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
            when(productRepository.save(Mockito.<Product>any())).thenReturn(product2);
            when(productRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

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

            FoodCategory category3 = new FoodCategory();
            category3.setId(1L);
            category3.setIsActivated(true);
            category3.setName("Name");
            category3.setProducts(new ArrayList<>());
            category3.setRestaurant(restaurant4);

            Product updatedProduct = new Product();
            updatedProduct.setBonusPoints(1);
            updatedProduct.setCategory(category3);
            updatedProduct.setId(1L);
            updatedProduct.setImg("Img");
            updatedProduct.setInfo("Info");
            updatedProduct.setIsActivated(true);
            updatedProduct.setName("Name");
            updatedProduct.setPrice(10.0d);

            // Act
            Product actualUpdateProductResult = productService.updateProduct(1L, updatedProduct,
                    new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

            // Assert
            mockFiles.verify(() -> Files.copy(Mockito.<InputStream>any(), Mockito.<Path>any(), isA(CopyOption[].class)));
            mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
            verify(productRepository).findById(1L);
            verify(productRepository).save(isA(Product.class));
            assertSame(product2, actualUpdateProductResult);
        }
    }

    /**
     * Method under test:
     * {@link ProductService#updateProduct(Long, Product, MultipartFile)}
     */
    @Test
    void testUpdateProduct2() {
        try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
            // Arrange
            mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
                    .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
            mockFiles.when(() -> Files.copy(Mockito.<InputStream>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
                    .thenReturn(1L);

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
            Optional<Product> ofResult = Optional.of(product);
            when(productRepository.save(Mockito.<Product>any())).thenThrow(new RuntimeException("Product Created !"));
            when(productRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

            Location location2 = new Location();
            location2.setLatitude(10.0d);
            location2.setLongitude(10.0d);

            Owner owner2 = new Owner();
            owner2.setEmail("jane.doe@example.org");
            owner2.setId(1L);
            owner2.setName("Name");
            owner2.setPhone("6625550144");
            owner2.setRestaurant(new Restaurant());

            Restaurant restaurant2 = new Restaurant();
            restaurant2.setCoverImageUrl("https://example.org/example");
            restaurant2.setCuisine("Cuisine");
            restaurant2.setDescription("The characteristics of someone or something");
            restaurant2.setEmail("jane.doe@example.org");
            restaurant2.setFoodCategories(new ArrayList<>());
            restaurant2.setId(1L);
            restaurant2.setInstagram("Instagram");
            restaurant2.setLikes(1);
            restaurant2.setLocation(location2);
            restaurant2.setLogoUrl("https://example.org/example");
            restaurant2.setName("Name");
            restaurant2.setOwner(owner2);
            restaurant2.setParticipations(new HashSet<>());
            restaurant2.setPhoneNumber("6625550144");
            restaurant2.setPriceRange("Price Range");
            restaurant2.setRating(10.0d);
            restaurant2.setWaiters(new ArrayList<>());

            FoodCategory category2 = new FoodCategory();
            category2.setId(1L);
            category2.setIsActivated(true);
            category2.setName("Name");
            category2.setProducts(new ArrayList<>());
            category2.setRestaurant(restaurant2);

            Product updatedProduct = new Product();
            updatedProduct.setBonusPoints(1);
            updatedProduct.setCategory(category2);
            updatedProduct.setId(1L);
            updatedProduct.setImg("Img");
            updatedProduct.setInfo("Info");
            updatedProduct.setIsActivated(true);
            updatedProduct.setName("Name");
            updatedProduct.setPrice(10.0d);

            // Act and Assert
            assertThrows(RuntimeException.class, () -> updateProductWithMockFile(updatedProduct));
            mockFiles.verify(() -> Files.copy(Mockito.<InputStream>any(), Mockito.<Path>any(), isA(CopyOption[].class)));
            mockFiles.verify(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
            verify(productRepository).findById(1L);
            verify(productRepository).save(isA(Product.class));
        }

    }
    private void updateProductWithMockFile(Product updatedProduct) throws IOException {
        productService.updateProduct(1L, updatedProduct,
                new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes(StandardCharsets.UTF_8))));
    }

    /**
     * Method under test:
     * {@link ProductService#saveProductImage(MultipartFile, String)}
     */
    @Test
    void testSaveProductImage2() throws IOException {
        // Arrange
        MultipartFile file = mock(MultipartFile.class);
        when(file.getInputStream()).thenThrow(new IOException("foo"));

        // Act and Assert
        assertThrows(RuntimeException.class, () -> productService.saveProductImage(file, "foo.txt"));
        verify(file).getInputStream();
    }

    /**
     * Method under test:
     * {@link ProductService#saveProductImage(MultipartFile, String)}
     */
    @Test
    void testSaveProductImage3() throws IOException {
        // Arrange
        MultipartFile file = mock(MultipartFile.class);
        when(file.getInputStream()).thenThrow(new FileAlreadyExistsException("foo"));

        // Act and Assert
        assertThrows(RuntimeException.class, () -> productService.saveProductImage(file, "foo.txt"));
        verify(file).getInputStream();
    }


    /**
     * Method under test: {@link ProductService#deleteProduct(Long)}
     */
    @Test
    void testDeleteProduct() {
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
        Optional<Product> ofResult = Optional.of(product);
        doNothing().when(productRepository).delete(Mockito.<Product>any());
        when(productRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        ResponseEntity<?> actualDeleteProductResult = productService.deleteProduct(1L);

        // Assert
        verify(productRepository).delete(isA(Product.class));
        verify(productRepository).findById(1L);
        Object body = actualDeleteProductResult.getBody();
        assertTrue(body instanceof MessageResponse);
        HttpStatusCode statusCode = actualDeleteProductResult.getStatusCode();
        assertTrue(statusCode instanceof HttpStatus);
        assertEquals("Product of name Name deleted successfully !", ((MessageResponse) body).getMessage());
        assertEquals(200, actualDeleteProductResult.getStatusCode().value());
        assertEquals(HttpStatus.OK, statusCode);
        assertTrue(actualDeleteProductResult.hasBody());
        assertTrue(actualDeleteProductResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link ProductService#deleteProduct(Long)}
     */
    @Test
    void testDeleteProduct2() {
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
        Optional<Product> ofResult = Optional.of(product);
        doThrow(new RuntimeException("foo")).when(productRepository).delete(Mockito.<Product>any());
        when(productRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(RuntimeException.class, () -> productService.deleteProduct(1L));
        verify(productRepository).delete(isA(Product.class));
        verify(productRepository).findById(1L);
    }

    /**
     * Method under test: {@link ProductService#deleteProduct(Long)}
     */
    @Test
    void testDeleteProduct3() {
        // Arrange
        Optional<Product> emptyResult = Optional.empty();
        when(productRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

        // Act
        ResponseEntity<?> actualDeleteProductResult = productService.deleteProduct(1L);

        // Assert
        verify(productRepository).findById(1L);
        Object body = actualDeleteProductResult.getBody();
        assertTrue(body instanceof MessageResponse);
        HttpStatusCode statusCode = actualDeleteProductResult.getStatusCode();
        assertTrue(statusCode instanceof HttpStatus);
        assertEquals("Product with ID 1 not found.", ((MessageResponse) body).getMessage());
        assertEquals(200, actualDeleteProductResult.getStatusCodeValue());
        assertEquals(HttpStatus.OK, statusCode);
        assertTrue(actualDeleteProductResult.hasBody());
        assertTrue(actualDeleteProductResult.getHeaders().isEmpty());
    }
}
