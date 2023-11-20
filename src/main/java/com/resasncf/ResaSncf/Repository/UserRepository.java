package com.resasncf.ResaSncf.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resasncf.ResaSncf.Models.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    
    Optional<User> findByReservation_Id(Long reservationId);
    
}
