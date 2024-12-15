package com.example.pfabackend.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class LocationTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Location#equals(Object)}
     *   <li>{@link Location#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        // Act and Assert
        assertEquals(location, location2);
        int expectedHashCodeResult = location.hashCode();
        assertEquals(expectedHashCodeResult, location2.hashCode());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Location#equals(Object)}
     *   <li>{@link Location#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        // Act and Assert
        assertEquals(location, location);
        int expectedHashCodeResult = location.hashCode();
        assertEquals(expectedHashCodeResult, location.hashCode());
    }

    /**
     * Method under test: {@link Location#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
        // Arrange
        Location location = new Location();
        location.setLatitude(0.5d);
        location.setLongitude(10.0d);

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        // Act and Assert
        assertNotEquals(location, location2);
    }

    /**
     * Method under test: {@link Location#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(0.5d);

        Location location2 = new Location();
        location2.setLatitude(10.0d);
        location2.setLongitude(10.0d);

        // Act and Assert
        assertNotEquals(location, location2);
    }

    /**
     * Method under test: {@link Location#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsNull_thenReturnNotEqual() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        // Act and Assert
        assertNotEquals(location, null);
    }

    /**
     * Method under test: {@link Location#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
        // Arrange
        Location location = new Location();
        location.setLatitude(10.0d);
        location.setLongitude(10.0d);

        // Act and Assert
        assertNotEquals(location, "Different type to Location");
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Location#Location()}
     *   <li>{@link Location#setLatitude(double)}
     *   <li>{@link Location#setLongitude(double)}
     *   <li>{@link Location#toString()}
     *   <li>{@link Location#getLatitude()}
     *   <li>{@link Location#getLongitude()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        Location actualLocation = new Location();
        actualLocation.setLatitude(10.0d);
        actualLocation.setLongitude(10.0d);
        String actualToStringResult = actualLocation.toString();
        double actualLatitude = actualLocation.getLatitude();

        // Assert that nothing has changed
        assertEquals("Location(latitude=10.0, longitude=10.0)", actualToStringResult);
        assertEquals(10.0d, actualLatitude);
        assertEquals(10.0d, actualLocation.getLongitude());
    }

    /**
     * Method under test: {@link Location#Location(double, double)}
     */
    @Test
    void testNewLocation() {
        // Arrange and Act
        Location actualLocation = new Location(10.0d, 10.0d);

        // Assert
        assertEquals(10.0d, actualLocation.getLatitude());
        assertEquals(10.0d, actualLocation.getLongitude());
    }
}
