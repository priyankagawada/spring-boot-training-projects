package com.training.boot.jpa.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.boot.jpa.controller.model.EmployeeDTO;
import com.training.boot.jpa.custom.exception.EmployeeException;
import com.training.boot.jpa.service.EmployeeService;

//request to controller will be http://localhost:8082/status
//@Controller
@RestController  // internally, it means the class with @Controller and all methods will be annotated with @ResponseBody
public class EmployeeController {
	
	
	private EmployeeService service;
	
	@Autowired
	public EmployeeController(EmployeeService service) {
		System.out.println("EmployeeController instantiated..");
		this.service = service;
	}

	// map the method with the URL to handle incoming request
	// if you are designing a RESt API, the method must be annotated with @ResponseBody to send the response to client
	@RequestMapping(path="/status", method= RequestMethod.GET)
	//@ResponseBody
	public String updateStatus() {
		return "EmployeeController handles HTTP request";
	}
	
	// if we do not mention method attribute, default is GET method
	//@RequestMapping(path="/employees/{id}")
	@GetMapping(path="/employees/{id}")
	public EmployeeDTO getEmployeeDetails(@PathVariable("id") Long id) {
		EmployeeDTO employee = this.service.findById(id);
		return employee;
	}
	
	// add a new Employee object 
	@PostMapping(path="/employees")
	public EmployeeDTO addEmployeeDetails(@RequestBody EmployeeDTO employee) {
		
		 EmployeeDTO returnObject = this.service.save(employee);
		 return returnObject;
	}
	
	// Get all employees 
	@GetMapping(path="/employees")
	public List<EmployeeDTO> getEmployees(){
		List<EmployeeDTO> list = this.service.findAll();
		return list;
	}
	
	// PUT /employees
	
	// DELETE /employees/{id}
	@DeleteMapping(path="/employees/{id}")
	public void deleteEmployee(@PathVariable Long id) throws EmployeeException{
		EmployeeDTO  employee = this.service.delete(id);
		if(employee == null) {
			throw new EmployeeException("Employee ID Not Found");
		}
	}
	
	
	@GetMapping(path="/contact")
	public String getContact() {
		return "Contact us on myapp@abc.com";
	}
	
	
	
	
}
