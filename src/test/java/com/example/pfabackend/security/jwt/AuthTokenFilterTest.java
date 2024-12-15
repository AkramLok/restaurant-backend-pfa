package com.example.pfabackend.security.jwt;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.pfabackend.security.services.UserDetailsImpl;
import com.example.pfabackend.security.services.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {AuthTokenFilter.class})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AuthTokenFilterTest {
    @Autowired
    private AuthTokenFilter authTokenFilter;

    @MockBean
    private JwtUtils jwtUtils;

    @MockBean
    private UserDetailsServiceImpl userDetailsServiceImpl;

    /**
     * Method under test:
     * {@link AuthTokenFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal() throws ServletException, IOException {
        // Arrange
        MockHttpServletRequest request = new MockHttpServletRequest();
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

        // Act
        authTokenFilter.doFilterInternal(request, response, filterChain);

        // Assert
        verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    }

    /**
     * Method under test:
     * {@link AuthTokenFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal2() throws ServletException, IOException {
        // Arrange
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

        // Act
        authTokenFilter.doFilterInternal(null, response, filterChain);

        // Assert
        verify(filterChain).doFilter(isNull(), isA(ServletResponse.class));
    }

    /**
     * Method under test:
     * {@link AuthTokenFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal3() throws ServletException, IOException {
        // Arrange
        HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
        when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

        // Act
        authTokenFilter.doFilterInternal(request, response, filterChain);

        // Assert
        verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
        verify(request).getHeader("Authorization");
    }

    /**
     * Method under test:
     * {@link AuthTokenFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal4() throws ServletException, IOException, UsernameNotFoundException {
        // Arrange
        when(jwtUtils.getUserNameFromJwtToken(Mockito.<String>any())).thenReturn("janedoe");
        when(jwtUtils.validateJwtToken(Mockito.<String>any())).thenReturn(true);
        when(userDetailsServiceImpl.loadUserByUsername(Mockito.<String>any())).thenReturn(
                new UserDetailsImpl(1L, "janedoe", "jane.doe@example.org", "iloveyou", 1L, 1L, 1L, new ArrayList<>()));
        HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
        when(request.getSession(anyBoolean())).thenReturn(new MockHttpSession());
        when(request.getRemoteAddr()).thenReturn("42 Main St");
        when(request.getHeader(Mockito.<String>any())).thenReturn("Bearer ");
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

        // Act
        authTokenFilter.doFilterInternal(request, response, filterChain);

        // Assert
        verify(jwtUtils).getUserNameFromJwtToken("");
        verify(jwtUtils).validateJwtToken("");
        verify(userDetailsServiceImpl).loadUserByUsername("janedoe");
        verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
        verify(request).getRemoteAddr();
        verify(request).getHeader("Authorization");
        verify(request).getSession(false);
    }

    /**
     * Method under test:
     * {@link AuthTokenFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal5() throws ServletException, IOException {
        // Arrange
        when(jwtUtils.validateJwtToken(Mockito.<String>any())).thenReturn(false);
        HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
        when(request.getHeader(Mockito.<String>any())).thenReturn("Bearer ");
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

        // Act
        authTokenFilter.doFilterInternal(request, response, filterChain);

        // Assert
        verify(jwtUtils).validateJwtToken("");
        verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
        verify(request).getHeader("Authorization");
    }

    /**
     * Method under test:
     * {@link AuthTokenFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal6() throws ServletException, IOException, UsernameNotFoundException {
        // Arrange
        when(jwtUtils.getUserNameFromJwtToken(Mockito.<String>any())).thenReturn("janedoe");
        when(jwtUtils.validateJwtToken(Mockito.<String>any())).thenReturn(true);
        when(userDetailsServiceImpl.loadUserByUsername(Mockito.<String>any()))
                .thenReturn(new User("janedoe", "iloveyou", new ArrayList<>()));
        HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
        when(request.getSession(anyBoolean())).thenReturn(new MockHttpSession());
        when(request.getRemoteAddr()).thenReturn("42 Main St");
        when(request.getHeader(Mockito.<String>any())).thenReturn("Bearer ");
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

        // Act
        authTokenFilter.doFilterInternal(request, response, filterChain);

        // Assert
        verify(jwtUtils).getUserNameFromJwtToken("");
        verify(jwtUtils).validateJwtToken("");
        verify(userDetailsServiceImpl).loadUserByUsername("janedoe");
        verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
        verify(request).getRemoteAddr();
        verify(request).getHeader("Authorization");
        verify(request).getSession(false);
    }

    /**
     * Method under test:
     * {@link AuthTokenFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal7() throws ServletException, IOException, UsernameNotFoundException {
        // Arrange
        when(jwtUtils.getUserNameFromJwtToken(Mockito.<String>any())).thenReturn("janedoe");
        when(jwtUtils.validateJwtToken(Mockito.<String>any())).thenReturn(true);
        when(userDetailsServiceImpl.loadUserByUsername(Mockito.<String>any())).thenReturn(null);
        HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
        when(request.getHeader(Mockito.<String>any())).thenReturn("Bearer ");
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

        // Act
        authTokenFilter.doFilterInternal(request, response, filterChain);

        // Assert
        verify(jwtUtils).getUserNameFromJwtToken("");
        verify(jwtUtils).validateJwtToken("");
        verify(userDetailsServiceImpl).loadUserByUsername("janedoe");
        verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
        verify(request).getHeader("Authorization");
    }
}
