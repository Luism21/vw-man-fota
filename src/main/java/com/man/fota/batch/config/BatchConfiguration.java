package com.man.fota.batch.config;

import java.io.IOException;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

import com.man.fota.batch.mapper.VehicleFieldSetMapper;
import com.man.fota.batch.tasklet.FileMovingTasklet;
import com.man.fota.batch.writer.VehicleItemWriter;
import com.man.fota.model.VehicleCode;
import com.man.fota.repository.VehicleRepository;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	private Resource[] inputResources = null;

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public VehicleRepository vehicleRepository;

	@Bean
	public Job readCSVFilesJob() {
		return jobBuilderFactory.get("readCSVFilesJob").incrementer(new RunIdIncrementer()).start(step1()).next(step2())
				.build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<VehicleCode, VehicleCode>chunk(5).reader(multiResourceItemReader())
				.writer(writer()).build();
	}

	@Bean
	@JobScope
	public Step step2() {
		FileMovingTasklet task = new FileMovingTasklet();
		task.setResources(inputResources);
		return stepBuilderFactory.get("step2").tasklet(task).build();
	}

	@Bean
	@JobScope
	public MultiResourceItemReader<VehicleCode> multiResourceItemReader() {

		FileSystemXmlApplicationContext patternResolver = new FileSystemXmlApplicationContext();
		try {
			inputResources = patternResolver.getResources("/*.csv");
		} catch (IOException e) {
			// TODO logger
			e.printStackTrace();
		} finally {
			patternResolver.close();
		}
		
		MultiResourceItemReader<VehicleCode> resourceItemReader = new MultiResourceItemReader<VehicleCode>();
		resourceItemReader.setResources(inputResources);
		resourceItemReader.setDelegate(reader(resourceItemReader));
		return resourceItemReader;
	}

	@Bean
	public FlatFileItemReader<VehicleCode> reader(MultiResourceItemReader delegator) {
		// Create reader instance
		FlatFileItemReader<VehicleCode> reader = new FlatFileItemReader<VehicleCode>();
		

		// Configure how each line will be parsed and mapped to different values
		reader.setLineMapper(new DefaultLineMapper() {
			{
				// 3 columns in each row
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "vin", "code" });
					}
				});
				// Set values in Vehicle class
				setFieldSetMapper(new VehicleFieldSetMapper(delegator));
			}
		});
		return reader;
	}

	@Bean
	public VehicleItemWriter writer() {
		return new VehicleItemWriter();
	}

}