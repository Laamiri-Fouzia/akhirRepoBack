package com.bezkoder.springjwt.models;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class NoteEtudiantModule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private ModuleSemestreOption moduleSemestreOption;
    private BigDecimal noteModuleNormal ;
    private BigDecimal noteGlobale ;
    private BigDecimal noteModuleRat ;
    private BigDecimal noteContinue;
    private BigDecimal noteFinalAvRat;
    private BigDecimal noteFinalApresRat;
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private EtatValidation etatValidation;
    @ManyToOne
    private NoteEtudiantSemestre noteEtudiantSemestre;

    public BigDecimal getNoteContinue() {
        return noteContinue;
    }

    public void setNoteContinue(BigDecimal noteContinue) {
        this.noteContinue = noteContinue;
    }

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

    public ModuleSemestreOption getModuleSemestreOption() {
        return moduleSemestreOption;
    }

    public void setModuleSemestreOption(ModuleSemestreOption moduleSemestreOption) {
        this.moduleSemestreOption = moduleSemestreOption;
    }

    public EtatValidation getEtatValidation() {
        return etatValidation;
    }

    public void setEtatValidation(EtatValidation etatValidation) {
        this.etatValidation = etatValidation;
    }

    public BigDecimal getNoteFinalAvRat() {
        return noteFinalAvRat;
    }

    public void setNoteFinalAvRat(BigDecimal noteFinalAvRat) {
        this.noteFinalAvRat = noteFinalAvRat;
    }

    public BigDecimal getNoteFinalApresRat() {
        return noteFinalApresRat;
    }

    public void setNoteFinalApresRat(BigDecimal noteFinalApresRat) {
        this.noteFinalApresRat = noteFinalApresRat;
    }

    public BigDecimal getNoteModuleNormal() {
        return noteModuleNormal;
    }

    public void setNoteModuleNormal(BigDecimal noteModuleNormal) {
        this.noteModuleNormal = noteModuleNormal;
    }

    public BigDecimal getNoteModuleRat() {
        return noteModuleRat;
    }

    public void setNoteModuleRat(BigDecimal noteModuleRat) {
        this.noteModuleRat = noteModuleRat;
    }

    public BigDecimal getNoteGlobale() {
        return noteGlobale;
    }

    public void setNoteGlobale(BigDecimal noteGlobale) {
        this.noteGlobale = noteGlobale;
    }

    public NoteEtudiantSemestre getNoteEtudiantSemestre() {
        return noteEtudiantSemestre;
    }

    public void setNoteEtudiantSemestre(NoteEtudiantSemestre noteEtudiantSemestre) {
        this.noteEtudiantSemestre = noteEtudiantSemestre;
    }
}

