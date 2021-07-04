package com.training.boot.configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.training.boot.model.Project;
import com.training.boot.service.IProjectService;

// Runs after the beans in the applications are ready in the container
@Component
public class MyCommandLineRunner implements CommandLineRunner{

	// IProjectService object
	
	@Autowired
	private IProjectService iProjectService;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		iProjectService.save(new Project(1L, "Training Allocation to New Joinees", 
				LocalDate.of(2021, Month.JANUARY, 25)));
		
		iProjectService.save(new Project(2L, "Machine Allocations and Transport", 
				LocalDate.of(2021, Month.JANUARY, 10)));
		
		Optional<Project> optional = iProjectService.findById(1L);
		
		 if(optional.isPresent()) {
			 Project project  = optional.get();
			 System.out.println("Project Details - " + project.getId() + " " + project.getName());
	                   	 
		 }

	}

}
