package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.NoteEtudiantModule;
import com.bezkoder.springjwt.models.NoteEtudiantStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteEtudiantStageDao extends JpaRepository<NoteEtudiantStage,Long> {
    List<NoteEtudiantStage> findByModuleSemestreOptionCode (String code);
    NoteEtudiantStage findByEtudiantCneAndModuleSemestreOptionCode(String cne,String code);
   NoteEtudiantStage findByEtudiantCneAndModuleSemestreOptionSemestreCode(String cne,int codeSemestre);
}
