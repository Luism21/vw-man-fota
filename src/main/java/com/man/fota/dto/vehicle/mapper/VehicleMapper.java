package com.man.fota.dto.vehicle.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.man.fota.dto.vehicle.VehicleDTO;
import com.man.fota.model.Vehicle;
import com.man.fota.model.VehicleCode;

public class VehicleMapper {

	public static VehicleDTO toDTO(Vehicle vehicle) {
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
