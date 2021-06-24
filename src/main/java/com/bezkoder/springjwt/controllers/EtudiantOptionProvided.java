package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.AnneeUniversitaire;
import com.bezkoder.springjwt.models.EtudiantOption;
import com.bezkoder.springjwt.service.EtudiantOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("ispits-project/etudiantOption")
public class EtudiantOptionProvided {

    @Autowired
    private EtudiantOptionService etudiantOptionService;

    @GetMapping("/AncienEtudiant/option/code/{code}/annee/{annee}/semestre/codesemes/{codeSems}")
    public List<EtudiantOption> SearchAncienStudents(@PathVariable String code, @PathVariable  Long annee, @PathVariable  int codeSems) {
        return etudiantOptionService.SearchAncienStudents(code, annee, codeSems);
    }

    @DeleteMapping("/Etudiant/cne/{cne}")
    public int deleteByEtudiantCne(@PathVariable String cne) {
        return etudiantOptionService.deleteByEtudiantCne(cne);
    }

    @DeleteMapping("/option/code/{code}")
    public int deleteByMyOptionCode(@PathVariable String code) {
        return etudiantOptionService.deleteByMyOptionCode(code);
    }

    @GetMapping("/Etudiant/cne/{cne}/option/codeoption/{codeoption}/anneUniversitaire/annee/{annee}/semestre/semstreCode/{semstreCode}")
    public EtudiantOption findByEtudiantCneAndMyOptionCodeAndAnneeAndSemestreCode(@PathVariable String cne,@PathVariable  String codeoption,@PathVariable  String annee,@PathVariable  int semstreCode) {
        return etudiantOptionService.findByEtudiantCneAndMyOptionCodeAndAnnéeUniversitaireLibelleAndSemestreCode(cne, codeoption, annee, semstreCode);
    }
    @PostMapping("/")
    public int save(@RequestBody EtudiantOption etudiantOption) {
        return etudiantOptionService.save(etudiantOption);
    }

    @GetMapping("/option/code/{code}")
    public List<EtudiantOption> findMyOptionCode(@PathVariable String code) {
        return etudiantOptionService.findByMyOptionCode(code);
    }


    @GetMapping("etudiant/cneetudiant/{cetudiant}/option/code/{cmyOption}/annee/{annee}/semestre/codesemestre/{csemestre}")
    public void saveEtudiantOption(@PathVariable String cetudiant,@PathVariable String cmyOption, @PathVariable String annee,@PathVariable int csemestre) {
        etudiantOptionService.saveEtudiantOption(cetudiant, cmyOption, annee, csemestre);
    }

    @GetMapping("etudiant/cneetudiant/{cetudiant}/semestre/codesemestre1/{codesemestre1}/semestre/codesemestre2/{codeSemestre2}/annee/{annee}/option/code/{cmyOption}")
    public void saveEtudiantModule(@PathVariable String cetudiant,@PathVariable  int codesemestre1, @PathVariable int codeSemestre2, @PathVariable String annee,@PathVariable  String cmyOption) {
        etudiantOptionService.saveEtudiantModule(cetudiant, codesemestre1, codeSemestre2, annee, cmyOption);
    }
    @GetMapping("semestre/codesemestre1/{codeSemsetre1}/semestre/codesemestre2/{codeSemestre2}/etudiant/cneetudiant/{cetudiant}/option/code/{cmyOption}/annee1/{annee1}/annee2/{annee2}")
    public void saveEtudiantReinscrit(@PathVariable int codeSemsetre1,@PathVariable  int codeSemestre2,@PathVariable  String cetudiant,@PathVariable  String cmyOption, @PathVariable AnneeUniversitaire annee1) {
        etudiantOptionService.saveEtudiantReinscrit(codeSemsetre1, codeSemestre2, cetudiant, cmyOption, annee1);
    }

    @PostMapping("newEtudiant/")
    public int newEtudiant(@RequestBody EtudiantOption etudiantOption) {
        return etudiantOptionService.newEtudiant(etudiantOption);
    }
   // findByMyOptionCodeAndAnneeUniversitaireLibelleAndSemestreCode

    @GetMapping("Etudiant/cne/{cne}/option/codeOpt/{codeOpt}/annee-universitaire/libelle/{libelle}/semestre/codeSem/{codeSem}")
    public EtudiantOption findByEtudiantCneAndMyOptionCodeAndAnneeUniversitaireLibelleAndSemestreCode(@PathVariable String cne,@PathVariable String codeOpt,@PathVariable String libelle,@PathVariable int codeSem) {
        return etudiantOptionService.findByEtudiantCneAndMyOptionCodeAndAnneeUniversitaireLibelleAndSemestreCode(cne, codeOpt, libelle, codeSem);
    }
    @GetMapping("option/codeOpt/{code}/annee-universitaire/anneone/{anneone}/semestre/codeSemestre/{codeSems}")
    public List<EtudiantOption> findByMyOptionCodeAndAnneeUniversitaireAnneeOneAndSemestreCode(@PathVariable String code,@PathVariable Long anneone,@PathVariable int codeSems) {
        return etudiantOptionService.findByMyOptionCodeAndAnneeUniversitaireAnneeOneAndSemestreCode(code, anneone, codeSems);
    }
}
