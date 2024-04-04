package com.oracle.erpProject.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.oracle.erpProject.domain.Employee;

/* KM_EmployeeRepository */
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer>{

	//public Employee findById(String emp_no);
	
}