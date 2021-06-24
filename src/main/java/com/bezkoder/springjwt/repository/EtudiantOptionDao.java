package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.EtudiantOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantOptionDao extends JpaRepository<EtudiantOption,Long> {
    List<EtudiantOption> findByMyOptionCode(String code);
    EtudiantOption findByEtudiantCneAndMyOptionCodeAndAnneeUniversitaireLibelleAndSemestreCode(String cne,String codeoption,String anne ,int semstreCode);
    List<EtudiantOption> findByMyOptionCodeAndAnneeUniversitaireAnneeOneAndSemestreCode(String code,Long annee,int codeSems);
    int deleteByEtudiantCne(String cne);
    int deleteByMyOptionCode(String code);
    List<EtudiantOption> findByMyOptionCodeAndAnneeUniversitaireLibelleAndSemestreCode(String codeOpt,String libelle,int codeSem);
}
