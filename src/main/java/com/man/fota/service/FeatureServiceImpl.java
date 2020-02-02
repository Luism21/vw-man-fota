package com.man.fota.service;

import java.util.List;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.man.fota.dto.feature.FeatureDTO;
import com.man.fota.dto.feature.VehicleFeaturesListDTO;
import com.man.fota.dto.feature.mapper.FeatureMapper;
import com.man.fota.model.Feature;
import com.man.fota.repository.FeatureRepository;

@Service
@Transactional
public class FeatureServiceImpl implements FeatureService {

	private static final Logger logger = LogManager.getLogger(FeatureServiceImpl.class);
	
	@Autowired
	FeatureRepository featureRepository;

	@Override
	public Page<FeatureDTO> getAllFeatures(Pageable pageable) {
		logger.info("Getting all features");
		Page<Feature> featurePage = featureRepository.findAll(pageable);
		
		logger.info("Converting all Features to FeatureDTOs");
		Page<FeatureDTO> dtoPage = featurePage.map(new Function<Feature, FeatureDTO>() {
		    @Override
		    public FeatureDTO apply(Feature feature) {
		        return FeatureMapper.toDTO(feature);
		    }
		});
		return dtoPage;
	}
	
	@Override
	public List<FeatureDTO> getAllInstallablesFeaturesByVin(String vin) {
		logger.info("Converting all installables features of " + vin);
		return FeatureMapper.toDTO(featureRepository.getAllInstablleFeaturesByVin(vin));
	}
	
	@Override
	public List<FeatureDTO> getAllIncompatibleFeaturesByVin(String vin) {
		logger.info("Converting all incompatible features of " + vin);
		return FeatureMapper.toDTO(featureRepository.getAllIncompatibleFeaturesByVin(vin));
	}

	@Override
	public VehicleFeaturesListDTO getAllFeaturesByVin(String vin) {
		logger.info("Getting all features of " + vin);
		VehicleFeaturesListDTO vehicleFeaturesListDto = new VehicleFeaturesListDTO();
		vehicleFeaturesListDto.setInstallableFeatureList(getAllInstallablesFeaturesByVin(vin));
		vehicleFeaturesListDto.setIncompatibleFeatureList(getAllIncompatibleFeaturesByVin(vin));
		return vehicleFeaturesListDto;
	}

}
