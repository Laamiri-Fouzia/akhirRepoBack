package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Etudiant;
import com.bezkoder.springjwt.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("ispits-project/Etudiant")
public class EtudiantProvided {
    @GetMapping("/cne/{cne}")
    public Etudiant findByCne(@PathVariable String cne) {
        return etudiantService.findByCne(cne);
    }
    @GetMapping("/nom/{nom}/prenon/{prenon}")
    public List<Etudiant> findByNomAndPrenom(@PathVariable String nom, @PathVariable String prenon) {
        return etudiantService.findByNomAndPrenom(nom, prenon);
    }
    @DeleteMapping("/cne/{cne}")
    @PreAuthorize("hasRole('ADMINOTE')")
    public int deleteByCne(@PathVariable String cne) {
        return etudiantService.deleteByCne(cne);
    }
    @GetMapping("/")
    public List<Etudiant> findAll() {
        return etudiantService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Etudiant etudiant) {
        return etudiantService.save(etudiant);
    }

    @PutMapping("/")
    @PreAuthorize("hasRole('ADMINOTE')")
    public int update(@RequestBody Etudiant etudiant) {
       return etudiantService.update(etudiant);
    }
    @Autowired
    private EtudiantService etudiantService;
}
