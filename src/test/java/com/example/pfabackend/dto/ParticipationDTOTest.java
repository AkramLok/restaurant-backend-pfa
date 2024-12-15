package com.example.pfabackend.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ParticipationDTOTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link ParticipationDTO#ParticipationDTO()}
     *   <li>{@link ParticipationDTO#setClientId(Long)}
     *   <li>{@link ParticipationDTO#setPoints(int)}
     *   <li>{@link ParticipationDTO#setRestaurantId(Long)}
     *   <li>{@link ParticipationDTO#getClientId()}
     *   <li>{@link ParticipationDTO#getPoints()}
     *   <li>{@link ParticipationDTO#getRestaurantId()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        ParticipationDTO actualParticipationDTO = new ParticipationDTO();
        actualParticipationDTO.setClientId(1L);
        actualParticipationDTO.setPoints(1);
        actualParticipationDTO.setRestaurantId(1L);
        Long actualClientId = actualParticipationDTO.getClientId();
        int actualPoints = actualParticipationDTO.getPoints();
        Long actualRestaurantId = actualParticipationDTO.getRestaurantId();

        // Assert that nothing has changed
        assertEquals(1, actualPoints);
        assertEquals(1L, actualClientId.longValue());
        assertEquals(1L, actualRestaurantId.longValue());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link ParticipationDTO#ParticipationDTO(Long, Long, int)}
     *   <li>{@link ParticipationDTO#setClientId(Long)}
     *   <li>{@link ParticipationDTO#setPoints(int)}
     *   <li>{@link ParticipationDTO#setRestaurantId(Long)}
     *   <li>{@link ParticipationDTO#getClientId()}
     *   <li>{@link ParticipationDTO#getPoints()}
     *   <li>{@link ParticipationDTO#getRestaurantId()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        ParticipationDTO actualParticipationDTO = new ParticipationDTO(1L, 1L, 1);
        actualParticipationDTO.setClientId(1L);
        actualParticipationDTO.setPoints(1);
        actualParticipationDTO.setRestaurantId(1L);
        Long actualClientId = actualParticipationDTO.getClientId();
        int actualPoints = actualParticipationDTO.getPoints();
        Long actualRestaurantId = actualParticipationDTO.getRestaurantId();

        // Assert that nothing has changed
        assertEquals(1, actualPoints);
        assertEquals(1L, actualClientId.longValue());
        assertEquals(1L, actualRestaurantId.longValue());
    }
}
