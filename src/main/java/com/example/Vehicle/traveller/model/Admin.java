package com.example.Vehicle.traveller.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin_tbl")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull(message = "admin_name cannot be null")
    @Column(name = "admin_name")
    private String AdminName;
    @NotNull(message = "password cannot be null")
    @Column(name = "password")
    private String password;
    @NotNull(message = "email cannot be null")
    @Email(message = "Enter valid email")
    private String email;
}
