package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenceDao extends JpaRepository<Absence,Long> {
    Absence findByEtudiantCneAndSeanceLibelle(String cne,String libelle);
    List<Absence> findByEtatAbsenceTrueAndSeanceDateSeance(String date);
    List<Absence> findBySeanceLibelle(String libelle);
    int deleteByEtudiantCneAndSeanceLibelle(String cne,String libelle);
    List<Absence> findByEtudiantCneAndSeanceModuleSemestreOptionSemestreCodeAndSeanceModuleSemestreOptionAnneeUniversitaireLibelle(String cne, int semestre,String anne);
    @Query("select a from Absence a where a.etudiant.cne=:cne and a.seance.moduleSemestreOption.code =:codeModule and (a.etatJustification='refusée' or a.etatJustification='Aucune justification donnée' )")
    List<Absence> findEtudiantAbsente(@Param("cne") String cne,@Param("codeModule") String codeModule);

  }
