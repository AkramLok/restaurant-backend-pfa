package com.example.pfabackend.Controllers;

import com.example.pfabackend.entities.Discount;
import com.example.pfabackend.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount")
public class DiscountController {


    @Autowired
    private  DiscountService discountService;




    @GetMapping("/all")
    public ResponseEntity<List<Discount>> getAllDiscounts() {
        List<Discount> discounts = discountService.getAllDiscounts();
        return ResponseEntity.ok(discounts);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Discount>> getDiscountsByRestaurantId(@PathVariable Long restaurantId) {
        List<Discount> discounts = discountService.getDiscountsByRestaurantId(restaurantId);
        return ResponseEntity.ok(discounts);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Discount> getDiscountByProductId(@PathVariable Long productId) {
        Discount discount = discountService.getDiscountByProductId(productId);
        return ResponseEntity.ok(discount);
    }

    @PostMapping("/productId/{productId}")
    public ResponseEntity<Discount> createOrUpdateDiscount(@PathVariable Long productId, @RequestBody Discount discount) {
        Discount createdOrUpdatedDiscount = discountService.createOrUpdateDiscount(productId, discount);
        return new ResponseEntity<>(createdOrUpdatedDiscount, HttpStatus.CREATED);
    }

    @PutMapping("/{discountId}")
    public ResponseEntity<Discount> updateDiscount(@PathVariable Long discountId, @RequestBody Discount discount) {
        Discount updatedDiscount = discountService.updateDiscount(discountId, discount);
        return ResponseEntity.ok(updatedDiscount);
    }

    @DeleteMapping("/{discountId}")
    public ResponseEntity<Void> deleteDiscount(@PathVariable Long discountId) {
        discountService.deleteDiscount(discountId);
        return ResponseEntity.noContent().build();
    }
}
