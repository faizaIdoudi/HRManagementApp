package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entities.Candidature;

public interface CandidatureRepository extends JpaRepository<Candidature, Long> {

}
