package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.InscriptionEtudiantModule;
import com.bezkoder.springjwt.service.InscriptionEtudiantModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ispits-project/inscriptionEtudiantModule")
@CrossOrigin(origins = {"http://localhost:4200"})
public class InscriptionEtudiantModuleProvided {
    @Autowired
    private InscriptionEtudiantModuleService inscriptionEtudiantModuleService;

    @GetMapping("/moduleSemestreOption/code/{code}")
    public List<InscriptionEtudiantModule> findByModuleSemestreOptionCode(@PathVariable String code) {
        return inscriptionEtudiantModuleService.findByModuleSemestreOptionCode(code);
    }

}
