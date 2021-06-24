package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Seance;
import com.bezkoder.springjwt.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ispits-project/seance")
@CrossOrigin(origins = {"http://localhost:4200"})
public class SeanceProvided {
    @Autowired
    private SeanceService seanceService;

    @PostMapping("/")
    public int save(@RequestBody Seance seance) {
        return seanceService.save(seance);
    }
    @GetMapping("libelle/{libelle}")
    public Seance findByLibelle(@PathVariable String libelle) {
        return seanceService.findByLibelle(libelle);
    }
    @GetMapping("/moduleSemestreOption/code/{code}")
    public List<Seance> findByModuleSemestreOptionCode(@PathVariable String code) {
        return seanceService.findByModuleSemestreOptionCode(code);
    }
    @PutMapping("/")
    public void update(@RequestBody Seance seance) {
         seanceService.update(seance);
    }
}