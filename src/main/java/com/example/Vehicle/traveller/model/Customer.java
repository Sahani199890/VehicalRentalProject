package com.example.Vehicle.traveller.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_tbl")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull(message = "first_name cannot be null")
    @Column(name = "first_name")
    @Length(min =5)
    private String firstName;
    @NotNull(message = "last_name cannot be null")
    @Column(name = "last_name")
    private String lastName;
    @NotNull(message = "driving_license cannot be null")
    @Column(name = "driving_license")
    @Pattern(regexp = "^(([A-Z]{2}[0-9]{2})" + "( )|([A-Z]{2}-[0-9]" + "{2}))((19|20)[0-9]" + "[0-9])[0-9]{7}$",message = "please enter valid driving license ex: HR-0619850034761")
    private String drivingLicense;
    @NotNull(message = "password cannot be null")
    @Column(name = "password")
    private String password;
    @NotNull(message = "email cannot be null")
    @Email(message = "enter valid email")
    @Column(name = "email")
    private String email;
    @NotNull(message = "phone_number cannot be null")
    @Column(name = "phone_number")
    @Pattern(regexp = "^\\+\\d{2}\\d{10}$",message = "Please provide valid number")
    private String phoneNumber;
    @NotNull(message = "aadhaar_card cannot be null")
    @Column(name = "aadhaar_card")
    @Pattern(regexp = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$",message = "Please enter correct aadhaar number")
    private String aadhaarCardNumber;

}
