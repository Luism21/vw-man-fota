package com.man.fota.repository;

import org.springframework.data.repository.CrudRepository;

import com.man.fota.model.FeatureCode;
import com.man.fota.model.FeatureCodePK;

public interface FeatureCodeRepository extends CrudRepository<FeatureCode, FeatureCodePK> {

}
