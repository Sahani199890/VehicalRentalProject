package com.example.Vehicle.traveller.model.car;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cycle_tbl")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int carId;
    @Column(name = "car_color")
    private String color;
    @Column(name = "car_name")
    private String carName;
    @Column(name = "car_quantity")
    private int carQuantity;
}