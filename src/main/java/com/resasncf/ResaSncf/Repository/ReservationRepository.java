package com.resasncf.ResaSncf.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resasncf.ResaSncf.Models.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository <Reservation, Long> {
 
    Optional<List<Reservation>> findByCar_Id(Long carId);
    Optional<Reservation> findByOpinion_Id(Long opinionId);
}
