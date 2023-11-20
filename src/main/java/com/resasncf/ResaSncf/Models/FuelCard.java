package com.resasncf.ResaSncf.Models;

import java.util.*;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class FuelCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String cardNumber;
    private String type;

    @OneToOne (mappedBy = "fuelCard")
    private Car car;

    @OneToMany(mappedBy = "fuelCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CostFuel> costFuel = new HashSet<>(); 

}
