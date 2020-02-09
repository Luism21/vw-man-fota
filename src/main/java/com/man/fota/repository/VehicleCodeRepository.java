package com.man.fota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.man.fota.model.VehicleCode;
import com.man.fota.model.VehicleCodePK;

public interface VehicleCodeRepository extends JpaRepository<VehicleCode, VehicleCodePK> {

}
