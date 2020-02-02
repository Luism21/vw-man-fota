package com.man.fota.service;

import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.man.fota.dto.vehicle.VehicleDTO;
import com.man.fota.dto.vehicle.mapper.VehicleMapper;
import com.man.fota.model.Vehicle;
import com.man.fota.repository.VehicleRepository;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	private static final Logger logger = LogManager.getLogger(VehicleServiceImpl.class);
	
	@Autowired
	VehicleRepository vehicleRepository;

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

}
