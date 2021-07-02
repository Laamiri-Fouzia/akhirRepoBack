package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.ModuleSemestreOption;
import com.bezkoder.springjwt.service.ModuleSemestreOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("ispits-project/module-semestre-option")
public class ModuleSemestreOptionProvided {
    @Autowired
    private ModuleSemestreOptionService moduleSemestreOptionService;
    @GetMapping("semestre/codeSem/{codeSem}/option/codeOpt/{codeOpt}")
    public List<ModuleSemestreOption> findBySemestreCodeAndMyOptionCode(int codeSem, String codeOpt) {
        return moduleSemestreOptionService.findBySemestreCodeAndMyOptionCode(codeSem, codeOpt);
    }

    //findBySemestreCodeAndMyOptionCode
    @GetMapping("/code/{code}")
    public List<ModuleSemestreOption> findByMyOptionCode(@PathVariable String code) {
        return moduleSemestreOptionService.findByMyOptionCode(code);
    }
    @PostMapping("/")
    @PreAuthorize("hasRole('ADMINOTE')")
    public int save(@RequestBody  ModuleSemestreOption moduleSemestreOption) {
        return moduleSemestreOptionService.save(moduleSemestreOption);
    }

    @GetMapping("/")
    public List<ModuleSemestreOption> findAll() {
        return moduleSemestreOptionService.findAll();
    }

    @GetMapping("/semestre/code/{codeSemestre}/annee-universitaire/libelle/{annee}/option/code/{codeOp}")
    public List<ModuleSemestreOption> findBySemestreCodeAndAnneeUniversitaireLibelleAndMyOptionCode(@PathVariable int codeSemestre,@PathVariable String annee,@PathVariable String codeOp) {
        return moduleSemestreOptionService.findBySemestreCodeAndAnneeUniversitaireLibelleAndMyOptionCode(codeSemestre, annee, codeOp);
    }

    @GetMapping("/semestre/code/{codeSemestre}/anneeuniv/anneeOne/{annee}/option/code/{cmyOption}")
    @PreAuthorize("hasRole('COORDONNATEURMODULE') or hasRole('ADMINOTE') or hasRole('PROFESSEUR') or hasRole('ADMINABSENCE')")
    public List<ModuleSemestreOption> findBySemestreCodeAndAnneeUniversitaireAnneeOneAndMyOptionCode(@PathVariable int codeSemestre,@PathVariable  Long annee,@PathVariable  String cmyOption) {
        return moduleSemestreOptionService.findBySemestreCodeAndAnneeUniversitaireAnneeOneAndMyOptionCode(codeSemestre, annee, cmyOption);
    }

    @DeleteMapping("/code/{code}")
    @PreAuthorize("hasRole('ADMINOTE')")
    public int deleteByCode(@PathVariable String code) {
        return moduleSemestreOptionService.deleteByCode(code);
    }
}
