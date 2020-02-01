package com.man.fota.dto.feature;

import java.util.List;

public class FeatureListDTO {

	private List<FeatureDTO> featureList;

	public FeatureListDTO(List<FeatureDTO> featureList) {
		this.featureList = featureList;
	}

	public List<FeatureDTO> getFeatureList() {
		return featureList;
	}

	public void setFeatureList(List<FeatureDTO> featureList) {
		this.featureList = featureList;
	}

	@Override
	public String toString() {
		return "FeatureListDTO [featureList=" + featureList + "]";
	}
	
}
