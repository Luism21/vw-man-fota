package com.man.fota.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "FeatureCode")
@IdClass(FeatureCodePK.class)
public class FeatureCode {

	@Id
	private String featureId;
	
	@Id
	private Boolean mustBePresent;
	
	@Id
	private String code;
	
	@Id
	private Boolean isSoftware;

	public FeatureCode() {
	}
	
	public FeatureCode(String featureId) {
		this.featureId = featureId;
	}

	public String getFeatureId() {
		return featureId;
	}

	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}

	public Boolean mustBePresent() {
		return mustBePresent;
	}


	public void mustBePresent(Boolean mustBePresent) {
		this.mustBePresent = mustBePresent;
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


	public void isSoftware(Boolean isSoftware) {
		this.isSoftware = isSoftware;
	}
	
	public Boolean getMustBePresent() {
		return mustBePresent;
	}

	public void setMustBePresent(Boolean mustBePresent) {
		this.mustBePresent = mustBePresent;
	}

	public void setIsSoftware(Boolean isSoftware) {
		this.isSoftware = isSoftware;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeatureCode other = (FeatureCode) obj;
		if (featureId == null) {
			if (other.featureId != null)
				return false;
		} else if (!featureId.equals(other.featureId))
			return false;
		return true;
	}

}
