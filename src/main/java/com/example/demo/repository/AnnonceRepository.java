package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.entities.Annonce;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
	  public Annonce findByTitre(String titre);

}
