package com.resasncf.ResaSncf.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class ReservationForCarDTO {
    private Long id;
    private String startDate;
    private String endDate;
    private boolean statusReservation;
    private double costReservation;
}