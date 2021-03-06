package com.training.boot.service;

import java.util.Optional;

import com.training.boot.model.Project;

public interface IProjectService {
	public Optional<Project> findById(long id);
	public Project save(Project project);
}
