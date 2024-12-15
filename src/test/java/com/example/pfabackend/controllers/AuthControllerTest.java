package com.example.pfabackend.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.pfabackend.payload.request.LoginRequest;
import com.example.pfabackend.payload.request.SignupRequest;
import com.example.pfabackend.payload.response.MessageResponse;
import com.example.pfabackend.repository.RoleRepository;
import com.example.pfabackend.repository.UserRepository;
import com.example.pfabackend.security.jwt.JwtUtils;
import com.example.pfabackend.service.ClientService;
import com.example.pfabackend.service.OwnerService;
import com.example.pfabackend.service.RestaurantService;
import com.example.pfabackend.service.WaiterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.util.HashSet;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuthController.class, AuthenticationManager.class, PasswordEncoder.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AuthControllerTest {
    @Autowired
    private AuthController authController;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private ClientService clientService;

    @MockBean
    private JwtUtils jwtUtils;

    @MockBean
    private OwnerService ownerService;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private RestaurantService restaurantService;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private WaiterService waiterService;

    /**
     * Method under test: {@link AuthController#authenticateClient(LoginRequest)}
     */
    @Test
    void testAuthenticateClient() throws Exception {
        // Arrange
        when(authenticationManager.authenticate(Mockito.<Authentication>any()))
                .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("");
        loginRequest.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(loginRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/client/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(authController).build().perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link AuthController#logout(HttpServletRequest)}
     */
    @Test
    void testLogout() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        ResponseEntity<?> actualLogoutResult = authController.logout(new MockHttpServletRequest());

        // Assert
        Object body = actualLogoutResult.getBody();
        assertTrue(body instanceof MessageResponse);
        HttpStatusCode statusCode = actualLogoutResult.getStatusCode();
        assertTrue(statusCode instanceof HttpStatus);
        assertEquals("Logout successful", ((MessageResponse) body).getMessage());
        assertEquals(200, actualLogoutResult.getStatusCodeValue());
        assertEquals(HttpStatus.OK, statusCode);
        assertTrue(actualLogoutResult.hasBody());
        assertTrue(actualLogoutResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link AuthController#logout(HttpServletRequest)}
     */
    @Test
    void testLogout2() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange and Act
        ResponseEntity<?> actualLogoutResult = (new AuthController()).logout(mock(HttpServletRequestWrapper.class));

        // Assert
        Object body = actualLogoutResult.getBody();
        assertTrue(body instanceof MessageResponse);
        HttpStatusCode statusCode = actualLogoutResult.getStatusCode();
        assertTrue(statusCode instanceof HttpStatus);
        assertEquals("Logout successful", ((MessageResponse) body).getMessage());
        assertEquals(200, actualLogoutResult.getStatusCodeValue());
        assertEquals(HttpStatus.OK, statusCode);
        assertTrue(actualLogoutResult.hasBody());
        assertTrue(actualLogoutResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link AuthController#authenticateClient(LoginRequest)}
     */
    @Test
    void testAuthenticateClient2() throws Exception {
        // Arrange
        when(authenticationManager.authenticate(Mockito.<Authentication>any()))
                .thenThrow(new AccountExpiredException("Msg"));

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("iloveyou");
        loginRequest.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(loginRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/client/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(authController).build().perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Invalid username or password\"}"));
    }

    /**
     * Method under test: {@link AuthController#authenticateUser(LoginRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAuthenticateUser() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@5e00114c testClass = com.example.pfabackend.Controllers.DiffblueFakeClass217, locations = [], classes = [com.example.pfabackend.Controllers.AuthController, org.springframework.security.authentication.AuthenticationManager, org.springframework.security.crypto.password.PasswordEncoder], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@3dd11da9, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@3f675268, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@48e82c6d, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@61879868], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //   See https://diff.blue/R026 to resolve this issue.

        // Arrange
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("iloveyou");
        loginRequest.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(loginRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        MockMvcBuilders.standaloneSetup(authController).build().perform(requestBuilder);
    }

    /**
     * Method under test: {@link AuthController#authenticateWaiter(LoginRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAuthenticateWaiter() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@54584ca7 testClass = com.example.pfabackend.Controllers.DiffblueFakeClass315, locations = [], classes = [com.example.pfabackend.Controllers.AuthController, org.springframework.security.authentication.AuthenticationManager, org.springframework.security.crypto.password.PasswordEncoder], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@3dd11da9, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@3f675268, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@48e82c6d, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@61879868], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //   See https://diff.blue/R026 to resolve this issue.

        // Arrange
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("iloveyou");
        loginRequest.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(loginRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/waiter/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        MockMvcBuilders.standaloneSetup(authController).build().perform(requestBuilder);
    }

    /**
     * Method under test: {@link AuthController#logout(HttpServletRequest)}
     */
    @Test
    //@Disabled("TODO: Complete this test")
    void testLogout3() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@7e6674cb testClass = com.example.pfabackend.Controllers.DiffblueFakeClass413, locations = [], classes = [com.example.pfabackend.Controllers.AuthController, org.springframework.security.authentication.AuthenticationManager, org.springframework.security.crypto.password.PasswordEncoder], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@3dd11da9, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@3f675268, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@48e82c6d, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@61879868], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //   See https://diff.blue/R026 to resolve this issue.

        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/logout");

        // Act
        MockMvcBuilders.standaloneSetup(authController).build().perform(requestBuilder);
    }

    /**
     * Method under test: {@link AuthController#registerUser(SignupRequest)}
     */
    @Test
    //@Disabled("TODO: Complete this test")
    void testRegisterUser() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@592ef1b8 testClass = com.example.pfabackend.Controllers.DiffblueFakeClass436, locations = [], classes = [com.example.pfabackend.Controllers.AuthController, org.springframework.security.authentication.AuthenticationManager, org.springframework.security.crypto.password.PasswordEncoder], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@3dd11da9, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@3f675268, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@48e82c6d, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@61879868], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //   See https://diff.blue/R026 to resolve this issue.

        // Arrange
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setCin("Cin");
        signupRequest.setEmail("jane.doe@example.org");
        signupRequest.setName("Name");
        signupRequest.setPassword("iloveyou");
        signupRequest.setPhone("6625550144");
        signupRequest.setRestaurantId(1L);
        signupRequest.setRole(new HashSet<>());
        signupRequest.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(signupRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        MockMvcBuilders.standaloneSetup(authController).build().perform(requestBuilder);
    }
}
