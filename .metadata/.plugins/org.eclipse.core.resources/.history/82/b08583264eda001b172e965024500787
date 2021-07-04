package com.training.boot.jpa;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.training.boot.jpa.entities.EmployeeEntity;
import com.training.boot.jpa.repository.EmployeeRepository;

@Component
public class EmployeeRepositoryRunner  implements CommandLineRunner{

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
	
		EmployeeEntity entity1 = new EmployeeEntity(1L, "john", "rock", "john@abc.com", 30);
		repository.save(entity1);
		
		EmployeeEntity entity2 = new EmployeeEntity(2L, "jill", "mathew", "jill@abc.com", 34);
		repository.save(entity2);
		
		System.out.println("=================================================================");
		// findByID
		Optional<EmployeeEntity> optional =  repository.findById(2L);
		if(optional.isPresent()) {
			EmployeeEntity employee = optional.get();
			System.out.println("Ëmployee Email " + employee.getEmail());
		}
		
		System.out.println("=================================================================");
		
		// findAll()
		System.out.println("=================================================================");
		
		Iterable<EmployeeEntity> iterable = repository.findAll();
		System.out.println(iterable);
		
		System.out.println("==============================================================");
		
		// update
		EmployeeEntity emp = new EmployeeEntity(1L, "john", "abc", "john@abc.com", 30);
		repository.save(emp);
		System.out.println("=================================================================");
		
		System.out.println("Finder methods");

		EmployeeEntity email = repository.findByEmail("john@abc.com");
		System.out.println("Employee with email " + email);
		
		
		List<EmployeeEntity> listEmp = repository.findByAge(30);
		listEmp.forEach((e) -> System.out.println(e));
	}

	
	
	
}
