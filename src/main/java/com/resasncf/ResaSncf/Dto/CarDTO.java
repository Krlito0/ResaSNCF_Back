package com.resasncf.ResaSncf.Dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CarDTO {
    private Long CarId;
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
    private Set<ReservationForCarDTO> reservation = new HashSet<>();
    private LocationDTO location;
    private FuelCardDTO fuelCard;
    private Set<OperationForCarDTO> operation = new HashSet<>();  

}
