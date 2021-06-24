package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Ponderation;
import com.bezkoder.springjwt.service.PonderationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("ispits-project/ponderation")
public class PonderationProvided {
    @GetMapping("/code/{code}")
    public Ponderation findByCode(@PathVariable String code) {
        return ponderationService.findByCode(code);
    }
    @GetMapping("/coefContinue/{cne}/coefFinale/{code}")
    public List<Ponderation> findByCoefContinueAndCoefFinale(@PathVariable BigDecimal coefContinue,@PathVariable BigDecimal coefFinale) {
        return ponderationService.findByCoefContinueAndCoefFinale(coefContinue, coefFinale);
    }
    @GetMapping("/")
    public List<Ponderation> findAll() {
        return ponderationService.findAll();
    }

    @Autowired
    private PonderationService ponderationService;
}
