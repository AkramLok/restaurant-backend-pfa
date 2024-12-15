package com.example.pfabackend.security.jwt;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.DelegatingServletOutputStream;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuthEntryPointJwt.class})
@ExtendWith(SpringExtension.class)
class AuthEntryPointJwtTest {
    @Autowired
    private AuthEntryPointJwt authEntryPointJwt;

    /**
     * Method under test:
     * {@link AuthEntryPointJwt#commence(HttpServletRequest, HttpServletResponse, AuthenticationException)}
     */
    @Test
    void testCommence() throws ServletException, IOException {
        // Arrange
        MockHttpServletRequest request = new MockHttpServletRequest();
        HttpServletResponseWrapper response = mock(HttpServletResponseWrapper.class);
        when(response.getOutputStream()).thenReturn(new DelegatingServletOutputStream(new ByteArrayOutputStream(1)));
        doNothing().when(response).setContentType(Mockito.<String>any());
        doNothing().when(response).setStatus(anyInt());

        // Act
        authEntryPointJwt.commence(request, response, new AccountExpiredException("Msg"));

        // Assert
        verify(response).getOutputStream();
        verify(response).setContentType("application/json");
        verify(response).setStatus(403);
    }
}
