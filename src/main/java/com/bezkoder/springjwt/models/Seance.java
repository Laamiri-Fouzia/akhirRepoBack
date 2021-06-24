package com.bezkoder.springjwt.models;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

@Entity
public class

Seance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private ModuleSemestreOption moduleSemestreOption;
	private String heureDebut;
	private String heureFin;
	@JsonFormat(pattern="yyyy-MM-ddTHH:mm:ssZ", timezone = "UTC")
	private String dateSeance;
	private  String libelle;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ModuleSemestreOption getModuleSemestreOption() {
		return moduleSemestreOption;
	}

	public void setModuleSemestreOption(ModuleSemestreOption moduleSemestreOption) {
		this.moduleSemestreOption = moduleSemestreOption;
	}

	public String getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}


	public String getDateSeance() {
		return dateSeance;
	}

	public void setDateSeance(String dateSeance) {
		this.dateSeance = dateSeance;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
