package com.man.fota.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.TestPropertySource;

import com.man.fota.dto.feature.FeatureDTO;

@SpringBootTest
@TestPropertySource(properties = {
	    "CsvFilesPath=\"*.csv\""
	})
class FeatureServiceTests {
	
	@Autowired
	FeatureService featureService;
	
	
	

	@Test
	void getAllFeaturesTest() {
		List<FeatureDTO> featureList = featureService.getAllFeatures(PageRequest.of(0, 100)).getContent();
		for (FeatureDTO f : featureList) {
			assertThat(f.getFeatureId()).isNotNull();
			assertThat(f.getHardwareCodes()).isNotNull();
			assertThat(f.getSoftwareCodes()).isNotNull();
		}
	}

}
