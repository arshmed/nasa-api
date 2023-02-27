package com.example.nasaapiproject.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoverPhoto {

    public int id;
    public int sol;
    public Camera camera;
    public String img_src;
    public String earth_date;
    public Rover rover;

}
