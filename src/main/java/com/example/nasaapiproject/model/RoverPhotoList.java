package com.example.nasaapiproject.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoverPhotoList {

    private RoverPhoto[] photos;

}
