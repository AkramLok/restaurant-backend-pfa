package com.example.pfabackend.Controllers;

import com.example.pfabackend.entities.Participation;
import com.example.pfabackend.payload.response.MessageResponse;
import com.example.pfabackend.service.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/participation")
public class ParticipationController {

    private final ParticipationService participationService;

    @Autowired
    public ParticipationController(ParticipationService participationService) {
        this.participationService = participationService;
    }

    @PostMapping
    public ResponseEntity<Participation> createParticipation(@RequestBody Participation participation) {
        Participation createdParticipation = participationService.createParticipation(participation);
        return ResponseEntity.ok(createdParticipation);
    }

    @DeleteMapping("/{clientId}/{restaurantId}")
    public ResponseEntity<?> deleteParticipation(@PathVariable Long clientId, @PathVariable Long restaurantId) {
        participationService.deleteParticipation(clientId, restaurantId);
        return ResponseEntity.ok(new MessageResponse("Participation with clientId " + clientId + " and restaurantId " + restaurantId + " deleted successfully."));
    }

    @PutMapping("/add-points/{clientId}/{restaurantId}/{pointsToAdd}")
    public ResponseEntity<?> addPoints(@PathVariable Long clientId, @PathVariable Long restaurantId, @PathVariable int pointsToAdd) {
        participationService.addPoints(clientId, restaurantId, pointsToAdd);
        return ResponseEntity.ok(new MessageResponse("Points added successfully."));
    }

    @PutMapping("/reduce-points/{clientId}/{restaurantId}/{pointsToReduce}")
    public ResponseEntity<?> reducePoints(@PathVariable Long clientId, @PathVariable Long restaurantId, @PathVariable int pointsToReduce) {
        participationService.reducePoints(clientId, restaurantId, pointsToReduce);
        return ResponseEntity.ok(new MessageResponse("Points reduced successfully."));
    }
}
