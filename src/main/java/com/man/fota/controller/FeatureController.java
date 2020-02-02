package com.man.fota.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.man.fota.dto.feature.FeatureDTO;
import com.man.fota.dto.feature.FeatureListDTO;
import com.man.fota.dto.feature.VehicleFeaturesListDTO;
import com.man.fota.service.FeatureService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/features")
@Api(tags = {"fota"}, description = "Query possible features per vehicle and possible vehicles per feature")
public class FeatureController extends GenericController {
	
	private static final Logger logger = LogManager.getLogger(FeatureController.class);
	
	@Autowired
	private FeatureService featureService;
	
	@GetMapping
	@ApiOperation(value = "Find all features")
	public ResponseEntity<FeatureListDTO> getAllFeatures(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize) {
		Page<FeatureDTO> featurePage = featureService.getAllFeatures(PageRequest.of(page, pageSize));
		return ResponseEntity.ok().headers(setHeaders(featurePage)).body(new FeatureListDTO(featurePage.getContent()));
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
