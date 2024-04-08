package com.example.pfabackend.service;

import com.example.pfabackend.entities.FoodCategory;
import com.example.pfabackend.entities.Product;
import com.example.pfabackend.repository.FoodCategoryRepository;
import com.example.pfabackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, FoodCategoryRepository foodCategoryRepository) {
        this.productRepository = productRepository;
        this.foodCategoryRepository = foodCategoryRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Long categoryId, Product product) {
        Optional<FoodCategory> categoryOptional = foodCategoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            FoodCategory category = categoryOptional.get();
            product.setCategory(category);
            return productRepository.save(product);
        } else {
            throw new IllegalArgumentException("Food category with ID " + categoryId + " not found.");
        }
    }

    public List<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.findByCategory_Id(categoryId);
    }

    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Product with ID " + id + " not found.");
        }
    }
}
