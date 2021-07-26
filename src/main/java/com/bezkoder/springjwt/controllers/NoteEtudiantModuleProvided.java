package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.NoteEtudiantModule;
import com.bezkoder.springjwt.service.NoteEtudiantModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("ispits-project/note-etudiant-modul")
public class NoteEtudiantModuleProvided {



    @Autowired
    private NoteEtudiantModuleService noteEtudiantModuleService;

    @GetMapping("/")
    public List<NoteEtudiantModule> findAll() {
        return noteEtudiantModuleService.findAll();
    }

    @GetMapping("/module-semestre-option/codeModule/{codeModule}")
    @PreAuthorize("hasRole('ADMINABSENCE') or hasRole('COORDONNATEURMODULE')")
    public List<NoteEtudiantModule> findNotes(@PathVariable String codeModule) {
        return noteEtudiantModuleService.findNotes(codeModule);
    }


    @GetMapping("moduleSemestreOption/semestre/codeSemestre/{codeSemestre}/moduleSemestreOption/annee-universitaire/{annee}/Etudiant/cne/{cne}")
    public List<NoteEtudiantModule> findByModuleSemestreOptionSemestreCodeAndModuleSemestreOptionAnneeUnversAndEtudiantCne(@PathVariable int codeSemestre,@PathVariable Long annee,@PathVariable String cne) {
        return noteEtudiantModuleService.findByModuleSemestreOptionSemestreCodeAndModuleSemestreOptionAnneeUniversitaireAnneeOneAndEtudiantCne(codeSemestre, annee, cne);
    }

    @GetMapping("etatValidation/code/{code}")
    public List<NoteEtudiantModule> findByEtatValidationCode(@PathVariable String code) {
        return noteEtudiantModuleService.findByEtatValidationCode(code);
    }
    @GetMapping("moduleSemestreOption/codeModule/{codeModule}/etatValidation/codeEtat/{codeEtat}")
    @PreAuthorize("hasRole('COORDONNATEURMODULE')")
    public List<NoteEtudiantModule> findByModuleSemestreOptionCodeAndEtatValidationCode(@PathVariable String codeModule,@PathVariable String codeEtat) {
        return noteEtudiantModuleService.findByModuleSemestreOptionCodeAndEtatValidationCode(codeModule, codeEtat);
    }
    @GetMapping("Etudiant/cne/{cne}")
    public List<NoteEtudiantModule> findByEtudiantCne(@PathVariable String cne) {
        return noteEtudiantModuleService.findByEtudiantCne(cne);
    }
    @GetMapping("moduleSemestreOption/module/code/{code}/Etudiant/cne/{cne}")
    public List<NoteEtudiantModule> findByModuleSemestreOptionMyModuleCodeAndEtudiantCne(@PathVariable String code,@PathVariable String cne) {
        return noteEtudiantModuleService.findByModuleSemestreOptionMyModuleCodeAndEtudiantCne(code, cne);
    }
    @GetMapping("moduleSemestreOption/semestre/code/{codeSemestre}/moduleSemestreOption/annee-universitaire/anneeOne/{anneeOne}/Etudiant/cne/{cne}")
    public List<NoteEtudiantModule> findByModuleSemestreOptionSemestreCodeAndModuleSemestreOptionAnneeUniversitaireAnneeOneAndEtudiantCne(int codeSemestre, Long anneeOne, String cne) {
        return noteEtudiantModuleService.findByModuleSemestreOptionSemestreCodeAndModuleSemestreOptionAnneeUniversitaireAnneeOneAndEtudiantCne(codeSemestre, anneeOne, cne);
    }
    @GetMapping("Etudiant/cne/{cne}/moduleSemestreOption/annee-universitaire/libelle/{libelle}")
    public List<NoteEtudiantModule> findByEtudiantCneAndModuleSemestreOptionAnneeUniversitaireLibelle(String cne, String libelle) {
        return noteEtudiantModuleService.findByEtudiantCneAndModuleSemestreOptionAnneeUniversitaireLibelle(cne, libelle);
    }
    @GetMapping("Etudiant/cne/{cne}/moduleSemestreOption/semestre/code/{code}")
    //@PreAuthorize("hasRole('ADMINOTE')")
    public List<NoteEtudiantModule> findByEtudiantCneAndModuleSemestreOptionSemestreCode(@PathVariable String cne,@PathVariable int code) {
        return noteEtudiantModuleService.findByEtudiantCneAndModuleSemestreOptionSemestreCode(cne, code);
    }



    @PutMapping("/updatenormal/")
    @PreAuthorize("hasRole('COORDONNATEURMODULE')")
    public void updateNormal(@RequestBody NoteEtudiantModule noteEtudiantModule) {
        noteEtudiantModuleService.updateNormal(noteEtudiantModule);
    }

    @PutMapping("/updateratt/")
    @PreAuthorize("hasRole('COORDONNATEURMODULE')")
    public void updateRat(@RequestBody NoteEtudiantModule noteEtudiantModule) {
        noteEtudiantModuleService.updateRat(noteEtudiantModule);
    }


    @GetMapping("Etudiant/cne/{cne}/moduleSemestreOption/code/{code}")
    public NoteEtudiantModule findByEtudiantCneAndModuleSemestreOptionCode(@PathVariable String cne,@PathVariable String code) {
        return noteEtudiantModuleService.findByEtudiantCneAndModuleSemestreOptionCode(cne, code);
    }
}
