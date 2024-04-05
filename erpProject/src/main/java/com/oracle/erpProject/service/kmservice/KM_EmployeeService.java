package com.oracle.erpProject.service.kmservice;

import java.util.List;

import com.oracle.erpProject.domain.Employee;

public interface KM_EmployeeService {

	Employee insertEmployee(Employee employee);

	List<Employee> listEmployee(String searchType, String searchKeyword, 
								Integer start, Integer count, String sort, String Direction);

	Employee updateEmployee(Employee employee);

	Employee deleteEmployee(Employee employee);
}
