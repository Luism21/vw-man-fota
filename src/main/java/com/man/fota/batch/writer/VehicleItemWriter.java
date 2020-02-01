package com.man.fota.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.man.fota.model.Vehicle;
import com.man.fota.model.VehicleCode;
import com.man.fota.model.VehicleCodePK;
import com.man.fota.repository.VehicleCodeRepository;
import com.man.fota.repository.VehicleRepository;

public class VehicleItemWriter implements ItemWriter<VehicleCode> { 
	
	@Autowired
	protected VehicleRepository vehicleRepository;
	
	@Autowired
	protected VehicleCodeRepository vehicleCodeRepository;
	
    @Override
    public void write(List<? extends VehicleCode> items) throws Exception { 
        for (VehicleCode item : items) {
        	if(!vehicleRepository.existsById((item.getVin()))) {
        		vehicleRepository.save(new Vehicle(item.getVin()));
        	}
        	if(!vehicleCodeRepository.existsById((new VehicleCodePK(item.getVin(), item.getCode(), item.isSoftware())))) {
        		vehicleCodeRepository.save(item);
        	}
        } 
    } 
    
}