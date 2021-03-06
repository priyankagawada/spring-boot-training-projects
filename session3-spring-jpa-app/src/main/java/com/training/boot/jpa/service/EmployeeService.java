package com.training.boot.jpa.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.boot.jpa.controller.model.EmployeeDTO;
import com.training.boot.jpa.entities.EmployeeEntity;
import com.training.boot.jpa.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository repository;

	@Autowired
	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;

	}

	public EmployeeDTO findById(Long id) {
		Optional<EmployeeEntity> optional = repository.findById(id);
		EmployeeDTO returnObject = null;
		if (optional.isPresent()) {
			returnObject = new EmployeeDTO();
			EmployeeEntity employee = optional.get();
			BeanUtils.copyProperties(employee, returnObject);
		}
		return returnObject;
	}

	public EmployeeDTO save(EmployeeDTO emp) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(emp, employeeEntity);
		this.repository.save(employeeEntity);
		return emp;
	}

	public List<EmployeeDTO> findAll() {
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		Iterable<EmployeeEntity> iterable = this.repository.findAll();
		Iterator<EmployeeEntity> itr = iterable.iterator();

		while (itr.hasNext()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			EmployeeEntity employee = itr.next();
			BeanUtils.copyProperties(employee, employeeDTO);
			list.add(employeeDTO);
		}

		return list;
	}

	public EmployeeDTO delete(Long id) {
		// service class method is called
		
		EmployeeDTO employee = findById(id);
		System.out.println(employee);
		if (employee != null) {
			this.repository.deleteById(id);
		}
		return employee;
	}
}
