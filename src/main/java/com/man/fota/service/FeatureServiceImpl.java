package com.man.fota.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.man.fota.dto.feature.FeatureDTO;
import com.man.fota.dto.feature.mapper.FeatureMapper;
import com.man.fota.model.Feature;
import com.man.fota.repository.FeatureRepository;

@Service
@Transactional
public class FeatureServiceImpl implements FeatureService {

	@Autowired
	FeatureRepository featureRepository;

	@Override
	public Page<FeatureDTO> getAllFeatures(Pageable pageable) {
		Page<Feature> featurePage = featureRepository.findAll(pageable);
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
		return FeatureMapper.toDTO(featureRepository.getAllInstablleFeaturesByVin(vin));
	}
	
	@Override
	public List<FeatureDTO> getAllIncompatibleFeaturesByVin(String vin) {
		return FeatureMapper.toDTO(featureRepository.getAllIncompatibleFeaturesByVin(vin));
	}

}
