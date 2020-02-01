package com.man.fota.batch.mapper;

import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.core.io.Resource;
import org.springframework.validation.BindException;

import com.man.fota.model.VehicleCode;

public class VehicleFieldSetMapper implements FieldSetMapper<VehicleCode> {
	
	private MultiResourceItemReader delegator;
	
	public VehicleFieldSetMapper() {
	}
	
	public VehicleFieldSetMapper(MultiResourceItemReader delegator) {
		this.delegator = delegator;
	}

	@Override
    public VehicleCode mapFieldSet(FieldSet fieldSet) throws BindException {
		VehicleCode vehicle = new VehicleCode();
        vehicle.setVin(fieldSet.readString("vin"));
        vehicle.setCode(fieldSet.readString("code"));
		
		if (delegator != null) {
			Resource currentResource = delegator.getCurrentResource();
		    String[] fileName = currentResource.getFilename().split("_");
		    
		    if (fileName[0].equals("soft")) {
		    	vehicle.isSoftware(true);
		    } else if (fileName[0].equals("hard")) {
		    	vehicle.isSoftware(false);
		    }
		}
        
        return vehicle;

    }
}
