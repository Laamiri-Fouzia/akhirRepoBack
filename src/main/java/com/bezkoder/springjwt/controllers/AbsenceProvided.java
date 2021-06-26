package com.bezkoder.springjwt.controllers;



import com.bezkoder.springjwt.models.Absence;
import com.bezkoder.springjwt.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ispits-project/absence")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AbsenceProvided {
    @Autowired
    private AbsenceService absenceService;

    @PostMapping("/")
    @PreAuthorize("hasRole('PROFESSEUR')")
    public int save(@RequestBody  List<Absence> absences) {
        return absenceService.save(absences);
    }


    @GetMapping("/etudiant/cne/{cne}/seance/moduleSemestreOption/semestre/code/{semestre}/seance/moduleSemestreOption/anneuniv/libelle/{anne}")
    @PreAuthorize("hasRole('PROFESSEUR')")
    public List<Absence> findByEtudiantCneAndSeanceModuleSemestreOptionSemestreCodeAndSeanceModuleSemestreOptionAnneeUniversitaireLibelle(@PathVariable String cne,@PathVariable int semestre,@PathVariable String anne) {
        return absenceService.findByEtudiantCneAndSeanceModuleSemestreOptionSemestreCodeAndSeanceModuleSemestreOptionAnneeUniversitaireLibelle(cne, semestre, anne);
    }
    @GetMapping("/etudiant/cne/{cne}/seance/moduleSemestreOption/code/{codeModule}")
    @PreAuthorize("hasRole('ADMINABSENCE')")
    public List<Absence> findEtudiantAbsente(@PathVariable String cne,@PathVariable String codeModule) {
        return absenceService.findEtudiantAbsente(cne, codeModule);
    }

    @PutMapping("/updateForImage")
    public int updateForImage(@RequestBody  Absence absence) {
        return absenceService.updateForImage(absence);
    }

    @GetMapping("/Etudiant/Cne/{cne}/seance/libelle/{libelle}")
    public Absence findByEtudiantCneAndSeanceLibelle(@PathVariable String cne,@PathVariable String libelle) {
        return absenceService.findByEtudiantCneAndSeanceLibelle(cne, libelle);
    }

    @GetMapping("/seance/date/{date}")
    @PreAuthorize("hasRole('ADMINABSENCE')")

    public List<Absence> findByEtatAbsenceTrueAndSeanceDateSeance(@PathVariable String date) {
        return absenceService.findByEtatAbsenceTrueAndSeanceDate(date);
    }

    @PutMapping("/")
    @PreAuthorize("hasRole('ADMINABSENCE')")
    public void update(@RequestBody List<Absence> absences) {
        absenceService.update(absences);
    }

    @GetMapping("/seance/libelle/{libelle}")
    public List<Absence> findBySeanceLibelle(@PathVariable String libelle) {
        return absenceService.findBySeanceLibelle(libelle);
    }

    @DeleteMapping("/etudian/cne/{cne}/seance/libelle/{libelle}")
    @PreAuthorize(" hasRole('PROFESSEUR')")
    public int deleteByEtudiantCneAndSeanceLibelle(@PathVariable String cne,@PathVariable String libelle) {
        return absenceService.deleteByEtudiantCneAndSeanceLibelle(cne, libelle);
    }
}
