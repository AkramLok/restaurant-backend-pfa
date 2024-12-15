package com.example.pfabackend.security.jwt;

import com.example.pfabackend.security.services.UserDetailsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JwtUtilsTest {

    @InjectMocks
    private JwtUtils jwtUtils;

    @Mock
    private Authentication authentication;

    @Mock
    private UserDetailsImpl userDetails;

    private String jwtSecret = "mySecretKeymySecretKeymySecretKeymySecretKey";
    private int jwtExpirationMs = 3600000; // 1 hour

    @BeforeEach
    void setUp() {
        jwtUtils.jwtSecret = jwtSecret;
        jwtUtils.jwtExpirationMs = jwtExpirationMs;
    }

    @Test
    void testGenerateJwtTokenWhenCalledThenReturnNotNullToken() {
        // Arrange
        when(authentication.getPrincipal()).thenReturn(userDetails);
        when(userDetails.getUsername()).thenReturn("testUser");

        // Act
        String token = jwtUtils.generateJwtToken(authentication);

        // Assert
        assertNotNull(token);
    }

    @Test
    void testGetUserNameFromJwtTokenWhenCalledThenReturnCorrectUsername() {
        // Arrange
        when(authentication.getPrincipal()).thenReturn(userDetails);
        when(userDetails.getUsername()).thenReturn("testUser");
        String token = jwtUtils.generateJwtToken(authentication);

        // Act
        String username = jwtUtils.getUserNameFromJwtToken(token);

        // Assert
        assertEquals("testUser", username);
    }

    @Test
    void testValidateJwtTokenWhenCalledWithValidTokenThenReturnTrue() {
        // Arrange
        when(authentication.getPrincipal()).thenReturn(userDetails);
        when(userDetails.getUsername()).thenReturn("testUser");
        String token = jwtUtils.generateJwtToken(authentication);

        // Act
        boolean isValid = jwtUtils.validateJwtToken(token);

        // Assert
        assertTrue(isValid);
    }

    @Test
    void testValidateJwtTokenWhenCalledWithInvalidTokenThenReturnFalse() {
        // Arrange
        String invalidToken = "invalidToken";

        // Act
        boolean isValid = jwtUtils.validateJwtToken(invalidToken);

        // Assert
        assertFalse(isValid);
    }
}
