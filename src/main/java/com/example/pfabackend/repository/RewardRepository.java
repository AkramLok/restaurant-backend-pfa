package com.example.pfabackend.repository;

import com.example.pfabackend.entities.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Long> {
    Optional<Reward> findByProductId(Long productId);
    List<Reward> findAllByProductRestaurantId(Long restaurantId);
}
