package com.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
	// Search By Firstname
	public List<Employee>findByFirstname(String firstname);
	
	// Search By Lastname
	public List<Employee>findByLastname(String lastname);
	
	 // Search By Department
   public List<Employee> findByDepartment(String department);

    // Search By Designation
   public List<Employee> findByDesignation(String designation);

    // Search By Status
   public List<Employee> findByStatus(String status);

    // Search By Work Location
   public List<Employee> findByWorklocation(String worklocation);

    // Search By Reporting Manager
   public List<Employee> findByReportingmanager(String reportingmanager);
	

   // Search By Employeecode
   public Employee findByEmployeecode(String employeecode);

	
	
}
