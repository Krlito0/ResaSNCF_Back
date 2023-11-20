package com.resasncf.ResaSncf.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resasncf.ResaSncf.Models.Location;

@Repository
public interface LocationRepository extends JpaRepository <Location, Long>{
    Optional<Location> findByCar_Id(Long carId);
}
