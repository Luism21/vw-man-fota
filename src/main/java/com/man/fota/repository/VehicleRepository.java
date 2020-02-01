package com.man.fota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.man.fota.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

}
