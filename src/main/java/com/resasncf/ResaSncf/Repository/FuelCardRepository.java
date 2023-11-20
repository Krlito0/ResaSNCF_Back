package com.resasncf.ResaSncf.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resasncf.ResaSncf.Models.FuelCard;

@Repository
public interface FuelCardRepository extends JpaRepository <FuelCard, Long> {
  Optional<FuelCard> findByCar_Id(Long carId);
  Optional <FuelCard> findByCostFuel_Id(Long costFuelId);
}
