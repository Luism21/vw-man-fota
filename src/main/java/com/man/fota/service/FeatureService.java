package com.man.fota.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.man.fota.dto.feature.FeatureDTO;

public interface FeatureService {

	Page<FeatureDTO> getAllFeatures(Pageable paginable);
	
}
