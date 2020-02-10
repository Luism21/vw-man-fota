package com.man.fota;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.man.fota.controller.FeatureController;
import com.man.fota.controller.VehicleController;

@SpringBootTest
@TestPropertySource(properties = {
	    "CsvFilesPath=\"*.csv\""
	})
class FotaApplicationTests {
	
	@Autowired
	private FeatureController featureController;
	
	@Autowired
	private VehicleController vehicleController;

	@Test
	void contextLoads() {
		assertThat(featureController).isNotNull();
		assertThat(vehicleController).isNotNull();
	}

}
