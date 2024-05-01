package com.example.pfabackend.service;

import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RestaurantService {

    private final Path root = Paths.get("uploads/restaurant");

    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        return optionalRestaurant.orElse(null);
    }

    public Restaurant createRestaurant(Restaurant restaurant, MultipartFile logoFile, MultipartFile coverFile) {
        if (logoFile == null || logoFile.isEmpty()) {
            throw new IllegalArgumentException("Logo file cannot be null or empty.");
        }
        if (coverFile == null || coverFile.isEmpty()) {
            throw new IllegalArgumentException("Cover file cannot be null or empty.");
        }
        init();
        String randomLogoFileName = UUID.randomUUID().toString();
        String fileLogoExtension = StringUtils.getFilenameExtension(logoFile.getOriginalFilename());
        String combinedLogoFileName = randomLogoFileName + "." + fileLogoExtension;
        saveRestaurantImage(logoFile, combinedLogoFileName);

        String randomCoverFileName = UUID.randomUUID().toString();
        String fileCoverExtension = StringUtils.getFilenameExtension(coverFile.getOriginalFilename());
        String combinedCoverFileName = randomCoverFileName + "." + fileCoverExtension;
        saveRestaurantImage(coverFile, combinedCoverFileName);

        System.out.println("Restaurant Created !");
        System.out.println("email: "+restaurant.getEmail()+" ,desc: "+restaurant.getDescription()+" , id: "+ restaurant.getId());

        restaurant.setLogoUrl(combinedLogoFileName);
        restaurant.setCoverImageUrl(combinedCoverFileName);
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Long id, Restaurant updatedRestaurant) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant restaurant = optionalRestaurant.get();
            if (updatedRestaurant.getName() != null) {
                restaurant.setName(updatedRestaurant.getName());
            }
            if (updatedRestaurant.getCoverImageUrl() != null) {
                restaurant.setCoverImageUrl(updatedRestaurant.getCoverImageUrl());
            }
            if (updatedRestaurant.getLogoUrl() != null) {
                restaurant.setLogoUrl(updatedRestaurant.getLogoUrl());
            }
            if (updatedRestaurant.getCuisine() != null) {
                restaurant.setCuisine(updatedRestaurant.getCuisine());
            }
            if (updatedRestaurant.getRating() != 0) {
                restaurant.setRating(updatedRestaurant.getRating());
            }
            if (updatedRestaurant.getDescription() != null) {
                restaurant.setDescription(updatedRestaurant.getDescription());
            }
            if (updatedRestaurant.getInstagram() != null) {
                restaurant.setInstagram(updatedRestaurant.getInstagram());
            }
            if (updatedRestaurant.getPhoneNumber() != null) {
                restaurant.setPhoneNumber(updatedRestaurant.getPhoneNumber());
            }
            if (updatedRestaurant.getEmail() != null) {
                restaurant.setEmail(updatedRestaurant.getEmail());
            }
            if (updatedRestaurant.getLikes() != 0) {
                restaurant.setLikes(updatedRestaurant.getLikes());
            }
            if (updatedRestaurant.getPriceRange() != null) {
                restaurant.setPriceRange(updatedRestaurant.getPriceRange());
            }
            // Update location fields if provided
            if (updatedRestaurant.getLocation() != null) {
                if (updatedRestaurant.getLocation().getLatitude() != 0) {
                    restaurant.getLocation().setLatitude(updatedRestaurant.getLocation().getLatitude());
                }
                if (updatedRestaurant.getLocation().getLongitude() != 0) {
                    restaurant.getLocation().setLongitude(updatedRestaurant.getLocation().getLongitude());
                }
            }
            // Update other fields as needed
            return restaurantRepository.save(restaurant);
        } else {
            return null; // Restaurant with given id not found
        }
    }

    public void saveRestaurantImage(MultipartFile file, String filename) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(filename));
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
