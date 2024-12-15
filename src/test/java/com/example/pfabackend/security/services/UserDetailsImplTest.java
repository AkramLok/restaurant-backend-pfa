package com.example.pfabackend.security.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.pfabackend.entities.User;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

class UserDetailsImplTest {
    @Test
    void testBuild() {
        // Arrange
        User user = new User();
        user.setClientId(1L);
        user.setEmail("jane.doe@example.org");
        user.setId(1L);
        user.setOwnerId(1L);
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");
        user.setWaiterId(1L);
        UserDetailsImpl buildResult = UserDetailsImpl.build(user);

        User user2 = new User();
        user2.setClientId(1L);
        user2.setEmail("jane.doe@example.org");
        user2.setId(1L);
        user2.setOwnerId(1L);
        user2.setPassword("iloveyou");
        user2.setRoles(new HashSet<>());
        user2.setUsername("janedoe");
        user2.setWaiterId(1L);

        // Act
        UserDetailsImpl actualBuildResult = buildResult.build(user2);

        // Assert
        assertTrue(actualBuildResult.getAuthorities() instanceof List);
        assertEquals("iloveyou", actualBuildResult.getPassword());
        assertEquals("jane.doe@example.org", actualBuildResult.getEmail());
        assertEquals("janedoe", actualBuildResult.getUsername());
        assertEquals(1L, actualBuildResult.getClientId().longValue());
        assertEquals(1L, actualBuildResult.getId().longValue());
        assertEquals(1L, actualBuildResult.getOwnerId().longValue());
        assertEquals(1L, actualBuildResult.getWaiterId().longValue());
        assertTrue(actualBuildResult.isAccountNonExpired());
        assertTrue(actualBuildResult.isAccountNonLocked());
        assertTrue(actualBuildResult.isCredentialsNonExpired());
        assertTrue(actualBuildResult.isEnabled());
    }

    /**
     * Method under test: {@link UserDetailsImpl#equals(Object)}
     */
    @Test
    void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
        // Arrange
        UserDetailsImpl buildResult = UserDetailsImpl.build(new User());
        UserDetailsImpl buildResult2 = UserDetailsImpl.build(new User());

        // Act and Assert
        assertEquals(buildResult, buildResult2);
        int notExpectedHashCodeResult = buildResult.hashCode();
        assertNotEquals(notExpectedHashCodeResult, buildResult2.hashCode());
    }

    /**
     * Method under test: {@link UserDetailsImpl#equals(Object)}
     */
    @Test
    void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
        // Arrange
        UserDetailsImpl buildResult = UserDetailsImpl.build(new User());

        // Act and Assert
        assertEquals(buildResult, buildResult);
        int expectedHashCodeResult = buildResult.hashCode();
        assertEquals(expectedHashCodeResult, buildResult.hashCode());
    }

    /**
     * Method under test: {@link UserDetailsImpl#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
        // Arrange
        User user = mock(User.class);
        when(user.getClientId()).thenReturn(1L);
        when(user.getId()).thenReturn(1L);
        when(user.getOwnerId()).thenReturn(1L);
        when(user.getWaiterId()).thenReturn(1L);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getRoles()).thenReturn(new HashSet<>());
        UserDetailsImpl buildResult = UserDetailsImpl.build(user);

        // Act and Assert
        assertNotEquals(buildResult, UserDetailsImpl.build(new User()));
    }

    /**
     * Method under test: {@link UserDetailsImpl#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsNull_thenReturnNotEqual() {
        // Arrange, Act and Assert
        assertNotEquals(null, UserDetailsImpl.build(new User()));
    }

    /**
     * Method under test: {@link UserDetailsImpl#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
        // Arrange, Act and Assert
        assertNotEquals("Different type to UserDetailsImpl", UserDetailsImpl.build(new User()));
    }
}
