package com.resasncf.ResaSncf.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CarDTOminimalist {
    private long id;
    private String type;
    private String brand;
    private String model;
    private String Immat;
    private String picture;
}
