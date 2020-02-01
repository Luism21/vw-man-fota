package com.man.fota.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "VehicleCode")
@IdClass(VehicleCodePK.class)
public class VehicleCode {

	@Id
	private String vin;
	
	@Id
	private String code;
	
	@Id
	private Boolean isSoftware;
	
	public VehicleCode() {
	}
	
	public VehicleCode(String vin) {
		this.vin = vin;
	}

	public VehicleCode(String vin, String code, Boolean isSoftware) {
		super();
		this.vin = vin;
		this.code = code;
		this.isSoftware = isSoftware;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean isSoftware() {
		return isSoftware;
	}

	public void isSoftware(Boolean isSoftware) {
		this.isSoftware = isSoftware;
	}
	
	public Boolean getIsSoftware() {
		return isSoftware;
	}

	public void setIsSoftware(Boolean isSoftware) {
		this.isSoftware = isSoftware;
	}

	@Override
	public String toString() {
		return "Vehicle [vin=" + vin + ", code=" + code + ", isSoftware=" + isSoftware + "]";
	}

}
