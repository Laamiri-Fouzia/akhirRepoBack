package com.bezkoder.springjwt.models;


import javax.persistence.*;

@Entity
public class InscriptionEtudiantModule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	@ManyToOne
	private ModuleSemestreOption moduleSemestreOption;
	@ManyToOne
	private Etudiant etudiant;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ModuleSemestreOption getModuleSemestreOption() {
		return moduleSemestreOption;
	}

	public void setModuleSemestreOption(ModuleSemestreOption moduleSemestreOption) {
		this.moduleSemestreOption = moduleSemestreOption;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
}
