package com.man.fota.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.man.fota.dto.vehicle.FeatureVehiclesListDTO;
import com.man.fota.dto.vehicle.VehicleDTO;

public interface VehicleService {

	Page<VehicleDTO> getAllVehicles(Pageable paginable);

	List<VehicleDTO> getAllVinsThatCanInstallAFeature(String featureId);

	List<VehicleDTO> getAllVinsThatCannotInstallAFeature(String featureId);

	FeatureVehiclesListDTO getAllVinsByFeature(String featureId);
	
}
