package com.man.fota.dto.vehicle;

import java.util.ArrayList;
import java.util.List;

public class FeatureVehiclesListDTO {

	private List<VehicleDTO> installableVehicleList;

	private List<VehicleDTO> incompatibleVehicleList;
	
	public FeatureVehiclesListDTO() {
		super();
		this.installableVehicleList = new ArrayList<>();
		this.incompatibleVehicleList = new ArrayList<>();
	}

	public FeatureVehiclesListDTO(List<VehicleDTO> installableVehicleList, List<VehicleDTO> incompatibleVehicleList) {
		super();
		this.installableVehicleList = installableVehicleList;
		this.incompatibleVehicleList = incompatibleVehicleList;
	}

	public List<VehicleDTO> getInstallableVehicleList() {
		return installableVehicleList;
	}

	public void setInstallableVehicleList(List<VehicleDTO> installableVehicleList) {
		this.installableVehicleList = installableVehicleList;
	}

	public List<VehicleDTO> getIncompatibleVehicleList() {
		return incompatibleVehicleList;
	}

	public void setIncompatibleVehicleList(List<VehicleDTO> incompatibleVehicleList) {
		this.incompatibleVehicleList = incompatibleVehicleList;
	}

	@Override
	public String toString() {
		return "VehicleFeaturesListDTO [installableFeatureList=" + installableVehicleList + ", incompatibleFeatureList="
				+ incompatibleVehicleList + "]";
	}

}
