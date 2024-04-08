package com.example.pfabackend.Controllers;

import com.example.pfabackend.entities.FeedBack;
import com.example.pfabackend.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

    private final FeedBackService feedBackService;

    @Autowired
    public FeedBackController(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }

    @GetMapping
    public List<FeedBack> getAllFeedBacks() {
        return feedBackService.getAllFeedBacks();
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<FeedBack> getAllFeedBacksForRestaurant(@PathVariable Long restaurantId) {
        return feedBackService.getAllFeedBacksForRestaurant(restaurantId);
    }

    @GetMapping("/client/{clientId}")
    public List<FeedBack> getAllFeedBacksForClient(@PathVariable Long clientId) {
        return feedBackService.getAllFeedBacksForClient(clientId);
    }

    @PostMapping("/restaurant/{restaurantId}/client/{clientId}")
    public FeedBack postFeedBack(@PathVariable Long restaurantId, @PathVariable Long clientId, @RequestBody FeedBack feedBack) {
        return feedBackService.postFeedBack(restaurantId, clientId, feedBack);
    }

    @DeleteMapping("/{feedBackId}")
    public void deleteFeedBack(@PathVariable Long feedBackId) {
        feedBackService.deleteFeedBack(feedBackId);
    }
}
