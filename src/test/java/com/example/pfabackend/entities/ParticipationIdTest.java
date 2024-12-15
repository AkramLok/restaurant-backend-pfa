package com.example.pfabackend.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.assertj.core.api.Assertions;

@ExtendWith(MockitoExtension.class)
class ParticipationIdTest {

    @Test
    void testEqualsWhenSameClientIdAndRestaurantIdThenReturnTrue() {
        // Arrange
        Long clientId = 1L;
        Long restaurantId = 1L;
        ParticipationId participationId1 = new ParticipationId(clientId, restaurantId);
        ParticipationId participationId2 = new ParticipationId(clientId, restaurantId);

        // Act
        boolean result = participationId1.equals(participationId2);

        // Assert
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void testEqualsWhenDifferentClientIdAndRestaurantIdThenReturnFalse() {
        // Arrange
        ParticipationId participationId1 = new ParticipationId(1L, 1L);
        ParticipationId participationId2 = new ParticipationId(2L, 2L);

        // Act
        boolean result = participationId1.equals(participationId2);

        // Assert
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void testHashCodeWhenSameClientIdAndRestaurantIdThenReturnSameHashCode() {
        // Arrange
        Long clientId = 1L;
        Long restaurantId = 1L;
        ParticipationId participationId1 = new ParticipationId(clientId, restaurantId);
        ParticipationId participationId2 = new ParticipationId(clientId, restaurantId);

        // Act
        int hashCode1 = participationId1.hashCode();
        int hashCode2 = participationId2.hashCode();

        // Assert
        Assertions.assertThat(hashCode1).isEqualTo(hashCode2);
    }

    @Test
    void testHashCodeWhenDifferentClientIdAndRestaurantIdThenReturnDifferentHashCode() {
        // Arrange
        ParticipationId participationId1 = new ParticipationId(1L, 1L);
        ParticipationId participationId2 = new ParticipationId(2L, 2L);

        // Act
        int hashCode1 = participationId1.hashCode();
        int hashCode2 = participationId2.hashCode();

        // Assert
        Assertions.assertThat(hashCode1).isNotEqualTo(hashCode2);
    }
}
