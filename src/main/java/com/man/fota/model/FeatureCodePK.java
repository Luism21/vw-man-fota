package com.man.fota.model;

import java.io.Serializable;

public class FeatureCodePK implements Serializable {

	private static final long serialVersionUID = 2616770648739053008L;

	private String featureId;
	
	private Boolean mustBePresent;
	
	private String code;
	
	private Boolean isSoftware;
	
	public FeatureCodePK() {
	}

	public FeatureCodePK(String featureId, Boolean mustBePresent, String code, Boolean isSoftware) {
		super();
		this.featureId = featureId;
		this.mustBePresent = mustBePresent;
		this.code = code;
		this.isSoftware = isSoftware;
	}

	public String getFeatureId() {
		return featureId;
	}

	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}

	public Boolean getMustBePresent() {
		return mustBePresent;
	}

	public void setMustBePresent(Boolean mustBePresent) {
		this.mustBePresent = mustBePresent;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((featureId == null) ? 0 : featureId.hashCode());
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
		FeatureCodePK other = (FeatureCodePK) obj;
		if (featureId == null) {
			if (other.featureId != null)
				return false;
		} else if (!featureId.equals(other.featureId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FeaturePK [featureId=" + featureId + ", mustBePresent=" + mustBePresent + ", code=" + code
				+ ", isSoftware=" + isSoftware + "]";
	}

	
}
