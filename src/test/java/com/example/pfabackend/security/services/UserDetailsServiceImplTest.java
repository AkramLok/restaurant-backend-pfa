package com.example.pfabackend.security.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.pfabackend.entities.ERole;
import com.example.pfabackend.entities.Role;
import com.example.pfabackend.entities.User;
import com.example.pfabackend.repository.UserRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserDetailsServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class UserDetailsServiceImplTest {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link UserDetailsServiceImpl#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
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
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByUsername(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        UserDetails actualLoadUserByUsernameResult = userDetailsServiceImpl.loadUserByUsername("janedoe");

        // Assert
        verify(userRepository).findByUsername("janedoe");
        assertTrue(actualLoadUserByUsernameResult instanceof UserDetailsImpl);
        Collection<? extends GrantedAuthority> authorities = actualLoadUserByUsernameResult.getAuthorities();
        assertTrue(authorities instanceof List);
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        assertEquals("jane.doe@example.org", ((UserDetailsImpl) actualLoadUserByUsernameResult).getEmail());
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        assertEquals(1L, ((UserDetailsImpl) actualLoadUserByUsernameResult).getClientId().longValue());
        assertEquals(1L, ((UserDetailsImpl) actualLoadUserByUsernameResult).getId().longValue());
        assertEquals(1L, ((UserDetailsImpl) actualLoadUserByUsernameResult).getOwnerId().longValue());
        assertEquals(1L, ((UserDetailsImpl) actualLoadUserByUsernameResult).getWaiterId().longValue());
        assertTrue(authorities.isEmpty());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
    }

    /**
     * Method under test: {@link UserDetailsServiceImpl#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        // Arrange
        Role role = new Role();
        role.setId(1);
        role.setName(ERole.ROLE_USER);

        HashSet<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User();
        user.setClientId(1L);
        user.setEmail("jane.doe@example.org");
        user.setId(1L);
        user.setOwnerId(1L);
        user.setPassword("iloveyou");
        user.setRoles(roles);
        user.setUsername("janedoe");
        user.setWaiterId(1L);
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByUsername(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        UserDetails actualLoadUserByUsernameResult = userDetailsServiceImpl.loadUserByUsername("janedoe");

        // Assert
        verify(userRepository).findByUsername("janedoe");
        assertTrue(actualLoadUserByUsernameResult instanceof UserDetailsImpl);
        Collection<? extends GrantedAuthority> authorities = actualLoadUserByUsernameResult.getAuthorities();
        assertEquals(1, authorities.size());
        assertTrue(authorities instanceof List);
        GrantedAuthority getResult = ((List<? extends GrantedAuthority>) authorities).get(0);
        assertTrue(getResult instanceof SimpleGrantedAuthority);
        assertEquals("ROLE_USER", getResult.toString());
        assertEquals("ROLE_USER", getResult.getAuthority());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        assertEquals("jane.doe@example.org", ((UserDetailsImpl) actualLoadUserByUsernameResult).getEmail());
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        assertEquals(1L, ((UserDetailsImpl) actualLoadUserByUsernameResult).getClientId().longValue());
        assertEquals(1L, ((UserDetailsImpl) actualLoadUserByUsernameResult).getId().longValue());
        assertEquals(1L, ((UserDetailsImpl) actualLoadUserByUsernameResult).getOwnerId().longValue());
        assertEquals(1L, ((UserDetailsImpl) actualLoadUserByUsernameResult).getWaiterId().longValue());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
    }

    /**
     * Method under test: {@link UserDetailsServiceImpl#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername3() throws UsernameNotFoundException {
        // Arrange
        Role role = new Role();
        role.setId(1);
        role.setName(ERole.ROLE_USER);

        Role role2 = new Role();
        role2.setId(2);
        role2.setName(ERole.ROLE_MODERATOR);

        HashSet<Role> roles = new HashSet<>();
        roles.add(role2);
        roles.add(role);

        User user = new User();
        user.setClientId(1L);
        user.setEmail("jane.doe@example.org");
        user.setId(1L);
        user.setOwnerId(1L);
        user.setPassword("iloveyou");
        user.setRoles(roles);
        user.setUsername("janedoe");
        user.setWaiterId(1L);
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByUsername(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        UserDetails actualLoadUserByUsernameResult = userDetailsServiceImpl.loadUserByUsername("janedoe");

        // Assert
        verify(userRepository).findByUsername("janedoe");
        assertTrue(actualLoadUserByUsernameResult instanceof UserDetailsImpl);
        Collection<? extends GrantedAuthority> authorities = actualLoadUserByUsernameResult.getAuthorities();
        assertEquals(2, authorities.size());
        assertTrue(authorities instanceof List);
        assertTrue(((List<? extends GrantedAuthority>) authorities).get(0) instanceof SimpleGrantedAuthority);
        assertTrue(((List<? extends GrantedAuthority>) authorities).get(1) instanceof SimpleGrantedAuthority);
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        assertEquals("jane.doe@example.org", ((UserDetailsImpl) actualLoadUserByUsernameResult).getEmail());
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        assertEquals(1L, ((UserDetailsImpl) actualLoadUserByUsernameResult).getClientId().longValue());
        assertEquals(1L, ((UserDetailsImpl) actualLoadUserByUsernameResult).getId().longValue());
        assertEquals(1L, ((UserDetailsImpl) actualLoadUserByUsernameResult).getOwnerId().longValue());
        assertEquals(1L, ((UserDetailsImpl) actualLoadUserByUsernameResult).getWaiterId().longValue());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
    }

    /**
     * Method under test: {@link UserDetailsServiceImpl#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername4() throws UsernameNotFoundException {
        // Arrange
        Optional<User> emptyResult = Optional.empty();
        when(userRepository.findByUsername(Mockito.<String>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(UsernameNotFoundException.class, () -> userDetailsServiceImpl.loadUserByUsername("janedoe"));
        verify(userRepository).findByUsername("janedoe");
    }

    /**
     * Method under test: {@link UserDetailsServiceImpl#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername5() throws UsernameNotFoundException {
        // Arrange
        when(userRepository.findByUsername(Mockito.<String>any())).thenThrow(new UsernameNotFoundException("Msg"));

        // Act and Assert
        assertThrows(UsernameNotFoundException.class, () -> userDetailsServiceImpl.loadUserByUsername("janedoe"));
        verify(userRepository).findByUsername("janedoe");
    }
}
