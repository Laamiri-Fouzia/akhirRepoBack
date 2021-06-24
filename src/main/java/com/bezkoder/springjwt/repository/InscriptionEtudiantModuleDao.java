package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.InscriptionEtudiantModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionEtudiantModuleDao extends JpaRepository<InscriptionEtudiantModule,Long> {
    InscriptionEtudiantModule findByCode(String code);
    List<InscriptionEtudiantModule> findByModuleSemestreOptionCode(String code);
    int deleteByEtudiantCne(String cne);

}
