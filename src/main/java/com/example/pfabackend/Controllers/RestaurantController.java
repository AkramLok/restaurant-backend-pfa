package com.example.pfabackend.Controllers;

import com.example.pfabackend.entities.Restaurant;
import com.example.pfabackend.payload.response.MessageResponse;
import com.example.pfabackend.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @GetMapping("/owner/{id}")
    public Restaurant getRestaurantByOwnerId(@PathVariable Long id){
        return restaurantService.getRestaurantByOwnerId(id);
    }

    @PostMapping
    public ResponseEntity<?> createRestaurant(@RequestPart Restaurant restaurant, @RequestParam("logoFile") MultipartFile logoFile, @RequestParam("coverFile") MultipartFile coverFile, @RequestParam("ownerId") String ownerId ) {
        restaurantService.createRestaurant(restaurant, logoFile, coverFile, ownerId);
        return ResponseEntity.ok(new MessageResponse("Restaurant created successfully!"));
    }

    //get any image of restaurant (cover or logo) by sending get: http://localhost:8084/api/restaurants/files/<<file_name.ext>>
    @GetMapping(value = "/files/{filename:[a-zA-Z0-9._-]+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = restaurantService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody Restaurant updatedRestaurant) {
        return restaurantService.updateRestaurant(id, updatedRestaurant);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
    }
}
