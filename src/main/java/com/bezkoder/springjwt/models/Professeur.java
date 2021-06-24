package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String prenom;
    private String nom;
    private String cin;
    private String codeEmploye;
    private String login;
    private String passWord;
    private String mail;
    private String tel;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateEmbauche;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateNaissance;
    private boolean estCoordonateurModule=false;
    private boolean isCoordonateurOption=false;
    @OneToMany
    private List<MyModule> listeModules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getCodeEmploye() {
        return codeEmploye;
    }

    public void setCodeEmploye(String codeEmploye) {
        this.codeEmploye = codeEmploye;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isCoordinateurModule() {
        return estCoordonateurModule;
    }

    public void setCoordinateurModule(boolean coordinateurModule) {
        estCoordonateurModule = coordinateurModule;
    }

    public boolean isCoordinateurOption() {
        return isCoordonateurOption;
    }

    public void setCoordinateurOption(boolean coordinateurOption) {
        isCoordonateurOption = coordinateurOption;
    }


    public List<MyModule> getListeModules() {
        return listeModules;
    }

    public void setListeModules(List<MyModule> listeModules) {
        this.listeModules = listeModules;
    }
}
