package com.bezkoder.springjwt.models;


import javax.persistence.*;

@Entity
public class Absence {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Etudiant etudiant;
	@ManyToOne
	private Seance seance;
	//private  justification;
	private String etatJustification;
	private boolean etatAbsence;
	@ManyToOne
	private ImageModl imageModel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public void setEtatAbsence(boolean etatAbsence) {
		this.etatAbsence = etatAbsence;
	}
	public boolean getEtatAbsence() {
		return etatAbsence;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	public String getEtatJustification() {
		return etatJustification;
	}

	public void setEtatJustification(String etatJustification) {
		this.etatJustification = etatJustification;
	}

	public ImageModl getImageModel() {
		return imageModel;
	}

	public void setImageModel(ImageModl imageModl) {
		this.imageModel = imageModl;
	}
}
