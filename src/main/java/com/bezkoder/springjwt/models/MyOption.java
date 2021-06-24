package com.bezkoder.springjwt.models;



import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class MyOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String description;
    private String code;
    private BigDecimal coefContinue;
    private BigDecimal coefFinale;
    @ManyToOne
    private Filliere filliere;

    public BigDecimal getCoefContinue() {
        return coefContinue;
    }

    public void setCoefContinue(BigDecimal coefContinue) {
        this.coefContinue = coefContinue;
    }

    public BigDecimal getCoefFinale() {
        return coefFinale;
    }

    public void setCoefFinale(BigDecimal coefFinale) {
        this.coefFinale = coefFinale;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public Filliere getFilliere() {
        return filliere;
    }

    public void setFilliere(Filliere filliere) {
        this.filliere = filliere;
    }
}

