package com.example.demo.model.entities;

import java.util.List;

import com.example.demo.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
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
public class Candidat extends BaseEntity {


	@Column(nullable=false)
	private String NomComplet;
	@Email
	private String Email;
	@NotNull
	private String Telephone;
	@NotNull
	private String poste;
	@NotNull
	private String NiveauDetude;
	@NotNull
	private String Adresse;
	
	@OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL)
    private List<Candidature> candidatures;

}
