package com.example.pfabackend.Controllers;

import com.example.pfabackend.entities.Reward;
import com.example.pfabackend.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reward")
public class RewardController {
    private final RewardService rewardService;
    @Autowired
    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }
    @GetMapping
    public ResponseEntity<List<Reward>> getAllRewards() {
        List<Reward> rewards = rewardService.getAllRewards();
        return ResponseEntity.ok(rewards);
    }
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Reward>> getAllRewardsForRestaurant(@PathVariable Long restaurantId) {
        List<Reward> rewards = rewardService.getAllRewardsForRestaurant(restaurantId);
        return ResponseEntity.ok(rewards);
    }

    @GetMapping("/productId/{productId}")
    public ResponseEntity<Reward> getRewardByProductId(@PathVariable Long productId) {
        Optional<Reward> reward = rewardService.getRewardByProductId(productId);
        return reward.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/productId/{productId}")
    public ResponseEntity<Reward> createOrUpdateReward(@PathVariable Long productId, @RequestBody Reward reward) {
        Reward createdReward = rewardService.createOrUpdateReward(productId, reward);
        if (createdReward != null) {
            return ResponseEntity.ok(createdReward);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{rewardId}")
    public ResponseEntity<Void> deleteReward(@PathVariable Long rewardId) {
        rewardService.deleteReward(rewardId);
        return ResponseEntity.noContent().build();
    }
}
