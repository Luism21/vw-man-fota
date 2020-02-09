package com.man.fota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.man.fota.model.FeatureCode;
import com.man.fota.model.FeatureCodePK;

public interface FeatureCodeRepository extends JpaRepository<FeatureCode, FeatureCodePK> {
	
	List<FeatureCode> findAllFeatureCodeByFeatureIdAndMustBePresent(String featureId, boolean mustBePresent);
	
}
