package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Employee;
import com.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repo;
	
	// Add Employees
	public String addemployee(Employee e) {

	    // First Save
	    Employee savedEmployee = repo.save(e);

	    // Generate Employee Code
	    String employeecode =
	            String.format("EMP%03d",
	                    savedEmployee.getId());

	    savedEmployee.setEmployeecode(employeecode);

	    // Save Again
	    repo.save(savedEmployee);

	    return "Employee record added successfully.";
	}
	
	// Get All Employees
	public List<Employee>getallemployee(){
		return repo.findAll();
	}
	
	// Get Employee By Id
	public Employee getemployeebyid(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	// Delete Employee By Id
	public String deleteemployeebyid(Long id) {
		Employee existingemployee = repo.findById(id).orElse(null);
		
		if(existingemployee == null) {
			return "Employee record not found for the provided ID.";
		}else {
			repo.deleteById(id);
			return "Employee record deleted successfully.";
		}
	}
	
	// Update Employeee
	public String updateemployee(Long id, Employee newemployee) {
		Employee existingemployee=repo.findById(id).orElse(null);
	
	
	if(existingemployee == null) {
		return "Employee record not found for the provided ID.";
	}
	
	if(newemployee.getEmployeecode() == null
			&& newemployee.getFirstname() == null
			&& newemployee.getMiddlename() == null
			&& newemployee.getLastname() == null
			&& newemployee.getGender() == null
			&& newemployee.getDateofbirth() == null
			&& newemployee.getProfilepicture() == null
			&& newemployee.getEmail() == null
			&& newemployee.getPhonenumber() == null
			&& newemployee.getAddress() == null
			&& newemployee.getEducation() == null
			&& newemployee.getDepartment() == null
			&& newemployee.getDesignation() == null
			&& newemployee.getExperience() == 0
			&& newemployee.getSalary() == 0
			&& newemployee.getJoiningdate() == null
			&& newemployee.getWorklocation() == null
			&& newemployee.getReportingmanager() == null
			&& newemployee.getStatus() == null ) {
		
		return "No new data provided for update.";
	}
	
	if(newemployee.getEmployeecode() != null) {
		existingemployee.setEmployeecode(newemployee.getEmployeecode());
	}
	
	if(newemployee.getFirstname() != null) {
		existingemployee.setFirstname(newemployee.getFirstname());
	}
	
	if(newemployee.getMiddlename() != null) {
		existingemployee.setMiddlename(newemployee.getMiddlename());
	}
	
	if(newemployee.getLastname() != null) {
		existingemployee.setLastname(newemployee.getLastname());
	}
	
	if(newemployee.getGender() != null) {
		existingemployee.setGender(newemployee.getGender());
	}
	
	if(newemployee.getDateofbirth() != null) {
		existingemployee.setDateofbirth(newemployee.getDateofbirth());
	}
	
	if(newemployee.getProfilepicture() != null) {
		existingemployee.setProfilepicture(newemployee.getProfilepicture());
	}
	
	if(newemployee.getEmail() != null) {
		existingemployee.setEmail(newemployee.getEmail());
	}
	
	if(newemployee.getPhonenumber() != null) {
		existingemployee.setPhonenumber(newemployee.getPhonenumber());
	}
	
	if(newemployee.getAddress() != null) {
		existingemployee.setAddress(newemployee.getAddress());
	}
	
	if(newemployee.getEducation() != null) {
		existingemployee.setEducation(newemployee.getEducation());
	}
	
	if(newemployee.getDepartment() != null) {
		existingemployee.setDepartment(newemployee.getDepartment());
	}
	
	if(newemployee.getDesignation() != null) {
		existingemployee.setDesignation(newemployee.getDesignation());
	}
	
	if (newemployee.getExperience() != 0) {
	    existingemployee.setExperience(newemployee.getExperience());
	}

	if (newemployee.getSalary() != 0) {
	    existingemployee.setSalary(newemployee.getSalary());
	}
	
	if(newemployee.getJoiningdate() != null) {
		existingemployee.setJoiningdate(newemployee.getJoiningdate());
	}
	
	if(newemployee.getWorklocation() != null) {
		existingemployee.setWorklocation(newemployee.getWorklocation());
	}
	
	if(newemployee.getReportingmanager() != null) {
		existingemployee.setReportingmanager(newemployee.getReportingmanager());
	}
	
	if(newemployee.getStatus() != null) {
		existingemployee.setStatus(newemployee.getStatus());
	}
	
	repo.save(existingemployee);

	return "Employee record updated successfully.";
  
	}
	
	public List<Employee> getemployeesbyfirstname(String firstname) {
	    return repo.findByFirstname(firstname);
	}

	public List<Employee> getemployeesbylastname(String lastname) {
	    return repo.findByLastname(lastname);
	}

	public List<Employee> getemployeesbydepartment(String department) {
	    return repo.findByDepartment(department);
	}

	public List<Employee> getemployeesbydesignation(String designation) {
	    return repo.findByDesignation(designation);
	}

	public List<Employee> getemployeesbystatus(String status) {
	    return repo.findByStatus(status);
	}

	public List<Employee> getemployeesbyworklocation(String worklocation) {
	    return repo.findByWorklocation(worklocation);
	}

	public List<Employee> getemployeesbyreportingmanager(String reportingmanager) {
	    return repo.findByReportingmanager(reportingmanager);
	}
	
	
	public Employee getEmployeeByEmployeeCode(String employeecode) {
	    return repo.findByEmployeecode(employeecode);
	}
	
	
}

