package com.resasncf.ResaSncf.Dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class OperationDTO {
    private Long id;
    private String date;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    private MaintenanceTypeDTO maintenanceType;
    private CarDTOminimalist car;
    
}
