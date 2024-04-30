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
@RequestMapping("/api/auth-client")
public class AuthClientController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserClientRepository userClientRepository;

  @Autowired
  ClientService clientService;


  @Autowired
  RoleClientRepository roleClientRepository;

  @Autowired
  PasswordEncoder encoder;


  @Autowired
  JwtClientUtils jwtClientUtils;


  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUserClient(@Valid @RequestBody LoginRequest loginRequest) {
    try {
      System.out.println("fsqf0");
      Authentication authentication = authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

      System.out.println("fsqf1");
      SecurityContextHolder.getContext().setAuthentication(authentication);
      String jwt = jwtClientUtils.generateJwtToken(authentication);
      System.out.println("fsqf2");

      UserClientDetailsImpl userClientDetails = (UserClientDetailsImpl) authentication.getPrincipal();
      List<String> rolesClients = userClientDetails.getAuthorities().stream()
              .map(item -> item.getAuthority())
              .collect(Collectors.toList());
      System.out.println("fsqf3");

      return ResponseEntity.ok(new JwtResponse(jwt,
              userClientDetails.getId(),
              userClientDetails.getUsername(),
              userClientDetails.getEmail()
              , rolesClients
      ));

    } catch (AuthenticationException e) {

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Invalid username or password"));
    }
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUserClient(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userClientRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userClientRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: Email is already in use!"));
    }

    UserClient userClient = new UserClient(signUpRequest.getUsername(),
            signUpRequest.getEmail(),
            encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<RoleClient> rolesClients = new HashSet<>();

    if (strRoles == null) {
      RoleClient userRoleClient = roleClientRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      rolesClients.add(userRoleClient);
    } else {
      strRoles.forEach(roleClient -> {
        switch (roleClient) {
          case "admin":
            RoleClient adminRoleClient = roleClientRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            rolesClients.add(adminRoleClient);

            break;
          case "mod":
            RoleClient modRoleClient = roleClientRepository.findByName(ERole.ROLE_MODERATOR)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            rolesClients.add(modRoleClient);

            break;
          default:
            RoleClient userRoleClient = roleClientRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            rolesClients.add(userRoleClient);
        }
      });


      userClient.setRolesClient(rolesClients);
    }

    userClientRepository.save(userClient);

    Client client = new Client(
            null,
            signUpRequest.getName(),
            signUpRequest.getEmail(),
            signUpRequest.getPhone(),
            null,
            null
    );

    clientService.createClient(client);
    return ResponseEntity.ok(new MessageResponse("User and Client registered successfully!"));

  }




}
