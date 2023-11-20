package com.resasncf.ResaSncf.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LocationDTO {
    private Long id;
    private int coordinates;
    private String address;

}
