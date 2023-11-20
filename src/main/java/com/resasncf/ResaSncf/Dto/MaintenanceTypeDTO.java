package com.resasncf.ResaSncf.Dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MaintenanceTypeDTO {
    private Long id;
    private String type;
    private int durationHours;
    private double cost;

}
