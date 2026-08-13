package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.Employee;
import com.ems.service.EmployeeService;

@RestController
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	//Add Employee
	@PostMapping("/addemployee")
	public String addemployee(@RequestBody Employee e) {
		return service.addemployee(e);
	}
	
	// Get All Employees
	@GetMapping("/getemployee")
	public List<Employee>getallemployee(){
		return service.getallemployee();
	}
	
	// Get Employees By Id
	@GetMapping("/findbyid")
	public Employee getemployeebyid(@RequestParam Long id) {
		return service.getemployeebyid(id);
	}
	
	// Delete Employee By Id
	@DeleteMapping("/deletebyid")
	public String deleteemployeebyid(@RequestParam Long id) {
		return service.deleteemployeebyid(id);
	}
	
	// Update Employee 
	@PutMapping("/updateemployee")
	public String updateemployee(@RequestParam Long id, @RequestBody Employee newemployee) {
		return service.updateemployee(id, newemployee);
	}
	
	
	@GetMapping("/findbyfirstname")
	public List<Employee> getemployeesbyfirstname(@RequestParam String firstname) {
	    return service.getemployeesbyfirstname(firstname);
	}

	@GetMapping("/findbylastname")
	public List<Employee> getemployeesbylastname(@RequestParam String lastname) {
	    return service.getemployeesbylastname(lastname);
	}

	@GetMapping("/findbydepartment")
	public List<Employee> getemployeesbydepartment(@RequestParam String department) {
	    return service.getemployeesbydepartment(department);
	}

	@GetMapping("/findbydesignation")
	public List<Employee> getemployeesbydesignation(@RequestParam String designation) {
	    return service.getemployeesbydesignation(designation);
	}

	@GetMapping("/findbystatus")
	public List<Employee> getemployeesbystatus(@RequestParam String status) {
	    return service.getemployeesbystatus(status);
	}

	@GetMapping("/findbyworklocation")
	public List<Employee> getemployeesbyworklocation(@RequestParam String worklocation) {
	    return service.getemployeesbyworklocation(worklocation);
	}

	@GetMapping("/findbyreportingmanager")
	public List<Employee> getemployeesbyreportingmanager(@RequestParam String reportingmanager) {
	    return service.getemployeesbyreportingmanager(reportingmanager);
	}
	
	
	@GetMapping("/employeeprofile")
	public Employee getEmployeeProfile(@RequestParam String employeecode) {
	    return service.getEmployeeByEmployeeCode(employeecode);
	}
	
	
	
	
	
	
	
}
