package com.man.fota.service;

import java.util.function.Function;

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

	@Autowired
	VehicleRepository vehicleRepository;

	@Override
	public Page<VehicleDTO> getAllVehicles(Pageable pageable) {
		Page<Vehicle> vehiclePage = vehicleRepository.findAll(pageable);
		Page<VehicleDTO> dtoPage = vehiclePage.map(new Function<Vehicle, VehicleDTO>() {
		    @Override
		    public VehicleDTO apply(Vehicle vehicle) {
		        return VehicleMapper.toDTO(vehicle);
		    }
		});
		return dtoPage;
	}

}
