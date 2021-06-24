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
    @PreAuthorize("hasRole('ADMIN')")
    public List<MyModule> findAll() {
        return myModuleService.findAll();
    }


}
