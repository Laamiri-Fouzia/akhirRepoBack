package com.bezkoder.springjwt.models;
import javax.persistence.*;

@Entity
public class ModuleSemestreOption {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	@ManyToOne
	private Semestre semestre;
	@ManyToOne
	private AnneeUniversitaire anneeUniversitaire;
	@ManyToOne
	private MyModule myModule;
	@ManyToOne
	private MyOption myOption;
	@ManyToOne
	private  TypeModule typeModule;

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

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public MyModule getMyModule() {
		return myModule;
	}

	public void setMyModule(MyModule mymodule) {
		this.myModule = mymodule;
	}

	public MyOption getMyOption() {
		return myOption;
	}

	public void setMyOption(MyOption myoption) {
		this.myOption = myoption;
	}

	public TypeModule getTypeModule() {
		return typeModule;
	}

	public void setTypeModule(TypeModule typeModule) {
		this.typeModule = typeModule;
	}

	public AnneeUniversitaire getAnneeUniversitaire() {
		return anneeUniversitaire;
	}

	public void setAnneeUniversitaire(AnneeUniversitaire anneeUniversitaire) {
		this.anneeUniversitaire = anneeUniversitaire;
	}
}
