package com.resasncf.ResaSncf.Dto;

import java.util.HashSet;
import java.util.Set;

import com.resasncf.ResaSncf.Models.CostFuel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class FuelCardDTO {
    
    private Long id; 
    private String cardNumber;
    private String Type;
    private Set<CostFuel> costFuel = new HashSet<>();

}
