package com.man.fota.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.man.fota.dto.vehicle.VehicleDTO;
import com.man.fota.model.FeatureCode;
import com.man.fota.model.Vehicle;
import com.man.fota.model.VehicleCode;
import com.man.fota.model.VehicleCodePK;
import com.man.fota.repository.FeatureCodeRepository;
import com.man.fota.repository.VehicleCodeRepository;
import com.man.fota.repository.VehicleRepository;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@TestPropertySource(properties = {
	    "CsvFilesPath=\"*.csv\""
	})
class VehicleServiceTests {

	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	VehicleCodeRepository vehicleCodeRepository;
	
	@Autowired
	FeatureCodeRepository featureCodeRepository;
	
	@BeforeAll
	void before() throws Exception {
		
		
		String[] csvFiles = {"TestFiles/hard_001.csv", 
							"TestFiles/hard_002.csv",
							"TestFiles/hard_003.csv",
							"TestFiles/soft_001.csv",
							"TestFiles/soft_002.csv",
							"TestFiles/soft_003.csv"};
        BufferedReader br = null;
        String line = "";
        
        try {
        	for (String file : csvFiles) {
	            br = new BufferedReader(new FileReader(file));
	            
	            String[] fileName = file.split("_");
	            boolean isSoftware = false;
	            if ("soft".equals(fileName[0])) {
	            	isSoftware = true;
	            }
	    
	            
	            while ((line = br.readLine()) != null) {
	
	                String[] vehicleCode = line.split(",");
	                if (!vehicleRepository.existsById(vehicleCode[0])) {
	                	vehicleRepository.saveAndFlush(new Vehicle(vehicleCode[0]));
	                }
	                
	                if (!vehicleCodeRepository.existsById(new VehicleCodePK(vehicleCode[0], vehicleCode[1], isSoftware))) {
	                	vehicleCodeRepository.saveAndFlush(new VehicleCode(vehicleCode[0], vehicleCode[1], isSoftware));
	                }
	                
	            }
        	}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	@Test
	void getAllVinsThatCanInstallAFeatureTest() {

		List<VehicleDTO> list = vehicleService.getAllVinsThatCanInstallAFeature("A");
		assertThat(list).isNotEmpty();
		
		
		List<String> featureCodeMustBePresentList = featureCodeRepository.findAllFeatureCodeByFeatureIdAndMustBePresent("A", true).stream()
				.map(FeatureCode::getCode)
				.collect(Collectors.toList());
		
		
		
		List<String> featureCodeMustNotBePresentList = featureCodeRepository.findAllFeatureCodeByFeatureIdAndMustBePresent("A", false).stream()
				.map(FeatureCode::getCode)
				.collect(Collectors.toList());
		
		for (VehicleDTO vehicle : list) {
			List<String> codeList = vehicle.getHardwareCodes();
			codeList.addAll(vehicle.getSoftwareCodes());
						
			assertThat(codeList.containsAll(featureCodeMustBePresentList)).isTrue();
			assertThat(Collections.disjoint(codeList, featureCodeMustNotBePresentList)).isTrue();
		}
	
	}

}
