package com.man.fota.model;

import java.io.Serializable;

public class VehicleCodePK implements Serializable {

	private static final long serialVersionUID = -1250633112547370886L;

	private String vin;
	
	private String code;
	
	private Boolean isSoftware;
	

	public VehicleCodePK() {
	}
	
	public VehicleCodePK(String vin, String code, Boolean isSoftware) {
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


	public Boolean getIsSoftware() {
		return isSoftware;
	}


	public void setIsSoftware(Boolean isSoftware) {
		this.isSoftware = isSoftware;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleCodePK other = (VehicleCodePK) obj;
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VehiclePK [vin=" + vin + ", code=" + code + ", isSoftware=" + isSoftware + "]";
	}

}
