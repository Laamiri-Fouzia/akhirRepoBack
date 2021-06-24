package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.NoteEtudiantModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteEtudiantModuleDao extends JpaRepository<NoteEtudiantModule,Long> {
    List<NoteEtudiantModule> findByEtudiantCne(String cne);
    List<NoteEtudiantModule> findByEtatValidationCode(String code);
    List<NoteEtudiantModule> findByModuleSemestreOptionCode (String code);
    List<NoteEtudiantModule> findByModuleSemestreOptionCodeAndEtatValidationCode (String code,String codeEtat);
    List<NoteEtudiantModule> findByModuleSemestreOptionSemestreCodeAndModuleSemestreOptionAnneeUniversitaireAnneeOneAndEtudiantCne(int codeSemestre,Long anne, String cne);
    List<NoteEtudiantModule> findByModuleSemestreOptionSemestreCodeAndModuleSemestreOptionAnneeUniversitaireAnneeOneAndEtudiantCneAndEtatValidationCode(int codeSemestre,Long anne, String cne,String codeEtat);
    List<NoteEtudiantModule> findByModuleSemestreOptionMyModuleCodeAndEtudiantCne(String code,String cne);
    List<NoteEtudiantModule> findByEtudiantCneAndModuleSemestreOptionAnneeUniversitaireLibelle(String cne,String libelle);
    NoteEtudiantModule findByEtudiantCneAndModuleSemestreOptionCode(String cne,String code);
    List<NoteEtudiantModule> findByEtudiantCneAndModuleSemestreOptionSemestreCode(String cne,int code);
}
