package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Admin extends Employee {
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Employee> employees;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Réunion> réunions;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Annonce> annonces;


}
