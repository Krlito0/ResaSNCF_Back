package com.resasncf.ResaSncf.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resasncf.ResaSncf.Models.MaintenanceType;

@Repository
public interface MaintenanceTypeRepository extends JpaRepository <MaintenanceType, Long> {
    Optional<MaintenanceType> findByOperation_Id(Long operationId);
}
