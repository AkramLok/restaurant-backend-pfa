package com.example.pfabackend.dto;
import lombok.Data;

@Data
public class CreateParticipationRequest {
    private Long clientId;
    private Long restaurantId;
    private int points;
}

