package com.example.nasaapiproject.service;


import com.example.nasaapiproject.model.RoverPhoto;
import com.example.nasaapiproject.model.RoverPhotoList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class PhotoService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private HttpEntity<String> entity;
    private HttpHeaders headers;

    private static final String URI = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";
    private static final String DEMO_KEY = "DEMO_KEY";

    public PhotoService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        entity = new HttpEntity<>(headers);
    }

    public void getALlPhotos() {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URI)
                .queryParam("api_key", DEMO_KEY);
        String uriString = builder.toUriString();

        ResponseEntity<String> result =
                restTemplate.exchange(
                        uriString,
                        HttpMethod.GET,
                        entity,
                        String.class);

        RoverPhotoList photoList = null;

        try {
            photoList = objectMapper.readValue(result.getBody(), RoverPhotoList.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        assert photoList != null;
        int randomNumber = (int) (Math.random() * photoList.getPhotos().length);

        RoverPhoto photo = photoList.getPhotos()[randomNumber];
        String url = photo.getImg_src();
        openImageInBrowser(url);

    }

    public void openImageInBrowser(String url) {

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("open " + url);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
