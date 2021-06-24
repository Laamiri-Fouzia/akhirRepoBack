package com.bezkoder.springjwt.models;

import javax.persistence.*;

@Entity
@Table(name = "Test_excel")
public class TestExcel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private boolean published;


    @ManyToOne
    private Etudiant etudiant;

    /*
    private String  nom;
    */


    public TestExcel() {

    }

    public TestExcel(String title, String description, boolean published, Etudiant etudiant) {
        this.title = title;
        this.description = description;
        this.published = published;
        this.etudiant=etudiant;
        //this.etudiant.getPrenom()= prenom;this.etudiant.getNom=this.

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + ",nom="+etudiant.getNom()+",prenom="+etudiant.getPrenom()+"]";
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}