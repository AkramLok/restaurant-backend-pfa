package com.example.pfabackend.Controllers;

import com.example.pfabackend.entities.*;
import com.example.pfabackend.payload.request.LoginRequest;
import com.example.pfabackend.payload.request.SignupRequest;
import com.example.pfabackend.payload.response.JwtResponse;
import com.example.pfabackend.payload.response.MessageResponse;
import com.example.pfabackend.repository.RoleClientRepository;
import com.example.pfabackend.repository.RoleRepository;
import com.example.pfabackend.repository.UserClientRepository;
import com.example.pfabackend.repository.UserRepository;
import com.example.pfabackend.security.jwt.JwtClientUtils;
import com.example.pfabackend.security.jwt.JwtUtils;
import com.example.pfabackend.security.services.UserClientDetailsImpl;
import com.example.pfabackend.security.services.UserDetailsImpl;
import com.example.pfabackend.service.ClientService;
import com.example.pfabackend.service.OwnerService;
import com.example.pfabackend.service.WaiterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  UserClientRepository userClientRepository;


  @Autowired
  OwnerService ownerService;

  @Autowired
  ClientService clientService;

  @Autowired
  WaiterService waiterService;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  RoleClientRepository roleClientRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  JwtClientUtils jwtClientUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    try {
      Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));


    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());
      return ResponseEntity.ok(new JwtResponse(jwt,
              userDetails.getId(),
              userDetails.getUsername(),
              userDetails.getEmail()
              , roles
      ));

    } catch (AuthenticationException e) {

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Invalid username or password"));
    }
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    User user = new User(signUpRequest.getUsername(),
               signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "mod":
          Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(modRole);

          break;
        default:
          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });


    user.setRoles(roles);
    }

    userRepository.save(user);

    Owner owner = new Owner(
            null,
            signUpRequest.getName(),
            signUpRequest.getEmail(),
            signUpRequest.getPhone(),
            null
    );
    ownerService.createOwner(owner);
    return ResponseEntity.ok(new MessageResponse("User and Owner registered successfully!"));

  }

}
