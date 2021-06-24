package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Professeur;
import com.bezkoder.springjwt.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("ispits-project/professeur")
public class ProfesseurProvided {
    @Autowired
    private ProfesseurService professeurService;

    @GetMapping("/cin/{cin}")
    public Professeur findByCin(@PathVariable String cin) {
        return professeurService.findByCin(cin);
    }

    @GetMapping("/codeEmploye/{codeEmploye}")
    public Professeur findByCodeEmploye(@PathVariable String codeEmploye) {
        return professeurService.findByCodeEmploye(codeEmploye);
    }
    @GetMapping("/nom/{nom}/prenon/{prenon}")
    public List<Professeur> findByNomAndPrenom(@PathVariable String nom,@PathVariable  String prenon) {
        return professeurService.findByNomAndPrenom(nom, prenon);
    }

    @DeleteMapping("/codeEmploye/{codeEmploye}")
    public int deleteByCodeEmploye(@PathVariable String codeEmploye) {
        return professeurService.deleteByCodeEmploye(codeEmploye);
    }

    @GetMapping("/")
    public List<Professeur> findAll() {
        return professeurService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Professeur professeur) {
        return professeurService.save(professeur);
    }
    @PutMapping("/")
    public void update(@RequestBody Professeur professeur) {
         professeurService.update(professeur);
    }

    @GetMapping("/cordonnateur/")
    public List<Professeur> findByEstCoordonateurModuleTrue() {
        return professeurService.findByEstCoordonateurModuleTrue();
    }
}
