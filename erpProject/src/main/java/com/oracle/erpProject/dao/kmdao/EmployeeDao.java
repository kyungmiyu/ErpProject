package com.oracle.erpProject.dao.kmdao;

import java.util.List;

import com.oracle.erpProject.domain.Employee;

public interface EmployeeDao {

	Employee registEmployee(Employee employee);
	
	Employee getEmployee(int empNo);
	
	Employee updateEmployee(Employee employee);

	Employee findByEmpNo(int empNo);
	
	Integer countEmployeeList();

	List<Employee> getEmployeeList(int size, int offset, String searchType, String searchValue);

}
