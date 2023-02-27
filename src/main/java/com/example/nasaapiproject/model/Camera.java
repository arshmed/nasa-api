package com.example.nasaapiproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Camera {

    private int id;
    private String name;
    private int rover_id;
    private String full_name;


}
