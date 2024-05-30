package com.example.pfabackend.service;

import com.example.pfabackend.entities.*;
import com.example.pfabackend.repository.ClientRepository;
import com.example.pfabackend.repository.ParticipationRepository;
import com.example.pfabackend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ParticipationService {

    private final ParticipationRepository participationRepository;

    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private ClientService clientService;
    @Autowired
    public ParticipationService(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    public List<Participation> getAllParticipations() {
        return participationRepository.findAll();
    }

    public List<Participation> getAllParticipationsForRestaurant(Long restaurantId) {
        return participationRepository.findByRestaurantId(restaurantId);
    }

    public List<Participation> getAllParticipationsForClient(Long clientId) {
        return participationRepository.findByClientId(clientId);
    }

    public Participation createParticipation(Long clientId, Long restaurantId, int points) {
        Client client = clientService.getClientById(clientId);
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);

        ParticipationId participationId = new ParticipationId(clientId, restaurantId);
        Participation participation = new Participation(participationId, client, restaurant, points);

        return participationRepository.save(participation);
    }


    public void deleteParticipation(Long clientId, Long restaurantId) {
        ParticipationId participationId = new ParticipationId(clientId, restaurantId);
        Participation participation = participationRepository.findById(participationId)
                .orElseThrow(() -> new NoSuchElementException("Participation not found with clientId: " + clientId + " and restaurantId: " + restaurantId));
        participationRepository.delete(participation);
    }

    public void addPoints(Long clientId, Long restaurantId, int pointsToAdd) {
        ParticipationId participationId = new ParticipationId(clientId, restaurantId);
        Participation participation = participationRepository.findById(participationId)
                .orElseThrow(() -> new NoSuchElementException("Participation not found with clientId: " + clientId + " and restaurantId: " + restaurantId));

        int currentPoints = participation.getPoints();
        participation.setPoints(currentPoints + pointsToAdd);

        participationRepository.save(participation);
    }

    public void reducePoints(Long clientId, Long restaurantId, int pointsToReduce) {
        ParticipationId participationId = new ParticipationId(clientId, restaurantId);
        Participation participation = participationRepository.findById(participationId)
                .orElseThrow(() -> new NoSuchElementException("Participation not found with clientId: " + clientId + " and restaurantId: " + restaurantId));

        int currentPoints = participation.getPoints();
        int newPoints = currentPoints - pointsToReduce;
        if (newPoints < 0) {
            throw new IllegalArgumentException("Points cannot be reduced below zero.");
        }
        participation.setPoints(newPoints);

        participationRepository.save(participation);
    }
}

