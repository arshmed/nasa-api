package com.example.nasaapiproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rover {

    public int id;
    public String name;
    public String landing_date;
    public String launch_date;
    public String status;

}
