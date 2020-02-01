package com.man.fota.repository;

import org.springframework.data.repository.CrudRepository;

import com.man.fota.model.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, String> {

}
