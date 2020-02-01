package com.man.fota.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.man.fota.dto.vehicle.VehicleDTO;

public interface VehicleService {

	Page<VehicleDTO> getAllVehicles(Pageable paginable);
	
}
