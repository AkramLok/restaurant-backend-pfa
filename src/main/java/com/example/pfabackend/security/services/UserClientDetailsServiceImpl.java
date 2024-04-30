package com.example.pfabackend.security.services;

import com.example.pfabackend.entities.User;
import com.example.pfabackend.entities.UserClient;
import com.example.pfabackend.repository.UserClientRepository;
import com.example.pfabackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserClientDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserClientRepository userClientRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserClient userClient = userClientRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UserClientDetailsImpl.build(userClient);
  }

}
