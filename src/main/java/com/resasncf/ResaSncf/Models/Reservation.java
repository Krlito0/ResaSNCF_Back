package com.resasncf.ResaSncf.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Reservation {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String startDate;
    private String endDate;
    private boolean statusReservation;
    private double costReservation;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToOne( cascade = CascadeType.PERSIST)
    @JoinColumn(name = "opinion_id")
    private Opinion opinion;
    
}
