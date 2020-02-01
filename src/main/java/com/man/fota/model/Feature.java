package com.man.fota.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "Features")
public class Feature {

	@Id
	private String featureId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "featureId")
	private List<FeatureCode> codes = new ArrayList<>();
	
	public Feature() {
	}
	
	public Feature(String featureId) {
		this.featureId = featureId;
	}

	public String getFeatureId() {
		return featureId;
	}

	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}

	public List<FeatureCode> getCodes() {
		return codes;
	}

	public void setCodes(List<FeatureCode> codes) {
		this.codes = codes;
	}

	@Override
	public String toString() {
		return "Feature [featureId=" + featureId + "]";
	}

}
