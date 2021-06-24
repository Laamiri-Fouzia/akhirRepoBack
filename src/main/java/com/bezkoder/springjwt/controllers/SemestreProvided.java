package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Semestre;
import com.bezkoder.springjwt.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("ispits-project/semestre")
public class SemestreProvided {
    @Autowired
    private SemestreService semestreService;

    @GetMapping("code/{code}")
    public Semestre findByCode(@PathVariable int code) {
        return semestreService.findByCode(code);
    }

    @GetMapping("libelle/{libelle}")
    public Semestre findByLibelle(@PathVariable String libelle) {
        return semestreService.findByLibelle(libelle);
    }

    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable int code) {
        return semestreService.deleteByCode(code);
    }

    @GetMapping("/")
    public List<Semestre> findAll() {
        return semestreService.findAll();
    }


    @PostMapping("/")
    public int save(@RequestBody Semestre semestre) {
        return semestreService.save(semestre);
    }
}
