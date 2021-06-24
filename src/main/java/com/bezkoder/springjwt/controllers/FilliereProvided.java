package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Filliere;
import com.bezkoder.springjwt.service.FilliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
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
    public int deleteByCode(@PathVariable String code) {
        return filliereService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<Filliere> findAll() {
        return filliereService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Filliere filliere) {
        return filliereService.save(filliere);
    }
}
