package com.resasncf.ResaSncf.Models;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class CostFuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private Date date;
    private double cost;
    
    @ManyToOne
    @JoinColumn(name = "fuel_card_id")
    private FuelCard fuelCard;
}
