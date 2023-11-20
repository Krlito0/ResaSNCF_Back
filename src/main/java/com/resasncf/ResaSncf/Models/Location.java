package com.resasncf.ResaSncf.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int coordinates;
    private String address;

    @OneToMany(mappedBy = "location")
    private List<Car> car = new ArrayList<>();
    
}
