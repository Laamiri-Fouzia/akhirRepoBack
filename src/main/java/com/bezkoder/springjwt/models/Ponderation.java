package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Ponderation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private BigDecimal coefContinue;
    private BigDecimal coefFinale;

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

}

