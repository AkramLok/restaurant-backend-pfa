package com.example.pfabackend.repository;

import com.example.pfabackend.entities.ERole;
import com.example.pfabackend.entities.Role;
import com.example.pfabackend.entities.RoleClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleClientRepository extends JpaRepository<RoleClient, Long> {
  Optional<RoleClient> findByName(ERole name);
}
