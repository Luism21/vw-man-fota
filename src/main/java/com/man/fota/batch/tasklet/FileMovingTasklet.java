package com.man.fota.batch.tasklet;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

public class FileMovingTasklet implements Tasklet, InitializingBean {

   private Resource[] resources;

   public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        
	   if (resources != null) {
	       for(Resource r: resources) {
	    	   
	    	   File file = r.getFile();
	    	   
	    	   Path source = Paths.get(file.getPath());
	    	   Path newdir = Paths.get(file.getParentFile().getPath() + File.separator + "done");
	    	   if (!Files.exists(newdir)) {
	               Files.createDirectory(newdir);
	           }
	    	   Files.move(source, newdir.resolve(source.getFileName()),
	    	               StandardCopyOption.REPLACE_EXISTING);
	    	   
	       }
	   }
       return RepeatStatus.FINISHED;
   }

   public void setResources(Resource[] resources) {
       this.resources = resources;
   }

   public void afterPropertiesSet() throws Exception {
       Assert.notNull(resources, "directory must be set");
   }

}

