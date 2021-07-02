package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.TestExcel;
import com.bezkoder.springjwt.service.TestExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/excel")
public class TestExcelProvided {

    @GetMapping("/")
    public List<TestExcel> findAll() {
        return testExcelService.findAll();
    }


    @Autowired
    TestExcelService testExcelService;

    @GetMapping("/title/{title}")
    public TestExcel findByTitle(@PathVariable String title) {
        return testExcelService.findByTitle(title);
    }

    @PostMapping("/")
    public int save(@RequestBody TestExcel testExcel) {
        return testExcelService.save(testExcel);
    }

    /*public ByteArrayInputStream load() {
        return testExcelService.load();
    }*/


    @GetMapping("/download")
    public ResponseEntity<Resource> getFile() {
        String filename = "tutorials.xlsx";
        InputStreamResource file = new InputStreamResource(testExcelService.load());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }
}