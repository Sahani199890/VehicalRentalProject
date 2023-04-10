package com.example.Vehicle.traveller.model.cycle;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cycle_tbl")
public class Cycle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cycleId;
    @Column(name = "cycle_color")
    private String color;
    @Column(name = "cycle_name")
    private String cycleName;
    @Column(name = "cycle_quantity")
    private int cycleQuantity;
}
