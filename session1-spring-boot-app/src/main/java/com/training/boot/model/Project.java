package com.training.boot.model;

import java.time.LocalDate;

public class Project {
	
	private long id;
	private String name;
	private LocalDate startDate;
	
	
	public Project(long id, String name, LocalDate startDate) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	

}
