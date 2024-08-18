package com.example.demo.model.entities;

import java.time.LocalDate;

import com.example.demo.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Candidature extends BaseEntity{

	@Column(nullable=false)
	private LocalDate dateCandidature;
	@NotNull
	private String Statut;
	@NotNull
	private String Poste;
	@NotNull
	private String CV;
	@NotNull
	private String letterMotivation;
	
	@ManyToOne
    @JoinColumn(name = "rh_id")
    private RH rh;

    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private Candidat candidat;
}
