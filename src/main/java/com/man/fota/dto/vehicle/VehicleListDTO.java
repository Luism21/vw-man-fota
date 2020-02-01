package com.man.fota.dto.vehicle;

import java.util.List;

public class VehicleListDTO {

	private List<VehicleDTO> vehicleList;

	public List<VehicleDTO> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<VehicleDTO> vehicleList) {
		this.vehicleList = vehicleList;
	}

	@Override
	public String toString() {
		return "VehicleListDTO [vehicleList=" + vehicleList.toString() + "]";
	}

}
