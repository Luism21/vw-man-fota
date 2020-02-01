package com.man.fota.dto.feature.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.man.fota.dto.feature.FeatureCodesDTO;
import com.man.fota.dto.feature.FeatureDTO;
import com.man.fota.model.Feature;
import com.man.fota.model.FeatureCode;

public class FeatureMapper {

	public static FeatureDTO toDTO(Feature feature) {
		FeatureDTO featureDto = new FeatureDTO();
		featureDto.setFeatureId(feature.getFeatureId());
		featureDto.setSoftwareCodes(new FeatureCodesDTO());
		featureDto.setHardwareCodes(new FeatureCodesDTO());
		
		featureDto.getSoftwareCodes().setMustBePresent(feature.getCodes().stream()
				.filter(c -> c.getIsSoftware() == true && c.getMustBePresent() == true)
				.map(FeatureCode::getCode)
				.collect(Collectors.toList()));
		featureDto.getSoftwareCodes().setMustNotBePresent(feature.getCodes().stream()
				.filter(c -> c.getIsSoftware() == true && c.getMustBePresent() == false)
				.map(FeatureCode::getCode)
				.collect(Collectors.toList()));
		
		featureDto.getHardwareCodes().setMustBePresent(feature.getCodes().stream()
				.filter(c -> c.getIsSoftware() == false && c.getMustBePresent() == true)
				.map(FeatureCode::getCode)
				.collect(Collectors.toList()));
		featureDto.getHardwareCodes().setMustNotBePresent(feature.getCodes().stream()
				.filter(c -> c.getIsSoftware() == false && c.getMustBePresent() == false)
				.map(FeatureCode::getCode)
				.collect(Collectors.toList()));
		return featureDto;
	}
	
	public static List<FeatureDTO> toDTO(List<Feature> featureList) {
		List<FeatureDTO> featureDtoList = new ArrayList<>();
		for (Feature feature : featureList) {
			featureDtoList.add(toDTO(feature));
		}
		return featureDtoList;
	}
	
}
