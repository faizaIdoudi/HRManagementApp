package com.example.demo.model.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitialiser","handler"})
public class Admin extends Employee  {
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Employee> employees;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Réunion> réunions;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Annonce> annonces;


}
