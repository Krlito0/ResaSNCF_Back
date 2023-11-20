package com.resasncf.ResaSncf.Dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class OpinionForReservationDTO {
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String comments;
    private Integer opinionRank;
}
