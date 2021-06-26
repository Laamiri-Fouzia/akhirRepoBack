package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.MyOption;
import com.bezkoder.springjwt.service.MyOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("ispits-project/option")
public class MyOptionProvided {
    @Autowired
    private MyOptionService myOptionService;
    @PreAuthorize("hasRole('COORDONNATEURMODULE')")
    @GetMapping("/code/{code}")
    public MyOption findByCode(@PathVariable String code) {
        return myOptionService.findByCode(code);
    }

    @DeleteMapping("/code/{code}")
    @PreAuthorize("hasRole('ADMINOTE')")
    public int deleteByCode(@PathVariable String code) {
        return myOptionService.deleteByCode(code);
    }

    @GetMapping("/")
    public List<MyOption> findAll() {
        return myOptionService.findAll();
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMINOTE')")
    public int save(@RequestBody MyOption myOption) {
        return myOptionService.save(myOption);
    }

    @GetMapping("/filiere/code/{code}")
    @PreAuthorize("hasRole('ADMINOTE')")
    public List<MyOption> findByFilliereCode(@PathVariable String code) {
        return myOptionService.findByFilliereCode(code);
    }

    @PutMapping("/")
    @PreAuthorize("hasRole('ADMINOTE')")
    public void update(@RequestBody MyOption myOption) {
        myOptionService.update(myOption);
    }

    @DeleteMapping("/filiere/code/{code}")
    public int deleteByFilliereCode(@PathVariable String Code) {
        return myOptionService.deleteByFilliereCode(Code);
    }
}
