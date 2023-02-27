package com.example.nasaapiproject.controller;

import com.example.nasaapiproject.service.PhotoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NasaController {

    private final PhotoService photoService;

    public NasaController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/photos")
    public void getAllPhotos() {
        System.out.println("Welcome");
        photoService.getALlPhotos();
    }

}
