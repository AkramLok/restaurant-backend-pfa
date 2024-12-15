package com.example.pfabackend.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(Lifecycle.PER_CLASS)
class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    void testGetAndSetOwnerIdWhenOwnerIdIsSetThenOwnerIdIsReturned() {
        // Arrange
        Long ownerId = 1L;

        // Act
        user.setOwnerId(ownerId);
        Long result = user.getOwnerId();

        // Assert
        assertEquals(ownerId, result);
    }

    @Test
    void testGetAndSetClientIdWhenClientIdIsSetThenClientIdIsReturned() {
        // Arrange
        Long clientId = 2L;

        // Act
        user.setClientId(clientId);
        Long result = user.getClientId();

        // Assert
        assertEquals(clientId, result);
    }

    @Test
    void testGetAndSetWaiterIdWhenWaiterIdIsSetThenWaiterIdIsReturned() {
        // Arrange
        Long waiterId = 3L;

        // Act
        user.setWaiterId(waiterId);
        Long result = user.getWaiterId();

        // Assert
        assertEquals(waiterId, result);
    }

    @Test
    void testGetAndSetIdWhenIdIsSetThenIdIsReturned() {
        // Arrange
        Long id = 4L;

        // Act
        user.setId(id);
        Long result = user.getId();

        // Assert
        assertEquals(id, result);
    }

    @Test
    void testGetAndSetUsernameWhenUsernameIsSetThenUsernameIsReturned() {
        // Arrange
        String username = "testUser";

        // Act
        user.setUsername(username);
        String result = user.getUsername();

        // Assert
        assertEquals(username, result);
    }

    @Test
    void testGetAndSetEmailWhenEmailIsSetThenEmailIsReturned() {
        // Arrange
        String email = "test@example.com";

        // Act
        user.setEmail(email);
        String result = user.getEmail();

        // Assert
        assertEquals(email, result);
    }

    @Test
    void testGetAndSetPasswordWhenPasswordIsSetThenPasswordIsReturned() {
        // Arrange
        String password = "password123";

        // Act
        user.setPassword(password);
        String result = user.getPassword();

        // Assert
        assertEquals(password, result);
    }

    @Test
    void testGetAndSetRolesWhenRolesAreSetThenRolesAreReturned() {
        // Arrange
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(ERole.ROLE_USER));

        // Act
        user.setRoles(roles);
        Set<Role> result = user.getRoles();

        // Assert
        assertEquals(roles, result);
    }
}
