package com.oracle.erpProject.dao.kmdao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.oracle.erpProject.domain.Employee;

public interface EmployeeDao {

	Employee registEmployee(Employee employee);
	
	Page<Employee> listEmployee(Pageable paging);
	
	Employee getEmployee(int empNo);
	
	Employee updateEmployee(Employee employee);

	Page<Employee> listPage(Pageable pageable);
	
	Employee findByEmpNo(int empNo);

}
