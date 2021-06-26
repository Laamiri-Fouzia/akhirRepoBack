package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.MyModule;
import com.bezkoder.springjwt.service.MyModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("ispits-project/module")
public class MyModuleProvided {

    @Autowired
    private MyModuleService myModuleService;

    @GetMapping("/")
    public List<MyModule> findAll() {
        return myModuleService.findAll();
    }


    @GetMapping("/code/{code}")
    public MyModule findByCode(@PathVariable String code) {
        return myModuleService.findByCode(code);
    }

    @GetMapping("/libelle/{libelle}")
    public MyModule findByLibelle(@PathVariable String libelle) {
        return myModuleService.findByLibelle(libelle);
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMINOTE')")
    public int save(@RequestBody MyModule myModule) {
        return myModuleService.save(myModule);
    }

    @PutMapping("/")
    @PreAuthorize("hasRole('ADMINOTE')")
    public MyModule update(@RequestBody MyModule myModule) {
        return myModuleService.update(myModule);
    }

    @PostMapping("/delete-multiple-by-code")
    @PreAuthorize("hasRole('ADMINOTE')")
    public int deleteByCode(@RequestBody List<MyModule> myModules) {
        return myModuleService.deleteByCode(myModules);
    }

    @DeleteMapping("/code/{code}")
    @PreAuthorize("hasRole('ADMINOTE')")
    public int deleteByCode(@PathVariable String code) {
        return myModuleService.deleteByCode(code);
    }

}
