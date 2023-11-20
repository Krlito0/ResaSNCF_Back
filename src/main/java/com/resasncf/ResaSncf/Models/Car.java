package com.resasncf.ResaSncf.Models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String immat;
    private String type;
    private String brand;
    private String picture;
    private String model;
    private boolean available;
    private int kilometers;
    private String state;
    private String fuel;
    private int priceDay;

    @OneToMany(mappedBy = "car")
    private Set<Reservation> reservation = new HashSet<>();

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "localisation_id")
    private Location location;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fuel_card_id")
    private FuelCard fuelCard;

    @OneToMany(mappedBy = "car")
    private Set<Operation> operation = new HashSet<>();

}
