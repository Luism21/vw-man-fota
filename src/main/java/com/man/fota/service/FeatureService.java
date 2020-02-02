package com.man.fota.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.man.fota.dto.feature.FeatureDTO;
import com.man.fota.dto.feature.VehicleFeaturesListDTO;

public interface FeatureService {

	Page<FeatureDTO> getAllFeatures(Pageable paginable);

	List<FeatureDTO> getAllInstallablesFeaturesByVin(String vin);

	List<FeatureDTO> getAllIncompatibleFeaturesByVin(String vin);
	
	VehicleFeaturesListDTO getAllFeaturesByVin(String vin);
	
}
