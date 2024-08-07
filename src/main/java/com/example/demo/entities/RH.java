package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class RH extends Employee{
	
	@OneToMany(mappedBy = "rh", cascade = CascadeType.ALL)
    private List<Congé> congés;

    @OneToMany(mappedBy = "rh", cascade = CascadeType.ALL)
    private List<Candidat> candidats;

}
