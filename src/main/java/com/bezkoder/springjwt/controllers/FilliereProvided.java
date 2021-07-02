package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Filliere;
import com.bezkoder.springjwt.service.FilliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("ispits-project/filliere")
public class FilliereProvided {
    @Autowired
    private FilliereService filliereService;

    @GetMapping("/code/{code}")
    public Filliere findByCode(@PathVariable String code) {
        return filliereService.findByCode(code);
    }
    @GetMapping("/libelle/{libelle}")
    public Filliere findByLibelle(@PathVariable String libelle) {
        return filliereService.findByLibelle(libelle);
    }

    @DeleteMapping("/code/{code}")
    @PreAuthorize("hasRole('ADMINOTE')")
    public int deleteByCode(@PathVariable String code) {
        return filliereService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<Filliere> findAll() {
        return filliereService.findAll();
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMINOTE')")
    public int save(@RequestBody Filliere filliere) {
        return filliereService.save(filliere);
    }
}
