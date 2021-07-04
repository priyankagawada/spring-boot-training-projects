package com.training.boot.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.training.boot.model.Project;
import com.training.boot.repository.IProjectRepository;

//@Service
public class IProjectServiceImpl implements IProjectService {
	// Autowire the repository
	// At Runtime the object of IProjectRepositoryImpl will be provided to the reference
	// In case if @Autowired finds multiple beans of same type, it raise exception
	
	Logger logger = LoggerFactory.getLogger(IProjectServiceImpl.class);
	
	// INFO is the default logging level 
	public IProjectServiceImpl() {
	   logger.info("IProjectServiceImpl object instanriated...");	
	}
	
	@Autowired
	private IProjectRepository repository;

	@Override
	public Optional<Project> findById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Project save(Project project) {
		// TODO Auto-generated method stub
		return repository.save(project);
	}

}
