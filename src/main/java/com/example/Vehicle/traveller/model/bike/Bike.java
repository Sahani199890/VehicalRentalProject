package com.example.Vehicle.traveller.model.bike;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bike_tbl")
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bikeId;
    @Column(name = "bike_color")
    private String color;
    @Column(name = "bike_name")
    private String bikeName;
    @Column(name = "bike_quantity")
    private int bikeQuantity;
}