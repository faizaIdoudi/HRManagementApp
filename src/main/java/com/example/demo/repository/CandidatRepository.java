package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.entities.Candidat;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {

	 public Candidat findByEmail(String email);


}
