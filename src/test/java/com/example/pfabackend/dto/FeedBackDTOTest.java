package com.example.pfabackend.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class FeedBackDTOTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link FeedBackDTO#equals(Object)}
     *   <li>{@link FeedBackDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
        // Arrange
        FeedBackDTO feedBackDTO = new FeedBackDTO();
        feedBackDTO.setDescription("The characteristics of someone or something");
        feedBackDTO.setId(1L);
        feedBackDTO.setRating(1);

        FeedBackDTO feedBackDTO2 = new FeedBackDTO();
        feedBackDTO2.setDescription("The characteristics of someone or something");
        feedBackDTO2.setId(1L);
        feedBackDTO2.setRating(1);

        // Act and Assert
        assertEquals(feedBackDTO, feedBackDTO2);
        int expectedHashCodeResult = feedBackDTO.hashCode();
        assertEquals(expectedHashCodeResult, feedBackDTO2.hashCode());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link FeedBackDTO#equals(Object)}
     *   <li>{@link FeedBackDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
        // Arrange
        FeedBackDTO feedBackDTO = new FeedBackDTO();
        feedBackDTO.setDescription(null);
        feedBackDTO.setId(1L);
        feedBackDTO.setRating(1);

        FeedBackDTO feedBackDTO2 = new FeedBackDTO();
        feedBackDTO2.setDescription(null);
        feedBackDTO2.setId(1L);
        feedBackDTO2.setRating(1);

        // Act and Assert
        assertEquals(feedBackDTO, feedBackDTO2);
        int expectedHashCodeResult = feedBackDTO.hashCode();
        assertEquals(expectedHashCodeResult, feedBackDTO2.hashCode());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link FeedBackDTO#equals(Object)}
     *   <li>{@link FeedBackDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
        // Arrange
        FeedBackDTO feedBackDTO = new FeedBackDTO();
        feedBackDTO.setDescription("The characteristics of someone or something");
        feedBackDTO.setId(null);
        feedBackDTO.setRating(1);

        FeedBackDTO feedBackDTO2 = new FeedBackDTO();
        feedBackDTO2.setDescription("The characteristics of someone or something");
        feedBackDTO2.setId(null);
        feedBackDTO2.setRating(1);

        // Act and Assert
        assertEquals(feedBackDTO, feedBackDTO2);
        int expectedHashCodeResult = feedBackDTO.hashCode();
        assertEquals(expectedHashCodeResult, feedBackDTO2.hashCode());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link FeedBackDTO#equals(Object)}
     *   <li>{@link FeedBackDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
        // Arrange
        FeedBackDTO feedBackDTO = new FeedBackDTO();
        feedBackDTO.setDescription("The characteristics of someone or something");
        feedBackDTO.setId(1L);
        feedBackDTO.setRating(1);

        // Act and Assert
        assertEquals(feedBackDTO, feedBackDTO);
        int expectedHashCodeResult = feedBackDTO.hashCode();
        assertEquals(expectedHashCodeResult, feedBackDTO.hashCode());
    }

    /**
     * Method under test: {@link FeedBackDTO#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
        // Arrange
        FeedBackDTO feedBackDTO = new FeedBackDTO();
        feedBackDTO.setDescription("Description");
        feedBackDTO.setId(1L);
        feedBackDTO.setRating(1);

        FeedBackDTO feedBackDTO2 = new FeedBackDTO();
        feedBackDTO2.setDescription("The characteristics of someone or something");
        feedBackDTO2.setId(1L);
        feedBackDTO2.setRating(1);

        // Act and Assert
        assertNotEquals(feedBackDTO, feedBackDTO2);
    }

    /**
     * Method under test: {@link FeedBackDTO#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
        // Arrange
        FeedBackDTO feedBackDTO = new FeedBackDTO();
        feedBackDTO.setDescription(null);
        feedBackDTO.setId(1L);
        feedBackDTO.setRating(1);

        FeedBackDTO feedBackDTO2 = new FeedBackDTO();
        feedBackDTO2.setDescription("The characteristics of someone or something");
        feedBackDTO2.setId(1L);
        feedBackDTO2.setRating(1);

        // Act and Assert
        assertNotEquals(feedBackDTO, feedBackDTO2);
    }

    /**
     * Method under test: {@link FeedBackDTO#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
        // Arrange
        FeedBackDTO feedBackDTO = new FeedBackDTO();
        feedBackDTO.setDescription("The characteristics of someone or something");
        feedBackDTO.setId(2L);
        feedBackDTO.setRating(1);

        FeedBackDTO feedBackDTO2 = new FeedBackDTO();
        feedBackDTO2.setDescription("The characteristics of someone or something");
        feedBackDTO2.setId(1L);
        feedBackDTO2.setRating(1);

        // Act and Assert
        assertNotEquals(feedBackDTO, feedBackDTO2);
    }

    /**
     * Method under test: {@link FeedBackDTO#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
        // Arrange
        FeedBackDTO feedBackDTO = new FeedBackDTO();
        feedBackDTO.setDescription("The characteristics of someone or something");
        feedBackDTO.setId(null);
        feedBackDTO.setRating(1);

        FeedBackDTO feedBackDTO2 = new FeedBackDTO();
        feedBackDTO2.setDescription("The characteristics of someone or something");
        feedBackDTO2.setId(1L);
        feedBackDTO2.setRating(1);

        // Act and Assert
        assertNotEquals(feedBackDTO, feedBackDTO2);
    }

    /**
     * Method under test: {@link FeedBackDTO#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
        // Arrange
        FeedBackDTO feedBackDTO = new FeedBackDTO();
        feedBackDTO.setDescription("The characteristics of someone or something");
        feedBackDTO.setId(1L);
        feedBackDTO.setRating(3);

        FeedBackDTO feedBackDTO2 = new FeedBackDTO();
        feedBackDTO2.setDescription("The characteristics of someone or something");
        feedBackDTO2.setId(1L);
        feedBackDTO2.setRating(1);

        // Act and Assert
        assertNotEquals(feedBackDTO, feedBackDTO2);
    }

    /**
     * Method under test: {@link FeedBackDTO#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsNull_thenReturnNotEqual() {
        // Arrange
        FeedBackDTO feedBackDTO = new FeedBackDTO();
        feedBackDTO.setDescription("The characteristics of someone or something");
        feedBackDTO.setId(1L);
        feedBackDTO.setRating(1);

        // Act and Assert
        assertNotEquals(feedBackDTO, null);
    }

    /**
     * Method under test: {@link FeedBackDTO#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
        // Arrange
        FeedBackDTO feedBackDTO = new FeedBackDTO();
        feedBackDTO.setDescription("The characteristics of someone or something");
        feedBackDTO.setId(1L);
        feedBackDTO.setRating(1);

        // Act and Assert
        assertNotEquals(feedBackDTO, "Different type to FeedBackDTO");
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>default or parameterless constructor of {@link FeedBackDTO}
     *   <li>{@link FeedBackDTO#setDescription(String)}
     *   <li>{@link FeedBackDTO#setId(Long)}
     *   <li>{@link FeedBackDTO#setRating(int)}
     *   <li>{@link FeedBackDTO#toString()}
     *   <li>{@link FeedBackDTO#getDescription()}
     *   <li>{@link FeedBackDTO#getId()}
     *   <li>{@link FeedBackDTO#getRating()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        FeedBackDTO actualFeedBackDTO = new FeedBackDTO();
        actualFeedBackDTO.setDescription("The characteristics of someone or something");
        actualFeedBackDTO.setId(1L);
        actualFeedBackDTO.setRating(1);
        String actualToStringResult = actualFeedBackDTO.toString();
        String actualDescription = actualFeedBackDTO.getDescription();
        Long actualId = actualFeedBackDTO.getId();

        // Assert that nothing has changed
        assertEquals("FeedBackDTO(id=1, description=The characteristics of someone or something, rating=1)",
                actualToStringResult);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals(1, actualFeedBackDTO.getRating());
        assertEquals(1L, actualId.longValue());
    }
}
