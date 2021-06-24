package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.ImageModl;
import com.bezkoder.springjwt.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("ispits-project/image")

public class ImageProvided {
    @Autowired
    private ImageService imageService;

    @PostMapping("/upload/nameData/{nameData}")
    public int uplaodImage( @RequestParam("imageFile") MultipartFile file,@PathVariable String nameData) throws IOException {
        return imageService.uplaodImage(file,nameData);
    }

    @GetMapping(path = { "/get/{imageName}" })
    public ImageModl getImage(@PathVariable("imageName") String imageName) throws IOException {
        return imageService.getImage(imageName);
    }
}
