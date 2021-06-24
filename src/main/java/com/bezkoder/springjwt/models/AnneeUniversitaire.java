package com.bezkoder.springjwt.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnneeUniversitaire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String libelle;
	private Long anneeOne;
	private Long anneeTwo;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAnneeOne() {
		return anneeOne;
	}

	public void setAnneeOne(Long annee1) {
		this.anneeOne = annee1;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Long getAnneeTwo() {
		return anneeTwo;
	}

	public void setAnneeTwo(Long anneeTwo) {
		this.anneeTwo = anneeTwo;
	}
}
