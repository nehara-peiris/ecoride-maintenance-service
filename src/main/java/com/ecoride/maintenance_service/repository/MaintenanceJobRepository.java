package com.ecoride.maintenance_service.repository;

import com.ecoride.maintenance_service.entity.MaintenanceJob;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaintenanceJobRepository extends JpaRepository<MaintenanceJob, Long> {
    List<MaintenanceJob> findByVehicleCode(String vehicleCode);
}