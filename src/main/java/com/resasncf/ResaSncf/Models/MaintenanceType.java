package com.resasncf.ResaSncf.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class MaintenanceType {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private int durationHours;
    private double cost; 

    @OneToMany(mappedBy = "maintenanceType")
    private List<Operation> operation = new ArrayList<>();
}
