package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.InscriptionEtudiantModule;
import com.bezkoder.springjwt.service.InscriptionEtudiantModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ispits-project/inscriptionEtudiantModule")
@CrossOrigin(origins = "*", maxAge = 3600)
public class InscriptionEtudiantModuleProvided {
    @Autowired
    private InscriptionEtudiantModuleService inscriptionEtudiantModuleService;

    @GetMapping("/moduleSemestreOption/code/{code}")
    @PreAuthorize(" hasRole('PROFESSEUR')")
    public List<InscriptionEtudiantModule> findByModuleSemestreOptionCode(@PathVariable String code) {
        return inscriptionEtudiantModuleService.findByModuleSemestreOptionCode(code);
    }

}
