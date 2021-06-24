package com.bezkoder.springjwt.models;

import javax.persistence.*;

@Entity
public class EtudiantOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private MyOption myOption;
    @ManyToOne
    private Semestre semestre;
    @ManyToOne
    private AnneeUniversitaire anneeUniversitaire;
    private String code;

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

    public MyOption getMyOption() {
        return myOption;
    }

    public void setMyOption(MyOption myOption) {
        this.myOption = myOption;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AnneeUniversitaire getAnneeUniversitaire() {
        return anneeUniversitaire;
    }

    public void setAnneeUniversitaire(AnneeUniversitaire anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }
}
