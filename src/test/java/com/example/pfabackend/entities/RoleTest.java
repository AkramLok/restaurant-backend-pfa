package com.example.pfabackend.entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RoleTest {

    private Role role;

    @BeforeAll
    public void setUp() {
        role = new Role();
    }

    @Test
    void testGetIdWhenIdIsSetThenReturnId() {
        // Arrange
        Integer expectedId = 1;
        role.setId(expectedId);

        // Act
        Integer actualId = role.getId();

        // Assert
        assertThat(actualId).isEqualTo(expectedId);
    }

    @Test
    void testSetIdWhenIdIsSetThenReturnId() {
        // Arrange
        Integer expectedId = 2;

        // Act
        role.setId(expectedId);
        Integer actualId = role.getId();

        // Assert
        assertThat(actualId).isEqualTo(expectedId);
    }

    @Test
    void testGetNameWhenNameIsSetThenReturnName() {
        // Arrange
        ERole expectedName = ERole.ROLE_USER;
        role.setName(expectedName);

        // Act
        ERole actualName = role.getName();

        // Assert
        assertThat(actualName).isEqualTo(expectedName);
    }

    @Test
    void testSetNameWhenNameIsSetThenReturnName() {
        // Arrange
        ERole expectedName = ERole.ROLE_ADMIN;

        // Act
        role.setName(expectedName);
        ERole actualName = role.getName();

        // Assert
        assertThat(actualName).isEqualTo(expectedName);
    }
}
