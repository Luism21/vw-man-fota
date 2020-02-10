package com.man.fota.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.man.fota.dto.vehicle.FeatureVehiclesListDTO;
import com.man.fota.dto.vehicle.VehicleDTO;
import com.man.fota.dto.vehicle.mapper.VehicleMapper;
import com.man.fota.model.FeatureCode;
import com.man.fota.model.Vehicle;
import com.man.fota.repository.FeatureCodeRepository;
import com.man.fota.repository.VehicleRepository;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	private static final Logger logger = LogManager.getLogger(VehicleServiceImpl.class);
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	FeatureCodeRepository featureCodeRepository;

	@Override
	public Page<VehicleDTO> getAllVehicles(Pageable pageable) {
		logger.info("Finding all vehicles");
		Page<Vehicle> vehiclePage = vehicleRepository.findAll(pageable);
		
		logger.info("Converting all vehicles to VehicleDTO");
		Page<VehicleDTO> dtoPage = vehiclePage.map(new Function<Vehicle, VehicleDTO>() {
		    @Override
		    public VehicleDTO apply(Vehicle vehicle) {
		        return VehicleMapper.toDTO(vehicle);
		    }
		});
		return dtoPage;
	}
	
	@Override
	public List<VehicleDTO> getAllVinsThatCanInstallAFeature(String featureId) {
		logger.info("Finding all vehicles thant can install feature: " + featureId);
		List<Vehicle> vehicleList = vehicleRepository.getAllVinsThatCanInstallAFeature(featureId);
		
		logger.info("Finding all codes needed to install feature: " + featureId);
		List<String> featureCodeMustBePresentList = featureCodeRepository.findAllFeatureCodeByFeatureIdAndMustBePresent(featureId, true).stream()
				.map(FeatureCode::getCode)
				.collect(Collectors.toList());
		
		logger.info("Finding all codes that cant be present to install feature: " + featureId);
		List<String> featureCodeMustNotBePresentList = featureCodeRepository.findAllFeatureCodeByFeatureIdAndMustBePresent(featureId, false).stream()
				.map(FeatureCode::getCode)
				.collect(Collectors.toList());
		
		logger.info("Converting all vehicles to VehicleDTO");
		List<VehicleDTO> vehicleDtoList = VehicleMapper.toDTO(vehicleList);
		
		List<VehicleDTO> listToReturn = new ArrayList<>(vehicleDtoList);		
		vehicleDtoList.forEach(v -> {
			List<String> allVehicleCodes = v.getHardwareCodes();
			allVehicleCodes.addAll(v.getSoftwareCodes());
			
			if(!allVehicleCodes.containsAll(featureCodeMustBePresentList) || 
					!Collections.disjoint(allVehicleCodes, featureCodeMustNotBePresentList) ){
				listToReturn.remove(v);
			}

		});
		
		
		return listToReturn;
	}
	
	@Override
	public List<VehicleDTO> getAllVinsThatCannotInstallAFeature(String featureId) {
		logger.info("Finding all vehicles thant can install feature: " + featureId);
		List<Vehicle> vehicleList = vehicleRepository.getAllVinsThatCannotInstallAFeature(featureId);
		
		logger.info("Finding all codes needed to install feature: " + featureId);
		List<String> featureCodeMustBePresentList = featureCodeRepository.findAllFeatureCodeByFeatureIdAndMustBePresent(featureId, true).stream()
				.map(FeatureCode::getCode)
				.collect(Collectors.toList());
		
		logger.info("Converting all vehicles to VehicleDTO");
		List<VehicleDTO> vehicleDtoList = VehicleMapper.toDTO(vehicleList);
		
		List<VehicleDTO> listToReturn = new ArrayList<>(vehicleDtoList);		
		vehicleDtoList.forEach(v -> {
			List<String> allVehicleCodes = v.getHardwareCodes();
			allVehicleCodes.addAll(v.getSoftwareCodes());
			
			if(allVehicleCodes.containsAll(featureCodeMustBePresentList) ){
				listToReturn.remove(v);
			}
		});
		
		
		return listToReturn;
	}
	
	@Override
	public FeatureVehiclesListDTO getAllVinsByFeature(String featureId) {
		logger.info("Finding all vehicles that cannot install feature: " + featureId);
		List<VehicleDTO> incompatibles = getAllVinsThatCannotInstallAFeature(featureId);
		
		logger.info("Finding all vehicles that can install feature: " + featureId);
		List<VehicleDTO> installables = getAllVinsThatCanInstallAFeature(featureId);
		
		FeatureVehiclesListDTO dto = new FeatureVehiclesListDTO();
		dto.setIncompatibleVehicleList(incompatibles);
		dto.setInstallableVehicleList(installables);
		
		return dto;
	}

}
