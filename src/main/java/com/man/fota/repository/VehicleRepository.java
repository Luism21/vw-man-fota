package com.man.fota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.man.fota.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

	@Query(	value="select distinct v.vin " + 
			"from vehicle_code v " + 
			"where v.code in (select code " + 
			"                           from feature_code " + 
			"                           where feature_id = :featureId " + 
			"                           and must_be_present = true) " + 
			"and v.code not in (select code " + 
			"                             from feature_code " + 
			"                             where feature_id = :featureId " + 
			"                             and must_be_present = false)", nativeQuery = true)
	List<Vehicle> getAllVinsThatCanInstallAFeature(@Param("featureId") String featureId);
	
	@Query(	value="select distinct v.vin " + 
			"from vehicle_code v " + 
			"where  v.code in (select code " + 
			"                  from feature_code " + 
			"                  where feature_id = :featureId " + 
			"                  and must_be_present = false)", nativeQuery = true)
	List<Vehicle> getAllVinsThatCannotInstallAFeature(@Param("featureId") String featureId);
	
}
