package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantDao extends JpaRepository<Etudiant,Long> {
    Etudiant findByCne( String cne);
    List<Etudiant> findByNomAndPrenom(String nom, String prenon);
    int deleteByCne( String cne);
}
