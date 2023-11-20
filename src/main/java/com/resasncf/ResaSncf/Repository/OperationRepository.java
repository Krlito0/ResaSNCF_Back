package com.resasncf.ResaSncf.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resasncf.ResaSncf.Models.MaintenanceType;
import com.resasncf.ResaSncf.Models.Operation;

@Repository
public interface OperationRepository extends JpaRepository <Operation, Long> {
     Optional<List<Operation>> findByCar_Id(Long carId);
     Optional<MaintenanceType> findByMaintenanceType_Id(Long maintenanceTypeId);
}
