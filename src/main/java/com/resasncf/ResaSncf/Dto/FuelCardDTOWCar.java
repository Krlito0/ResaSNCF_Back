package com.resasncf.ResaSncf.Dto;

import java.util.HashSet;
import java.util.Set;

import com.resasncf.ResaSncf.Models.CostFuel;

import lombok.Data;

@Data
public class FuelCardDTOWCar {
       
    private Long id; 
    private String cardNumber;
    private String Type;
    private Set<CostFuel> costFuel = new HashSet<>();
    private CarDTOminimalist car;
}
