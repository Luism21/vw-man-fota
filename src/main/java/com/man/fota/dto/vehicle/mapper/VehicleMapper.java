package com.man.fota.dto.vehicle.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.man.fota.dto.vehicle.VehicleDTO;
import com.man.fota.model.Vehicle;
import com.man.fota.model.VehicleCode;

public class VehicleMapper {

	private static final Logger logger = LogManager.getLogger(VehicleMapper.class);
	
	public static VehicleDTO toDTO(Vehicle vehicle) {
		logger.info("Converting Vehicle " + vehicle.getVin() + " to VehicleDTO");
		VehicleDTO vehicleDto = new VehicleDTO();
		vehicleDto.setVin(vehicle.getVin());
		vehicleDto.setSoftwareCodes(vehicle.getCodes().stream()
				.filter(c -> c.getIsSoftware() == true)
				.map(VehicleCode::getCode)
				.collect(Collectors.toList()));
		vehicleDto.setHardwareCodes(vehicle.getCodes().stream()
				.filter(c -> c.getIsSoftware() == false)
				.map(VehicleCode::getCode)
				.collect(Collectors.toList()));
		logger.info(vehicle.getVin() + "converted to VehicleDTO");
		return vehicleDto;
	}
	
	public static List<VehicleDTO> toDTO(List<Vehicle> vehicleList) {
		List<VehicleDTO> vehicleDtoList = new ArrayList<>();
		for (Vehicle vehicle : vehicleList) {
			vehicleDtoList.add(toDTO(vehicle));
		}
		return vehicleDtoList;
	}
	
}
