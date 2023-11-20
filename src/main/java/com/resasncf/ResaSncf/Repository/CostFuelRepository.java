package com.resasncf.ResaSncf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resasncf.ResaSncf.Models.CostFuel;

@Repository
public interface CostFuelRepository extends JpaRepository <CostFuel, Long>{
    
}
