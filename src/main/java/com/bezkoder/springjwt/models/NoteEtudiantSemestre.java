package com.bezkoder.springjwt.models;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class NoteEtudiantSemestre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private BigDecimal noteSemestre ;
    @ManyToOne
    private Semestre semestre;
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private EtatValidation etatValidation;

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
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public EtatValidation getEtatValidation() {
        return etatValidation;
    }

    public void setEtatValidation(EtatValidation etatValidation) {
        this.etatValidation = etatValidation;
    }



    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public BigDecimal getNoteSemestre() {
        return noteSemestre;
    }

    public void setNoteSemestre(BigDecimal noteSemestre) {
        this.noteSemestre = noteSemestre;
    }

}

