package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.TypeModule;
import com.bezkoder.springjwt.service.TypeModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("ispits-project/typeModule")
public class TypeModuleProvided {
    @Autowired
    private TypeModuleService typeModuleService;

    @GetMapping("/code/{code}")
    public TypeModule findByCode(@PathVariable String code) {
        return typeModuleService.findByCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody TypeModule typeModule) {
        return typeModuleService.save(typeModule);
    }
}
