package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.NoteEtudiantSemestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteEtudiantSemestreDao extends JpaRepository<NoteEtudiantSemestre,Long> {
    NoteEtudiantSemestre findByCode(String code);
    List<NoteEtudiantSemestre> findBySemestreCode(String code);
    List<NoteEtudiantSemestre> findByEtudiantCne(String cne);
    NoteEtudiantSemestre findByEtudiantCneAndSemestreCode(String cne,int code);
}
