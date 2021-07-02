package com.bezkoder.springjwt.controllers;



import com.bezkoder.springjwt.models.AnneeUniversitaire;
import com.bezkoder.springjwt.service.AnneeUniversitaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ispits-project/annee-universitaire")
//@CrossOrigin(origins = {"http://localhost:4200"})
@CrossOrigin(origins = "*", maxAge = 3600)

public class AnneeUniversitaireProvided {
    @Autowired
    private AnneeUniversitaireService anneeUniversitaireService;

    @GetMapping("/")
    //@PreAuthorize("hasRole('ADMINOTE') or hasRole('PROFESSEUR')")
    public List<AnneeUniversitaire> findAll() {
        return anneeUniversitaireService.findAll();
    }
}
