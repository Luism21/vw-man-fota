package com.man.fota.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import com.man.fota.dto.feature.FeatureDTO;

@SpringBootTest
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
