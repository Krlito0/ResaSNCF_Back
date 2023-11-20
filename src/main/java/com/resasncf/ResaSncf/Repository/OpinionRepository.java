package com.resasncf.ResaSncf.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resasncf.ResaSncf.Models.Opinion;

@Repository
public interface OpinionRepository extends JpaRepository <Opinion, Long>{
    Optional<Opinion> findByReservation_Id(Long reservationId);
}
