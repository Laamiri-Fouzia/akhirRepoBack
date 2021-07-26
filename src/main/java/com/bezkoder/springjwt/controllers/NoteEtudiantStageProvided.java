package com.bezkoder.springjwt.controllers;
import com.bezkoder.springjwt.models.NoteEtudiantStage;
import com.bezkoder.springjwt.service.NoteEtudiantStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("ispits-project/note-etudiant-stage")
public class NoteEtudiantStageProvided {
    @Autowired
    private NoteEtudiantStageService noteEtudiantStageService;

    @GetMapping("/module-semestre-option/codeModule/{codeModule}")
    @PreAuthorize("hasRole('ADMINABSENCE') or hasRole('COORDONNATEURMODULE')")
    public List<NoteEtudiantStage> findNoteStage(@PathVariable String codeModule) {
        return noteEtudiantStageService.findNoteStage(codeModule);
    }

    @PutMapping("/updateStage/")
    @PreAuthorize("hasRole('COORDONNATEURMODULE')")
    public void updateStage(@RequestBody NoteEtudiantStage noteEtudiantStage) {
        noteEtudiantStageService.updateStage(noteEtudiantStage);
    }
    @GetMapping("Etudiant/cne/{cne}/moduleSemestreOption/semestre/code/{code}")
    public NoteEtudiantStage findByEtudiantCneAndModuleSemestreOptionSemestreCode(@PathVariable String cne,@PathVariable  int code) {
        return noteEtudiantStageService.findByEtudiantCneAndModuleSemestreOptionSemestreCode(cne, code);
    }
}
