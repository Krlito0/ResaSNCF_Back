package com.resasncf.ResaSncf.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class ReservationDTO {
    private Long id;
    private String startDate;
    private String endDate;
    private boolean statusReservation;
    private double costReservation;
    private CarDTOminimalist car;
    private OpinionForReservationDTO opinion;
}
