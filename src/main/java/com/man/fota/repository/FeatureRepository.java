package com.man.fota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.man.fota.model.Feature;

public interface FeatureRepository extends JpaRepository<Feature, String> {

	@Query(	value="SELECT FEATURE_ID FROM " +
			"(SELECT DISTINCT  f.feature_id FROM feature_code f " + 
			"LEFT JOIN vehicle_code v   ON f.code = v.code  AND ( v.vin = :vin AND v.vin IS NOT NULL )  " +
			"WHERE  f.must_be_present = true ) " +

			"WHERE feature_id not in " +
			"(SELECT DISTINCT f.feature_id FROM   feature_code f   " +
			"LEFT JOIN vehicle_code v   ON f.code = v.code  AND ( v.vin = :vin  AND v.vin IS NOT NULL )   " +
			"WHERE  f.must_be_present = true AND v.vin IS NULL) " +

			"AND feature_id not in " +
			"(SELECT DISTINCT f.feature_id FROM feature_code f " +
			"JOIN vehicle_code v   ON f.code = v.code  AND ( v.vin = :vin )   " +
			"WHERE  f.must_be_present = false); ", nativeQuery = true)
	List<Feature> getAllInstablleFeaturesByVin(@Param("vin") String vin);
	
	@Query(	value="SELECT DISTINCT feature_id FROM  feature_code f " +
			"WHERE feature_id in  " +
			"(SELECT DISTINCT f.feature_id FROM feature_code f   " +
			"LEFT JOIN vehicle_code v  ON f.code = v.code  AND ( v.vin = :vin  AND v.vin IS NOT NULL )   " +
			"WHERE  f.must_be_present = true AND v.vin IS NULL) " +
			"OR feature_id in " +
			"(SELECT  DISTINCT f.feature_id FROM feature_code f " +
			"JOIN vehicle_code v ON f.code = v.code  AND ( v.vin = :vin )   " +
			"WHERE  f.must_be_present = false)", nativeQuery = true)
	List<Feature> getAllIncompatibleFeaturesByVin(@Param("vin") String vin);
	
}
