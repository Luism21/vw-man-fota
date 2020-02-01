package com.man.fota.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.man.fota.dto.feature.FeatureListDTO;
import com.man.fota.dto.feature.VehicleFeaturesListDTO;
import com.man.fota.dto.vehicle.VehicleListDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/vehicles")
@Api(value = "fota", description = "Query possible features per vehicle and possible vehicles per feature")
public class VehicleController {
	
	@GetMapping
	@ApiOperation(value = "Find all vehicles")
	public ResponseEntity<VehicleListDTO> getAllVehicles() {
		VehicleListDTO vehicleList = null;
		return ResponseEntity.accepted().body(vehicleList);
	}
	
	@GetMapping("/{vin}/installable")
	@ApiOperation(value = "Find installable features by VIN")
	public ResponseEntity<FeatureListDTO> getInstallables(@PathVariable(required = true) String vin) {
		FeatureListDTO featureList = null;
		return ResponseEntity.accepted().body(featureList);
	}
	
	@GetMapping("/{vin}/incompatible")
	@ApiOperation(value = "Find incompatible features by VIN")
	public ResponseEntity<FeatureListDTO> getIncompatibles(@PathVariable(required = true) String vin) {
		FeatureListDTO featureList = null;
		return ResponseEntity.accepted().body(featureList);
	}
	
	@GetMapping("/{vin}")
	@ApiOperation(value = "Find all features by VIN")
	public ResponseEntity<VehicleFeaturesListDTO> getAllFeatures(@PathVariable(required = true) String vin) {
		VehicleFeaturesListDTO featureList = null;
		return ResponseEntity.accepted().body(featureList);
	}

}
