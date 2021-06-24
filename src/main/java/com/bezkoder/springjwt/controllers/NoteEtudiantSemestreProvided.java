package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.NoteEtudiantSemestre;
import com.bezkoder.springjwt.service.NoteEtudiantSemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("ispits-project/note-etudiant-semestre")
public class NoteEtudiantSemestreProvided {
    @Autowired
    private NoteEtudiantSemestreService noteEtudiantSemestreService;

    @GetMapping("/")
    public List<NoteEtudiantSemestre> findAll() {
        return noteEtudiantSemestreService.findAll();
    }

    @GetMapping("/Etudiant/cne/{cne}/Semestre/code/{code}")
    public NoteEtudiantSemestre findByEtudiantCneAndSemestreCode(@PathVariable String cne,@PathVariable int code) {
        return noteEtudiantSemestreService.findByEtudiantCneAndSemestreCode(cne, code);
    }
    @GetMapping("/Semestre/code/{code}")
    public List<NoteEtudiantSemestre> findBySemestreCode(@PathVariable String code) {
        return noteEtudiantSemestreService.findBySemestreCode(code);
    }
    @GetMapping("/Etudiant/cne/{cne}")
    public List<NoteEtudiantSemestre> findByEtudiantCne(@PathVariable String cne) {
        return noteEtudiantSemestreService.findByEtudiantCne(cne);
    }

    @GetMapping("/code/{code}")
    public NoteEtudiantSemestre findByCode(@PathVariable String code) {
        return noteEtudiantSemestreService.findByCode(code);
    }

    @GetMapping("/semestre/codeSemestre/{codeSemestre}/option/codeOption/{codeOption}/annee-universitaire/libelle/{libelle}")
    public List<NoteEtudiantSemestre> notesSemestre(@PathVariable int codeSemestre,@PathVariable String codeOption,@PathVariable String libelle) {
        return noteEtudiantSemestreService.notesSemestre(codeSemestre, codeOption, libelle);
    }
}
