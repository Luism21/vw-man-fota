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
@RequestMapping("/features")
@Api(tags = {"fota"}, description = "Query possible features per vehicle and possible vehicles per feature")
public class FeatureController {
	
	@GetMapping
	@ApiOperation(value = "Find all features")
	public ResponseEntity<VehicleListDTO> getAllFeatures() {
		VehicleListDTO vehicleList = null;
		return ResponseEntity.accepted().body(vehicleList);
	}
	
	@GetMapping("/{feature}/installable")
	@ApiOperation(value = "Find installable VIN's by feature code")
	public ResponseEntity<FeatureListDTO> getInstallables(@PathVariable(required = true) String feature) {
		FeatureListDTO featureList = null;
		return ResponseEntity.accepted().body(featureList);
	}
	
	@GetMapping("/{feature}/incompatible")
	@ApiOperation(value = "Find incompatible VIN's by feature code")
	public ResponseEntity<FeatureListDTO> getIncompatibles(@PathVariable(required = true) String feature) {
		FeatureListDTO featureList = null;
		return ResponseEntity.accepted().body(featureList);
	}
	
	@GetMapping("/{feature}")
	@ApiOperation(value = "Find all VIN's by feature code")
	public ResponseEntity<VehicleFeaturesListDTO> getAllFeatures(@PathVariable(required = true) String feature) {
		VehicleFeaturesListDTO featureList = null;
		return ResponseEntity.accepted().body(featureList);
	}

}
