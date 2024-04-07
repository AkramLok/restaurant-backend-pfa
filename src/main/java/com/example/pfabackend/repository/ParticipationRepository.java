package com.example.pfabackend.repository;

import com.example.pfabackend.entities.Participation;
import com.example.pfabackend.entities.ParticipationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {

}