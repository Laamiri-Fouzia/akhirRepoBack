package com.bezkoder.springjwt.models;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class NoteEtudiantStage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private ModuleSemestreOption moduleSemestreOption;
    private BigDecimal noteStage ;
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private EtatValidation etatValidation;
    @ManyToOne
    private NoteEtudiantSemestre noteEtudiantSemestre;

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

    public BigDecimal getNoteStage() {
        return noteStage;
    }

    public void setNoteStage(BigDecimal noteStage) {
        this.noteStage = noteStage;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public EtatValidation getEtatValidation() {
        return etatValidation;
    }

    public void setEtatValidation(EtatValidation etatValidation) {
        this.etatValidation = etatValidation;
    }

    public NoteEtudiantSemestre getNoteEtudiantSemestre() {
        return noteEtudiantSemestre;
    }

    public void setNoteEtudiantSemestre(NoteEtudiantSemestre noteEtudiantSemestre) {
        this.noteEtudiantSemestre = noteEtudiantSemestre;
    }
}

