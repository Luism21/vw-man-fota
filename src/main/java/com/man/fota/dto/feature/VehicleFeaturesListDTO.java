package com.man.fota.dto.feature;

import java.util.List;

public class VehicleFeaturesListDTO {

	private List<FeatureDTO> installableFeatureList;

	private List<FeatureDTO> incompatibleFeatureList;

	public List<FeatureDTO> getInstallableFeatureList() {
		return installableFeatureList;
	}

	public void setInstallableFeatureList(List<FeatureDTO> installableFeatureList) {
		this.installableFeatureList = installableFeatureList;
	}

	public List<FeatureDTO> getIncompatibleFeatureList() {
		return incompatibleFeatureList;
	}

	public void setIncompatibleFeatureList(List<FeatureDTO> incompatibleFeatureList) {
		this.incompatibleFeatureList = incompatibleFeatureList;
	}

	@Override
	public String toString() {
		return "VehicleFeaturesListDTO [installableFeatureList=" + installableFeatureList + ", incompatibleFeatureList="
				+ incompatibleFeatureList + "]";
	}

}
