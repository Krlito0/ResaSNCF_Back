package com.resasncf.ResaSncf.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resasncf.ResaSncf.Models.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    
    Optional<Car> findByReservation_Id(Long reservationId);
    Optional<Car> findByOperation_Id(Long operationId);
    Optional<Car> findByFuelCard_Id(Long fuelCardId);
}
