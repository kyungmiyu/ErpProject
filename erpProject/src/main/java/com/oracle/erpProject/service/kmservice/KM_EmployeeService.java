package com.oracle.erpProject.service.kmservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oracle.erpProject.domain.Employee;

@Service
public interface KM_EmployeeService {

	Employee registEmployee(Employee employee);

	//List<Employee> listEmployee(Pageable paging);
	
	Employee getEmployee(int emp_no);
	
	Employee updateEmployee(Employee employee);

	Employee deleteEmployee(Employee employee);

	Page<Employee> listPage(Pageable pageable);

	Employee findByEmpNo(int empNo);
}
