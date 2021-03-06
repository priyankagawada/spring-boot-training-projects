package com.training.boot.repository;

import java.util.Optional;

import com.training.boot.model.Project;

public interface IProjectRepository {
	   public Optional<Project> findById(long id);
	   
	   public Project save(Project project); 
		
}
