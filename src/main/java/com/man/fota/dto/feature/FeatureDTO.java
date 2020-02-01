package com.man.fota.dto.feature;

public class FeatureDTO {

	private String featureId;
	
	private FeatureCodesDTO softwareCodes;
	
	private FeatureCodesDTO hardwareCodes;

	public FeatureDTO() {
		super();
	}

	public FeatureDTO(String featureId, FeatureCodesDTO softwareCodes, FeatureCodesDTO hardwareCodes) {
		super();
		this.featureId = featureId;
		this.softwareCodes = softwareCodes;
		this.hardwareCodes = hardwareCodes;
	}

	public String getFeatureId() {
		return featureId;
	}

	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}

	public FeatureCodesDTO getSoftwareCodes() {
		return softwareCodes;
	}

	public void setSoftwareCodes(FeatureCodesDTO softwareCodes) {
		this.softwareCodes = softwareCodes;
	}

	public FeatureCodesDTO getHardwareCodes() {
		return hardwareCodes;
	}

	public void setHardwareCodes(FeatureCodesDTO hardwareCodes) {
		this.hardwareCodes = hardwareCodes;
	}

	@Override
	public String toString() {
		return "FeatureDTO [featureId=" + featureId + ", softwareCodes=" + softwareCodes + ", hardwareCodes="
				+ hardwareCodes + "]";
	}
	
}
