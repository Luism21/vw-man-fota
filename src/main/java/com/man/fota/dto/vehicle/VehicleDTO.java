package com.man.fota.dto.vehicle;

import java.util.List;

public class VehicleDTO {

	private String vin;
	
	private List<String> hardwareCodes;
	
	private List<String> softwareCodes;
	
	public VehicleDTO() {}

	public VehicleDTO(String vin, List<String> hardwareCodes, List<String> softwareCodes) {
		this.vin = vin;
		this.hardwareCodes = hardwareCodes;
		this.softwareCodes = softwareCodes;
	}
	
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public List<String> getHardwareCodes() {
		return hardwareCodes;
	}

	public void setHardwareCodes(List<String> hardwareCodes) {
		this.hardwareCodes = hardwareCodes;
	}

	public List<String> getSoftwareCodes() {
		return softwareCodes;
	}

	public void setSoftwareCodes(List<String> softwareCodes) {
		this.softwareCodes = softwareCodes;
	}

	@Override
	public String toString() {
		return "VehicleDTO [vin=" + vin + ", hardwareCodes=" + hardwareCodes + ", softwareCodes=" + softwareCodes + "]";
	}

}
