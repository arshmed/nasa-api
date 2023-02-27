package com.example.nasaapiproject;

import com.example.nasaapiproject.controller.NasaController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class NasaApiProjectApplication {

    @Autowired
    NasaController nasaController;

    public static void main(String[] args) {
        SpringApplication.run(NasaApiProjectApplication.class, args);
    }

    @Scheduled(cron = "*/30 * * * * ?")
    public void cronJobSch() throws Exception {
        nasaController.getAllPhotos();
    }

}
