package com.man.fota.repository;

import org.springframework.data.repository.CrudRepository;

import com.man.fota.model.VehicleCode;
import com.man.fota.model.VehicleCodePK;

public interface VehicleCodeRepository extends CrudRepository<VehicleCode, VehicleCodePK> {

}
