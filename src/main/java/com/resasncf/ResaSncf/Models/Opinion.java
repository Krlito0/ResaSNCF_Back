package com.resasncf.ResaSncf.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String comments;

    @Column(name = "opinion_rank", nullable = false)
    private Integer opinionRank;

    @OneToOne(mappedBy = "opinion")
    private Reservation reservation;
}
