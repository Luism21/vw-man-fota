package com.man.fota.dto.feature;

import java.util.List;

public class FeatureCodesDTO {
	
	List<String> mustBePresent;
	
	List<String> mustNotBePresent;

	public FeatureCodesDTO(List<String> mustBePresent, List<String> mustNotBePresent) {
		super();
		this.mustBePresent = mustBePresent;
		this.mustNotBePresent = mustNotBePresent;
	}

	public FeatureCodesDTO() {
		super();
	}

	public List<String> getMustBePresent() {
		return mustBePresent;
	}

	public void setMustBePresent(List<String> mustBePresent) {
		this.mustBePresent = mustBePresent;
	}

	public List<String> getMustNotBePresent() {
		return mustNotBePresent;
	}

	public void setMustNotBePresent(List<String> mustNotBePresent) {
		this.mustNotBePresent = mustNotBePresent;
	}

	@Override
	public String toString() {
		return "FeatureCodesDTO [mustBePresent=" + mustBePresent + ", mustNotBePresent=" + mustNotBePresent + "]";
	}
	
}
