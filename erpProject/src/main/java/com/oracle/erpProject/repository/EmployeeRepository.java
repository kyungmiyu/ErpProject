package com.oracle.erpProject.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.oracle.erpProject.domain.Employee;

/* KM_EmployeeRepository */
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer>{

	//public Employee findById(String emp_no);
	
}