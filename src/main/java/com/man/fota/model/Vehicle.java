package com.man.fota.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "Vehicle")
public class Vehicle {

	@Id
	private String vin;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "vin")
	private List<VehicleCode> codes = new ArrayList<>();

	public Vehicle() {
	}

	public Vehicle(String vin) {
		this.vin = vin;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public List<VehicleCode> getCodes() {
		return codes;
	}

	public void setCodes(List<VehicleCode> codes) {
		this.codes = codes;
	}

	@Override
	public String toString() {
		return "Vehicle [vin=" + vin + "]";
	}

}
