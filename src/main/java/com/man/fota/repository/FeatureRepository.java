package com.man.fota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.man.fota.model.Feature;

public interface FeatureRepository extends JpaRepository<Feature, String> {

}
